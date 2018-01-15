package org.mackler.sknlg.slovník

import org.mackler.sknlg._
import Rod._
import Čislo._
import Pád._

/*
 * Possessive Pronouns
 */

sealed trait Privlastňovacie extends PrídavnéMeno {
  def asText(pád: Pád) = asText(Stredný, Jednotné, pád)
  def setČislo(č: Čislo): Privlastňovacie
}

sealed trait MôjBase extends Privlastňovacie {

  def decline(stem: String, rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String = {
    val shortStem = stem.replaceFirst("ô","o").replaceFirst("á","a")
    čislo match {
      case Jednotné => rod match {
        case MužskýŽivotný | MužskýNeživotný => pád match {
          case Nominatív => stem
          case Akusatív => rod match {
            case MužskýŽivotný => stem + "ho"
            case MužskýNeživotný => stem
          }
          case Lokál => shortStem + "om"
        }

        case Ženský => pád match {
          case Nominatív => shortStem + "a"
          case Akusatív => shortStem + "u"
          case Lokál => shortStem + "ej"
        }

        case Stredný => pád match {
          case Nominatív | Akusatív => shortStem + "e"
          case Lokál => shortStem + "om"
        }
      }

      case Množné => rod match {
        case MužskýŽivotný => pád match {
          case Nominatív => shortStem + "i"
          case Akusatív | Lokál => shortStem + "ich"
        }
        case MužskýNeživotný | Ženský | Stredný => pád match {
          case Nominatív | Akusatív => shortStem + "e"
          case Lokál => shortStem + "ich"
        }
      }
    }
  }

  def setČislo(č: Čislo): MôjBase = č match {
    case Jednotné => this match {
      case Môj | Tvoj => this
      case Náš => Môj
      case Váš => Tvoj
      case Svoj => Svoj
    }
    case Množné => this match {
      case Náš | Váš => this
      case Môj => Náš
      case Tvoj => Váš
      case Svoj => Svoj
    }
  }
}

object Môj extends MôjBase {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String =
    decline("môj", rod, čislo, pád)
}

object Náš extends MôjBase {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String =
    decline("náš", rod, čislo, pád)
}

object Tvoj extends MôjBase {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String =
    decline("tvoj", rod, čislo, pád)
}

object Váš extends MôjBase {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String =
    decline("váš", rod, čislo, pád)
}

object Svoj extends MôjBase {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String =
    decline("svoj", rod, čislo, pád)
}

trait Jeho extends Privlastňovacie {
  def setČislo(č: Čislo): Jeho = č match {
    case Jednotné => this match {
      case Jeho => Jeho
      case Jej => Jej
    }
    case Množné => Ich
  }
  def setRod(r: Rod) = r match {
    case MužskýŽivotný => this match {
      case Ich => Ich
      case Jeho | Jej => Jeho
    }
    case Ženský => this match {
      case Ich => Ich
      case Jeho | Jej => Jej
    }
  }
}

object Jeho extends Jeho {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String = "jeho"
}

object Jej extends Jeho {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String = "jej"
}
object Ich extends Jeho {
  def asText(rod: Rod, čislo: Čislo = Jednotné, pád: Pád = Nominatív): String = "ich"
}
