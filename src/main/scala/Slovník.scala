package org.mackler.sknlg

import Rod._
import Osoba._
import Čislo._
import Pád._

/*
 * Hard consonants: g, h, ch, k, d, n, t
 * Soft consonants: c, dz, j, all consonants with the mäkčeň
 * Neutral consonants: b, f, l, m, p, r, s, v, z  
 */

object Slovník {

  /*
   * PodstatnéMeno
   */

  // Masculine Animate
  // not ending in -a, e.g., "chlap"
  object Býk extends PodstatnéMenoFactory(entry = "býk", rod = MužskýŽivotný)
  object Muž extends PodstatnéMenoFactory(entry = "muž", rod = MužskýŽivotný)
  object Chlapec extends PodstatnéMenoFactory(entry = "chlapec", rod = MužskýŽivotný)
  object Kocúr extends PodstatnéMenoFactory(entry = "kocúr", rod = MužskýŽivotný)
  object Kôň extends PodstatnéMenoFactory(entry = "kôň", rod = MužskýŽivotný)
  object Pán extends PodstatnéMenoFactory(entry = "pán", rod = MužskýNeživotný)
  object Učiteľ extends PodstatnéMenoFactory(entry = "učitel", rod = MužskýŽivotný)
  // ending in -a, e.g., "hrdina"

  // Masculine Inanimate
  // ending in hard or neutral consonant, e.g., "dub"
  object Breh extends PodstatnéMenoFactory(entry = "breh", rod = MužskýNeživotný)
  object Deň extends PodstatnéMenoFactory(entry = "deň", rod = MužskýNeživotný)
  object Dom extends PodstatnéMenoFactory(entry = "dom", rod = MužskýNeživotný)
  object Dvor extends PodstatnéMenoFactory(entry = "dvor", rod = MužskýNeživotný)
  object Hrad extends PodstatnéMenoFactory(entry = "hrad", rod = MužskýNeživotný)
  object Kufor extends PodstatnéMenoFactory(entry = "kufor", rod = MužskýNeživotný)
  object Kvet extends PodstatnéMenoFactory(entry = "kvet", rod = MužskýNeživotný)
  object Les extends PodstatnéMenoFactory(entry = "les", rod = MužskýNeživotný)
  object Obchod extends PodstatnéMenoFactory(entry = "obchod", rod = MužskýNeživotný)
  object Obraz extends PodstatnéMenoFactory(entry = "obraz", rod = MužskýNeživotný)
  object Plot extends PodstatnéMenoFactory(entry = "plot", rod = MužskýNeživotný)
  object Prst extends PodstatnéMenoFactory(entry = "prst", rod = MužskýNeživotný)
  object Strom extends PodstatnéMenoFactory(entry = "strom", rod = MužskýNeživotný)
  object Večer extends PodstatnéMenoFactory(entry = "večer", rod = MužskýNeživotný)
  object Voz extends PodstatnéMenoFactory(entry = "voz", rod = MužskýNeživotný)
  // ending in soft consonant
  object Dunaj extends PodstatnéMenoFactory(entry = "Dunaj", rod = MužskýNeživotný)

  // Feminine
  // ending in -a preceded by a hard or neutral consonant, e.g., "žena"
  object Cena extends PodstatnéMenoFactory(entry = "cena", rod = Ženský)
  object Dedina extends PodstatnéMenoFactory(entry = "dedina", rod = Ženský)
  object Hlava extends PodstatnéMenoFactory(entry = "hlava", rod = Ženský)
  object Kniha extends PodstatnéMenoFactory(entry = "kniha", rod = Ženský)
  object Krava extends PodstatnéMenoFactory(entry = "krava", rod = Ženský)
  object Lúka extends PodstatnéMenoFactory(entry = "lúka", rod = Ženský)
  object Mačka extends PodstatnéMenoFactory(entry = "mačka", rod = Ženský)
  object Minúta extends PodstatnéMenoFactory(entry = "minúta", rod = Ženský)
  object Noha extends PodstatnéMenoFactory(entry = "noha", rod = Ženský)
  object Otázka extends PodstatnéMenoFactory(entry = "otázka", rod = Ženský)
  object Rieka extends PodstatnéMenoFactory(entry = "rieka", rod = Ženský)
  object Ruka extends PodstatnéMenoFactory(entry = "ruka", rod = Ženský)
  object Stavba extends PodstatnéMenoFactory(entry = "stavba", rod = Ženský)
  object Stena extends PodstatnéMenoFactory(entry = "stena", rod = Ženský)
  object Škola extends PodstatnéMenoFactory(entry = "škola", rod = Ženský)
  object Trieda extends PodstatnéMenoFactory(entry = "trieda", rod = Ženský)
  object Učiteľka extends PodstatnéMenoFactory(entry = "učiteľka", rod = Ženský)
  object Voda extends PodstatnéMenoFactory(entry = "voda", rod = Ženský)
  object Žena extends PodstatnéMenoFactory(entry = "žena", rod = Ženský)
  object Záhrada extends PodstatnéMenoFactory(entry = "záhrada", rod = Ženský)
  // ending in -a preceding by a soft consonant, e.g., "ulica"
  object Stanica extends PodstatnéMenoFactory(entry = "stanica", rod = Ženský)
  object Ulica extends PodstatnéMenoFactory(entry = "ulica", rod = Ženský)
  // following dlaň
  object Dlaň extends PodstatnéMenoFactory(entry = "dlaň", rod = Ženský)
  object Kaviareň extends PodstatnéMenoFactory(entry = "kaviareň", rod = Ženský)
  object Radosť extends PodstatnéMenoFactory(entry = "radosť", rod = Ženský)
  // ending in consonant in nominative singular, -i in genitive singular, e.g., "kosť"
  object Pomoc extends PodstatnéMenoFactory(entry = "pomoc", rod = Ženský)
  object Vec extends PodstatnéMenoFactory(entry = "vec", rod = Ženský)
  // uncategorized Feminine
  object Tvár extends PodstatnéMenoFactory(entry = "tvár", rod = Ženský)
  object Pani extends PodstatnéMenoFactory(entry = "pani", rod = Ženský)


