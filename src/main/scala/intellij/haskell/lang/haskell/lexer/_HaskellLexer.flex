package intellij.haskell.lang.haskell.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static intellij.haskell.lang.haskell.psi.HaskellTypes.*;

%%

%{
  public _HaskellLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _HaskellLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+


%%
<YYINITIAL> {
  {WHITE_SPACE}                     { return WHITE_SPACE; }

  "NEWLINE"                         { return HS_NEWLINE; }
  "INCLUDE_DIRECTIVE"               { return HS_INCLUDE_DIRECTIVE; }
  "DIRECTIVE"                       { return HS_DIRECTIVE; }
  "PRAGMA_START"                    { return HS_PRAGMA_START; }
  "PRAGMA_END"                      { return HS_PRAGMA_END; }
  "ONE_PRAGMA"                      { return HS_ONE_PRAGMA; }
  "PRAGMA_SEP"                      { return HS_PRAGMA_SEP; }
  "CHARACTER_LITERAL"               { return HS_CHARACTER_LITERAL; }
  "STRING_LITERAL"                  { return HS_STRING_LITERAL; }
  "DASH"                            { return HS_DASH; }
  "HASH"                            { return HS_HASH; }
  "MODULE"                          { return HS_MODULE; }
  "WHERE"                           { return HS_WHERE; }
  "IMPORT"                          { return HS_IMPORT; }
  "LEFT_PAREN"                      { return HS_LEFT_PAREN; }
  "COMMA"                           { return HS_COMMA; }
  "RIGHT_PAREN"                     { return HS_RIGHT_PAREN; }
  "TYPE"                            { return HS_TYPE; }
  "SEMICOLON"                       { return HS_SEMICOLON; }
  "COLON_COLON"                     { return HS_COLON_COLON; }
  "EQUAL"                           { return HS_EQUAL; }
  "VERTICAL_BAR"                    { return HS_VERTICAL_BAR; }
  "RIGHT_ARROW"                     { return HS_RIGHT_ARROW; }
  "DOUBLE_RIGHT_ARROW"              { return HS_DOUBLE_RIGHT_ARROW; }
  "DATA"                            { return HS_DATA; }
  "INSTANCE"                        { return HS_INSTANCE; }
  "DERIVING"                        { return HS_DERIVING; }
  "NEWTYPE"                         { return HS_NEWTYPE; }
  "CLASS"                           { return HS_CLASS; }
  "DOT"                             { return HS_DOT; }
  "TILDE"                           { return HS_TILDE; }
  "DEFAULT"                         { return HS_DEFAULT; }
  "TYPE_INSTANCE"                   { return HS_TYPE_INSTANCE; }
  "DECIMAL"                         { return HS_DECIMAL; }
  "FOREIGN_IMPORT"                  { return HS_FOREIGN_IMPORT; }
  "FOREIGN_EXPORT"                  { return HS_FOREIGN_EXPORT; }
  "TYPE_FAMILY"                     { return HS_TYPE_FAMILY; }
  "QUASIQUOTE"                      { return HS_QUASIQUOTE; }
  "HEXADECIMAL"                     { return HS_HEXADECIMAL; }
  "OCTAL"                           { return HS_OCTAL; }
  "FLOAT"                           { return HS_FLOAT; }
  "COMMENT"                         { return HS_COMMENT; }
  "NCOMMENT"                        { return HS_NCOMMENT; }
  "HADDOCK"                         { return HS_HADDOCK; }
  "NHADDOCK"                        { return HS_NHADDOCK; }
  "NOT_TERMINATED_COMMENT"          { return HS_NOT_TERMINATED_COMMENT; }
  "VAR_ID"                          { return HS_VAR_ID; }
  "CON_ID"                          { return HS_CON_ID; }
  "VARSYM_ID"                       { return HS_VARSYM_ID; }
  "BACKSLASH"                       { return HS_BACKSLASH; }
  "AT"                              { return HS_AT; }
  "CONSYM_ID"                       { return HS_CONSYM_ID; }
  "BACKQUOTE"                       { return HS_BACKQUOTE; }
  "QUOTE"                           { return HS_QUOTE; }
  "LEFT_BRACKET"                    { return HS_LEFT_BRACKET; }
  "RIGHT_BRACKET"                   { return HS_RIGHT_BRACKET; }
  "LEFT_BRACE"                      { return HS_LEFT_BRACE; }
  "RIGHT_BRACE"                     { return HS_RIGHT_BRACE; }
  "FORALL"                          { return HS_FORALL; }
  "UNDERSCORE"                      { return HS_UNDERSCORE; }
  "INFIXL"                          { return HS_INFIXL; }
  "INFIXR"                          { return HS_INFIXR; }
  "INFIX"                           { return HS_INFIX; }
  "LIST_COMPREHENSION"              { return HS_LIST_COMPREHENSION; }
  "NOT_TERMINATED_QQ_EXPRESSION"    { return HS_NOT_TERMINATED_QQ_EXPRESSION; }
  "DOUBLE_QUOTES"                   { return HS_DOUBLE_QUOTES; }
  "LEFT_ARROW"                      { return HS_LEFT_ARROW; }
  "CASE"                            { return HS_CASE; }
  "DO"                              { return HS_DO; }
  "ELSE"                            { return HS_ELSE; }
  "IF"                              { return HS_IF; }
  "IN"                              { return HS_IN; }
  "LET"                             { return HS_LET; }
  "OF"                              { return HS_OF; }
  "THEN"                            { return HS_THEN; }


}

[^] { return BAD_CHARACTER; }
