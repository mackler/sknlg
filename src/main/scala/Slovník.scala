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

package object slovník {

  /*
   * PodstatnéMeno
   */

  // Masculine Animate
  // not ending in -a, e.g., "chlap", "muž"
  object Býk extends PodstatnéMenoFactory(entry = "býk", rod = MužskýŽivotný)
  object Muž extends PodstatnéMenoFactory(entry = "muž", rod = MužskýŽivotný)
  object Chlapec extends PodstatnéMenoFactory(entry = "chlapec", rod = MužskýŽivotný)
  object Kocúr extends PodstatnéMenoFactory(entry = "kocúr", rod = MužskýŽivotný)
  object Kôň extends PodstatnéMenoFactory(entry = "kôň", rod = MužskýŽivotný)
  object Manžel extends PodstatnéMenoFactory(entry = "manžel", rod = MužskýŽivotný)
  object Pán extends PodstatnéMenoFactory(entry = "pán", rod = MužskýŽivotný)
  object Spolubývajúci extends PodstatnéMenoFactory(entry = "spolubývajúci", rod = MužskýŽivotný)
  object Učiteľ extends PodstatnéMenoFactory(entry = "učiteľ", rod = MužskýŽivotný)
  // ending in -a, e.g., "hrdina", "kolega""

  // Masculine Inanimate
  // ending in hard or neutral consonant, e.g., "dub", "plán"
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
  object Vatikán extends PodstatnéMenoFactory(entry = "strom", rod = MužskýNeživotný) // vatikánsky
  object Večer extends PodstatnéMenoFactory(entry = "večer", rod = MužskýNeživotný)
  object Voz extends PodstatnéMenoFactory(entry = "voz", rod = MužskýNeživotný)
  // ending in soft consonant, e.g., "počitač"
  object Dunaj extends PodstatnéMenoFactory(entry = "Dunaj", rod = MužskýNeživotný)

  // Feminine
  // ending in -a preceded by a hard or neutral consonant, e.g., "žena"
  object Amerika extends PodstatnéMenoFactory(entry = "Amerika", rod = Ženský)
  object Bosna extends PodstatnéMenoFactory(entry = "Amerika", rod = Ženský) // Bosniak/Bosniačka - bosniacky (unsure)
  object Británia extends PodstatnéMenoFactory(entry = "Británia", rod = Ženský) // Brit/Britka - britský
  object Cena extends PodstatnéMenoFactory(entry = "cena", rod = Ženský)
  object ČiernaHora extends PodstatnéMenoFactory(entry = "Čierna Hora", rod = Ženský) // Čiernohorec/Čiernohorka
  object Čína extends PodstatnéMenoFactory(entry = "Čierna Hora", rod = Ženský) // Číňan/Číňanka - čínsky
  object Dedina extends PodstatnéMenoFactory(entry = "dedina", rod = Ženský)
  object Európa extends PodstatnéMenoFactory(entry = "Európa", rod = Ženský)
  object Hercegovina extends PodstatnéMenoFactory(entry = "Hercegovina", rod = Ženský) // Hercegovinec/?? - hercegovský
  object Hlava extends PodstatnéMenoFactory(entry = "hlava", rod = Ženský)
  object Izba extends PodstatnéMenoFactory(entry = "izba", rod = Ženský)
  object Kniha extends PodstatnéMenoFactory(entry = "kniha", rod = Ženský)
  object Krava extends PodstatnéMenoFactory(entry = "krava", rod = Ženský)
  object Litva extends PodstatnéMenoFactory(entry = "Litva", rod = Ženský) // Litovciv/?? - litovský
  object Lúka extends PodstatnéMenoFactory(entry = "lúka", rod = Ženský)
  object Mačka extends PodstatnéMenoFactory(entry = "mačka", rod = Ženský)
  object Manželka extends PodstatnéMenoFactory(entry = "manželka", rod = Ženský)
  object Minúta extends PodstatnéMenoFactory(entry = "minúta", rod = Ženský)
  object Noha extends PodstatnéMenoFactory(entry = "noha", rod = Ženský)
  object Otázka extends PodstatnéMenoFactory(entry = "otázka", rod = Ženský)
  object Rada extends PodstatnéMenoFactory(entry = "rada", rod = Ženský)
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
  object Ukrajina extends PodstatnéMenoFactory(entry = "Ukrajina", rod = Ženský)

  // Feminine ending in -a preceding by a soft consonant, e.g., "ulica", "stanica"
  object Spolubývajúca extends PodstatnéMenoFactory(entry = "spolubývajúca", rod = Ženský)
  object Stanica extends PodstatnéMenoFactory(entry = "stanica", rod = Ženský)
  object Ulica extends PodstatnéMenoFactory(entry = "ulica", rod = Ženský)
  // following "dlaň", "loď"
  object Dlaň extends PodstatnéMenoFactory(entry = "dlaň", rod = Ženský)
  object Kaviareň extends PodstatnéMenoFactory(entry = "kaviareň", rod = Ženský)
  object Radosť extends PodstatnéMenoFactory(entry = "radosť", rod = Ženský)
  // ending in consonant in nominative singular, -i in genitive singular, e.g., "kosť", "miestnosť"
  object Pomoc extends PodstatnéMenoFactory(entry = "pomoc", rod = Ženský)
  object Vec extends PodstatnéMenoFactory(entry = "vec", rod = Ženský)
  // uncategorized Feminine
  object Tvár extends PodstatnéMenoFactory(entry = "tvár", rod = Ženský)
  object Pani extends PodstatnéMenoFactory(entry = "pani", rod = Ženský)


  // Neuter
  // ending in -o, e.g., "mesto"
  object Albánsko extends PodstatnéMenoFactory(entry = "auto", rod = Stredný) // Albánec/Albánka - albánsky
  object Auto extends PodstatnéMenoFactory(entry = "auto", rod = Stredný)
  object Belgicko extends PodstatnéMenoFactory(entry = "Belgicko", rod = Stredný) // Belgičan/Belgičanka - belgický
  object Bielorusko extends PodstatnéMenoFactory(entry = "Bielorusko", rod = Stredný) // Bielorus/Bieloruska - bieloruský
  object Čelo extends PodstatnéMenoFactory(entry = "čelo", rod = Stredný)
  object Česko extends PodstatnéMenoFactory(entry = "Česko", rod = Stredný)
  object Chorvátsko extends PodstatnéMenoFactory(entry = "Chorvátsko", rod = Stredný) // Chorvát/Chorvátka - chorvátsky
  object Estónsko extends PodstatnéMenoFactory(entry = "Estónsko", rod = Stredný) // Estónec/Estónka - estónsky
  object Fínsko extends PodstatnéMenoFactory(entry = "Fínsko", rod = Stredný) // Fín/Fínka - fínsky
  object Grécko extends PodstatnéMenoFactory(entry = "Francúzsko", rod = Stredný) // Grék/Grékyňa - grécky
  object Holandsko extends PodstatnéMenoFactory(entry = "Holandsko", rod = Stredný) // Holanďan/Holanďanka - holandský
  object Írsko extends PodstatnéMenoFactory(entry = "Írsko", rod = Stredný) // Ír/Írka - írsky
  object Japonsko extends PodstatnéMenoFactory(entry = "Írsko", rod = Stredný) // Japonec/Japonka - japonský
  object Lichtenštajnsko extends PodstatnéMenoFactory(entry = "Írsko", rod = Stredný) // Lichtenštajnčan/Lichtenštajnčanka
  object Lotyšsko extends PodstatnéMenoFactory(entry = "Lotyšsko", rod = Stredný) // lotyš/Lotyška - lotyšský
  object Luxembursko extends PodstatnéMenoFactory(entry = "Luxembursko", rod = Stredný) // Luxemburčan/Luxemburčanka - luxemburský
  object Mesto extends PodstatnéMenoFactory(entry = "mesto", rod = Stredný)
  object Maďarsko extends PodstatnéMenoFactory(entry = "Maďarsko", rod = Stredný)
  object Macedónsko extends PodstatnéMenoFactory(entry = "Maďarsko", rod = Stredný) // Macedónec/Macedónka - macedónsky
  object Mlieko extends PodstatnéMenoFactory(entry = "mlieko", rod = Stredný)
  object Monako extends PodstatnéMenoFactory(entry = "mlieko", rod = Stredný) // Monačan/Monačanka
  object Moldavsko extends PodstatnéMenoFactory(entry = "Moldavsko", rod = Stredný) // Moldavčan/Moldavčanka - moldavský
  object Nemecko extends PodstatnéMenoFactory(entry = "Nemecko", rod = Stredný)
  object Nórsko extends PodstatnéMenoFactory(entry = "Nórsko", rod = Stredný) // Nór/Nórka - nórsky
  object Oko extends PodstatnéMenoFactory(entry = "oko", rod = Stredný)
  object Poľsko extends PodstatnéMenoFactory(entry = "Poľsko", rod = Stredný)
  object Portugalsko extends PodstatnéMenoFactory(entry = "Portugalsko", rod = Stredný) // Portugalec/Portugalka - portugalský
  object Rakúsko extends PodstatnéMenoFactory(entry = "Rakúsko", rod = Stredný)
  object Rameno extends PodstatnéMenoFactory(entry = "rameno", rod = Stredný)
  object Ráno extends PodstatnéMenoFactory(entry = "ráno", rod = Stredný)
  object Rumunsko extends PodstatnéMenoFactory(entry = "ráno", rod = Stredný) // Rumun/Rumunka - rumunský
  object Rusko extends PodstatnéMenoFactory(entry = "Rusko", rod = Stredný)
  object Sklo extends PodstatnéMenoFactory(entry = "sklo", rod = Stredný)
  object Slovinsko extends PodstatnéMenoFactory(entry = "Slovensko", rod = Stredný) // Slovinec/Slovinka - slovinský
  object Španielsko extends PodstatnéMenoFactory(entry = "Španielsko", rod = Stredný)
  object Srbsko extends PodstatnéMenoFactory(entry = "Srbsko", rod = Stredný) // Srb/srbský - srbský
  object Švédsko extends PodstatnéMenoFactory(entry = "Švédsko", rod = Stredný) // Švéd/Švédka - švédsky
  object Švajčiarsko extends PodstatnéMenoFactory(entry = "Švajčiarsko", rod = Stredný) // Švajčiar/Švajčiarka - švajčiarsky
  object Taliansko extends PodstatnéMenoFactory(entry = "Taliansko", rod = Stredný)
  object Turecko extends PodstatnéMenoFactory(entry = "Taliansko", rod = Stredný) // ??? - turecký

  // Neuter ending in "-e", e.g., "more"
  object Srdce extends PodstatnéMenoFactory(entry = "srdce", rod = Stredný)
  // ending -ie, e.g., "poschodie""
  object Namestie extends PodstatnéMenoFactory(entry = "namestie", rod = Stredný)
  // ending -a or -ä, e.g., "dievča"
  object Dieťa extends PodstatnéMenoFactory(entry = "dieťa", rod = Stredný)
  object Dievča extends PodstatnéMenoFactory(entry = "dievča", rod = Stredný)
  object Mača extends PodstatnéMenoFactory(entry = "mača", rod = Stredný)
  object Teľa extends PodstatnéMenoFactory(entry = "teľa", rod = Stredný)

  /*
   * Country and other place names
   */

  // Feminine place names

  // Neuter place names
  val Francúzsko = PlaceName(entry = "Francúzsko", rod = Stredný,
                            demonymMužský = "Francúz", demonymŽenský = "Francúzka", adjectival = "francúzsky")
  val Slovensko = PlaceName(entry = "Slovensko", rod = Stredný,
                            demonymMužský = "Slovák", demonymŽenský = "Slovenka", adjectival = "slovenský")

  /*
   * PrídavnéMeno
   */

  val Čistý = new PrídavnéMeno("čistý")
  val Dobrý = new PrídavnéMeno("dobrý")
//  val Ešte = new PrídavnéMeno("hnedý")
  val Hnedý = new PrídavnéMeno("hnedý")
  val Hlavný = new PrídavnéMeno("hlavny")
  val Hospodársky = new PrídavnéMeno("hospodársky")
  // TODO jeden, jedna, jedno
  val Jednoduchý = new PrídavnéMeno("jednoduchý")
  val Krázny = new PrídavnéMeno("krázný")
  // TODO this is actually not an adjective but an interrogative pronoun
  val Ktorý = new PrídavnéMeno("ktorý")
  val Malý = new PrídavnéMeno("malý")
  val Mladý = new PrídavnéMeno("mladý")
  val Modrý = new PrídavnéMeno("modrý")
  // TODO this is not actually an adjective but an indefinite pronoun
  val Nejaký = new PrídavnéMeno("nejaký")
  val Nízky = new PrídavnéMeno("nízky")
  val Nový = new PrídavnéMeno("nový")
  val Pekný = new PrídavnéMeno("pekný")
  val Posledný = new PrídavnéMeno("posledný")
  val Pravý = new PrídavnéMeno("pravý")
  val Široký = new PrídavnéMeno("široký")
  val Škaredý = new PrídavnéMeno("škaredý")
  val Slobodný = new PrídavnéMeno("slobodný")
  val Špinavý = new PrídavnéMeno("špinavý")
  val Starý = new PrídavnéMeno("starý")
  // This is not actually an adjective but a demonstrative pronoun
  val Taký = new PrídavnéMeno("taký")
  val Veľký = new PrídavnéMeno("veľký")
  val Vysoký = new PrídavnéMeno("vysoký")
  val Zaujímavý = new PrídavnéMeno("Zaujímavý")
  val Zelený = new PrídavnéMeno("zelený")
  val Ženatý = new PrídavnéMeno("Ženatý")
  val Zlý = new PrídavnéMeno("zlý")

  /*
   * Sloveso
   */

  // Type1 Verbs follow "chytať" - "chytám"

  val Bývať = SlovesoType1("bývať")
  val Čakať = SlovesoType1("čakať")
  val Hľadať = SlovesoType1("hľadať")
  // apparently this is not really a word, but its negative is
  val Chávať = SlovesoType1("chávať")
  val Chodievať = SlovesoType1("chodievať")
  val Konať = SlovesoType1("konať")
  val Mať = SlovesoType1("mať")
  val Pamätať = SlovesoType1("pamätať")
  val Poznať = SlovesoType1("poznať")
  val Prichádzať = SlovesoType1("prichádzať")
  val Rozprávať = SlovesoType1("rozprávať")
  // nespavať appears in the Mistrík textbook
   val Spať = SlovesoType1("spať")
  val Vstávať = SlovesoType1("vstávať")
  val Vychádzať = SlovesoType1("vychádzať")
  val Začinať = SlovesoType1("začinať")
  val Žiadať = SlovesoType1("žiadať")
  val Znamenať = SlovesoType1("znamenať")

  // Type 11 verbs follow "pracuvať"
  val Potrebovať = SlovesoType11("potrebovať")

  // Type 12 verbs follow "robiť"
  // TOTO WARNING I ONLY GUESSED THIS VERB's TYPE!!!!
  val Obrátiť = SlovesoType12("obrátiť")
  val Robiť = SlovesoType12("robiť")

  // Type 13 verbs follow "vidieť" - "vidím"
  val Vidieť = SlovesoType13("vidieť")

  // Irregular verb: to go
  case class ísť(
    val podmet: Seq[NounPhrase] = Seq.empty[PodstatnéMeno],
    val príslovka: Option[String] = None,
    val záporný: Boolean = false,
    directPredmet: Option[PodstatnéMeno] = None, // use only with a preposition
    override val predložka: Option[String] = None
  ) extends RegularSloveso {
    override val infinitív = "ísť"
    def addPodmet(p: NounPhrase) = this.copy(podmet = podmet :+ p)
    def setPodmet(p: Seq[NounPhrase]) = this.copy(podmet = p)
    def setPredmet(o: PodstatnéMeno) = this.copy(directPredmet = Some(o))
    def toggleZáporný() = this.copy(záporný = !záporný)
    def setZáporný(z: Boolean) = this.copy(záporný = z)
    def setPredložka(p: String) = this.copy(predložka = Some(p))

    val časovanie = Array(
      Array("idem", "ideš", "ide"),   // singular
      Array("ideme", "idete", "idú")   // plural
    )
    override val paradigm = { (čislo: Čislo, person: Osoba, negate: Boolean) =>
      (if (negate) "nie " else "") +
      časovanie(čislo.id)(person.id) + predložka.map(" " + _).getOrElse("")
    }
  }
  val Ísť = ísť()

}
