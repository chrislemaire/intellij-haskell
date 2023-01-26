// This is a generated file. Not intended for manual editing.
package haskellij.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellCidecl extends HaskellCompositeElement {

  @Nullable
  HaskellDataDeclaration getDataDeclaration();

  @Nullable
  HaskellDefaultDeclaration getDefaultDeclaration();

  @NotNull
  List<HaskellDotDot> getDotDotList();

  @Nullable
  HaskellInstanceDeclaration getInstanceDeclaration();

  @Nullable
  HaskellNewtypeDeclaration getNewtypeDeclaration();

  @Nullable
  HaskellPragma getPragma();

  @NotNull
  List<HaskellQName> getQNameList();

  @NotNull
  List<HaskellQuasiQuote> getQuasiQuoteList();

  @NotNull
  List<HaskellTextLiteral> getTextLiteralList();

  @Nullable
  HaskellTypeDeclaration getTypeDeclaration();

  @Nullable
  HaskellTypeFamilyDeclaration getTypeFamilyDeclaration();

}
