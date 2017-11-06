package org.mackler.sknlg

import Osoba._
import Čislo._
import Pád._

abstract class Sloveso(podmet: Seq[Noun], príslovka: Option[String]) {
  val infinitív: String
  val isCopulative: Boolean = false

  def asText: String  = podmet.length match {
    case 0 =>
      infinitív
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

      podmet.map(_.asText(Nominative)).mkString(" ") + " " +
      príslovka.map(_ + " ").getOrElse("") +
      inflect(čislo, person)
  }

  def inflect(čislo: Čislo, person: Osoba.Osoba, negate: Boolean = false): String
}

abstract class RegularSloveso(podmet: Seq[Noun], príslovka: Option[String])
    extends Sloveso(podmet, príslovka) {
  lazy val root: String = infinitív.replaceFirst("ať", "")
}

// This is the paradigmatic "A-type" verb

class Chytať(podmet: Seq[Noun], príslovka: Option[String])
    extends RegularSloveso(podmet, príslovka) {
  override val infinitív = "chytať"

  override def inflect(čislo: Čislo, osoba: Osoba, negate: Boolean): String =
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

/* Some verbs can take direct objects */

trait SlovesoPrechodné extends Sloveso {
  val directPredmet: Option[PodstatméMeno]
  override def asText = super.asText + directPredmet.map(" " + _.asText(Accusative)).getOrElse("")
}
