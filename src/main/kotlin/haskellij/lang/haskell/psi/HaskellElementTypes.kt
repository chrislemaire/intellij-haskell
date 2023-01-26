package haskellij.lang.haskell.psi

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import haskellij.lang.haskell.HaskellLanguage
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull
import java.util.*

object HaskellElementTypes {
    object HaskellFileElementType : IFileElementType(HaskellLanguage)

    class HaskellCompositeElementType(@NotNull @NonNls debugName: String) : IElementType(debugName, HaskellLanguage)

    class HaskellTokenType(@NotNull @NonNls debugName: String) : IElementType(debugName, HaskellLanguage) {
        fun getName(): String =
            super.toString().lowercase(Locale.getDefault())

        override fun toString(): String =
            "HaskellTokenType." + super.toString()
    }
}