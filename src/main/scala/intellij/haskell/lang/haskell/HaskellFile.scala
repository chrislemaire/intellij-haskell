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

package intellij.haskell.lang.haskell

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes._
import com.intellij.psi.FileViewProvider
import intellij.haskell.lang.haskell.{HaskellFileType, HaskellLanguage}

import javax.swing._
import org.jetbrains.annotations.NotNull

class HaskellFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, HaskellLanguage.Instance) {

  @NotNull
  def getFileType: FileType = {
    HaskellFileType.INSTANCE
  }

  override def toString: String = {
    "Haskell file"
  }

  override def getIcon(flags: Int): Icon = {
    super.getIcon(flags)
  }
}
