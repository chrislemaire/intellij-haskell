// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellExports extends HaskellCompositeElement {

  @NotNull
  List<HaskellExport> getExportList();

  @NotNull
  List<HaskellPragma> getPragmaList();

}
