package intellij.haskell.lang.alex.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static intellij.haskell.lang.alex.psi.AlexTypes.*;

%%

%{
  public _AlexLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _AlexLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+


%%
<YYINITIAL> {
  {WHITE_SPACE}                       { return WHITE_SPACE; }

  "EOL"                               { return ALEX_EOL; }
  "REGEX_PART_TOKEN"                  { return ALEX_REGEX_PART_TOKEN; }
  "HASKELL_IDENTIFIER"                { return ALEX_HASKELL_IDENTIFIER; }
  "DOLLAR_AND_IDENTIFIER"             { return ALEX_DOLLAR_AND_IDENTIFIER; }
  "EMAIL_AND_IDENTIFIER"              { return ALEX_EMAIL_AND_IDENTIFIER; }
  "EQUAL"                             { return ALEX_EQUAL; }
  "SOMETHING_IS_GONNA_HAPPEN"         { return ALEX_SOMETHING_IS_GONNA_HAPPEN; }
  "SOMETHING_IS_HAPPENING"            { return ALEX_SOMETHING_IS_HAPPENING; }
  "SOMETHING_HAS_ALREADY_HAPPENED"    { return ALEX_SOMETHING_HAS_ALREADY_HAPPENED; }
  "WRAPPER_TYPE_IS_GONNA_BE_HERE"     { return ALEX_WRAPPER_TYPE_IS_GONNA_BE_HERE; }
  "STRING"                            { return ALEX_STRING; }
  "A_SYMBOL_FOLLOWED_BY_TOKENS"       { return ALEX_A_SYMBOL_FOLLOWED_BY_TOKENS; }
  "SEMICOLON"                         { return ALEX_SEMICOLON; }
  "LEFT_LISP"                         { return ALEX_LEFT_LISP; }
  "RIGHT_LISP"                        { return ALEX_RIGHT_LISP; }
  "PUBLIC_REGEX"                      { return ALEX_PUBLIC_REGEX; }
  "STATEFUL_TOKENS_RULE_START"        { return ALEX_STATEFUL_TOKENS_RULE_START; }
  "STATEFUL_TOKENS_RULE_END"          { return ALEX_STATEFUL_TOKENS_RULE_END; }


}

[^] { return BAD_CHARACTER; }
