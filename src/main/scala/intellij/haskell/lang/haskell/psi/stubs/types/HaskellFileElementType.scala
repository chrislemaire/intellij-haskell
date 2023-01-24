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

package intellij.haskell.lang.haskell.psi.stubs.types

import com.intellij.psi.stubs._
import com.intellij.psi.tree.IStubFileElementType
import com.intellij.psi.{PsiElement, PsiFile, StubBuilder}
import HaskellFileElementType.HaskellFileStub
import intellij.haskell.lang.haskell.HaskellFile
import intellij.haskell.lang.haskell.HaskellLanguage

class HaskellFileElementType(language: HaskellLanguage) extends IStubFileElementType[HaskellFileStub](language) {
  override def indexStub(stub: HaskellFileStub, sink: IndexSink): Unit = {}

  private val Version: Int = 1

  override def getBuilder: StubBuilder = new DefaultStubBuilder() {
    override protected def createStubForFile(file: PsiFile): StubElement[_ <: PsiElement] = {
      file match {
        case f: HaskellFile => new HaskellFileStub(f)
        case _ => super.createStubForFile(file)
      }
    }
  }

  override def getStubVersion: Int = Version

  override def serialize(stub: HaskellFileStub, dataStream: StubOutputStream): Unit = {
  }

  override def deserialize(dataStream: StubInputStream, parentStub: StubElement[_ <: PsiElement]): HaskellFileStub = {
    new HaskellFileStub(null)
  }

  override def getExternalId: String = {
    "haskell.FILE"
  }
}

object HaskellFileElementType {
  type HaskellFileStub = PsiFileStubImpl[HaskellFile]
  val Instance = new HaskellFileElementType(HaskellLanguage.Instance)
}