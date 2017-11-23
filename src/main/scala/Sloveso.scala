package org.mackler.sknlg

import Osoba._
import Čislo._
import Pád._

trait Sloveso {
  val infinitív: String
  val paradigm: (Čislo, Osoba, Boolean) => String
  val podmet: Seq[NounPhrase]
  val príslovka: Option[String]
  val záporný: Boolean
  val predložka: Option[String] = None

  def addPodmet(p: NounPhrase): Sloveso
  def setPodmet(p: Seq[NounPhrase]): Sloveso
  def setZáporný(z: Boolean): Sloveso

  protected def asTextInfinitive: String =
    infinitív + príslovka.map(_ + " ").getOrElse("") + predložka.map(" " + _).getOrElse("")

  def asText: String  = {
    (podmet.length match {
      case 0 => // no subject so generate inifinitive form
        asTextInfinitive
      case _ =>
        val osoba =
          if (podmet.exists(s => s.isInstanceOf[Ja])) Osoba.First
          else if (podmet.exists(s => s.isInstanceOf[Ty])) Osoba.Second
          else Osoba.Third
        val čislo =
          if (podmet.length > 1 ||
            podmet(0).isInstanceOf[Noun] && podmet(0).asInstanceOf[Noun].čislo == Čislo.Množné)
            Čislo.Množné
          else
            Čislo.Jednotné
        podmet.map(_.asText(Nominatív)).mkString(" a ") + " " +
        príslovka.map(_ + " ").getOrElse("") +
        paradigm(čislo, osoba, záporný)
    })
  }
}

trait RegularSloveso extends Sloveso {
  val directPredmet: Option[PodstatnéMeno]
  def setPredmet(o: PodstatnéMeno): Sloveso
  override def asText: String  = {
    super.asText + directPredmet.map(" " + _.asText(Akusatív)).getOrElse("")
  }
}

object SlovesoFactory {
  def apply(infinitív: String, paradigm: (Čislo, Osoba, Boolean) => String) = {
    val _infinitív = infinitív
    val _paradigm = paradigm
    case class SlovesoInstance(
      podmet        : Seq[NounPhrase]       = Seq.empty[Noun],
      directPredmet : Option[PodstatnéMeno] = None,
      príslovka     : Option[String]        = None,
      záporný       : Boolean               = false
    ) extends RegularSloveso {
      val infinitív = _infinitív
      val infinitívSuffix = infinitív.substring(infinitív.length - 2, infinitív.length)
      val paradigm = _paradigm
      def addPodmet(p: NounPhrase)= this.copy(podmet = podmet :+ p)
      def setPodmet(s: Seq[NounPhrase])= this.copy(podmet = s)
      def setPredmet(o: PodstatnéMeno) = this.copy(directPredmet = Some(o))
      def setPríslovka(p: String) = this.copy(príslovka = Some(p))
      def toggleZáporný() = this.copy(záporný = !záporný)
      def setZáporný(z: Boolean) = this.copy(záporný = z)
    }
    SlovesoInstance()
  }
}

object SlovesoType1 {
  def apply(infinitív: String) = SlovesoFactory(infinitív, { (čislo: Čislo, osoba: Osoba, záporný: Boolean) =>
    val stem = infinitív.substring(0, infinitív.length -2 )
    (if (záporný) "ne" else "") +
    stem +
    {
       val a = if (finalSyllableIsLong(stem)) "a" else "á"
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
  })
}

// Type11 Verbs Follow "procuvať"
object SlovesoType11 {
  def apply(infinitív: String) = SlovesoFactory(infinitív, { (čislo: Čislo, osoba: Osoba, záporný: Boolean) =>
    (if (záporný) "ne" else "") +
    infinitív.substring(0, infinitív.length -4) +
    (čislo match {
      case Jednotné => osoba match {
        case First =>  "ujem"
      }
      case Množné => osoba match {
        case _ => throw new Exception("not implemented")
      }
    })
  })
}

// Type12 Verbs Follow "robiť"
object SlovesoType12 {
  def apply(infinitív: String) = SlovesoFactory(infinitív, { (čislo: Čislo, osoba: Osoba, záporný: Boolean) =>
    val stem = infinitív.substring(0, infinitív.length -2 )
    val i = if (finalSyllableIsLong(stem)) "i" else "í"
    stem +
    (čislo match {
      case Jednotné => osoba match {
        case _ =>  throw new Exception("not implemented")
      }
      case Množné => osoba match {
        case Second => i + "te"
      }
    })
  })
}

object SlovesoType13 {
  def apply(infinitív: String) = SlovesoFactory(infinitív, { (čislo: Čislo, osoba: Osoba, záporný: Boolean) =>
    infinitív.substring(0, infinitív.length -3) +
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
  })
}
