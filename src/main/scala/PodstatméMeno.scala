package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import Skloňovanie._

trait PodstatméMeno {
  protected val entry: String
  val rod:          Rod
  val čislo:        Čislo
  val prídavnéMeno: Option[PrídavnéMeno] = None
  private lazy val skloňovanie = rod match {
    case MužskýŽivotný =>
      if (entry.endsWith("a"))                               Hrdina
      else                                                   Chlap
    case MužskýNeživotný =>
      if (Spoluhláska.soft.exists(entry.endsWith))           Stroj
      else                                                   Dub
    case Ženský =>
      if (Set("c","s","p","v","st").exists(entry.endsWith))  Kosť
      else if ((Spoluhláska.hard ++ Spoluhláska.neutral).exists(c => entry.endsWith(c + "a")))
                                                             Žena
        else if (entry.endsWith("a"))                        Ulica
        else                                                 Dlaň
    case Stredný =>
      if (entry.endsWith("o"))                               Mesto
      else if (entry.endsWith("ie"))                         Vysvedčenie
      else if (entry.endsWith("e"))                          Srdce
      else if (entry.endsWith("a") || entry.endsWith("ä"))   Dievča
    }

  protected def decline(pád: Pád): String = {
    skloňovanie match {
      case Chlap => pád match {
        case Nominative => čislo match {
          case Jednotné => entry
          case Množné   => entry.replaceFirst("a$", "i")
        }
        case Accusative => čislo match {
          case Jednotné => entry.replaceFirst("a$", "a")
          case Množné   => entry.replaceFirst("a$", "ov")
        }
      }
      case Dub => čislo match {
        case Jednotné => entry
        case Množné   => entry + "y"
      }
      case Stroj => entry

      case Dlaň => entry

      case Žena => pád match {
        case Nominative => čislo match {
          case Jednotné => entry
          case Množné   => entry.replaceFirst("a$", "y")
        }
        case Accusative => čislo match {
          case Jednotné => entry.replaceFirst("a$", "a")
          case Množné   => entry.replaceFirst("a$", "u")
        }
      }
      case Mesto => čislo match {
        case Jednotné => entry
        case Množné   => entry + "á"
      }
      case Srdce => entry
      case Vysvedčenie => čislo match {
        case Jednotné => entry
      }
      case Dievča => entry
    }
  }

  def asText(pád: Pád = Nominative) =
    (prídavnéMeno map { a => a.asText(rod) + " " }).getOrElse("") + decline(pád)
//    skloňovanie(pád.id)(čislo.id)
}

abstract class PodstatméMenoFactory(entry: String, rod: Rod) {
  class PodstatméMenoInstance(
    override protected val entry        : String,
    override           val rod          : Rod,
    override           val čislo        : Čislo,
    override           val prídavnéMeno : Option[PrídavnéMeno]
  ) extends PodstatméMeno

  def apply(čislo: Čislo = Jednotné, prídavnéMeno: Option[PrídavnéMeno] = None) = {
    new PodstatméMenoInstance(entry, rod, čislo, prídavnéMeno)
  }
}

object Spoluhláska {
  val hard = Set("g", "h", "ch", "k", "d", "n", "t")
  val soft = Set("c", "dz", "j", "ď", "ť", "ľ", "ň", "ž", "č")
  val neutral = Set("b", "f", "l", "m", "p", "r", "s", "v", "z")
}

trait Zámeno extends PodstatméMeno {
  protected val skloňovanie: Array[Array[String]]
  override def decline(pád: Pád = Nominative) =
    skloňovanie(pád.id)(čislo.id)
}

case class Ja(val čislo: Čislo) extends Zámeno {
  val entry = "ja"
  val rod = MužskýŽivotný
  override protected val skloňovanie = Array(
      Array(entry, "my"),
      Array("ma", "nás")
    )
}

case class Ty(val čislo: Čislo) extends Zámeno {
  override val entry = "ty"
  val rod = MužskýŽivotný
  override protected val skloňovanie = Array(
      Array(entry, "vy"),
      Array("ťa", "vás")
    )
}

case class On(val čislo: Čislo) extends Zámeno {
  override val entry = "on"
  val rod = MužskýŽivotný
  override protected val skloňovanie = Array(
      Array(entry, "oni"),
      Array("ho", "ich")
    )
}

case class Ona(val čislo: Čislo) extends Zámeno {
  override val entry = "ona"
  val rod = Ženský
  override protected val skloňovanie = Array(
      Array(entry, "oni"),
      Array("ho", "ich")
    )
}

case class To(val čislo: Čislo) extends Zámeno {
  override val entry = "to"
  val rod = Stredný
  override protected val skloňovanie = Array(
      Array(entry, "oni"),
      Array("error", "error")
    )
}
