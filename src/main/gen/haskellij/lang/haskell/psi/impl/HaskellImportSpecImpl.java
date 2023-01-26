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

public class HaskellImportSpecImpl extends HaskellCompositeElementImpl implements HaskellImportSpec {

  public HaskellImportSpecImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitImportSpec(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HaskellImportEmptySpec getImportEmptySpec() {
    return findChildByClass(HaskellImportEmptySpec.class);
  }

  @Override
  @Nullable
  public HaskellImportHidingSpec getImportHidingSpec() {
    return findChildByClass(HaskellImportHidingSpec.class);
  }

  @Override
  @Nullable
  public HaskellImportIdsSpec getImportIdsSpec() {
    return findChildByClass(HaskellImportIdsSpec.class);
  }

}
