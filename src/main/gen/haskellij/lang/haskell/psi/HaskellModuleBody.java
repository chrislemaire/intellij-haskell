// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellModuleBody extends HaskellCompositeElement {

  @Nullable
  HaskellImportDeclarations getImportDeclarations();

  @Nullable
  HaskellModuleDeclaration getModuleDeclaration();

  @NotNull
  List<HaskellPragma> getPragmaList();

  @NotNull
  List<HaskellTopDeclaration> getTopDeclarationList();

}
