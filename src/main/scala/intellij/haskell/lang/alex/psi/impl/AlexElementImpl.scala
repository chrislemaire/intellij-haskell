package intellij.haskell.lang.alex.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import intellij.haskell.lang.alex.psi.AlexElement

/**
  * @author ice1000
  */
class AlexElementImpl private[impl](node: ASTNode) extends ASTWrapperPsiElement(node) with AlexElement {
}
