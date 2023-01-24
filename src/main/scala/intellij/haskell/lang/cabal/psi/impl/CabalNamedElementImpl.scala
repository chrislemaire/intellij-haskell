package intellij.haskell.lang.cabal.psi.impl

import com.intellij.psi.{PsiElement, PsiReference}
import intellij.haskell.lang.cabal.psi.{CabalNamedElement, CabalReference}

trait CabalNamedElementImpl extends CabalNamedElement {

  def getVariants: Array[AnyRef]

  def resolve(): Option[PsiElement]

  override def getReference: PsiReference = {
    new CabalReference(this, getTextRange)
  }
}
