// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellImportDeclaration extends HaskellCompositeElement {

  @Nullable
  HaskellImportPackageName getImportPackageName();

  @Nullable
  HaskellImportQualified getImportQualified();

  @Nullable
  HaskellImportQualifiedAs getImportQualifiedAs();

  @Nullable
  HaskellImportSpec getImportSpec();

  @Nullable
  HaskellModid getModid();

  @NotNull
  List<HaskellPragma> getPragmaList();

}
