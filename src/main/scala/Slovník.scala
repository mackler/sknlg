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
  // other masculine animate
  object Chlapec extends PodstatméMenoFactory(entry = "chlapec", rod = MužskýŽivotný)
  object Kôň extends PodstatméMenoFactory(entry = "kôň", rod = MužskýŽivotný)

  // Masculine Inanimate
  // ending in hard consonant
  object Deň extends PodstatméMenoFactory(entry = "deň", rod = MužskýNeživotný)
  object Hrad extends PodstatméMenoFactory(entry = "hrad", rod = MužskýNeživotný)
  object Kufor extends PodstatméMenoFactory(entry = "kufor", rod = MužskýNeživotný)
  object Pán extends PodstatméMenoFactory(entry = "pán", rod = MužskýNeživotný)
  object Prst extends PodstatméMenoFactory(entry = "prst", rod = MužskýNeživotný)
  // ending in sort consonant
  object Dunaj extends PodstatméMenoFactory(entry = "Dunaj", rod = MužskýNeživotný)
  // ending in a neutral consonant
  object Dom extends PodstatméMenoFactory(entry = "dom", rod = MužskýNeživotný)
  object Les extends PodstatméMenoFactory(entry = "les", rod = MužskýNeživotný)
  object Obraz extends PodstatméMenoFactory(entry = "obraz", rod = MužskýNeživotný)
  object Strom extends PodstatméMenoFactory(entry = "strom", rod = MužskýNeživotný)
  object Večer extends PodstatméMenoFactory(entry = "večer", rod = MužskýNeživotný)

  // Feminine
  // ending in -a preceded by a hard consonant (or neutral for krava, hlavab, škola)
  object Dedina extends PodstatméMenoFactory(entry = "dedina", rod = Ženský)
  object Hlava extends PodstatméMenoFactory(entry = "hlava", rod = Ženský)
  object Kniha extends PodstatméMenoFactory(entry = "kniha", rod = Ženský)
  object Krava extends PodstatméMenoFactory(entry = "krava", rod = Ženský)
  object Lúka extends PodstatméMenoFactory(entry = "lúka", rod = Ženský)
  object Mačka extends PodstatméMenoFactory(entry = "mačka", rod = Ženský)
  object Noha extends PodstatméMenoFactory(entry = "noha", rod = Ženský)
  object Rieka extends PodstatméMenoFactory(entry = "rieka", rod = Ženský)
  object Ruka extends PodstatméMenoFactory(entry = "ruka", rod = Ženský)
  object Škola extends PodstatméMenoFactory(entry = "škola", rod = Ženský)
  object Stena extends PodstatméMenoFactory(entry = "stena", rod = Ženský)
  object Trieda extends PodstatméMenoFactory(entry = "trieda", rod = Ženský)
  object Učiteľka extends PodstatméMenoFactory(entry = "učiteľka", rod = Ženský)
  object Voda extends PodstatméMenoFactory(entry = "voda", rod = Ženský)
  object Žena extends PodstatméMenoFactory(entry = "žena", rod = Ženský)
  object Záhrada extends PodstatméMenoFactory(entry = "záhrada", rod = Ženský)
  // following dlaň
  object Dlaň extends PodstatméMenoFactory(entry = "dlaň", rod = Ženský)
  object Kaviareň extends PodstatméMenoFactory(entry = "kaviareň", rod = Ženský)
  object Radosť extends PodstatméMenoFactory(entry = "radosť", rod = Ženský)
  // uncategorized Feminine
  object Tvár extends PodstatméMenoFactory(entry = "tvár", rod = Ženský)
  object Ulica extends PodstatméMenoFactory(entry = "ulica", rod = Ženský)
  object Pani extends PodstatméMenoFactory(entry = "pani", rod = Ženský)


  // Neuter
  // ending in -o
  object Auto extends PodstatméMenoFactory(entry = "auto", rod = Stredný)
  object Čelo extends PodstatméMenoFactory(entry = "čelo", rod = Stredný)
  object Mesto extends PodstatméMenoFactory(entry = "mesto", rod = Stredný)
  object Mlieko extends PodstatméMenoFactory(entry = "mlieko", rod = Stredný)
  object Oko extends PodstatméMenoFactory(entry = "oko", rod = Stredný)
  object Rameno extends PodstatméMenoFactory(entry = "rameno", rod = Stredný)
  object Ráno extends PodstatméMenoFactory(entry = "ráno", rod = Stredný)
  object Sklo extends PodstatméMenoFactory(entry = "sklo", rod = Stredný)
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

  val Čistý = new PrídavnéMeno("čistý")
  val Dobrý = new PrídavnéMeno("dobrý")
  val Hnedý = new PrídavnéMeno("hnedý")
  val Krázny = new PrídavnéMeno("krázný")
  val Malý = new PrídavnéMeno("malý")
  val Mladý = new PrídavnéMeno("mladý")
  val Modrý = new PrídavnéMeno("modrý")
  val Nový = new PrídavnéMeno("nový")
  val Pekný = new PrídavnéMeno("pekný")
  val Škaredý = new PrídavnéMeno("škaredý")
  val Špinavý = new PrídavnéMeno("špinavý")
  val Starý = new PrídavnéMeno("starý")
  val Veľký = new PrídavnéMeno("veľký")
  val Vysoký = new PrídavnéMeno("vysoký")
  val Zelený = new PrídavnéMeno("zelený")
  val Zlý = new PrídavnéMeno("zlý")

  /*
   * Sloveso
   */

  case class Byť(
    podmet: Seq[Noun] = Seq.empty[PodstatméMeno],
    príslovka: Option[String] = None,
    záporný: Boolean = false,
    prísudok: Option[PrídavnéMeno] = None
  ) extends Sloveso(podmet, None, príslovka, záporný) {
    override val infinitív = "byť"
    val časovanie = Array(
      Array("som", "si", "je"),   // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

    // add a podmet and return a new verb instance
//    def podmet(newPodmet: PodstatméMeno): Sloveso = new Byť(podmet :+ newPodmet)
    override def asText = super.asText + prísudok.map { adjective =>
      " " + adjective.asText(if (podmet.length == 0) Stredný else podmet(0).rod)
    }.getOrElse("")

  }

  object Mať extends ATypeFactory("mať")
  object Bývať extends ATypeFactory("bývať")
  object Čakať extends ATypeFactory("čakať")

}
