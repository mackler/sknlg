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

import VerbNumber._
import VerbPerson._

trait Verb {
  val root: String
  val konjuguj: Array[Array[String]]
  def inflect(number: VerbNumber, person: VerbPerson): String =
    root + konjuguj(number.id)(person.id)
}

trait chytáť extends Verb {
  val konjuguj = Array(
    Array("ám", "áš", "á"),      // singular
    Array("áme", "áte", "ajú")   // plural
  )
}

object Mať extends chytáť {
  override val root = "m"
}

for {
  number <- VerbNumber.values
  person <- VerbPerson.values
} {
  Console.println(number + " " + person + " person: " + Mať.inflect(number, person))
}

