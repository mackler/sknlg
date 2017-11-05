package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._

trait PodstatméMeno {
  val rod:          Rod
  val čislo:        Čislo
  val prídavnéMeno: Option[PrídavnéMeno] = None
  protected val skloňovanie: Array[Array[String]]

  def asText(pád: Pád = Nominative) =
    (prídavnéMeno map { a => a.asText(rod) + " " }).getOrElse("") +
    skloňovanie(pád.id)(čislo.id)
}

abstract class PodstatméMenoFactory(rod: Rod, skloňovanie: Array[Array[String]]) {
  class PodstatméMenoInstance(
    override           val rod          : Rod,
    override protected val skloňovanie  : Array[Array[String]],
    override           val čislo        : Čislo,
    override           val prídavnéMeno : Option[PrídavnéMeno]
  ) extends PodstatméMeno

  def apply(čislo: Čislo = Jednotné, prídavnéMeno: Option[PrídavnéMeno] = None) = {
    new PodstatméMenoInstance(rod, skloňovanie, čislo, prídavnéMeno)
  }
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
