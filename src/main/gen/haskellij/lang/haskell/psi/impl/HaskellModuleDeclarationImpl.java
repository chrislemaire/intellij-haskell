// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static haskellij.lang.haskell.psi.HaskellTypes.*;
import haskellij.lang.haskell.psi.*;

public class HaskellModuleDeclarationImpl extends HaskellCompositeElementImpl implements HaskellModuleDeclaration {

  public HaskellModuleDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitModuleDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HaskellExports getExports() {
    return findChildByClass(HaskellExports.class);
  }

  @Override
  @NotNull
  public HaskellModid getModid() {
    return findNotNullChildByClass(HaskellModid.class);
  }

  @Override
  @NotNull
  public List<HaskellPragma> getPragmaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellPragma.class);
  }

}
