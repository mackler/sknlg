package org.mackler.sknlg

import Pád._
import Čislo._
import Rod._

trait Zámeno extends Noun

case class Ja(val čislo: Čislo = Jednotné) extends Zámeno {
  val rod = MužskýŽivotný
  def setČislo(č: Čislo) = copy(čislo = č)
  override def decline(pád: Pád = Nominatív) = pád match {
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

case class Ty(val čislo: Čislo = Jednotné) extends Zámeno {
  val rod = MužskýŽivotný
  def setČislo(č: Čislo) = copy(čislo = č)
  override def decline(pád: Pád = Nominatív) = pád match {
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

case class On(val čislo: Čislo = Jednotné) extends Zámeno {
  val rod = MužskýŽivotný
  def setČislo(č: Čislo) = copy(čislo = č)
  override def decline(pád: Pád = Nominatív) = pád match {
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

case class Ona(val čislo: Čislo = Jednotné) extends Zámeno {
  val rod = Ženský
  override def decline(pád: Pád = Nominatív) = pád match {
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

case class To(val čislo: Čislo) extends Zámeno {
  val rod = Stredný
  override def decline(pád: Pád = Nominatív): String = {
    pád match {
      case Nominatív => čislo match {
        case Jednotné => "to"
        case Množné => "ony"
      }
    }
  }
}

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
