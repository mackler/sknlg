package org.mackler.sknlg

import Gender._
import Number._
import Case._

trait Noun {
  val gender: Gender
  val number: Number
  val adjective: Option[Adjective] = None
  protected val skloňovanie: Array[Array[String]]

  def asText(pád: Case = Nominative) =
    (adjective map { a => a.asText(gender) + " " }).getOrElse("") +
    skloňovanie(pád.id)(number.id)
}

case class Ja(val number: Number) extends Noun {
  val gender = Male
  override protected val skloňovanie = Array(
      Array("ja", "my"),
      Array("ma", "nás")
    )
}

case class Ty(val number: Number) extends Noun {
  val gender = Male
  override protected val skloňovanie = Array(
      Array("ty", "vy"),
      Array("ťa", "vás")
    )
}

case class On(val number: Number) extends Noun {
  val gender = Male
  override protected val skloňovanie = Array(
      Array("on", "oni"),
      Array("ho", "ich")
    )
}

case class Ona(val number: Number) extends Noun {
  val gender = Female
  override protected val skloňovanie = Array(
      Array("ona", "oni"),
      Array("ho", "ich")
    )
}

case class To(val number: Number) extends Noun {
  val gender = Neuter
  override protected val skloňovanie = Array(
      Array("to", "oni"),
      Array("error", "error")
    )
}
