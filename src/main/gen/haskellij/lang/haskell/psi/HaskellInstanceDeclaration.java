// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellInstanceDeclaration extends HaskellCompositeElement {

  @Nullable
  HaskellCidecls getCidecls();

  @Nullable
  HaskellInst getInst();

  @NotNull
  List<HaskellPragma> getPragmaList();

  @Nullable
  HaskellQName getQName();

  @Nullable
  HaskellScontext getScontext();

  @Nullable
  HaskellTypeEquality getTypeEquality();

  @NotNull
  List<HaskellVarid> getVaridList();

}
