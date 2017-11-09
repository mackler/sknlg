package org.mackler.sknlg

import Osoba._
import Čislo._
import Pád._

abstract class Sloveso(podmet: Seq[Noun], directPredmet: Option[PodstatméMeno], príslovka: Option[String]) {
  val infinitív: String
  lazy val root: String = infinitív.replaceFirst("ať", "")
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

      podmet.map(_.asText(Nominative)).mkString(" a ") + " " +
      príslovka.map(_ + " ").getOrElse("") +
      inflect(čislo, person, false) +
      directPredmet.map(" " + _.asText(Accusative)).getOrElse("")
  }

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

abstract class ATypeFactory(infinitív: String) {
  class ATypeInstance(
    override val infinitív: String = infinitív,
    podmet: Seq[Noun],
    directPredmet: Option[PodstatméMeno],
    príslovka: Option[String]
  ) extends Sloveso(podmet, directPredmet, príslovka)
  def apply(
    podmet: Seq[Noun] = Seq.empty[Noun],
    directPredmet: Option[PodstatméMeno] = None,
    príslovka: Option[String] = None
  ) =
    new ATypeInstance(infinitív, podmet, directPredmet, príslovka)
}

/* Some verbs can take direct objects */

trait SlovesoPrechodné extends Sloveso {
  val directPredmet: Option[PodstatméMeno]
  override def asText = super.asText + directPredmet.map(" " + _.asText(Accusative)).getOrElse("")
}
