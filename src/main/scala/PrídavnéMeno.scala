package org.mackler.sknlg

import Rod._

trait PrídavnéMeno {
  protected val root: String
  // We make the final vowel short if the preceding syllable is long.
  // TODO obviously this will fail with a non-vowel vowel, i.e. 'ŕ' or 'ĺ'
  def longFinal(s: String): Boolean = {
    if (s.length <= 1) false // root contains no vowel
    else s.last match {
      case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => false // last syllable in the root is short
      case 'á' | 'é' | 'í' | 'ó' | 'ú' | 'ý' => true
      case _ => longFinal(s.init)
    }
  }
  def asText(rod: Rod) = root + {
    if (longFinal(root))
      rod match {
        case MužskýŽivotný | MužskýNeživotný => "y"
        case Ženský => "a"
        case Stredný => "e"
      }
      else rod match {
        case MužskýŽivotný | MužskýNeživotný  => "ý"
        case Ženský => "á"
        case Stredný => "é"
      }
  }

}
