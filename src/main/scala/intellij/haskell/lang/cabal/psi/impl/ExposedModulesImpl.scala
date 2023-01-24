package intellij.haskell.lang.cabal.psi.impl

import com.intellij.psi.PsiElement
import intellij.haskell.lang.cabal.psi.{Module, ModuleList}
import intellij.haskell.lang.haskell.psi.HaskellPsiUtil

trait ExposedModulesImpl extends PsiElement {

  def getModuleNames: Array[String] = {
    HaskellPsiUtil.getChildOfType(this, classOf[ModuleList]) match {
      case None => Array.empty
      case Some(moduleList) => HaskellPsiUtil.streamChildren(moduleList, classOf[Module]).map(c => c.getModuleName ).toArray
    }
  }
}