  // Neuter
  // ending in -o, e.g., "mesto"
  object Auto extends PodstatnéMenoFactory(entry = "auto", rod = Stredný)
  object Čelo extends PodstatnéMenoFactory(entry = "čelo", rod = Stredný)
  object Mesto extends PodstatnéMenoFactory(entry = "mesto", rod = Stredný)
  object Mlieko extends PodstatnéMenoFactory(entry = "mlieko", rod = Stredný)
  object Oko extends PodstatnéMenoFactory(entry = "oko", rod = Stredný)
  object Rameno extends PodstatnéMenoFactory(entry = "rameno", rod = Stredný)
  object Ráno extends PodstatnéMenoFactory(entry = "ráno", rod = Stredný)
  object Sklo extends PodstatnéMenoFactory(entry = "sklo", rod = Stredný)
  // ending -e
  object Srdce extends PodstatnéMenoFactory(entry = "srdce", rod = Stredný)
  // ending -ie
  object Namestie extends PodstatnéMenoFactory(entry = "namestie", rod = Stredný)
  // ending -a or -ä
  object Dieťa extends PodstatnéMenoFactory(entry = "dieťa", rod = Stredný)
  object Dievča extends PodstatnéMenoFactory(entry = "dievča", rod = Stredný)
  object Mača extends PodstatnéMenoFactory(entry = "mača", rod = Stredný)
  object Teľa extends PodstatnéMenoFactory(entry = "teľa", rod = Stredný)

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

  // Irregular verbs: to be, to go

  case class Byť(
    podmet: Seq[Noun] = Seq.empty[PodstatnéMeno],
    príslovka: Option[String] = None,
    záporný: Boolean = false,
    prísudok: Option[PrídavnéMeno] = None
  ) extends Sloveso(podmet, None, príslovka, záporný) {
    override val infinitív = "byť"
    def setPodmet(p: Noun): Sloveso = this.copy(podmet = podmet :+ p)

    val časovanie = Array(
      Array("som", "si", "je"),   // singular
      Array("sme", "ste", "sú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

    override def asText = super.asText + prísudok.map { adjective =>
      " " + adjective.asText(if (podmet.length == 0) Stredný else podmet(0).rod)
    }.getOrElse("")

  }

  case class Ísť(
    podmet: Seq[Noun] = Seq.empty[PodstatnéMeno],
    príslovka: Option[String] = None,
    záporný: Boolean = false,
    prísudok: Option[PrídavnéMeno] = None,
    directPredmet: Option[PodstatnéMeno] = None // TODO probably not really a direct object
  ) extends Sloveso(podmet, None, príslovka, záporný) with TransitiveVerb {
    override val infinitív = "ísť"
    override def setPodmet(p: Noun) = this.copy(podmet = podmet :+ p)
    def setPredmet(o: PodstatnéMeno): Sloveso = this.copy(directPredmet = Some(o))

    val časovanie = Array(
      Array("idem", "ideš", "ide"),   // singular
      Array("ideme", "idete", "idú")   // plural
    )
    override def inflect(čislo: Čislo, person: Osoba, negate: Boolean): String =
      (if (negate) "nie " else "") + časovanie(čislo.id)(person.id)

  }


  // Type1 Verbs follow "chytať" - "chytám"
  object Mať extends Type1Factory("mať")
  object Bývať extends Type1Factory("bývať")
  object Čakať extends Type1Factory("čakať")
  object Hľadať extends Type1Factory("hľadať")
  object Poznať extends Type1Factory("poznať")

  // Type 11 verbs follow "pracuvať"
  val Potrebovať = new SlovesoType11Factory("potrebovať")

  // Type 12 verbs follow "robiť"
  // TOTO WARNING I ONLY GUESSED THIS VERB's TYPE!!!!
  val Obrátiť = new SlovesoType12Factory("obrátiť")
  val Robiť = new SlovesoType12Factory("robiť")

  // Type 13 verbs follow "vidieť" - "vidím"
  val Vidieť = new SlovesoType13Factory("vidieť")

}
