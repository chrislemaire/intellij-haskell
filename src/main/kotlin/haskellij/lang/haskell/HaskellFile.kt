package haskellij.lang.haskell

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class HaskellFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, HaskellLanguage) {
    override fun getFileType(): FileType =
        HaskellFileType

    override fun toString(): String =
        "Haskell file"
}