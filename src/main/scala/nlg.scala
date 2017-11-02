package org.mackler.sknlg

import Gender._
import Person._
import Number._

object Vocabulary {

  val Demonstrative: Array[Array[Array[Option[String]]]] = Array(
    // dimensions are gender: number, person
    Array(                          // muž.
      Array(None, None, Some("ten")),  // sing.
      Array(None, None, None) // plur.
    ),
    Array (                         // žen.
      Array(None, None, Some("tá")),  // sing.
      Array(None, None, None) // plur.
    ),
    Array(// stredného rodu
      Array(None, None, Some("to")), // sing.
      Array(None, None, None) // plur.
    )
  )

  object kufor extends Noun {
    override val gender = Male
    val nominative = Some("kufor")
    override val accusative = Some("kufor")
    val asText = "kufor"
    val number = Singular
  }

  object auto extends Noun {
    override val gender = Male
    val nominative = None
    override val accusative = Some("auto")
    val asText = "auto"
    val number = Singular
  }

  case class Byť(subject: Seq[Noun] = Seq.empty[Noun]) extends Verb(subject) {
    override val infinitive = "byť"
    override val isCopulative = true
    override val konjugácia = Array(
      Array("som", "si", "je"),      // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(number: Number, person: Person, negate: Boolean = false): String =
      (if (negate) "nie " else "") + konjugácia(number.id)(person.id)

    // add a subject and return a new verb instance
    def subject(newSubject: Noun): Verb = new Byť(subject :+ newSubject)

  }

  case class Mať(subject: Seq[Noun] = Seq.empty[Noun], directObject: Option[Noun] = None)
      extends chytáť(subject) with TransitiveVerb {
    override val root = "m"
    override val isTransitive = true
  }

  val verbs = Set(Byť, Mať)
}

object Main extends App {
  import Vocabulary._

  val nouns = Set(kufor, auto)
  val pronouns = Set(Ja, Ty, On, Ona, To)

    for {
      pronoun <- pronouns
      number <- Number.values
    } {
      println( Byť(subject = Seq(pronoun(number))).asText )
      for {
        noun <- nouns
      } {
        println(Mať(subject = Seq(pronoun(number)), directObject = Some(noun)).asText)
      }
    }

}
