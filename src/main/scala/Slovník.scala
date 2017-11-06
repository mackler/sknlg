package org.mackler.sknlg

import Rod._
import Osoba._
import Čislo._
import Pád._

object Slovník {

  /*
   * PodstatméMeno
   */

  // Masculine Animate
  // not ending in -a
  object Muž extends PodstatméMenoFactory(entry = "muž", rod = MužskýŽivotný)
  object Učiteľ extends PodstatméMenoFactory(entry = "učitel", rod = MužskýŽivotný)
  object Býk extends PodstatméMenoFactory(entry = "býk", rod = MužskýŽivotný)
  object Kocúr extends PodstatméMenoFactory(entry = "kocúr", rod = MužskýŽivotný)

  // Masculine Inanimate
  // ending in hard consonant
  object Hrad extends PodstatméMenoFactory(entry = "hrad", rod = MužskýNeživotný)
  object Kufor extends PodstatméMenoFactory(entry = "kufor", rod = MužskýNeživotný)
  // ending in sort consonant
  object Dunaj extends PodstatméMenoFactory(entry = "Dunaj", rod = MužskýNeživotný)

  // Feminine
  // ending in -a preceded by a hard consonant (or neutral for krava)
  object Krava extends PodstatméMenoFactory(entry = "krava", rod = Ženský)
  object Mačka extends PodstatméMenoFactory(entry = "mačka", rod = Ženský)
  object Rieka extends PodstatméMenoFactory(entry = "rieka", rod = Ženský)
  object Učiteľka extends PodstatméMenoFactory(entry = "učiteľka", rod = Ženský)
  object Voda extends PodstatméMenoFactory(entry = "voda", rod = Ženský)
  object Žena extends PodstatméMenoFactory(entry = "žena", rod = Ženský)
  // following dlaň
  object Kaviareň extends PodstatméMenoFactory(entry = "kaviareň", rod = Ženský)
  object Radosť extends PodstatméMenoFactory(entry = "radosť", rod = Ženský)

  // Neuter
  // ending in -o
  object Auto extends PodstatméMenoFactory(entry = "auto", rod = Stredný)
  object Mesto extends PodstatméMenoFactory(entry = "mesto", rod = Stredný)
  // ending -e
  object Srdce extends PodstatméMenoFactory(entry = "srdce", rod = Stredný)
  // ending -ie
  object Namestie extends PodstatméMenoFactory(entry = "namestie", rod = Stredný)
  // ending -a or -ä
  object Dieťa extends PodstatméMenoFactory(entry = "dieťa", rod = Stredný)
  object Dievča extends PodstatméMenoFactory(entry = "dievča", rod = Stredný)
  object Mača extends PodstatméMenoFactory(entry = "mača", rod = Stredný)
  object Teľa extends PodstatméMenoFactory(entry = "teľa", rod = Stredný)

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

  case class Byť(podmet: Seq[Noun] = Seq.empty[PodstatméMeno], príslovka: Option[String] = None)
      extends Sloveso(podmet, príslovka) {
    override val infinitív = "byť"
    override val isCopulative = true
    val časovanie = Array(
      Array("som", "si", "je"),      // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean = false): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

    // add a podmet and return a new verb instance
    def podmet(newPodmet: PodstatméMeno): Sloveso = new Byť(podmet :+ newPodmet)

  }

  case class Mať(podmet: Seq[Noun]                    = Seq.empty[PodstatméMeno],
                 directPredmet: Option[PodstatméMeno] = None,
                 príslovka: Option[String]            = None)
      extends Chytať(podmet, príslovka) with SlovesoPrechodné {
    override val infinitív = "mať"
  }

  case class Bývať(podmet: Seq[Noun]                    = Seq.empty[PodstatméMeno],
                   príslovka: Option[String]            = None)
      extends Chytať(podmet, príslovka) {
    override val infinitív = "bývať"
  }

  object Čakať extends ChytaťFactory("čakať")

}
