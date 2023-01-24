package intellij.haskell.lang.cabal.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiNamedElement, PsiReferenceBase}
import intellij.haskell.lang.cabal.psi.impl.CabalNamedElementImpl

final class CabalReference(el: CabalNamedElementImpl, textRange: TextRange)
  extends PsiReferenceBase[PsiNamedElement](el, textRange) {

  override def getVariants: Array[AnyRef] = el.getVariants

  override def resolve(): PsiElement = el.resolve().orNull
}
