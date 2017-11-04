package org.mackler.sknlg

import Person._
import Number._
import Case._

abstract class Verb(subject: Seq[Noun]) {

  def asText: String  = subject.length match {
    case 0 =>
      infinitive
    case _ =>
      val person =
        if (subject.exists(s => s.isInstanceOf[Ja])) Person.First
        else if (subject.exists(s => s.isInstanceOf[Ty])) Person.Second
        else Person.Third
      val number =
        if (subject.length > 1 || subject.exists(_.number == Number.Plural))
          Number.Plural
        else
          Number.Singular

      subject.map(_.asText(Nominative)).mkString(" ") + " " + inflect(number, person)
  }

  val infinitive: String
  val konjugácia: Array[Array[String]]
  val isTransitive: Boolean = false
  val isCopulative: Boolean = false

  def konjuguj: Array[String] = (for {
    number <- Number.values
    person <- Person.values
  } yield number + " " + person + " person: " + inflect(number, person)).toArray

  def inflect(number: Number, person: Person.Person, negate: Boolean = false): String
}

abstract class RegularVerb(subject: Seq[Noun]) extends Verb(subject) {
  val root: String
  override val konjugácia: Array[Array[String]]
  override def inflect(number: Number, person: Person, negate: Boolean): String =
    (if (negate) "ne" else "") + root + konjugácia(number.id)(person.id)
}

// A-type verbs

abstract class chytáť(subject: Seq[Noun]) extends RegularVerb(subject) {
  override lazy val infinitive = root + "ať"
  override val konjugácia = Array(
    Array("ám", "áš", "á"),      // singular
    Array("áme", "áte", "ajú")   // plural
  )
}

trait TransitiveVerb extends Verb {
  val directObject: Option[Noun]
  override def asText =
    super.asText + directObject.map(" " + _.asText(Accusative)).getOrElse("")
}
