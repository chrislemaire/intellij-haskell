// This is a generated file. Not intended for manual editing.
package intellij.haskell.lang.haskell.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import scala.Option;
import scala.collection.immutable.Seq;

public interface HaskellTypeInstanceDeclaration extends HaskellDeclarationElement {

  @NotNull
  HaskellExpression getExpression();

  @NotNull
  List<HaskellPragma> getPragmaList();

  String getName();

  ItemPresentation getPresentation();

  Seq<HaskellNamedElement> getIdentifierElements();

  Option<String> getModuleName();

}
