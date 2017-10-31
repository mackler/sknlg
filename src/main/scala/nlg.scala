// Contant enumerations

object Gender extends Enumeration {
  type Gender = Value
  val Male, Female, Neuter = Value
}
import Gender._

// Number
object VerbNumber extends Enumeration {
  type VerbNumber = Value
  val Singular, Plural = Value
}
import VerbNumber._

// Person
object VerbPerson extends Enumeration {
  type VerbPerson = Value
  val First, Second, Third  = Value
}
import VerbPerson._

object Vocabulary {
  // Pronouns

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
      Array(None, None, Some("ono")), // sing.
      Array(None, None, None) // plur.
    )
  )

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

  // Nouns

  trait Noun {
    val gender: Gender
    // these are just Options until I learn all the declensions
    val nominative: Option[String]
    val accusative: Option[String]
  }

  object kufor extends Noun {
    override val gender = Male
    override val nominative = Some("kufor")
    override val accusative = Some("kufor")
  }

  object auto extends Noun {
    override val gender = Male
    override val nominative = None
    override val accusative = Some("auto")
  }

  val nouns = Set(kufor, auto)

  // Verbs

  trait Verb {
    val infinitive: String
    val konjugácia: Array[Array[String]]
    val isTransitive: Boolean = false
    val isCopulative: Boolean = false

    def konjuguj: Array[String] = (for {
      number <- VerbNumber.values
      person <- VerbPerson.values
    } yield number + " " + person + " person: " + inflect(number, person)).toArray

    def inflect(number: VerbNumber, person: VerbPerson, negate: Boolean = false): String
  }

  object Byť extends Verb {
    override val isCopulative = true
    override val infinitive = "byť"
    override val konjugácia = Array(
      Array("som", "si", "je"),      // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(number: VerbNumber, person: VerbPerson, negate: Boolean = false): String =
      (if (negate) "nie " else "") + konjugácia(number.id)(person.id)
  }

  trait RegularVerb extends Verb {
    val root: String
    override val konjugácia: Array[Array[String]]
    override def inflect(number: VerbNumber, person: VerbPerson, negate: Boolean): String =
      (if (negate) "ne" else "") + root + konjugácia(number.id)(person.id)
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
    override val isTransitive = true
  }

  val verbs = Set(Byť, Mať)
}

object Main extends App {
  import Vocabulary._

  // conjugate all the verbs
  verbs foreach { verb =>
    /*    for {
      number <- VerbNumber.values
      person <- VerbPerson.values
    } {
      println(verb.inflect(number, person))
    }*/

    // conjugate all the verbs including pronouns
    for {
      gender <- Gender.values
      number <- VerbNumber.values
      person <- VerbPerson.values
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
    }

  }
}
