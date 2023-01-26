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

public class HaskellQConQualifier1Impl extends HaskellCompositeElementImpl implements HaskellQConQualifier1 {

  public HaskellQConQualifier1Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitQConQualifier1(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HaskellConid getConid() {
    return findNotNullChildByClass(HaskellConid.class);
  }

}
