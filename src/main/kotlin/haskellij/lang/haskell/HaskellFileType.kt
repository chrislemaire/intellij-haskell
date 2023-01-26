package haskellij.lang.haskell

import com.intellij.openapi.fileTypes.LanguageFileType
import haskellij.HaskellIcons
import javax.swing.Icon

object HaskellFileType : LanguageFileType(HaskellLanguage) {
    override fun getName(): String =
        "Haskell"

    override fun getDescription(): String =
        "Haskell file"

    override fun getDefaultExtension(): String =
        "hs"

    override fun getIcon(): Icon =
        HaskellIcons.haskellLogo
}