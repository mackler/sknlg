package org.mackler.sknlg

import Pád._
import Čislo._
import Rod._

trait Zámeno extends Noun {
  protected val skloňovanie: Array[Array[String]]
  override def decline(pád: Pád = Nominative) =
    skloňovanie(pád.id)(čislo.id)
}

case class Ja(val čislo: Čislo) extends Zámeno {
  val rod = MužskýŽivotný
  override protected val skloňovanie = Array(
      Array("ja", "my"),
      Array("ma", "nás")
    )
}

case class Ty(val čislo: Čislo) extends Zámeno {
  val rod = MužskýŽivotný
  override protected val skloňovanie = Array(
      Array("ty", "vy"),
      Array("ťa", "vás")
    )
}

case class On(val čislo: Čislo) extends Zámeno {
  val rod = MužskýŽivotný
  override protected val skloňovanie = Array(
      Array("on", "oni"),
      Array("ho", "ich")
    )
}

case class Ona(val čislo: Čislo) extends Zámeno {
  val rod = Ženský
  override protected val skloňovanie = Array(
      Array("ona", "oni"),
      Array("ho", "ich")
    )
}

case class To(val čislo: Čislo) extends Zámeno {
  val rod = Stredný
  override protected val skloňovanie = Array(
      Array("to", "oni"),
      Array("error", "error")
    )
}
