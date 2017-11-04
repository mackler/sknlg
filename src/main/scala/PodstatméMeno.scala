package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._

trait PodstatméMeno {
  val rod: Rod
  val čislo: Čislo
  val adjective: Option[PrídavnéMeno] = None
  protected val skloňovanie: Array[Array[String]]

  def asText(pád: Pád = Nominative) =
    (adjective map { a => a.asText(rod) + " " }).getOrElse("") +
    skloňovanie(pád.id)(čislo.id)
}

case class Ja(val čislo: Čislo) extends PodstatméMeno {
  val rod = Mužský
  override protected val skloňovanie = Array(
      Array("ja", "my"),
      Array("ma", "nás")
    )
}

case class Ty(val čislo: Čislo) extends PodstatméMeno {
  val rod = Mužský
  override protected val skloňovanie = Array(
      Array("ty", "vy"),
      Array("ťa", "vás")
    )
}

case class On(val čislo: Čislo) extends PodstatméMeno {
  val rod = Mužský
  override protected val skloňovanie = Array(
      Array("on", "oni"),
      Array("ho", "ich")
    )
}

case class Ona(val čislo: Čislo) extends PodstatméMeno {
  val rod = Ženský
  override protected val skloňovanie = Array(
      Array("ona", "oni"),
      Array("ho", "ich")
    )
}

case class To(val čislo: Čislo) extends PodstatméMeno {
  val rod = Stredný
  override protected val skloňovanie = Array(
      Array("to", "oni"),
      Array("error", "error")
    )
}
