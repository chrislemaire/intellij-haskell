package haskellij.lang.haskell.parser

import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.TokenType.WHITE_SPACE
import haskellij.lang.haskell.psi.HaskellTypes.*

object HaskellParserUtil : GeneratedParserUtilBase() {
    @JvmStatic
    fun containsSpaces(builder: PsiBuilder, level: Int): Boolean =
        builder.rawLookup(0) === HS_NEWLINE && (
                builder.rawLookup(1) === WHITE_SPACE
                        || builder.rawLookup(1) === HS_COMMENT)
                || builder.rawLookup(1) === HS_NCOMMENT
                || builder.rawLookup(1) === HS_DIRECTIVE
                || builder.rawLookup(1) === HS_HADDOCK
                || builder.rawLookup(1) === HS_NHADDOCK
                || (builder.rawLookup(0) === HS_NEWLINE && builder.rawLookup(1) === HS_NEWLINE
                && builder.rawLookup((1..7).first { builder.rawLookup(it) !== HS_NEWLINE }) === WHITE_SPACE)

    @JvmStatic
    fun noSpaceAfterQualifier(builder: PsiBuilder, level: Int): Boolean =
        builder.rawLookup(0) === HS_CON_ID && builder.rawLookup(1) === HS_DOT
}