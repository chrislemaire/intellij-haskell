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

package intellij.haskell.lang.haskell.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.AbstractElementManipulator

class HaskellNamedElementManipulator extends AbstractElementManipulator[HaskellNamedElement] {
  def handleContentChange(psi: HaskellNamedElement, range: TextRange, newContent: String): HaskellNamedElement = {
    psi.setName(newContent)
    psi
  }
}