package intellij.haskell.lang.cabal.psi.impl

import com.intellij.psi.PsiElement
import intellij.haskell.lang.cabal.psi.CabalTypes
import intellij.haskell.lang.haskell.psi.HaskellPsiUtil

trait SourceDirsImpl extends PsiElement {

  /** Retrieves the source dir paths as strings. */
  def getValue: Array[String] = {
    HaskellPsiUtil.getChildNodes(this, CabalTypes.SOURCE_DIR).map(_.getText)
  }
}
