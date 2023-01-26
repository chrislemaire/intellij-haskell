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

public class HaskellInstvarImpl extends HaskellCompositeElementImpl implements HaskellInstvar {

  public HaskellInstvarImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitInstvar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HaskellQName getQName() {
    return findChildByClass(HaskellQName.class);
  }

  @Override
  @Nullable
  public HaskellTtype getTtype() {
    return findChildByClass(HaskellTtype.class);
  }

}
