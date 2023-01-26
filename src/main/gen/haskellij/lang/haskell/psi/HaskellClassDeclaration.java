// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellClassDeclaration extends HaskellCompositeElement {

  @Nullable
  HaskellCdecls getCdecls();

  @NotNull
  List<HaskellPragma> getPragmaList();

  @NotNull
  List<HaskellQName> getQNameList();

  @Nullable
  HaskellScontext getScontext();

  @NotNull
  List<HaskellTtype> getTtypeList();

}
