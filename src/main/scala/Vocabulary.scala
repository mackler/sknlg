package org.mackler.sknlg

import Gender._
import Person._
import Number._
import Case._

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

  /*
   * Nouns
   */

  case class Kufor(
    override val number: Number = Singular,
    override val adjective: Option[Adjective] = None
  ) extends Noun {
    val gender = Male
    override protected val skloňovanie = Array(
      Array("kufor", "kufor"),
      Array("kufor", "kufor")
    )
  }

  case class Rieka(
    override val number: Number = Singular,
    override val adjective: Option[Adjective] = None
  ) extends Noun {
    override val gender = Female
    override protected val skloňovanie = Array(
      Array("rieka", "rieka"),
      Array("", "")
    )
  }

  case class Auto(
    override val number: Number = Singular,
    override val adjective: Option[Adjective] = None
  ) extends Noun {
    override val gender = Neuter
    override protected val skloňovanie = Array(
      Array("auto", "chyba"),
      Array("auto", "chyba")
    )
  }

  /*
   * Adjectives
   */

  case object Pekný extends Adjective {
    override def asText(gender: Gender) = gender match {
      case Male => "pekný"
      case Female => "pekná"
      case Neuter => "pekné"
    }
  }

  /*
   * Verbs
   */

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
