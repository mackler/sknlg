package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import Skloňovanie._

/* This is the superclass of both pronouns (zámeno) and common nouns (podstatmé meno) */
trait Noun extends NounPhrase {
  val rod   : Rod
  val čislo : Čislo = Jednotné
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
  // The `rod` parameter is needed only if the noun is exceptional
  def apply(entry: String, rod: Rod = Neznámy, genitiveSingular: String = "", nominativePlural: String = ""): PodstatnéMeno = {
    val _entry = entry
    val _genitiveSingular = genitiveSingular
    val _nominativePlural = nominativePlural
    val _rod = {
      if (rod != Neznámy) rod // explicitly provided
        else if (entry.matches(".*(a|osť|eň)$")) // ends with "a" or "osť" or "eň" (last one is debatable)
        Ženský
      else if (entry.matches(".*[bcčdďfghjklľĺmnňprŕsštťvyýzž]$")) // ends with any consonant
        MužskýNeživotný
      else if (entry.matches(".*[eo]$")) // ends with e or o
        Stredný
      else throw new Exception(s"unknown gender for $entry")
    }
    case class PodstatnéMenoInstance(
      override           val čislo        : Čislo,
      override           val prídavnéMeno : Option[PrídavnéMeno],
      protected val demonstrative: Boolean,
      _predložka: Option[String]
    ) extends PodstatnéMeno {
      override protected val entry = _entry
      override protected val genitiveSingular = _genitiveSingular
      override protected val nominativePlural = _nominativePlural
      override val rod = _rod

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
  protected val genitiveSingular: String // optional; ignored if empty
  protected val nominativePlural: String = "" // optional; ignored if empty
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

  // setting a preposition turns this noun into an adverb
  def predložka(p: String) = Príslovka {
    p match {
      case "pri" => "pri " + asText(Lokatív)
      case "vo" =>
        val t = asText(Lokatív)
        "v" + (if (t.matches("^[vVfF].*")) "o " else " ") + t
    }
  }

  object Spoluhláska {
    val hard = Set("g", "h", "ch", "k", "d", "n", "t")
    val neutral = Set("b", "f", "l", "m", "p", "r", "s", "v", "z")
    val tvrdný = hard ++ neutral
    val mäkký = Set("c", "dz", "j", "ď", "ť", "ľ", "ň", "ž", "č")
  }
  private lazy val skloňovanie = rod match {
    case MužskýŽivotný =>
      if (entry.endsWith("a"))                                          Hrdina
      else                                                              Chlap
    case MužskýNeživotný =>
      if (Spoluhláska.mäkký.exists(entry.endsWith))                     Stroj
      else /* ends with hard or neutral consonant */
        if (Spoluhláska.tvrdný.exists(entry.endsWith))                  Dub
      else throw new Exception(s"unrecognized noun form $entry")
    case Ženský =>
      if (Set("c","s","p","v","sť").exists(entry.endsWith) ||
      Set("jar","zver","chuť","ortuť","pamäť","smrť").contains(entry))  Kosť
      else if (Spoluhláska.tvrdný.exists(c => entry.endsWith(c + "a")))
                                                                        Žena
        else if (entry.endsWith("a"))                                   Ulica
        else                                                            Dlaň
    case Stredný =>
      if (entry.endsWith("o"))                                          Mesto
      else if (entry.endsWith("ie"))                                    Vysvedčenie
      else if (entry.endsWith("e"))                                     Srdce
      else if (entry.endsWith("a") || entry.endsWith("ä"))              Dievča
    }

  override protected def decline(pád: Pád): String = {
    val r = skloňovanie match {
      case Chlap =>
        val stem = if (genitiveSingular == "") entry else genitiveSingular.replaceFirst("a$", "")
        čislo match {
          case Jednotné => pád match {
            case Nominatív => entry
            case Akusatív => stem + "a"
            case Lokatív => stem + "ovi"
          }
          case Množné => pád match {
            case Nominatív =>
              if (nominativePlural != "") nominativePlural else entry + "i"
            case Akusatív  => stem + "ov"
            case Lokatív => stem + "och"
          }
        }
      case Dub => čislo match {
        case Jednotné => pád match {
          case Nominatív | Akusatív => entry
          case Genitív => entry + "a"
          case Lokatív => entry + "e"
        }
        case Množné => pád match {
          case Nominatív => entry + "y"
          case Akusatív => entry + "y"
          case Lokatív => entry + "och"
        }
      }
      case Stroj => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
          case Akusatív => entry
        }
        case Množné => pád match {
          case Nominatív => entry + "e"
          case Akusatív => entry + "e"
        }
      }
      case Žena => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
          case Genitív => entry.replaceFirst("a$", "y")
          case Akusatív => entry.replaceFirst("a$", "u")
          case Lokatív => entry.replaceFirst("a$", "e")
        }
        case Množné => pád match {
          case Nominatív => entry.replaceFirst("a$", "y")
          case Akusatív => entry.replaceFirst("a$", "y")
          case Lokatív => entry.replaceFirst("a$", "ách")
        }
      }
      case Ulica => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
          case Genitív => entry.replaceFirst("a$", "e")
          case Akusatív => entry.replaceFirst("a$", "u")
          case Lokatív => entry.replaceFirst("a$", "i")
        }
        case Množné =>
          val stem = entry.substring(0, entry.length -1)
          val rhythmic = finalSyllableIsLong(stem)
          pád match {
//            case Nominatív => entry.replaceFirst("a$", "e")
//            case Genitív => entry.replaceFirst("a$", "")
//            case Akusatív => entry.replaceFirst("a$", "e")
//            case Lokatív => entry.replaceFirst("a$", "iach")
            case Nominatív => stem + "e"
            case Genitív => stem
          // Dative case is altered by a long final syllable
            case Datív => stem + (if (rhythmic) "" else "i") +  "am"
            case Akusatív => stem + "e"
            case Lokatív => stem + (if (rhythmic) "" else "i") +  "ach"
          }
      }
      case Dlaň =>
        val stem = if (genitiveSingular != "") genitiveSingular.replaceFirst("e$", "")
                   else entry.replaceFirst("eň$", "ň")
        čislo match {
          case Jednotné => pád match {
            case Nominatív => entry
            case Genitív => stem + "e"
            case Akusatív => entry
            case Lokatív => stem + "i"
          }
          case Množné => pád match {
            case Nominatív => stem + "e"
            case Genitív => stem + "í"
            case Datív => stem + (if (finalSyllableIsLong(stem)) "" else "i") + "am"
            case Akusatív => stem + "e"
            case Lokatív => stem + (if (finalSyllableIsLong(stem)) "" else "i") + "ach"
          }
        }
      case Kosť => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
          case Genitív => entry + "i"
          case Akusatív => entry
          case Lokatív => entry + "i"
        }
        case Množné => pád match {
          case Nominatív => entry + "i"
          case Genitív => entry + "í"
          case Akusatív => entry + "i"
          case Lokatív => entry + "iach"
        }
      }
      case Mesto => čislo match {
        case Jednotné => pád match {
          case Nominatív | Akusatív => entry
          case Genitív => entry.replaceFirst("o$", "a")
          case Lokatív => entry.replaceFirst("o$", "e")
        }
        case Množné   => pád match {
          case Nominatív => entry.replaceFirst("o$", "á")
          case Akusatív => entry.replaceFirst("o$", "á")
          case Lokatív => entry.replaceFirst("o$", "ách")
        }
      }
      case Srdce => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
        }
      }
      case Vysvedčenie => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
        }
      }
      case Dievča => čislo match {
        case Jednotné => pád match {
          case Nominatív => entry
        }
      }
    }
    // remove unnecessary soft-marks
    r.replaceFirst("ň([iíe])", "n$1")
  }

  override def equals(other: Any): Boolean = other match {
    case that: PodstatnéMeno => that.entry == this.entry && this.čislo == that.čislo
    case _ => false
  }

  override def hashCode = entry.##

}
