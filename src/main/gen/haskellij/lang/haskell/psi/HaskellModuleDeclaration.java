// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellModuleDeclaration extends HaskellCompositeElement {

  @Nullable
  HaskellExports getExports();

  @NotNull
  HaskellModid getModid();

  @NotNull
  List<HaskellPragma> getPragmaList();

}
