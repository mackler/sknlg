package org.mackler.sknlg

import Gender._
import Number._
import Case._

trait Noun {
  def asText: String
  val gender: Gender
  val number: Number
}


class Ja(val gender: Gender, val number: Number) extends Noun {
  import Ja._
  override val asText: String = konjugácia(number.id).get
}
object Ja {
  def apply(gender: Gender = Male, number: Number = Singular) =
    new Ja(gender, number)

  private val konjugácia = Array(Some("ja"), Some("my"))

}


/*class Pronoun(gender: Gender, number: Number, person: Person, implied: Boolean)
    extends Noun {
  import Pronoun._

  val inflected: String = konjugácia(gender.id)(number.id)(person.id).get
  override def asText: String = if (implied) "" else konjugácia(gender.id)(number.id)(person.id).get
}

object Pronoun {

  def apply(gender: Gender, number: Number, person: Person, implied: Boolean = false) =
    new Pronoun(gender, number, person, implied)

  private val konjugácia: Array[Array[Array[Option[String]]]] = Array(
    // dimensions are gender: number, person
    Array(                          // muž.
      Array(Some("ja"), Some("ty"), Some("on")),  // sing.
      Array(Some("my"), Some("vy"), Some("oni")) // plur.
    ),
    Array (                         // žen.
      Array(Some("ja"), Some("ty"), Some("ona")), // sing.
      Array(Some("my"), Some("vy"), Some("ony")) // plur.
    ),
    Array(// stredného rodu
      Array(None, None, Some("ono")), // sing.
      Array(None, None, None) // plur.
    )
  )

}*/
