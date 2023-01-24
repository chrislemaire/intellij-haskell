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

public class AlexDeclarationImpl extends AlexElementImpl implements AlexDeclaration {

  public AlexDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AlexVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AlexVisitor) accept((AlexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AlexRuleDeclaration getRuleDeclaration() {
    return findChildByClass(AlexRuleDeclaration.class);
  }

  @Override
  @Nullable
  public AlexTokenSetDeclaration getTokenSetDeclaration() {
    return findChildByClass(AlexTokenSetDeclaration.class);
  }

}
