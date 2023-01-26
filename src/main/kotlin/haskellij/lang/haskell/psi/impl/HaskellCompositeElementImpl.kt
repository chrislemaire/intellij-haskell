package haskellij.lang.haskell.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import haskellij.lang.haskell.psi.HaskellCompositeElement

open class HaskellCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), HaskellCompositeElement {
    override fun toString(): String =
        node.elementType.toString()
}