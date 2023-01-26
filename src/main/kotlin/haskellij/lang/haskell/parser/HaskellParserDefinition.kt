package haskellij.lang.haskell.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import haskellij.lang.haskell.HaskellFile
import haskellij.lang.haskell.lexer.HaskellLexerAdapter
import haskellij.lang.haskell.psi.HaskellElementTypes
import haskellij.lang.haskell.psi.HaskellTypes.*
import org.jetbrains.annotations.NotNull

class HaskellParserDefinition : ParserDefinition {
    //noinspection TypeAnnotation
    companion object HaskellParserDefinition {
        val WhiteSpaces = TokenSet.create(TokenType.WHITE_SPACE)
        val Comments = TokenSet.create(HS_COMMENT, HS_NCOMMENT, HS_HADDOCK, HS_NHADDOCK)
        val PragmaStartEndIds = TokenSet.create(HS_PRAGMA_START, HS_PRAGMA_END)
        val ReservedIdS = TokenSet.create(HS_CASE, HS_CLASS, HS_DATA, HS_DEFAULT, HS_DERIVING, HS_DO, HS_ELSE, HS_IF, HS_IMPORT,
            HS_IN, HS_INFIX, HS_INFIXL, HS_INFIXR, HS_INSTANCE, HS_LET, HS_MODULE, HS_NEWTYPE, HS_OF, HS_THEN, HS_TYPE, HS_WHERE, HS_UNDERSCORE)
        val SpecialReservedIds = TokenSet.create(HS_TYPE_FAMILY, HS_FOREIGN_IMPORT, HS_FOREIGN_EXPORT, HS_TYPE_INSTANCE)
        val AllReservedIds = TokenSet.orSet(ReservedIdS, SpecialReservedIds)
        val ReservedOperators = TokenSet.create(HS_COLON_COLON, HS_EQUAL, HS_BACKSLASH, HS_VERTICAL_BAR, HS_LEFT_ARROW,
            HS_RIGHT_ARROW, HS_AT, HS_TILDE, HS_DOUBLE_RIGHT_ARROW, HS_DOT_DOT)
        val Operators = TokenSet.orSet(ReservedOperators, TokenSet.create(HS_VARSYM_ID, HS_CONSYM_ID), TokenSet.create(HS_DOT))
        val NumberLiterals = TokenSet.create(HS_DECIMAL, HS_FLOAT, HS_HEXADECIMAL, HS_OCTAL)
        val SymbolsResOp = TokenSet.create(HS_EQUAL, HS_AT, HS_BACKSLASH, HS_VERTICAL_BAR, HS_TILDE)
        val StringLiterals = TokenSet.create(HS_CHARACTER_LITERAL, HS_STRING_LITERAL)
        val Literals = TokenSet.orSet(StringLiterals, NumberLiterals, TokenSet.create(HS_QUASIQUOTE))
        val HaskellParser = HaskellParser()
        val Ids = TokenSet.create(HS_VAR_ID, HS_CON_ID, HS_VARSYM_ID, HS_CONSYM_ID)
    }

    @NotNull
    override fun createLexer(project: Project): Lexer =
        HaskellLexerAdapter()

    override fun createParser(project: Project): PsiParser =
        HaskellParser

    override fun getFileNodeType(): IFileElementType =
        HaskellElementTypes.HaskellFileElementType

    @NotNull
    override fun getWhitespaceTokens(): TokenSet =
        WhiteSpaces

    @NotNull
    override fun getCommentTokens(): TokenSet =
        Comments

    @NotNull
    override fun getStringLiteralElements(): TokenSet =
        StringLiterals

    @NotNull
    override fun createElement(node: ASTNode): PsiElement =
        Factory.createElement(node)

    @NotNull
    override fun createFile(viewProvider: FileViewProvider): PsiFile =
        HaskellFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements =
        ParserDefinition.SpaceRequirements.MAY
}