package org.mackler.sknlg

import Rod._
import Osoba._
import Čislo._
import Pád._

object Slovník {

  val Demonstrative: Array[Array[Array[Option[String]]]] = Array(
    // dimensions are rod: čislo, person
    Array(                          // muž.
      Array(None, None, Some("ten")),  // sing.
      Array(None, None, None) // plur.
    ),
    Array (                         // žen.
      Array(None, None, Some("tá")),  // sing.
      Array(None, None, None) // plur.
    ),
    Array(// stredny rod
      Array(None, None, Some("to")), // sing.
      Array(None, None, None) // plur.
    )
  )

  /*
   * PodstatméMeno
   */

  case class Kufor(
    override val čislo: Čislo = Jednotné,
    override val adjective: Option[PrídavnéMeno] = None
  ) extends PodstatméMeno {
    val rod = Mužský
    override protected val skloňovanie = Array(
      Array("kufor", "kufor"),
      Array("kufor", "kufor")
    )
  }

  case class Rieka(
    override val čislo: Čislo = Jednotné,
    override val adjective: Option[PrídavnéMeno] = None
  ) extends PodstatméMeno {
    override val rod = Ženský
    override protected val skloňovanie = Array(
      Array("rieka", "rieka"),
      Array("", "")
    )
  }

  case class Auto(
    override val čislo: Čislo = Jednotné,
    override val adjective: Option[PrídavnéMeno] = None
  ) extends PodstatméMeno {
    override val rod = Stredný
    override protected val skloňovanie = Array(
      Array("auto", "chyba"),
      Array("auto", "chyba")
    )
  }

  /*
   * PrídavnéMeno
   */

  case object Pekný extends PrídavnéMeno {
    override def asText(rod: Rod) = rod match {
      case Mužský => "pekný"
      case Ženský => "pekná"
      case Stredný => "pekné"
    }
  }

  /*
   * Sloveso
   */

  case class Byť(podmet: Seq[PodstatméMeno] = Seq.empty[PodstatméMeno]) extends Sloveso(podmet) {
    override val infinitív = "byť"
    override val isCopulative = true
    override val časovanie = Array(
      Array("som", "si", "je"),      // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean = false): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

    // add a podmet and return a new verb instance
    def podmet(newPodmet: PodstatméMeno): Sloveso = new Byť(podmet :+ newPodmet)

  }

  case class Mať(podmet: Seq[PodstatméMeno] = Seq.empty[PodstatméMeno], directPredmet: Option[PodstatméMeno] = None)
      extends chytáť(podmet) with SlovesoPrechodné {
    override val root = "m"
    override val isTransitive = true
  }

  val verbs = Set(Byť, Mať)
}
