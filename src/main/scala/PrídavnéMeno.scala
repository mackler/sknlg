package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._

case class PrídavnéMeno(entry: String) extends NounPhrase {
  private val root = entry.replaceFirst(".$", "")
  val (y, e, a, u, i) =
    if (finalSyllableIsLong(root)) ("y", "e", "a", "u", "i")
    else                           ("ý", "é", "á", "ú", "í")

  override def asText(pád: Pád) = asText(Stredný, Jednotné, pád)

  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív) = root + {
    čislo match {
      case Jednotné => rod match {
        case MužskýNeživotný => y
        case MužskýŽivotný => pád match {
          case Nominatív => y
          case Akusatív => e + "ho"
        }
        case Ženský => pád match {
          case Nominatív => a
          case Akusatív => u
        }
        case Stredný => e
      }

      case Množné => rod match {
        case MužskýŽivotný => pád match {
          case Nominatív => i
          case Akusatív => y + "ch"
        }
        case MužskýNeživotný | Ženský | Stredný => pád match {
          case Nominatív => e
          case Akusatív => e
        }
      }
    }
  }

}
