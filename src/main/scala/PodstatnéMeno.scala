package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import Skloňovanie._

/* This is the superclass of both pronouns (zámeno) and common nouns (podstatmé meno) */
trait Noun extends NounPhrase {
  val rod   : Rod
  val čislo : Čislo
  protected def decline(pád: Pád): String
  override def asText(pád: Pád = Nominatív): String = {
    decline(pád)
  }
}

/* Person names */
case class Pomenovanie(name: String, rod: Rod) extends Noun {
  require(rod == MužskýŽivotný || rod == Ženský)
  override val čislo = Jednotné
  override def decline(pad: Pád = Nominatív) = name
}

object PodstatnéMeno {
  def apply(entry: String, rod: Rod): PodstatnéMeno = {
    val _entry = entry
    val _rod = rod
    case class PodstatnéMenoInstance(
      override           val čislo        : Čislo,
      override           val prídavnéMeno : Option[PrídavnéMeno],
      protected val demonstrative: Boolean,
      _predložka: Option[String]
    ) extends PodstatnéMeno {
      override protected val entry = _entry
      override val rod = _rod

      def predložka(p: String) = this.copy(_predložka = Some(p))
      def predložka() = _predložka
      def setČislo(č: Čislo) = this.copy(čislo = č)
      def setPrídavnéMeno(p: PrídavnéMeno): PodstatnéMeno = this.copy(prídavnéMeno = Some(p))
      override def setDemonstrative(d: Boolean) = this.copy(demonstrative = d)

      override def asText(pád: Pád): String = _predložka.map(_ + " ").getOrElse("") + super.asText(pád)
    }
    PodstatnéMenoInstance(čislo = Jednotné, prídavnéMeno = None, demonstrative = false, _predložka = None)
  }
}

/* These are only common nouns (not pronouns) */
trait PodstatnéMeno extends Noun {
  protected val entry         : String   // form of the slovo as listed in a slovník
  override  val rod           : Rod // removing this line caused an exception that looked like a bug
  val prídavnéMeno            : Option[PrídavnéMeno] = None
  protected val demonstrative : Boolean
  def setČislo(č: Čislo): PodstatnéMeno
  def setPrídavnéMeno(p: PrídavnéMeno): PodstatnéMeno
  def setDemonstrative(d: Boolean) = this

  override def asText(pád: Pád = Nominatív) =
    (if (demonstrative) Ten.asText(rod, čislo, pád) + " " else "") +
    (prídavnéMeno map { a => a.asText(rod, čislo, pád) + " " }).getOrElse("") +
    super.asText(pád)

  object Spoluhláska {
    val hard = Set("g", "h", "ch", "k", "d", "n", "t")
    val neutral = Set("b", "f", "l", "m", "p", "r", "s", "v", "z")
    val tvrdný = hard ++ neutral
    val mäkký = Set("c", "dz", "j", "ď", "ť", "ľ", "ň", "ž", "č")
  }
  private lazy val skloňovanie = rod match {
    case MužskýŽivotný =>
      if (entry.endsWith("a"))                               Hrdina
      else                                                   Chlap
    case MužskýNeživotný =>
      if (Spoluhláska.mäkký.exists(entry.endsWith))          Stroj
      else /* ends with hard or neutral consonant */         Dub
    case Ženský =>
      if (Set("c","s","p","v","st").exists(entry.endsWith))  Kosť
      else if (Spoluhláska.tvrdný.exists(c => entry.endsWith(c + "a")))
                                                             Žena
        else if (entry.endsWith("a"))                        Ulica
        else                                                 Dlaň
    case Stredný =>
      if (entry.endsWith("o"))                               Mesto
      else if (entry.endsWith("ie"))                         Vysvedčenie
      else if (entry.endsWith("e"))                          Srdce
      else if (entry.endsWith("a") || entry.endsWith("ä"))   Dievča
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
        case Jednotné => pád match {
          case Nominatív | Akusatív => entry
          case Genitív => entry + "a"
        }
        case Množné   => entry + "y"
      }
      case Stroj => entry
      case Žena => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
          case Genitív => entry.replaceFirst("a$", "y")
          case Akusatív => entry.replaceFirst("a$", "u")
        }
        case Množné => pád match {
          case Nominatív => entry.replaceFirst("a$", "y")
          case Akusatív => entry.replaceFirst("a$", "y")
        }
      }
      case Ulica => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
          case Genitív => entry.replaceFirst("a$", "e")
          case Akusatív => entry.replaceFirst("a$", "u")
        }
        case Množné => pád match {
          case Nominatív => entry.replaceFirst("a$", "e")
          case Genitív => entry.replaceFirst("a$", "")
          case Akusatív => entry.replaceFirst("a$", "e")
        }
      }
      case Dlaň => entry
      case Kosť => čislo match {
        case Jednotné => entry
        case Množné => entry + "i"
      }

      case Mesto => čislo match {
        case Jednotné => pád match {
          case Nominatív | Akusatív => entry
          case Genitív => entry.replaceFirst("o$", "a")
        }
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
