package haskellij.lang.haskell.highlighter

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import haskellij.lang.haskell.lexer.HaskellLexer
import haskellij.lang.haskell.parser.HaskellParserDefinition.HaskellParserDefinition.AllReservedIds
import haskellij.lang.haskell.parser.HaskellParserDefinition.HaskellParserDefinition.NumberLiterals
import haskellij.lang.haskell.parser.HaskellParserDefinition.HaskellParserDefinition.Operators
import haskellij.lang.haskell.parser.HaskellParserDefinition.HaskellParserDefinition.PragmaStartEndIds
import haskellij.lang.haskell.parser.HaskellParserDefinition.HaskellParserDefinition.SymbolsResOp
import haskellij.lang.haskell.parser.HaskellParserDefinition.HaskellParserDefinition.WhiteSpaces
import haskellij.lang.haskell.psi.HaskellTypes.*
import org.jetbrains.annotations.NotNull

class HaskellSyntaxHighlighter : SyntaxHighlighterBase() {
    class Factory : SyntaxHighlighterFactory() {
        override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?): SyntaxHighlighter {
            return HaskellSyntaxHighlighter()
        }
    }

    //noinspection TypeAnnotation
    companion object HaskellSyntaxHighlighter {
        val Illegal = createTextAttributesKey("HS_ILLEGAL", INVALID_STRING_ESCAPE)
        val Comment = createTextAttributesKey("HS_COMMENT", LINE_COMMENT)
        val BlockComment = createTextAttributesKey("HS_NCOMMENT", BLOCK_COMMENT)
        val DocComment = createTextAttributesKey("HS_HADDOCK", DOC_COMMENT)
        val BlockDocComment = createTextAttributesKey("HS_NHADDOCK", DOC_COMMENT)
        val String = createTextAttributesKey("HS_STRING", STRING)
        val Number = createTextAttributesKey("HS_NUMBER", NUMBER)
        val Keyword = createTextAttributesKey("HS_KEYWORD", KEYWORD)
        val FunctionName = createTextAttributesKey("HS_FUNCTION_NAME", FUNCTION_DECLARATION)
        val Parentheses = createTextAttributesKey("HS_PARENTHESES", PARENTHESES)
        val Brace = createTextAttributesKey("HSL_BRACE", BRACES)
        val Bracket = createTextAttributesKey("HS_BRACKET", BRACKETS)
        val Variable = createTextAttributesKey("HS_VARIABLE", LOCAL_VARIABLE)
        val PragmaContent = createTextAttributesKey("HS_PRAGMA_CONTENT", IDENTIFIER)
        val Constructor = createTextAttributesKey("HS_CONSTRUCTOR", INSTANCE_FIELD)
        val Operator = createTextAttributesKey("HS_OPERATOR", OPERATION_SIGN)
        val ReservedSymbol = createTextAttributesKey("HS_SYMBOL", PREDEFINED_SYMBOL)
        val Pragma = createTextAttributesKey("HS_PRAGMA", METADATA)
        val Quasiquote = createTextAttributesKey("HS_QUASI_QUOTES", METADATA)
        val Default = createTextAttributesKey("HS_DEFAULT", LOCAL_VARIABLE)
    }

    @NotNull
    override fun getHighlightingLexer(): Lexer =
        HaskellLexer()

    @NotNull
    override fun getTokenHighlights(et: IElementType): Array<TextAttributesKey> =
        when {
            et === TokenType.BAD_CHARACTER -> pack(Illegal)
            PragmaStartEndIds.contains(et) -> pack(Pragma)
            et == HS_COMMENT -> pack(Comment)
            et == HS_HADDOCK || et == HS_NHADDOCK -> pack(DocComment)
            et == HS_NCOMMENT -> pack(BlockComment)
            et == HS_STRING_LITERAL || et == HS_CHARACTER_LITERAL -> pack(String)
            NumberLiterals.contains(et) -> pack(Number)
            et == HS_LEFT_PAREN || et == HS_RIGHT_PAREN -> pack(Parentheses)
            et == HS_LEFT_BRACE || et == HS_RIGHT_BRACE -> pack(Brace)
            et == HS_LEFT_BRACKET || et == HS_RIGHT_BRACKET -> pack(Bracket)
            AllReservedIds.contains(et) -> pack(Keyword)
            SymbolsResOp.contains(et) -> pack(ReservedSymbol)
            Operators.contains(et) -> pack(Operator)
            et == HS_VAR_ID -> pack(Variable)
            et == HS_CON_ID -> pack(Constructor)
            et == HS_MODID -> pack(Constructor)
            et == HS_QUASIQUOTE -> pack(Quasiquote)
            WhiteSpaces.contains(et) || et == HS_NEWLINE -> pack(null)
            else -> pack(Default)
        }
}