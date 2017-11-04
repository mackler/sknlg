package org.mackler.sknlg

import Rod._

trait PrídavnéMeno {
  protected val root: String
      // TODO obviously this will fail with a non-vowel vowel, i.e. 'ŕ' or 'ĺ'
  def longFinal(s: String): Boolean = {
    s.last match {
      case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => false
      case 'á' | 'é' | 'í' | 'ó' | 'ú' | 'ý' => true
      case _ => longFinal(s.init)
    }
  }
  def asText(rod: Rod) = root + {
    if (longFinal(root))
      rod match {
        case Mužský => "y"
        case Ženský => "a"
        case Stredný => "e"
      }
      else rod match {
        case Mužský => "ý"
        case Ženský => "á"
        case Stredný => "é"
      }
  }

}
