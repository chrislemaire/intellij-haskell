/*
 * Copyright 2014-2020 Rik van der Kleij
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package intellij.haskell.lang.haskell.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import icons.HaskellIcons
import HaskellSyntaxHighlighter._
import javax.swing._
import org.jetbrains.annotations.NotNull

import scala.jdk.CollectionConverters._

object HaskellColorSettingsPage {
  private final val Attrs = Array[AttributesDescriptor](
    new AttributesDescriptor("Illegal character", Illegal),
    new AttributesDescriptor("Comment", Comment),
    new AttributesDescriptor("Block comment", BlockComment),
    new AttributesDescriptor("String", String),
    new AttributesDescriptor("Number", Number),
    new AttributesDescriptor("Keyword", Keyword),
    new AttributesDescriptor("Parentheses", Parentheses),
    new AttributesDescriptor("Brace", Brace),
    new AttributesDescriptor("Bracket", Bracket),
    new AttributesDescriptor("Variable", Variable),
    new AttributesDescriptor("Function name", FunctionName),
    new AttributesDescriptor("Constructor", Constructor),
    new AttributesDescriptor("Operator", Operator),
    new AttributesDescriptor("Reserved symbol", ReservedSymbol),
    new AttributesDescriptor("Pragma", Pragma),
    new AttributesDescriptor("Pragma content", PragmaContent),
    new AttributesDescriptor("Quasiquote", Quasiquote),
    new AttributesDescriptor("Default", Default))

  private final val AttributesKeyMap = Map[String, TextAttributesKey](
    "keyword" -> Keyword,
    "functionName" -> FunctionName,
    "pragmaContent" -> PragmaContent
  )
}

class HaskellColorSettingsPage extends ColorSettingsPage {

  @NotNull
  def getDisplayName: String = {
    "Haskell"
  }

  def getIcon: Icon = {
    HaskellIcons.HaskellLogo
  }

  @NotNull
  def getAttributeDescriptors: Array[AttributesDescriptor] = {
    HaskellColorSettingsPage.Attrs
  }

  @NotNull
  def getColorDescriptors: Array[ColorDescriptor] = {
    ColorDescriptor.EMPTY_ARRAY
  }

  @NotNull
  def getHighlighter: SyntaxHighlighter = {
    new HaskellSyntaxHighlighter
  }

  @NotNull
  def getDemoText: String = {
    """{-# LANGUAGE <pragmaContent>CPP</pragmaContent> #-}
      |module ModuleName
      |import <keyword>qualified</keyword> ImportModuleName
      |"string literal"
      |'c'
      |<functionName>intPair</functionName> :: (Int, Int)
      |intPair = (456,434)
      |-- line comment
      |{- nested
      |comment -}
      |data Bool = True | False
      |let l1 = [1, 2]
      |let l2 = 1 : []
      |let two = 1 + 1
      |let f = \_ + 1
      |[t|select * from foo|]""".stripMargin
  }

  @NotNull
  def getAdditionalHighlightingTagToDescriptorMap: java.util.Map[String, TextAttributesKey] = {
    HaskellColorSettingsPage.AttributesKeyMap.asJava
  }
}