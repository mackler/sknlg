package org.mackler.sknlg

import Rod._

case class PrídavnéMeno(entry: String) {
  private val root = entry.replaceFirst(".$", "")

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
