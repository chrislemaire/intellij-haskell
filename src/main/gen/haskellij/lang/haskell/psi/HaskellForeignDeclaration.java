// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellForeignDeclaration extends HaskellCompositeElement {

  @NotNull
  HaskellExpression getExpression();

  @NotNull
  List<HaskellPragma> getPragmaList();

}
