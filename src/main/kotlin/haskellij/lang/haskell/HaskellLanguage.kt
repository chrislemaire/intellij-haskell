package haskellij.lang.haskell

import com.intellij.lang.Language

object HaskellLanguage : Language("Haskell") {
    override fun getDisplayName(): String =
        "Haskell"

    override fun isCaseSensitive(): Boolean =
        true
}