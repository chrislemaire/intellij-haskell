package haskellij.lang.haskell.parser

import com.intellij.testFramework.ParsingTestCase

class HaskellParsingTest : ParsingTestCase("", "hs", false, HaskellParserDefinition()) {
    fun testSimpleModule() = doTest(true)

    override fun getTestDataPath(): String =
        "src/test/resources/parsing"

    override fun skipSpaces(): Boolean =
        false

    override fun includeRanges(): Boolean =
        true
}
