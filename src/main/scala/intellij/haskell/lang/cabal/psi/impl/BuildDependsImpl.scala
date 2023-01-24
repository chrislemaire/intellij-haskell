package intellij.haskell.lang.cabal.psi.impl

import com.intellij.psi.PsiElement
import intellij.haskell.lang.cabal.psi.{CabalTypes, Dependencies, Dependency}
import intellij.haskell.lang.haskell.psi.HaskellPsiUtil

trait BuildDependsImpl extends PsiElement {

  /** Retrieves the package names as strings. */
  def getPackageNames: Array[String] = HaskellPsiUtil.getChildOfType(this, classOf[Dependencies]) match {
    case None => Array.empty
    case Some(el) =>
      val res =
        HaskellPsiUtil.streamChildren(el, classOf[Dependency]).flatMap(c =>
          HaskellPsiUtil.getChildNodes(c, CabalTypes.DEPENDENCY_NAME).headOption.map(_.getText)
        ).toArray
      res
  }
}
