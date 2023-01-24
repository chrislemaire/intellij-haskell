// This is a generated file. Not intended for manual editing.
package intellij.haskell.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellCdeclDataDeclaration extends HaskellCompositeElement {

  @NotNull
  List<HaskellKindSignature> getKindSignatureList();

  @NotNull
  List<HaskellPragma> getPragmaList();

  @NotNull
  List<HaskellQName> getQNameList();

  @NotNull
  HaskellSimpletype getSimpletype();

  @Nullable
  HaskellTtype getTtype();

}
