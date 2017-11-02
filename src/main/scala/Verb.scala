package org.mackler.sknlg

import Person._
import Number._

abstract class Verb(subject: Seq[Noun]) {
  import Verb._

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

      subject.map(_.asText).mkString(" ") + " " + inflect(number, person)
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

object Verb {

}

abstract class RegularVerb(subject: Seq[Noun]) extends Verb(subject) {
  val root: String
  override val konjugácia: Array[Array[String]]
  override def inflect(number: Number, person: Person, negate: Boolean): String =
    (if (negate) "ne" else "") + root + konjugácia(number.id)(person.id)
}
