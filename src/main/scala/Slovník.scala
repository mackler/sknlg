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
  object Večer extends PodstatnéMenoFactory(entry = "večer", rod = MužskýNeživotný)
  object Voz extends PodstatnéMenoFactory(entry = "voz", rod = MužskýNeživotný)
  // ending in soft consonant, e.g., "počitač"
  object Dunaj extends PodstatnéMenoFactory(entry = "Dunaj", rod = MužskýNeživotný)

  // Feminine
  // ending in -a preceded by a hard or neutral consonant, e.g., "žena"
  object Cena extends PodstatnéMenoFactory(entry = "cena", rod = Ženský)
  object Dedina extends PodstatnéMenoFactory(entry = "dedina", rod = Ženský)
  object Hlava extends PodstatnéMenoFactory(entry = "hlava", rod = Ženský)
  object Izba extends PodstatnéMenoFactory(entry = "izba", rod = Ženský)
  object Kniha extends PodstatnéMenoFactory(entry = "kniha", rod = Ženský)
  object Krava extends PodstatnéMenoFactory(entry = "krava", rod = Ženský)
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
  object Čelo extends PodstatnéMenoFactory(entry = "čelo", rod = Stredný)
  object Mesto extends PodstatnéMenoFactory(entry = "mesto", rod = Stredný)
  object Mlieko extends PodstatnéMenoFactory(entry = "mlieko", rod = Stredný)
  object Monako extends PodstatnéMenoFactory(entry = "mlieko", rod = Stredný) // Monačan/Monačanka
  object Oko extends PodstatnéMenoFactory(entry = "oko", rod = Stredný)
  object Rameno extends PodstatnéMenoFactory(entry = "rameno", rod = Stredný)
  object Ráno extends PodstatnéMenoFactory(entry = "ráno", rod = Stredný)
  object Rumunsko extends PodstatnéMenoFactory(entry = "ráno", rod = Stredný) // Rumun/Rumunka - rumunský
  object Sklo extends PodstatnéMenoFactory(entry = "sklo", rod = Stredný)

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

  // Masculine place names
  val Vatikán = PlaceName(entry = "strom", rod = MužskýNeživotný, adjectival = "vatikánsky")

  // Feminine place names
  val Amerika = PlaceName(entry = "Amerika", rod = Ženský, demonymMužský = "Američan", adjectival = "americký")
  val Bosna = PlaceName(entry = "Bosna", rod = Ženský,
                            demonymMužský = "Bosniak", demonymŽenský = "Bosniačka", adjectival = "bosniansky")
  val Británia = PlaceName(entry = "Veľká Británia", rod = Ženský, demonymMužský = "Brit", adjectival = "britský")
  val ČiernaHora = PlaceName(entry = "Čierna Hora", rod = Ženský, demonymMužský = "Čiernohorec", adjectival = "čiernohorský")
  val Čína = PlaceName(entry = "Čína", rod = Ženský, demonymMužský = "Číňan", adjectival = "čínsky")
  val Európa = PlaceName(entry = "Európa", rod = Ženský, demonymMužský = "Európan", adjectival = "európsky")
  val Hercegovina = PlaceName(entry = "Hercegovina", rod = Ženský, demonymMužský = "Hercegovinec", adjectival = "hercegovský")
  val Litva = PlaceName(entry = "Litva", rod = Ženský, demonymMužský = "Litovčan", adjectival = "litovský")
  val Ukrajina = PlaceName(entry = "Ukrajina", rod = Ženský, demonymMužský = "Ukrajinec", adjectival = "ukrajinský")

  // Neuter place names
  val Anglicko = PlaceName(entry = "Anglicko", rod = Stredný, demonymMužský = "Angličan", adjectival = "anglický")
  val Belgicko = PlaceName(entry = "Belgicko", rod = Stredný, demonymMužský = "Belgičan", adjectival = "belgický")
  val Bielorusko = PlaceName(entry = "Bielorusko", rod = Stredný, demonymMužský = "Bielorus", adjectival = "bieloruský")
  val Česko = PlaceName(entry = "Česko", rod = Stredný, demonymMužský = "Čech", demonymŽenský = "Češka", adjectival = "český")
  val Kanada = PlaceName(entry = "Kanada ", rod = Stredný, demonymMužský = "Kanaďan", adjectival = "kanadský")
  val Estónsko = PlaceName(entry = "Estónsko", rod = Stredný, demonymMužský = "Estónec", adjectival = "estónsky")
  val Fínsko = PlaceName(entry = "Fínsko", rod = Stredný, demonymMužský = "Fín", adjectival = "fínsky")
  val Francúzsko = PlaceName(entry = "Francúzsko", rod = Stredný, demonymMužský = "Francúz", adjectival = "francúzsky")
  val Grécko = PlaceName(entry = "Francúzsko", rod = Stredný,
                            demonymMužský = "Grék", demonymŽenský = "Grékyňa", adjectival = "grécky")
  val Holandsko = PlaceName(entry = "Holandsko", rod = Stredný, demonymMužský = "Holanďan", adjectival = "holandský")
  val Chorvátsko = PlaceName(entry = "Chorvátsko", rod = Stredný, demonymMužský = "Chorvát", adjectival = "chorvátsky")
  val Írsko = PlaceName(entry = "Írsko", rod = Stredný, demonymMužský = "Ír", adjectival = "írsky")
  val Japonsko = PlaceName(entry = "Japonsko", rod = Stredný, demonymMužský = "Japonec", adjectival = "japonský")
  val Lichtenštajnsko = PlaceName(entry = "Lichtenštajnsko", rod = Stredný,
                            demonymMužský = "Lichtenštajnčan", adjectival = "lichtenštajnský")
  val Lotyšsko = PlaceName(entry = "Lotyšsko", rod = Stredný, demonymMužský = "Lotyš", adjectival = "lotyšský")
  val Luxembursko = PlaceName(entry = "Luxembursko", rod = Stredný, demonymMužský = "Luxemburčan", adjectival = "luxemburský")
  val Macedónsko = PlaceName(entry = "Maďarsko", rod = Stredný, demonymMužský = "Macedónec", adjectival = "macedónsky")
  val Maďarsko = PlaceName(entry = "Maďarsko", rod = Stredný, demonymMužský = "Maďar", adjectival = "maďarský")
  val Mexiko = PlaceName(entry = "Mexiko", rod = Stredný, demonymMužský = "Mexičan", adjectival = "mexický")
  val Moldavsko = PlaceName(entry = "Moldavsko", rod = Stredný, demonymMužský = "Moldavčan", adjectival = "moldavský")
  val Nemecko = PlaceName(entry = "Nemecko", rod = Stredný, demonymMužský = "Nemec", adjectival = "nemecký")
  val Nórsko = PlaceName(entry = "Nórsko", rod = Stredný, demonymMužský = "Nór", adjectival = "nórsky")
  val Poľsko = PlaceName(entry = "Poľsko", rod = Stredný,
                            demonymMužský = "Poliak", demonymŽenský = "Poľka", adjectival = "poľský")
  val Portugalsko = PlaceName(entry = "Portugalsko", rod = Stredný, demonymMužský = "Portugalec", adjectival = "portugalský")
  val Rakúsko = PlaceName(entry = "Rakúsko", rod = Stredný, demonymMužský = "Rakúšan", adjectival = "rakúsky")
  val Rusko = PlaceName(entry = "Rusko", rod = Stredný, demonymMužský = "Rus", adjectival = "ruský")
  val Škótsko = PlaceName(entry = "Škótsko", rod = Stredný, demonymMužský = "Škót", adjectival = "škótsky")
  val Slovensko = PlaceName(entry = "Slovensko", rod = Stredný,
                            demonymMužský = "Slovák", demonymŽenský = "Slovenka", adjectival = "slovenský")
  val Slovinsko = PlaceName(entry = "Slovensko", rod = Stredný, demonymMužský = "Slovinec", adjectival = "slovinský")
  val Španielsko = PlaceName(entry = "Španielsko", rod = Stredný, demonymMužský = "Španiel", adjectival = "španielsky")
  val Srbsko = PlaceName(entry = "Srbsko", rod = Stredný, demonymMužský = "Srb", adjectival = "srbský")
  val Švédsko = PlaceName(entry = "Švédsko", rod = Stredný, demonymMužský = "Švéd", adjectival = "švédsky")
  val Švajčiarsko = PlaceName(entry = "Švajčiarsko", rod = Stredný, demonymMužský = "Švajčiar", adjectival = "švajčiarsky")
  val Taliansko = PlaceName(entry = "Taliansko", rod = Stredný, demonymMužský = "Talian", adjectival = "taliansky")
  val Turecko = PlaceName(entry = "Turecko", rod = Stredný, adjectival = "turecký")

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
    val príslovka: Option[Príslovka] = None,
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
