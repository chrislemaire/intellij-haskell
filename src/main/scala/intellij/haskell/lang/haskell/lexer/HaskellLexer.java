package intellij.haskell.lang.haskell.lexer;

import com.intellij.lexer.FlexAdapter;
import intellij.haskell.lang.haskell._HaskellLexer;

public class HaskellLexer extends FlexAdapter {
    public HaskellLexer() {
        super(new _HaskellLexer());
    }
}
