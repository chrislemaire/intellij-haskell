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

import java.util.concurrent.TimeUnit

import com.intellij.openapi.application.{ApplicationManager, ReadAction}
import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.openapi.progress.util.ProgressIndicatorBase
import com.intellij.openapi.project.Project
import com.intellij.util.concurrency.AppExecutorUtil
import intellij.haskell.lang.haskell.HaskellNotificationGroup
import intellij.haskell.external.component._

import scala.concurrent.TimeoutException

object ApplicationUtil {

  def isBlockingReadAccessAllowed: Boolean = {
    ApplicationManager.getApplication.isReadAccessAllowed
  }

  def runReadAction[T](f: => T, project: Option[Project] = None): T = {
    if (isBlockingReadAccessAllowed) {
      f
    } else {
      val progressIndicator = Option(ProgressIndicatorProvider.getGlobalProgressIndicator).getOrElse(new ProgressIndicatorBase(false, false))
      val readAction = ReadAction.nonBlocking(ScalaUtil.callable(f))
      readAction.wrapProgress(progressIndicator)
      project.foreach(readAction.expireWith)
      readAction.submit(AppExecutorUtil.getAppExecutorService).get(5, TimeUnit.SECONDS)
    }
  }

  def runReadActionWithFileAccess[A](project: Project, f: => A, actionDescription: => String): Either[NoInfo, A] = {
    if (isBlockingReadAccessAllowed) {
      Right(f)
    } else {
      val progressIndicator = Option(ProgressIndicatorProvider.getGlobalProgressIndicator)
      val readAction = ReadAction.nonBlocking(ScalaUtil.callable(f)).inSmartMode(project)
      progressIndicator.foreach(readAction.wrapProgress)
      readAction.expireWith(project)
      try {
        Option(readAction.submit(AppExecutorUtil.getAppExecutorService).get(5, TimeUnit.SECONDS)) match {
          case Some(x) => Right(x)
          case None => Left(IndexNotReady)
        }
      } catch {
        case _: TimeoutException =>
          HaskellNotificationGroup.logInfoEvent(project, s"Timeout in readActionWithFileAccess while $actionDescription")
          Left(ReadActionTimeout(actionDescription))
      }
    }
  }
}

