package intellij.haskell.lang.cabal.psi.impl

import com.intellij.psi.PsiElement
import intellij.haskell.lang.cabal.psi.CabalTypes
import intellij.haskell.lang.haskell.psi.HaskellPsiUtil

trait MainIsImpl extends PsiElement {

  def getValue: Option[String] = {
    HaskellPsiUtil.getChildNodes(this, CabalTypes.FREEFORM).headOption.map(_.getText)
  }
}
