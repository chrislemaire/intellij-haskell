package intellij.haskell.lang.cabal.psi

import com.intellij.psi.PsiElement
import intellij.haskell.lang.haskell.psi.HaskellPsiUtil

object CabalPsiUtil {

  def getFieldContext(el: PsiElement): Option[CabalFieldElement] = {
    HaskellPsiUtil.collectFirstParent(el) { case el: CabalFieldElement => el }
  }
}
