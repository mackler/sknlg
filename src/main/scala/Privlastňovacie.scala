package org.mackler.sknlg.slovník

import org.mackler.sknlg._
import Rod._
import Čislo._
import Pád._

/*
 * Possessive Pronouns
 */

object Môj extends PrídavnéMeno {
  def asText(pád: Pád) = asText(Stredný, Jednotné, pád)

  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String = {
    čislo match {
      case Jednotné => rod match {
        case MužskýŽivotný | MužskýNeživotný => pád match {
          case Nominatív => "môj"
          case Akusatív => rod match {
            case MužskýŽivotný => "môjho"
            case MužskýNeživotný => "môj"
          }
          case Lokatív => "mojom"
        }

        case Ženský => pád match {
          case Nominatív => "moja"
          case Akusatív => "moju"
          case Lokatív => "mojej"
        }

        case Stredný => pád match {
          case Nominatív | Akusatív => "moje"
          case Lokatív => "mojom"
        }
      }

      case Množné => rod match {
        case MužskýŽivotný => pád match {
          case Nominatív => "moji"
          case Akusatív | Lokatív => "mojich"
        }
        case MužskýNeživotný | Ženský | Stredný => pád match {
          case Nominatív | Akusatív => "moje"
          case Lokatív => "mojich"
        }
      }
    }
  }
}

object Tvoj extends PrídavnéMeno {
  def asText(pád: Pád) = asText(Stredný, Jednotné, pád)

  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String = {
    čislo match {
      case Jednotné => rod match {
        case MužskýŽivotný | MužskýNeživotný => pád match {
          case Nominatív => "tvoj"
          case Akusatív => rod match {
            case MužskýŽivotný => "tvojho"
            case MužskýNeživotný => "tvoj"
          }
          case Lokatív => "tvojom"
        }

        case Ženský => pád match {
          case Nominatív => "tvoja"
          case Akusatív => "tvoju"
          case Lokatív => "tvojej"
        }

        case Stredný => pád match {
          case Nominatív | Akusatív => "tvoje"
          case Lokatív => "tvojom"
        }
      }

      case Množné => rod match {
        case MužskýŽivotný => pád match {
          case Nominatív => "tvoji"
          case Akusatív | Lokatív => "tvojich"
        }
        case MužskýNeživotný | Ženský | Stredný => pád match {
          case Nominatív | Akusatív => "tvoje"
          case Lokatív => "tvojich"
        }
      }
    }
  }
}


