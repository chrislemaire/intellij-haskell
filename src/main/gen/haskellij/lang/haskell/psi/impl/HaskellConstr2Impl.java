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

public class HaskellConstr2Impl extends HaskellCompositeElementImpl implements HaskellConstr2 {

  public HaskellConstr2Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitConstr2(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HaskellPragma> getPragmaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellPragma.class);
  }

  @Override
  @NotNull
  public List<HaskellQName> getQNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellQName.class);
  }

  @Override
  @NotNull
  public List<HaskellTtype> getTtypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTtype.class);
  }

  @Override
  @NotNull
  public List<HaskellTypeSignature> getTypeSignatureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTypeSignature.class);
  }

}
