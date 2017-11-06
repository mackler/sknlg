package org.mackler.sknlg

import Rod._

trait PrídavnéMeno {
  protected val root: String

  def asText(rod: Rod) = root + {
    if (finalSyllableIsLong(root))
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
