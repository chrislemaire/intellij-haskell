/*
 * Copyright 2016 Rik van der Kleij
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package intellij.haskell.external.component

import java.util.concurrent.{Callable, Executors}

import com.google.common.cache.{CacheBuilder, CacheLoader}
import com.google.common.util.concurrent.{ListenableFuture, ListenableFutureTask, UncheckedExecutionException}
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Computable
import com.intellij.psi.{PsiElement, PsiFile}
import intellij.haskell.external.repl.StackReplsManager
import intellij.haskell.external.repl.process.StackReplOutput
import intellij.haskell.psi._
import intellij.haskell.util.HaskellProjectUtil
import intellij.haskell.util.Util.escapeString

import scala.collection.JavaConversions._

private[component] object NameInfoComponent {

  private final val ProjectInfoPattern = """(.+)-- Defined at (.+):([\d]+):([\d]+)""".r
  private final val LibraryModuleInfoPattern = """(.+)-- Defined in ‘([\w\.\-]+):([\w\.\-]+)’""".r
  private final val ModuleInfoPattern = """(.+)-- Defined in ‘([\w\.\-]+)’""".r

  private final val Executor = Executors.newCachedThreadPool()

  private case class Key(psiFile: PsiFile, name: String)

  private final val Cache = CacheBuilder.newBuilder()
    .build(
      new CacheLoader[Key, Iterable[NameInfo]]() {

        override def load(key: Key): Iterable[NameInfo] = {
          createNameInfos(key, key.psiFile.getProject)
        }

        override def reload(key: Key, oldInfo: Iterable[NameInfo]): ListenableFuture[Iterable[NameInfo]] = {
          val task = ListenableFutureTask.create(new Callable[Iterable[NameInfo]]() {
            def call() = {
              createNameInfos(key, key.psiFile.getProject)
            }
          })
          Executor.execute(task)
          task
        }

        private def createNameInfos(key: Key, project: Project): Iterable[NameInfo] = {
          val output = if (HaskellProjectUtil.isProjectFile(key.psiFile)) {
            StackReplsManager.getProjectRepl(project).findNameInfo(key.psiFile, key.name)
          } else {
            val moduleName = findModuleName(key.psiFile)
            moduleName.map(mn => StackReplsManager.getGlobalRepl(project).findNameInfo(mn, key.name)).getOrElse(StackReplOutput())
          }
          output.stdOutLines.flatMap(l => createNameInfo(l, project))
        }

        private def findModuleName(psiFile: PsiFile) = {
          ApplicationManager.getApplication.runReadAction {
            new Computable[Option[String]] {
              override def compute(): Option[String] = {
                HaskellPsiUtil.findModuleName(psiFile)
              }
            }
          }
        }

        private def createNameInfo(outputLine: String, project: Project): Option[NameInfo] = {
          outputLine match {
            case ProjectInfoPattern(declaration, filePath, lineNr, colNr) => Some(ProjectNameInfo(declaration, filePath, lineNr.toInt, colNr.toInt))
            case LibraryModuleInfoPattern(declaration, libraryName, moduleName) =>
              if (libraryName == "ghc-prim" || libraryName == "integer-gmp") {
                Some(BuiltInNameInfo(declaration, libraryName, "GHC.Base"))
              }
              else {
                Some(LibraryNameInfo(declaration, moduleName))
              }
            case ModuleInfoPattern(declaration, moduleName) => Some(LibraryNameInfo(declaration, moduleName))
            case _ => None
          }
        }
      }
    )

  def findNameInfo(psiElement: PsiElement): Iterable[NameInfo] = {
    val namedElement = for {
      qne <- HaskellPsiUtil.findQualifiedNameElement(psiElement)
      pf <- Option(qne.getContainingFile.getOriginalFile)
    } yield Key(pf, qne.getName.replaceAll("""\s+""", ""))

    (try {
      namedElement.map(k => Cache.get(k))
    }
    catch {
      case _: UncheckedExecutionException => None
      case _: ProcessCanceledException => None
    }).getOrElse(Iterable())
  }

  def refresh(psiFile: PsiFile): Unit = {
    val keys = Cache.asMap().filter(_._1.psiFile == psiFile).keys
    val namedElements = findNamedElements(psiFile)
    keys.filter(k => namedElements.contains(k.name)).foreach(k => Cache.refresh(k))
  }

  private def findNamedElements(psiFile: PsiFile) = {
    ApplicationManager.getApplication.runReadAction {
      new Computable[Iterable[String]] {
        override def compute(): Iterable[String] = {
          HaskellPsiUtil.findNamedElements(psiFile).map(_.getName)
        }
      }
    }
  }
}

sealed trait NameInfo {
  private final val PackageQualifierPattern = """([a-z\-]+\-[\.0-9]+\:)?([A-Z][A-Za-z\-\']+\.)+"""

  def declaration: String

  def unqualifiedDeclaration = declaration.replaceAll(PackageQualifierPattern, "")

  def escapedDeclaration = escapeString(declaration)
}

case class ProjectNameInfo(declaration: String, filePath: String, lineNr: Int, columnNr: Int) extends NameInfo

case class LibraryNameInfo(declaration: String, moduleName: String) extends NameInfo

case class BuiltInNameInfo(declaration: String, libraryName: String, moduleName: String) extends NameInfo
