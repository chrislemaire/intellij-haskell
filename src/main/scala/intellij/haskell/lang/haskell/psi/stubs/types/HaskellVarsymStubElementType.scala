package intellij.haskell.lang.haskell.psi.stubs.types

import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.{StubElement, StubInputStream}
import intellij.haskell.lang.haskell.psi.stubs.HaskellVarsymStub
import intellij.haskell.lang.haskell.psi.HaskellVarsym
import intellij.haskell.lang.haskell.psi.impl.HaskellVarsymImpl

class HaskellVarsymStubElementType(debugName: String) extends HaskellNamedStubElementType[HaskellVarsymStub, HaskellVarsym](debugName) {
  def createPsi(stub: HaskellVarsymStub): HaskellVarsym = {
    new HaskellVarsymImpl(stub, this)
  }

  def createStub(psi: HaskellVarsym, parentStub: StubElement[_ <: PsiElement]): HaskellVarsymStub = {
    new HaskellVarsymStub(parentStub, this, psi.getName)
  }

  def deserialize(dataStream: StubInputStream, parentStub: StubElement[_ <: PsiElement]): HaskellVarsymStub = {
    new HaskellVarsymStub(parentStub, this, dataStream.readName)
  }
}