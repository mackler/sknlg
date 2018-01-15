package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._

trait PrídavnéMeno extends NounPhrase {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String
}

object PrídavnéMeno {
  def apply(entry: String) = new PrídavnéMenoRegular(entry)
}

class PrídavnéMenoRegular(entry: String) extends PrídavnéMeno {
  private val root = entry.replaceFirst(".$", "")
  val (y, e, a, u, i) =
    if (finalSyllableIsLong(root)) ("y", "e", "a", "u", "i")
    else                           ("ý", "é", "á", "ú", "í")

  override def asText(pád: Pád) = asText(Stredný, Jednotné, pád)

  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív) = root + {
    čislo match {
      case Jednotné => rod match {
        case MužskýŽivotný => pád match {
          case Nominatív => y
          case Akusatív => e + "ho"
          case Lokál => "om"
        }
        case MužskýNeživotný => pád match {
          case Nominatív => y
          case Akusatív => y
          case Lokál => "om"
        }
        case Ženský => pád match {
          case Nominatív => a
          case Genitív => "ej"
          case Akusatív => u
          case Lokál => "ej"
        }
        case Stredný => pád match {
          case Nominatív => e
          case Akusatív => e
          case Lokál => "om"
        }
      }

      case Množné => rod match {
        case MužskýŽivotný => pád match {
          case Nominatív => i
          case Akusatív => y + "ch"
          case Lokál => y + "ch"
        }
        case MužskýNeživotný | Ženský | Stredný => pád match {
          case Nominatív => e
          case Akusatív => e
          case Lokál => y + "ch"
        }
      }
    }
  }

}
