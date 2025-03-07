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

public class HaskellConstrImpl extends HaskellCompositeElementImpl implements HaskellConstr {

  public HaskellConstrImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitConstr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HaskellConstr1 getConstr1() {
    return findChildByClass(HaskellConstr1.class);
  }

  @Override
  @Nullable
  public HaskellConstr2 getConstr2() {
    return findChildByClass(HaskellConstr2.class);
  }

  @Override
  @Nullable
  public HaskellConstr3 getConstr3() {
    return findChildByClass(HaskellConstr3.class);
  }

}
