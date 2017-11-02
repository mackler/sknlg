package org.mackler.sknlg

import Gender._
import Number._
import Case._

trait Noun {
  def asText: String
  val gender: Gender
  val number: Number
}

trait Pronoun extends Noun {
  protected val konjugácia: Array[String]
  override lazy val asText: String = konjugácia(number.id)
}

case class Ja(val number: Number) extends Pronoun {
  val gender = Male
  override protected val konjugácia = Array("ja", "my")
}

case class Ty(val number: Number) extends Pronoun {
  val gender = Male
  override protected val konjugácia = Array("ty", "vy")
}

case class On(val number: Number) extends Pronoun {
  val gender = Male
  override protected val konjugácia = Array("on", "oni")
}

case class Ona(val number: Number) extends Pronoun {
  val gender = Female
  override protected val konjugácia = Array("ona", "oni")
}

case class To(val number: Number) extends Pronoun {
  val gender = Neuter
  override protected val konjugácia = Array("to", "oni")
}

