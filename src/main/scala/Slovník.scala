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
   * Specify the gender for animate-masculine or if the rules-of-thumb would indicate wrongly
   */

  // Masculine Animate
  // not ending in -a, e.g., "chlap", "muž"
  val Brat = PodstatnéMeno("brat", MužskýŽivotný, nominativePlural = "bratia")
  val Býk = PodstatnéMeno("býk", MužskýŽivotný)
  val Muž = PodstatnéMeno("muž", MužskýŽivotný)
  val Chlap = PodstatnéMeno("chlap", MužskýŽivotný)
  val Chlapec = PodstatnéMeno("chlapec", MužskýŽivotný)
  val Kocúr = PodstatnéMeno("kocúr", MužskýŽivotný)
  val Kôň = PodstatnéMeno("kôň", MužskýŽivotný)
  val Manžel = PodstatnéMeno("manžel", MužskýŽivotný)
  val Otec = PodstatnéMeno("otec", MužskýŽivotný, "otca")
  val Pán = PodstatnéMeno("pán", MužskýŽivotný)
  val Priateľ = PodstatnéMeno("priateľ", MužskýŽivotný)
  val Robotník = PodstatnéMeno("robotník", MužskýŽivotný)
  val Spolubývajúci = PodstatnéMeno("spolubývajúci", MužskýŽivotný)
  val Učiteľ = PodstatnéMeno("učiteľ", MužskýŽivotný)
  // ending in -a, e.g., "hrdina", "kolega""

  // Masculine Inanimate
  // ending in hard or neutral consonant, e.g., "dub", "plán"
  val Breh = PodstatnéMeno("breh")
  val Deň = PodstatnéMeno("deň", MužskýNeživotný)  // TODO seems to be irregular
  val Dom = PodstatnéMeno("dom")
  val Dvor = PodstatnéMeno("dvor")
  val Hrad = PodstatnéMeno("hrad")
  val Kufor = PodstatnéMeno("kufor")
  val Kvet = PodstatnéMeno("kvet")
  val Les = PodstatnéMeno("les")
  val Obchod = PodstatnéMeno("obchod")
  val Obraz = PodstatnéMeno("obraz")
  val Plot = PodstatnéMeno("plot")
  val Prst = PodstatnéMeno("prst")
  val Strom = PodstatnéMeno("strom")
  val Telefón = PodstatnéMeno("telefón")
  val Večer = PodstatnéMeno("večer")
  val Voz = PodstatnéMeno("voz")
  // ending in soft consonant, e.g., "počitač"
  val Dunaj = PodstatnéMeno("Dunaj")

  // Feminine
  // ending in -a preceded by a hard or neutral consonant, e.g., "žena"
  val Cena = PodstatnéMeno("cena")
  val Dedina = PodstatnéMeno("dedina")
  val Hlava = PodstatnéMeno("hlava")
  val Izba = PodstatnéMeno("izba")
  val Kniha = PodstatnéMeno("kniha")
  val Krava = PodstatnéMeno("krava")
  val Lúka = PodstatnéMeno("lúka")
  val Mačka = PodstatnéMeno("mačka")
  val Manželka = PodstatnéMeno("manželka")
  val Matka = PodstatnéMeno("matka")
  val Minúta = PodstatnéMeno("minúta")
  val Noha = PodstatnéMeno("noha")
  val Otázka = PodstatnéMeno("otázka")
  val Práca = PodstatnéMeno("práca")
  val Rada = PodstatnéMeno("rada")
  val Rieka = PodstatnéMeno("rieka")
  val Rodina = PodstatnéMeno("rodina")
  val Ruka = PodstatnéMeno("ruka")
  val Sestra = PodstatnéMeno("sestra")
  val Stavba = PodstatnéMeno("stavba")
  val Stena = PodstatnéMeno("stena")
  val Škola = PodstatnéMeno("škola")
  val Trieda = PodstatnéMeno("trieda")
  val Učiteľka = PodstatnéMeno("učiteľka")
  val Voda = PodstatnéMeno("voda")
  val Žena = PodstatnéMeno("žena")
  val Záhrada = PodstatnéMeno("záhrada")
  val Zima = PodstatnéMeno("zima")

  // Feminine ending in -a preceded by a soft consonant, e.g., "ulica", "stanica"
  val Spolubývajúca = PodstatnéMeno("spolubývajúca")
  val Stanica = PodstatnéMeno("stanica")
  val Ulica = PodstatnéMeno("ulica")

  // following "dlaň", "loď"
  // genitive singular ends with 'e'
  // nomivative singular ends with either 'j', 'z', 'ň', 'ž', 'č', 'š', 'ď', 'f', 'dz', 'sť', 'r'
  val Dlaň = PodstatnéMeno("dlaň", Ženský)
  val Jeseň = PodstatnéMeno("jeseň", Ženský, genitiveSingular = "jesene")
  val Kaviareň = PodstatnéMeno("kaviareň", Ženský)
  val Radosť = PodstatnéMeno("radosť")
  val Továreň = PodstatnéMeno("továreň", Ženský)

  // Feminine Following "kosť", "miestnosť"
  // Nominative singular ends with a consodant, -i in genitive singular.
  // Nominative singular usually ends with either "c", "s", "p", "v", or "sť"
  val Jar = PodstatnéMeno("jar", Ženský)
  val Pomoc = PodstatnéMeno("pomoc", Ženský)
  val Vec = PodstatnéMeno("vec", Ženský)

  // uncategorized Feminine
  // this can follow either "dlaň" or "kosť"
  val Tvár = PodstatnéMeno("tvár", Ženský)
  // this follows I don't know what paradigm
  val Pani = PodstatnéMeno("pani", Ženský)

  // Neuter
  // ending in -o, e.g., "mesto"

  val Družstvo = PodstatnéMeno("družstvo")
  val Auto = PodstatnéMeno("auto")
  val Čelo = PodstatnéMeno("čelo")
  val Leto = PodstatnéMeno("leto")
  val Mesto = PodstatnéMeno("mesto")
  val Mlieko = PodstatnéMeno("mlieko")
  val Oko = PodstatnéMeno("oko")
  val Rameno = PodstatnéMeno("rameno")
  val Ráno = PodstatnéMeno("ráno")
  val Sklo = PodstatnéMeno("sklo")

  // Neuter ending in "-e", e.g., "more"
  val Srdce = PodstatnéMeno("srdce")
  // ending -ie, e.g., "poschodie""
  val Namestie = PodstatnéMeno("namestie")
  // ending -a or -ä, e.g., "dievča"
  val Dieťa = PodstatnéMeno("dieťa", Stredný)
  val Dievča = PodstatnéMeno("dievča", Stredný)
  val Mača = PodstatnéMeno("mača", Stredný)
  val Teľa = PodstatnéMeno("teľa", Stredný)

  /*
   * Country and other place names
   */

  // Masculine place names
  val Vatikán = PlaceName(entry = "Vatikán", rod = MužskýNeživotný, adjectival = "vatikánsky")

  // Feminine place names
  val Amerika = PlaceName(entry = "Amerika", rod = Ženský, demonymMužský = "Američan", adjectival = "americký")
  val Bosna = PlaceName(entry = "Bosna", rod = Ženský,
                            demonymMužský = "Bosniak", demonymŽenský = "Bosniačka", adjectival = "bosniansky")
  val Británia = PlaceName(entry = "Veľká Británia", rod = Ženský, demonymMužský = "Brit", adjectival = "britský")
  val ČiernaHora = PlaceName(entry = "Čierna Hora", rod = Ženský, demonymMužský = "Čiernohorec", adjectival = "čiernohorský")
  val Čína = PlaceName(entry = "Čína", rod = Ženský, demonymMužský = "Číňan", adjectival = "čínsky")
  val Európa = PlaceName(entry = "Európa", rod = Ženský, demonymMužský = "Európan", adjectival = "európsky")
  val Hercegovina = PlaceName(entry = "Hercegovina", rod = Ženský, demonymMužský = "Hercegovinec", adjectival = "hercegovský")
  val Kanada = PlaceName(entry = "Kanada ", rod = Ženský, demonymMužský = "Kanaďan", adjectival = "kanadský")
  val Litva = PlaceName(entry = "Litva", rod = Ženský, demonymMužský = "Litovčan", adjectival = "litovský")
  val Ukrajina = PlaceName(entry = "Ukrajina", rod = Ženský, demonymMužský = "Ukrajinec", adjectival = "ukrajinský")

  // Neuter place names
  val Albánsko = PlaceName(entry = "Albánsko", rod = Stredný, demonymMužský = "Albánec", adjectival = "albánsky")
  val Anglicko = PlaceName(entry = "Anglicko", rod = Stredný, demonymMužský = "Angličan", adjectival = "anglický")
  val Belgicko = PlaceName(entry = "Belgicko", rod = Stredný, demonymMužský = "Belgičan", adjectival = "belgický")
  val Bielorusko = PlaceName(entry = "Bielorusko", rod = Stredný, demonymMužský = "Bielorus", adjectival = "bieloruský")
  val Česko = PlaceName(entry = "Česko", rod = Stredný, demonymMužský = "Čech", demonymŽenský = "Češka", adjectival = "český")
  val Estónsko = PlaceName(entry = "Estónsko", rod = Stredný, demonymMužský = "Estónec", adjectival = "estónsky")
  val Fínsko = PlaceName(entry = "Fínsko", rod = Stredný, demonymMužský = "Fín", adjectival = "fínsky")
  val Francúzsko = PlaceName(entry = "Francúzsko", rod = Stredný, demonymMužský = "Francúz", adjectival = "francúzsky")
  val Grécko = PlaceName(entry = "Grécko", rod = Stredný,
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
  val Monako = PlaceName(entry = "Monako", rod = Stredný, demonymMužský = "Monačan", adjectival = "monakský")
  val Nemecko = PlaceName(entry = "Nemecko", rod = Stredný, demonymMužský = "Nemec", adjectival = "nemecký")
  val Nórsko = PlaceName(entry = "Nórsko", rod = Stredný, demonymMužský = "Nór", adjectival = "nórsky")
  val Poľsko = PlaceName(entry = "Poľsko", rod = Stredný,
                            demonymMužský = "Poliak", demonymŽenský = "Poľka", adjectival = "poľský")
  val Portugalsko = PlaceName(entry = "Portugalsko", rod = Stredný, demonymMužský = "Portugalec", adjectival = "portugalský")
  val Rakúsko = PlaceName(entry = "Rakúsko", rod = Stredný, demonymMužský = "Rakúšan", adjectival = "rakúsky")
  val Rumunsko = PlaceName(entry = "Rumunsko", rod = Stredný, demonymMužský = "Rumun", adjectival = "rumunský")
  val Rusko = PlaceName(entry = "Rusko", rod = Stredný, demonymMužský = "Rus", adjectival = "ruský")
  val Škótsko = PlaceName(entry = "Škótsko", rod = Stredný, demonymMužský = "Škót", adjectival = "škótsky")
  val Slovensko = PlaceName(entry = "Slovensko", rod = Stredný,
                            demonymMužský = "Slovák", demonymŽenský = "Slovenka", adjectival = "slovenský")
  val Slovinsko = PlaceName(entry = "Slovinsko", rod = Stredný, demonymMužský = "Slovinec", adjectival = "slovinský")
  val Španielsko = PlaceName(entry = "Španielsko", rod = Stredný, demonymMužský = "Španiel", adjectival = "španielsky")
  val Srbsko = PlaceName(entry = "Srbsko", rod = Stredný, demonymMužský = "Srb", adjectival = "srbský")
  val Švédsko = PlaceName(entry = "Švédsko", rod = Stredný, demonymMužský = "Švéd", adjectival = "švédsky")
  val Švajčiarsko = PlaceName(entry = "Švajčiarsko", rod = Stredný, demonymMužský = "Švajčiar", adjectival = "švajčiarsky")
  val Taliansko = PlaceName(entry = "Taliansko", rod = Stredný, demonymMužský = "Talian", adjectival = "taliansky")
  val Turecko = PlaceName(entry = "Turecko", rod = Stredný, adjectival = "turecký")

  val allKrajiny = List(Albánsko, Amerika, Anglicko, Belgicko, Bielorusko, Bosna, Británia, Česko, ČiernaHora, Čína, Estónsko, Fínsko, Francúzsko, Grécko, Hercegovina, Holandsko, Chorvátsko, Írsko, Japonsko, Kanada, Lichtenštajnsko, Litva, Lotyšsko, Luxembursko, Macedónsko, Maďarsko, Mexiko, Moldavsko, Monako, Nemecko, Nórsko, Poľsko, Portugalsko, Rakúsko, Rumunsko, Rusko, Škótsko, Slovensko, Slovinsko, Španielsko, Srbsko, Švajčiarsko, Švédsko, Taliansko, Turecko, Ukrajina, Vatikán)

  val allPlaces = allKrajiny :+ Európa

  /*
   * PrídavnéMeno
   */

  val Bohatý = PrídavnéMeno("bohatý")
  val Čistý = PrídavnéMeno("čistý")
  val Chorý = PrídavnéMeno("chorý")
  val Dobrý = PrídavnéMeno("dobrý")
//  val Ešte = PrídavnéMeno("ešte")
  val Hnedý = PrídavnéMeno("hnedý")
  val Hlavný = PrídavnéMeno("hlavny")
  val Hospodársky = PrídavnéMeno("hospodársky")
  val Iný = PrídavnéMeno("iný")
  // TODO jeden, jedna, jedno
  val Jednoduchý = PrídavnéMeno("jednoduchý")
  val Krázny = PrídavnéMeno("krázný")
  // TODO this is actually not an adjective but an interrogative pronoun
  val Ktorý = PrídavnéMeno("ktorý")
  val Malý = PrídavnéMeno("malý")
  val Mladý = PrídavnéMeno("mladý")
  val Modrý = PrídavnéMeno("modrý")
  // TODO this is not actually an adjective but an indefinite pronoun
  val Nejaký = PrídavnéMeno("nejaký")
  val Nízky = PrídavnéMeno("nízky")
  val Nový = PrídavnéMeno("nový")
  val Pekný = PrídavnéMeno("pekný")
  val Posledný = PrídavnéMeno("posledný")
  val Pravý = PrídavnéMeno("pravý")
  val Široký = PrídavnéMeno("široký")
  val Škaredý = PrídavnéMeno("škaredý")
  val Slobodný = PrídavnéMeno("slobodný")
  val Starý = PrídavnéMeno("starý")
  val Špinavý = PrídavnéMeno("špinavý")
  val Šťastný = PrídavnéMeno("šťastný")
  // This is not actually an adjective but a demonstrative pronoun
  val Taký = PrídavnéMeno("taký")
  val Ťažký = PrídavnéMeno("ťažký")
  val Veľký = PrídavnéMeno("veľký")
  val Vysoký = PrídavnéMeno("vysoký")
  val Zaujímavý = PrídavnéMeno("Zaujímavý")
  val Zelený = PrídavnéMeno("zelený")
  val Ženatý = PrídavnéMeno("Ženatý")
  val Zlý = PrídavnéMeno("zlý")
  val Známy = PrídavnéMeno("známy")

  /*
   * Sloveso
   * First argument is invifitive, second is third person singular present
   */

  // Type1 Verbs follow "chytať" - "chytám"

  val Bývať = Sloveso("bývať", "bývá")
  val Čakať = Sloveso("čakať", "čaká")
  val Čítať = Sloveso("čítať", "čítá")
  val Hľadať = Sloveso("hľadať", "hľadá")
  // apparently this is not really a word, but its negative is
  val Chávať = Sloveso("chávať", "chává")
  val Chodievať = Sloveso("chodievať", "chodievá")
  val Konať = Sloveso("konať", "koná")
  val Mať = Sloveso("mať", "má")
  val Pamätať = Sloveso("pamätať", "pamätá")
  val Počúvať = Sloveso("počúvať", "počúva")
  val Poznať = Sloveso("poznať", "pozná")
  val Prichádzať = Sloveso("prichádzať", "prichádzá")
  val Rozprávať = Sloveso("rozprávať", "rozprává")
  // nespavať appears in the Mistrík textbook
  val Spávať = Sloveso("spávať", "spáva")
  val Spievať = Sloveso("spievať", "spieva")
  val Strácať = Sloveso("strácať", "stráca")
  val Vstávať = Sloveso("vstávať", "vstává")
  val Vychádzať = Sloveso("vychádzať", "vychádzá")
  val Začinať = Sloveso("začinať", "začiná")
  val Žiadať = Sloveso("žiadať", "žiadá")
  val Znamenať = Sloveso("znamenať", "znamená")

  // Type 6 verbs follow "brať" - "beriem"
  val Brať = Sloveso("brať", "berie")

  // Type 11 verbs follow "pracuvať"
  val Potrebovať = Sloveso("potrebovať", "potrebuje")

  // Type 12 verbs follow "robiť"
  val Chodiť = Sloveso("chodiť", "chodí")
  val Obrátiť = Sloveso("obrátiť", "obrátí")
  val Robiť = Sloveso("robiť", "robí")

  // Type 13 verbs follow "vidieť" - "vidím"
  val Vidieť = Sloveso("vidieť", "vidí") // "to see"
  val Sedieť = Sloveso("sedieť", "sedí")

  // Type 13 verbs follow "kričať" - "kričím"
  val Kričať = Sloveso("kričať", "kričí")
  val Spať = Sloveso("spať", "spí")

  // Uncategorized verbs--whatever type they are, that type is probbaly untested
  val Hovoriť = Sloveso("hovoriť", "hovorí")


  // Irregular verb: to know
  val Vedieť = SlovesoFactory("vedieť", { (čislo: Čislo, osoba: Osoba, záporný: Boolean) =>
    (if (záporný) "ne" else "") +
    (čislo match {
      case Jednotné => osoba match {
        case First =>  "viem"
        case Second => "vieš"
        case Third =>  "vie"
      }
      case Množné => osoba match {
        case First =>  "vieme"
        case Second => "viete"
        case Third =>  "vedia"
      }
    })
  })

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
