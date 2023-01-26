// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellSimpletype extends HaskellCompositeElement {

  @NotNull
  List<HaskellPragma> getPragmaList();

  @NotNull
  List<HaskellQName> getQNameList();

  @Nullable
  HaskellTtype getTtype();

  @NotNull
  List<HaskellTypeSignature> getTypeSignatureList();

  //WARNING: getIdentifierElements(...) is skipped
  //matching getIdentifierElements(HaskellSimpletype, ...)
  //methods are not found in HaskellPsiImplUtil

}
