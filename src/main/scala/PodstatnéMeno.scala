package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import Skloňovanie._

abstract class PodstatnéMenoFactory(entry: String, rod: Rod) {
  case class PodstatnéMenoInstance(
    override protected val entry        : String,
    override           val rod          : Rod,
    override           val čislo        : Čislo,
    override           val prídavnéMeno : Option[PrídavnéMeno],
    override protected val demonstrative: Boolean,
    _predložka: Option[String] = None
  ) extends PodstatnéMeno {
    def predložka(p: String) = this.copy(_predložka = Some(p))
    def predložka() = _predložka
    def setČislo(č: Čislo) = this.copy(čislo = č)
    override def asText(pád: Pád) = _predložka.map(_ + " ").getOrElse("") + super.asText(pád)
  }

  def apply(čislo: Čislo = Jednotné, prídavnéMeno: Option[PrídavnéMeno] = None, demonstrative: Boolean = false) = {
    new PodstatnéMenoInstance(entry, rod, čislo, prídavnéMeno, demonstrative)
  }
}

/* This is the superclass of both pronouns (zámeno) and common nouns (podstatmé meno) */
trait Noun {
val rod: Rod
  val čislo:        Čislo
  protected def decline(pád: Pád): String
  def asText(pád: Pád = Nominatív) = decline(pád)
}

/* Person names */
case class Pomenovanie(name: String, rod: Rod) extends Noun {
  override val čislo = Jednotné
  override def decline(pad: Pád = Nominatív) = name
}

/* These are only common nouns (not pronouns) */
trait PodstatnéMeno extends Noun {
  protected val entry         : String   // form of the slovo as listed in a slovník
  override  val rod          : Rod // removing this line causes an exception that looks like a bug
  val prídavnéMeno            : Option[PrídavnéMeno] = None
  protected val demonstrative : Boolean

  override def asText(pád: Pád = Nominatív) =
    (if (demonstrative) ten(rod, čislo, pád) + " " else "") +
    (prídavnéMeno map { a => a.asText(rod) + " " }).getOrElse("") +
    super.asText(pád)

  object Spoluhláska {
    val hard = Set("g", "h", "ch", "k", "d", "n", "t")
    val soft = Set("c", "dz", "j", "ď", "ť", "ľ", "ň", "ž", "č")
    val neutral = Set("b", "f", "l", "m", "p", "r", "s", "v", "z")
  }
  private lazy val skloňovanie = rod match {
    case MužskýŽivotný =>
      if (entry.endsWith("a"))                               Hrdina
      else                                                   Chlap
    case MužskýNeživotný =>
      if (Spoluhláska.soft.exists(entry.endsWith))           Stroj
      else /* ends with hard or neutral consonant */         Dub
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

  // demonstrative ten, tá, to
  def ten(rod: Rod, čislo: Čislo, pád: Pád): String = {
    rod match {
      case MužskýŽivotný | MužskýNeživotný =>
        čislo match {
          case Jednotné => "ten"
          case Množné => "chyba"
        }
      case Ženský =>
        čislo match {
          case Jednotné => "tá"
          case Množné =>  "chyba"
        }
      case Stredný =>
        čislo match {
          case Jednotné => "to"
          case Množné =>  "chyba"
        }
    }
  }

  override protected def decline(pád: Pád): String = {
    skloňovanie match {
      case Chlap => pád match {
        case Nominatív => čislo match {
          case Jednotné => entry
          case Množné   => entry + "i"
        }
        case Akusatív => čislo match {
          case Jednotné => entry + "a"
          case Množné   => entry + "ov"
        }
      }
      case Dub => čislo match {
        case Jednotné => entry
        case Množné   => entry + "y"
      }
      case Stroj => entry
      case Žena => pád match {
        case Nominatív => čislo match {
          case Jednotné => entry
          case Množné   => entry.replaceFirst("a$", "y")
        }
        case Akusatív => čislo match {
          case Jednotné => entry.replaceFirst("a$", "u") // was a
          case Množné   => entry.replaceFirst("a$", "y") // was u
        }
      }
      case Ulica => pád match {
        case Nominatív =>  čislo match {
          case Jednotné => entry
          case Množné => entry.replaceFirst("a$", "e")
        }
        case Akusatív =>  čislo match {
          case Jednotné => entry.replaceFirst("a$", "u")
          case Množné => entry.replaceFirst("a$", "e")
        }
      }
      case Dlaň => entry
      case Kosť => čislo match {
        case Jednotné => entry
        case Množné => entry + "i"
      }

      case Mesto => čislo match {
        case Jednotné => entry
        case Množné   => entry.replaceFirst("o$", "á")
      }
      case Srdce => entry
      case Vysvedčenie => čislo match {
        case Jednotné => entry
      }
      case Dievča => entry
    }
  }

}
