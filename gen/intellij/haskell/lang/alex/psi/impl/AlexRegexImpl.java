// This is a generated file. Not intended for manual editing.
package intellij.haskell.lang.alex.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static intellij.haskell.lang.alex.psi.AlexTypes.*;
import intellij.haskell.lang.alex.psi.*;

public class AlexRegexImpl extends AlexElementImpl implements AlexRegex {

  public AlexRegexImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AlexVisitor visitor) {
    visitor.visitRegex(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AlexVisitor) accept((AlexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AlexRegexPart getRegexPart() {
    return findChildByClass(AlexRegexPart.class);
  }

  @Override
  @Nullable
  public AlexTokenSetId getTokenSetId() {
    return findChildByClass(AlexTokenSetId.class);
  }

}
