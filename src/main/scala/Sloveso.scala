package org.mackler.sknlg

import Osoba._
import Čislo._
import Pád._

abstract class Sloveso(podmet: Seq[PodstatméMeno]) {

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

      podmet.map(_.asText(Nominative)).mkString(" ") + " " + inflect(čislo, person)
  }

  val infinitív: String
  val časovanie: Array[Array[String]]
  val isTransitive: Boolean = false
  val isCopulative: Boolean = false

  def konjuguj: Array[String] = (for {
    čislo <- Čislo.values
    person <- Osoba.values
  } yield čislo + " " + person + " person: " + inflect(čislo, person)).toArray

  def inflect(čislo: Čislo, person: Osoba.Osoba, negate: Boolean = false): String
}

abstract class RegularSloveso(podmet: Seq[PodstatméMeno]) extends Sloveso(podmet) {
  val root: String
  override val časovanie: Array[Array[String]]
  override def inflect(čislo: Čislo, person: Osoba, negate: Boolean): String =
    (if (negate) "ne" else "") + root + časovanie(čislo.id)(person.id)
}

// A-type verbs

abstract class chytáť(podmet: Seq[PodstatméMeno]) extends RegularSloveso(podmet) {
  override lazy val infinitív = root + "ať"
  override val časovanie = Array(
    Array("ám", "áš", "á"),      // singular
    Array("áme", "áte", "ajú")   // plural
  )
}

trait SlovesoPrechodné extends Sloveso {
  val directPredmet: Option[PodstatméMeno]
  override def asText =
    super.asText + directPredmet.map(" " + _.asText(Accusative)).getOrElse("")
}
