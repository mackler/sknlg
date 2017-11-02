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
    val accusative = Some("kufor")
    val asText = "kufor"
    val number = Singular
  }

  object auto extends Noun {
    override val gender = Male
    val nominative = None
    val accusative = Some("auto")
    val asText = "auto"
    val number = Singular
  }

//  val nouns = Set(kufor, auto)
val nouns = Set(Ja, Ty, On, Ona, To)

  class Byť(subject: Seq[Noun]) extends Verb(subject) {
    import Byť._

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
  object Byť {
    def apply(subject: Seq[Noun] = Seq.empty[Noun]) = new Byť(subject)
  }

  abstract class chytáť(subject: Seq[Noun]) extends RegularVerb(subject) {
    override lazy val infinitive = root + "ať"
    override val konjugácia = Array(
      Array("ám", "áš", "á"),      // singular
      Array("áme", "áte", "ajú")   // plural
    )
  }

  object Mať extends chytáť(Seq.empty[Noun]) {
    override val root = "m"
    override val isTransitive = true
  }

  val verbs = Set(Byť, Mať)
}

 object Main extends App {
  import Vocabulary._

  // conjugate all the verbs
//  verbs foreach { verb =>
    for {
      noun <- nouns
      number <- Number.values
    } {
      println(Byť().subject(noun(number)).asText)
//      println(s" the number is $number and the person is $person")
    }

    // conjugate all the verbs including pronouns
/*    for {
      gender <- Gender.values
      number <- Number.values
      person <- Person.values
      pronoun <- Pronoun(gender.id)(number.id)(person.id)
      negate <- Set(true, false)
    } {
      if (verb.isTransitive) nouns.map(_.accusative).filter(_.isDefined).map(_.get).foreach { directObject: String =>
        // include a direct object
        println(pronoun + " " + verb.inflect(number, person, negate) + " " + directObject)
      } else {
        // no direct object
        println(pronoun + " " + verb.inflect(number, person, negate))
      }
    }*/

//  }
}
