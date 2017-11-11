package org.mackler.sknlg

import Osoba._
import Čislo._
import Pád._

abstract class Sloveso(
  podmet: Seq[Noun], directPredmet: Option[PodstatnéMeno], príslovka: Option[String], záporný: Boolean
) {
  val infinitív: String
  lazy val root: String = infinitív.replaceFirst("ať", "")
  val isCopulative: Boolean = false

  def setPodmet(p: Noun): Sloveso
  def asText: String  = (podmet.length match {
    case 0 =>
      infinitív + príslovka.map(_ + " ").getOrElse("")
    case _ =>
      val person =
        if (podmet.exists(s => s.isInstanceOf[Ja])) Osoba.First
        else if (podmet.exists(s => s.isInstanceOf[Ty])) Osoba.Second
        else Osoba.Third
      val čislo =
        if (podmet.length > 1 || podmet.exists(_.čislo == Čislo.Množné))
          Čislo.Množné
        else
          Čislo.Jednotné
      podmet.map(_.asText(Nominatív)).mkString(" a ") + " " +
      príslovka.map(_ + " ").getOrElse("") +
      inflect(čislo, person, záporný)
  }) + directPredmet.map(" " + _.asText(Akusatív)).getOrElse("")

  def inflect(čislo: Čislo, osoba: Osoba, negate: Boolean): String =
    (if (negate) "ne" else "") +
    root +
    {
      val a = if (finalSyllableIsLong(root)) "a" else "á"
        čislo match {
          case Jednotné => osoba match {
            case First =>  a + "m"
            case Second => a + "š"
            case Third =>  a
          }
          case Množné => osoba match {
            case First =>  a + "me"
            case Second => a + "te"
            case Third =>  "ajú"
          }
        }
    }
}

trait TransitiveVerb extends Sloveso {
  def setPredmet(o: PodstatnéMeno): Sloveso
}

abstract class Type1Factory(infinitív: String) {
  case class Type1Instance(
    override val infinitív: String = infinitív,
    podmet: Seq[Noun],
    directPredmet: Option[PodstatnéMeno],
    príslovka: Option[String],
    záporný: Boolean
  ) extends Sloveso(podmet, directPredmet, príslovka, záporný) with TransitiveVerb {
    def setPodmet(p: Noun): TransitiveVerb = this.copy(podmet = podmet :+ p)
    def setPredmet(o: PodstatnéMeno): Sloveso = this.copy(directPredmet = Some(o))
  }
  def apply(
    podmet: Seq[Noun] = Seq.empty[Noun],
    directPredmet: Option[PodstatnéMeno] = None,
    príslovka: Option[String] = None,
    záporný: Boolean = false
  ) =
    new Type1Instance(infinitív, podmet, directPredmet, príslovka, záporný)
}

// Type11 Verbs Follow "procuvať"
class SlovesoType11Factory(infinitív: String) {
  case class SlovesoType11(
    override val infinitív: String = infinitív,
    podmet: Seq[Noun],
    directPredmet: Option[PodstatnéMeno],
    príslovka: Option[String],
    záporný: Boolean
  ) extends Sloveso(podmet, directPredmet, príslovka, záporný) with TransitiveVerb {
    def setPodmet(p: Noun): TransitiveVerb = this.copy(podmet = podmet :+ p)
    def setPredmet(o: PodstatnéMeno): TransitiveVerb = this.copy(directPredmet = Some(o))

    override def inflect(čislo: Čislo, osoba: Osoba, negate: Boolean): String = {
      val stem = infinitív.replaceFirst("ovať$", "")
      stem +
      (čislo match {
        case Jednotné => osoba match {
          case First =>  "ujem"
          case Second => "chyba"
          case Third =>  "chyba"
        }
        case Množné => osoba match {
          case First =>  "chyba"
          case Second => "chyba"
          case Third =>  "chyba"
        }
      })
    }
  }
  def apply(
    podmet: Seq[Noun] = Seq.empty[Noun],
    directPredmet: Option[PodstatnéMeno] = None,
    príslovka: Option[String] = None,
    záporný: Boolean = false
  ) =
    new SlovesoType11(infinitív, podmet, directPredmet, príslovka, záporný)
}

// Type12 Verbs Follow "robiť"
class SlovesoType12Factory(infinitív: String) {
  case class SlovesoType12(
    override val infinitív: String = infinitív,
    podmet: Seq[Noun],
    directPredmet: Option[PodstatnéMeno],
    príslovka: Option[String],
    záporný: Boolean
  ) extends Sloveso(podmet, directPredmet, príslovka, záporný) with TransitiveVerb {
    def setPodmet(p: Noun): TransitiveVerb = this.copy(podmet = podmet :+ p)
    def setPredmet(o: PodstatnéMeno): TransitiveVerb = this.copy(directPredmet = Some(o))

    override def inflect(čislo: Čislo, osoba: Osoba, negate: Boolean): String = {
      val stem = infinitív.replaceFirst("iť$", "")
      val i = if (finalSyllableIsLong(stem)) "i" else "í"
      stem +
      (čislo match {
        case Jednotné => osoba match {
          case First =>  "chyba"
          case Second => "chyba"
          case Third =>  "chyba"
        }
        case Množné => osoba match {
          case First =>  "chyba"
          case Second => i + "te"
          case Third =>  "chyba"
        }
      })
    }
  }
  def apply(
    podmet: Seq[Noun] = Seq.empty[Noun],
    directPredmet: Option[PodstatnéMeno] = None,
    príslovka: Option[String] = None,
    záporný: Boolean = false
  ) =
    new SlovesoType12(infinitív, podmet, directPredmet, príslovka, záporný)
}

class SlovesoType13Factory(infinitív: String) {
  case class SlovesoType13(
    override val infinitív: String = infinitív,
    podmet: Seq[Noun],
    directPredmet: Option[PodstatnéMeno],
    príslovka: Option[String],
    záporný: Boolean
  ) extends Sloveso(podmet, directPredmet, príslovka, záporný) with TransitiveVerb {
    def setPodmet(p: Noun): TransitiveVerb = this.copy(podmet = podmet :+ p)
    def setPredmet(o: PodstatnéMeno): TransitiveVerb = this.copy(directPredmet = Some(o))

    override def inflect(čislo: Čislo, osoba: Osoba, negate: Boolean): String = {
      infinitív.replaceFirst("ieť$", "") +
      (čislo match {
        case Jednotné => osoba match {
          case First =>  "ím"
          case Second => "íš"
          case Third =>  "í"
        }
        case Množné => osoba match {
          case First =>  "íme"
          case Second => "íte"
          case Third =>  "ia"
        }
      })
    }
  }
  def apply(
    podmet: Seq[Noun] = Seq.empty[Noun],
    directPredmet: Option[PodstatnéMeno] = None,
    príslovka: Option[String] = None,
    záporný: Boolean = false
  ) =
    new SlovesoType13(infinitív, podmet, directPredmet, príslovka, záporný)
}
