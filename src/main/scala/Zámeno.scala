package org.mackler.sknlg

import Pád._
import Čislo._
import Rod._

trait Zámeno extends Noun {
  val rod = MužskýŽivotný
  def setČislo(č: Čislo): Zámeno
}

trait Ja extends Zámeno {
  def decline(pád: Pád = Nominatív) = pád match {
    case Nominatív => čislo match {
      case Jednotné => "ja"
      case Množné => "my"
    }
    case Akusatív => čislo match {
      case Jednotné => "ma"
      case Množné => "nás"
    }
  }
}
object Ja extends Ja {
  def apply = JaInstance()
  def setČislo(č: Čislo) = JaInstance(čislo = č)
}
case class JaInstance(override val čislo: Čislo = Jednotné) extends Ja {
  def setČislo(č: Čislo) = copy(čislo = č)
}

trait Ty extends Zámeno {
  def decline(pád: Pád = Nominatív) = pád match {
    case Nominatív => čislo match {
      case Jednotné => "ty"
      case Množné => "vy"
    }
    case Akusatív => čislo match {
      case Jednotné => "ta"
      case Množné => "vás"
    }
  }
}

object Ty extends Ty {
  def apply = TyInstance()
  def setČislo(č: Čislo) = TyInstance(čislo = č)
}
case class TyInstance(override val čislo: Čislo = Jednotné) extends Ty {
  def setČislo(č: Čislo) = copy(čislo = č)
}

trait On extends Zámeno {
  def decline(pád: Pád = Nominatív) = pád match {
    case Nominatív => čislo match {
      case Jednotné => "on"
      case Množné => "oni"
    }
    case Akusatív => čislo match {
      case Jednotné => "ho"
      case Množné => "ich"
    }
  }
}
object On extends On {
  def apply = OnInstance()
  def setČislo(č: Čislo) = OnInstance(čislo = č)
}
case class OnInstance(override val čislo: Čislo = Jednotné) extends On {
  def setČislo(č: Čislo) = copy(čislo = č)
}

trait Ona extends Zámeno {
  override val rod = Ženský
  def decline(pád: Pád = Nominatív) = pád match {
    case Nominatív => čislo match {
      case Jednotné => "ona"
      case Množné => "ony"
    }
    case Akusatív => čislo match {
      case Jednotné => "ho"
      case Množné => "ich"
    }
  }
}
object Ona extends Ona {
  def apply = OnaInstance()
  def setČislo(č: Čislo) = OnaInstance(čislo = č)
}
case class OnaInstance(override val čislo: Čislo = Jednotné) extends Ona {
  def setČislo(č: Čislo) = copy(čislo = č)
}

trait To extends Zámeno {
  override val rod = Stredný
  def decline(pád: Pád = Nominatív): String = {
    pád match {
      case Nominatív => čislo match {
        case Jednotné => "to"
        case Množné => "ony"
      }
    }
  }
}
object To extends To {
  def apply = ToInstance()
  def setČislo(č: Čislo) = ToInstance(čislo = č)
}
case class ToInstance(override val čislo: Čislo = Jednotné) extends To {
  def setČislo(č: Čislo) = copy(čislo = č)
}

// TODO combine this with the preceding `To` object
// demonstrative ten, tá, to
object Ten extends NounPhrase {
  override def asText(pád: Pád) = asText(Stredný, Jednotné, pád)

  def asText(rod: Rod, čislo: Čislo, pád: Pád): String = {
    rod match {
      case MužskýŽivotný =>
        čislo match {
          case Jednotné => "ten"
          case Množné => "tí"
        }
      case MužskýNeživotný =>
        čislo match {
          case Jednotné => "ten"
          case Množné => "tie"
        }
      case Ženský =>
        čislo match {
          case Jednotné => "tá"
          case Množné =>  "tie"
        }
      case Stredný =>
        čislo match {
          case Jednotné => "to"
          case Množné =>  "tie"
        }
    }
  }
}
