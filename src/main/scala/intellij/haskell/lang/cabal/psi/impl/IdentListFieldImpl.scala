package intellij.haskell.lang.cabal.psi.impl

import com.intellij.psi.PsiElement
import intellij.haskell.lang.cabal.psi.{CabalTypes, IdentList}
import intellij.haskell.lang.haskell.psi.HaskellPsiUtil

trait IdentListFieldImpl extends PsiElement {

  /** Retrieves the extension names as strings. */
  def getValue: Array[String] = HaskellPsiUtil.getChildOfType(this, classOf[IdentList]) match {
    case None => Array.empty
    case Some(el) => HaskellPsiUtil.getChildNodes(el, CabalTypes.IDENT).map(_.getText)
  }
}

