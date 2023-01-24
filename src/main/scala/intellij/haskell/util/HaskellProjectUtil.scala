/*
 * Copyright 2014-2020 Rik van der Kleij
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

package intellij.haskell.util

import java.io.File

import com.intellij.openapi.module.{Module, ModuleManager, ModuleUtilCore}
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots._
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.{VfsUtilCore, VirtualFile}
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.{PsiElement, PsiFile}
import com.intellij.util.PathUtilRt
import intellij.haskell.GlobalInfo
import org.jetbrains.jps.model.java.JavaModuleSourceRootTypes

import scala.jdk.CollectionConverters._

object HaskellProjectUtil {

  final val Prelude = "Prelude"

  def isValidHaskellProject(project: Project, notifyNoSdk: Boolean): Boolean = {
    isHaskellProject(project) // && HaskellSdkType.getStackPath(project, notifyNoSdk).isDefined
  }

  def isHaskellProject(project: Project): Boolean = {
    findProjectHaskellModules(project).nonEmpty
  }

  def isSourceFile(project: Project, virtualFile: VirtualFile): Boolean = {
    if (project.isDisposed) {
      // Well, it does not matter what is returned because is closing or closed
      false
    } else {
      val rootManager = ProjectRootManager.getInstance(project)
      val sourceRoots = rootManager.getModuleSourceRoots(JavaModuleSourceRootTypes.SOURCES).asScala.toSet.asJava
      VfsUtilCore.isUnder(virtualFile, sourceRoots)
    }
  }

  def isSourceFile(psiFile: PsiFile): Boolean = {
    val project = psiFile.getProject
    // Only source files can be only in memory
    HaskellFileUtil.findVirtualFile(psiFile).forall(vf => isSourceFile(project, vf))
  }

  def getProjectLibrarySourcesDirectory(project: Project): File = {
    new File(GlobalInfo.getLibrarySourcesPath, project.getName)
  }

  def getModuleDir(module: Module): File = {
    val path = ModuleUtilCore.getModuleDirPath(module)
    val dir = new File(path)
    dir.getName match {
      case ".idea" => new File(PathUtilRt.getParentPath(path))
      case _ => dir
    }
  }

  def findCabalFile(directory: File): Option[File] = {
    directory.listFiles.find(_.getName.endsWith(".cabal"))
  }

  def findStackFile(directory: File): Option[File] = {
    directory.listFiles.find(_.getName == "stack.yaml")
  }

  def findPackageFile(directory: File): Option[File] = {
    directory.listFiles.find(_.getName == "package.yaml")
  }

  def getProjectSearchScope(project: Project): GlobalSearchScope = {
    GlobalSearchScope.allScope(project)
  }

  import ScalaUtil._

  def findModule(psiElement: PsiElement): Option[Module] = {
    Option(ModuleUtilCore.findModuleForPsiElement(psiElement))
  }

  def findProjectHaskellModules(project: Project): Iterable[Module] = {
    Iterable()
//    ModuleManager.getInstance(project).getModules.filter(_.getModuleTypeName == HaskellModuleType.Id)
  }
}

case class GhcVersion(major: Int, minor: Int, patch: Int) extends Ordered[GhcVersion] {
  def compare(that: GhcVersion): Int = GhcVersion.asc.compare(this, that)

  def prettyString: String = {
    s"$major.$minor.$patch"
  }
}

object GhcVersion {
  val asc: Ordering[GhcVersion] = Ordering.by(unapply)

  def parse(version: String): GhcVersion = {
    val parts = version.split('.')
    GhcVersion(parts(0).toInt, parts(1).toInt, parts(2).toInt)
  }
}
