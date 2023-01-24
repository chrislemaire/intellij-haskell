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

public class HaskellCideclImpl extends HaskellCompositeElementImpl implements HaskellCidecl {

  public HaskellCideclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitCidecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HaskellDataDeclaration getDataDeclaration() {
    return PsiTreeUtil.getChildOfType(this, HaskellDataDeclaration.class);
  }

  @Override
  @Nullable
  public HaskellDefaultDeclaration getDefaultDeclaration() {
    return PsiTreeUtil.getChildOfType(this, HaskellDefaultDeclaration.class);
  }

  @Override
  @NotNull
  public List<HaskellDotDot> getDotDotList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellDotDot.class);
  }

  @Override
  @Nullable
  public HaskellInstanceDeclaration getInstanceDeclaration() {
    return PsiTreeUtil.getChildOfType(this, HaskellInstanceDeclaration.class);
  }

  @Override
  @Nullable
  public HaskellNewtypeDeclaration getNewtypeDeclaration() {
    return PsiTreeUtil.getChildOfType(this, HaskellNewtypeDeclaration.class);
  }

  @Override
  @Nullable
  public HaskellPragma getPragma() {
    return PsiTreeUtil.getChildOfType(this, HaskellPragma.class);
  }

  @Override
  @NotNull
  public List<HaskellQName> getQNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellQName.class);
  }

  @Override
  @NotNull
  public List<HaskellQuasiQuote> getQuasiQuoteList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellQuasiQuote.class);
  }

  @Override
  @NotNull
  public List<HaskellTextLiteral> getTextLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTextLiteral.class);
  }

  @Override
  @Nullable
  public HaskellTypeDeclaration getTypeDeclaration() {
    return PsiTreeUtil.getChildOfType(this, HaskellTypeDeclaration.class);
  }

  @Override
  @Nullable
  public HaskellTypeFamilyDeclaration getTypeFamilyDeclaration() {
    return PsiTreeUtil.getChildOfType(this, HaskellTypeFamilyDeclaration.class);
  }

}
