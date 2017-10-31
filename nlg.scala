// Pronouns

object Gender extends Enumeration {
  type Gender = Value
  val Male, Female, Neuter = Value
}

val Pronoun: Array[Array[Array[Option[String]]]] = Array(
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
    Array(None, None, Some("to")), // sing.
    Array(None, None, None) // plur.
  )
)

// Verbs

// Number
object VerbNumber extends Enumeration {
  type VerbNumber = Value
  val Singular, Plural = Value
}

// Person
object VerbPerson extends Enumeration {
  type VerbPerson = Value
  val First, Second, Third  = Value
}

import Gender._
import VerbNumber._
import VerbPerson._

trait Verb {
  val konjugácia: Array[Array[String]]

  val infinitive: String

  def konjuguj: Array[String] = (for {
    number <- VerbNumber.values
    person <- VerbPerson.values
  } yield number + " " + person + " person: " + inflect(number, person)).toArray

  def inflect(number: VerbNumber, person: VerbPerson): String
}

object Byť extends Verb {
  override val infinitive = "byť"
  override val konjugácia = Array(
    Array("som", "si", "je"),      // singular
    Array("sme", "ste", "sú")   // plural
  )
  override def inflect(number: VerbNumber, person: VerbPerson): String =
    konjugácia(number.id)(person.id)
}

trait RegularVerb extends Verb {
  val root: String
  override val konjugácia: Array[Array[String]]
  override def inflect(number: VerbNumber, person: VerbPerson): String =
    root + konjugácia(number.id)(person.id)
}

trait chytáť extends RegularVerb {
  override lazy val infinitive = root + "ať"
  override val konjugácia = Array(
    Array("ám", "áš", "á"),      // singular
    Array("áme", "áte", "ajú")   // plural
  )
}

object Mať extends chytáť {
  override val root = "m"
}

val verbs = Array(Byť, Mať)

object Main extends App {
  verbs foreach { verb =>
    for {
      number <- VerbNumber.values
      person <- VerbPerson.values
    } {
      println(verb.inflect(number, person))
    }

    for {
      gender <- Gender.values
      number <- VerbNumber.values
      person <- VerbPerson.values
      pronoun <- Pronoun(gender.id)(number.id)(person.id)
    } {
      println(pronoun + " " + verb.inflect(number, person))
    }

  }
}

Main.main(Array[String]())
