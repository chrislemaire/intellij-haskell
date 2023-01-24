// This is a generated file. Not intended for manual editing.
package intellij.haskell.lang.haskell.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static intellij.haskell.lang.haskell.psi.HaskellTypes.*;
import intellij.haskell.lang.haskell.psi.*;

public class HaskellCcontextImpl extends HaskellCompositeElementImpl implements HaskellCcontext {

  public HaskellCcontextImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitCcontext(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HaskellClazz> getClazzList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellClazz.class);
  }

  @Override
  @NotNull
  public List<HaskellPragma> getPragmaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellPragma.class);
  }

}
