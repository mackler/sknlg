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

  object Kufor extends PodstatméMenoFactory(rod = Mužský, skloňovanie = Array(
      Array("kufor", "kufor"),
      Array("kufor", "kufor")
    )
  )
  object Auto extends PodstatméMenoFactory(rod = Stredný, skloňovanie = Array(
      Array("auto", "chyba"),
      Array("auto", "chyba")
    )
  )
  object Rieka extends PodstatméMenoFactory(rod = Ženský, skloňovanie = Array(
      Array("rieka", "rieka"),
      Array("", "")
    )
  )

  /*
   * PrídavnéMeno
   */

  case object Čistý extends PrídavnéMeno { protected val root = "čist" }
  case object Dobrý extends PrídavnéMeno { protected val root = "dobr" }
  case object Hnedý extends PrídavnéMeno { protected val root = "hned" }
  case object Krázny extends PrídavnéMeno { protected val root = "krázn" }
  case object Malý extends PrídavnéMeno { protected val root = "mal" }
  case object Mladý extends PrídavnéMeno { protected val root = "mlad" }
  case object Modrý extends PrídavnéMeno { protected val root = "modr" }
  case object Nový extends PrídavnéMeno { protected val root = "nov" }
  case object Pekný extends PrídavnéMeno { protected val root = "pekn" }
  case object Škaredý extends PrídavnéMeno { protected val root = "škared" }
  case object Špinavý extends PrídavnéMeno { protected val root = "špinav" }
  case object Starý extends PrídavnéMeno { protected val root = "star" }
  case object Veľký extends PrídavnéMeno { protected val root = "veľk" }
  case object Zlý extends PrídavnéMeno { protected val root = "zl" }

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
