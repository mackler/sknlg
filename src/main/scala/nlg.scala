package org.mackler.sknlg

import Čislo._

object Main extends App {
  import slovník._
  import Rod._

  /**
    *  Combinations of sentence subjects, both singular and plural, proper names and pronouns.
    */
  val subjects: Set[Seq[Noun]] = {
    val pronouns = Set(Ja, Ty, On, Ona)
    val properNouns: Seq[Noun] = Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný))

      Čislo.values.flatMap { number =>
        pronouns flatMap { pronoun =>
          val proper: Set[Seq[Noun]] = Set(Seq[Noun](pronoun(number)))
          val pro: Set[Seq[Noun]] = if (number == Jednotné && (pronoun == Ja || pronoun == Ty))
                                      Set(Seq[Noun](properNouns(1), pronoun(number)))
                                    else Set.empty[Seq[Noun]]
          proper ++ pro
        }
      } ++ Set(Seq(properNouns(0)), Seq(properNouns(1)), properNouns)
  }

  /**
    * Like the above, but a function that takes a set of nouns and returns a set of subjects that includes the
    * first and second person, and excludes proper names.
    */
  def subjectNouns(nouns: Set[PodstatnéMeno]): Set[Seq[Noun]] = {
    val nounCombos = for {
      noun1 <- nouns
      noun2 <- nouns if noun2 != noun1
    } yield Seq(noun1, noun2)

    nouns.map(Seq(_)) ++ nouns.map(n => Seq(n setČislo Množné)) ++ nouns.map(Seq(_, Ja())) ++ nouns.map(Seq(Ty(), _))
  }

  /*
   * Takes a set of nouns and a set of verbs.  Use all the nouns as subjects with all the verbs.
   */
  def nominativeNounsVerbs(verbs: Set[Sloveso], nouns: Set[PodstatnéMeno]): Set[String] = {
    val s = subjectNouns(nouns)

    for {
      subject <- s
      verb <- verbs
      negate <- Set(true, false)
    } yield verb setPodmet subject setZáporný negate asText
  }

  /**
    * Takes a set of nouns, a set of adjectives, and joins them with the verb for "to be".
    */
  def nominativeNounsAdjectives(nouns: Set[PodstatnéMeno], adjectives: Set[PrídavnéMeno]): Set[String] =
    for {
      noun <- nouns
      adjective <- adjectives
    } yield Byť addPodmet noun setComplement adjective asText

  /**
    * Take a set of nouns, make each into a sentence saying that it is or they are here.
    */
  def nounsSingularPluralNominative(nouns: Set[PodstatnéMeno]): Set[String] = {
    val singularNominative =
      exM3Nouns.map(noun => Byť addPodmet noun setPríslovka Príslovka("tu") asText)
    val pluralNominative =
      exM3Nouns.map(noun => Byť addPodmet (noun setČislo Množné) setPríslovka Príslovka("tu") asText)
    singularNominative ++ pluralNominative
  }

  /**
    * Takes a set of verbs and a set of nouns and generates all combinations of them with all subjects using
    * the nouns as direct objects, both singular and plural.
    */
  def accusativeSingularPlural(verbs: Set[RegularSloveso], nouns: Set[PodstatnéMeno]): Set[String] = {
    for {
      verb <- verbs
      noun <- nouns
      number <- Set(Jednotné, Množné)
      subject <- subjects
    } yield { verb setPredmet (noun setČislo number) asText }
  }

  /**
    * Takes a set of nouns and a set of adjectives. Returns phrases with the adjective-modified nouns in
    * both nominative (using "to be") and accusative (using "I have") cases, singular and plural numbers.
    */
  def nounsAdjectivesNominativeAccusativeSingularPlural(nouns: Set[PodstatnéMeno], adjectives: Set[PrídavnéMeno]): Set[String] = {
    val r = for {
      adjective <- adjectives
      noun <- nouns
      number <- Set(Jednotné, Množné)
    } yield {
      val modifiedNoun = noun setČislo number setPrídavnéMeno adjective
      Set(
        Mať addPodmet Ja() setPredmet modifiedNoun asText,
        Byť addPodmet Príslovka("tu") setComplement modifiedNoun asText
      )
    }

    r.flatten
  }

  /**
    * Takes a set of verbs.  Returns combinations of subjects with the verbs, negated and not negated.
    */
  def verbsNegated(verbs: Set[Sloveso]): Set[String] =
    for {
      negate <- Set(true,false)
      subject <- subjects
      verb <- verbs if verb.infinitív != "chávať"
    } yield verb setPodmet subject setZáporný negate asText


  /*
   * Take a set of nouns. Return a phrase of each in the locative cases, both singular and plural,
   * using the prepositions for both "in" and "near."
   */
  def locative(nouns: Set[PodstatnéMeno], adjectives: Set[PrídavnéMeno]): Set[String] = {
    for {
      noun <- nouns
      subject <- subjects
      number <- Set(Jednotné, Množné)
      preposition <- Set("vo", "pri")
    } yield
      Byť setPodmet subject setComplement (noun setČislo number predložka preposition) asText
  }

  // END OF GENERIC FUNCTIONS -- BEGIN SPECIFIC EXERCISES


  /* Exercise corresponding to Mistrík Chapter 2 - adjective, noun gender */
  def exM2Adjectives: Set[String] = {
    val nouns = Set[PodstatnéMeno](Čelo, Dedina, Deň, Dieťa, Dlaň, Dom, Hlava, Chlapec, Kniha, Kôň, Les, Lúka, Mesto, Mlieko, Muž, Noha, Obraz, Oko, Pani, Pán,
                    Prst, Rameno, Ráno, Ruka, Sklo, Stena, Strom, Škola, Trieda, Tvár, Ulica, Večer, Voda, Záhrada)
    val adjectives = Set[PrídavnéMeno](Čistý, Dobrý, Malý, Nový, Pekný, Veľký, Vysoký, Zelený, Zlý)

    nominativeNounsAdjectives(nouns, adjectives)
  }

  /* Exercises corresponding to Mistrík Chapter 3 - declining nouns: singular/plural, nominative/accusative */
  val exM3Nouns: Set[PodstatnéMeno] = Set(Auto, Breh, Cena, Dedina, Dom, Dvor, Hlava, Kniha, Kvet, Les, Lúka, Mesto, Minúta, Muž, Noha,
    Obchod, Obraz, Otázka, Pán, Plot, Prst,
    Rieka, Ruka, Škola, Stanica, Stavba, Stena, Strom, Trieda, Vec, Ulica, Večer, Voz, Záhrada)

  def exM3Plural: Set[String] = nounsSingularPluralNominative(exM3Nouns)

  // this is a customized version of the accusativeSingularPlural method above to limit the number of generated phrases.
  // It only uses certain subject/verb combinations
  def exM3Accusative: Set[String] = {
    val verbs = Set(Hľadať addPodmet Ja(),
                    Mať addPodmet Ja(),
                    Poznať addPodmet Ty(čislo = Množné),
                    Vidieť addPodmet Ja(),
                    Obrátiť.addPodmet(Ty(čislo = Množné)),
                    Potrebovať.addPodmet(Ja()),
                    Mať.addPodmet(Ty(čislo = Jednotné)),
                    Mať.addPodmet(On(čislo = Množné)),
                    Mať.addPodmet(Ja(čislo = Množné)).toggleZáporný,
                    Mať.addPodmet(On()).toggleZáporný,
                    Ísť.setPredložka("cez").addPodmet(Ty(čislo = Množné))
    )

    val accusative: Set[String] = for {
      verb <- verbs
      noun <- exM3Nouns
      number <- Set(Jednotné, Množné)
      subject <- subjects
    } yield {
      val directObject = noun setČislo number
      verb setPredmet directObject asText
    }
    accusative
  }

  def exM3Adjectives(number: Čislo): Set[String] = {
    val adjectives = Set[PrídavnéMeno](Dobrý, Hlavný, Jednoduchý, Ktorý, Nejaký, Nízky, Nový, Posledný, Pekný, Pravý, Široký, Taký, Vysoký)
    nounsAdjectivesNominativeAccusativeSingularPlural(exM3Nouns, adjectives)
  }

  /* Some words from Krížom Krážom */
  val KK1nouns = Set(Manžel, Manželka, Izba, Spolubývajúci, Spolubývajúca)
  val KK1adjectives = Set(Slobodný, Ženatý, Zaujímavý )

  /* Some exercises corresponding to Mistrík chapter 4 */
  def exM4: Set[String] = {
    val verbs = Set[Sloveso](Vstávať, Mať, Byť, Bývať, Začinať, Poznať, Chodievať, Žiadať, Konať, Znamenať, Vychádzať,
                 Chávať, Rozprávať, Prichádzať, Spať, Pamätať)
    verbsNegated(verbs)
  }

  /* Countries, places, languages */
  def exPlaces: Set[String] = {
    val vlado = Pomenovanie("Vladimir", MužskýŽivotný)
    val natália = Pomenovanie("Natália", Ženský)

    val places = for {
      place <- List(Kanada) //allPlaces
    } yield Set (
      Byť addPodmet place setComplement Pekný asText,
      Vidieť addPodmet Ja() setPredmet place asText,
      Byť addPodmet vlado setComplement place.asOrigin asText
    )

    val demonyms = for {
      place <- List(Kanada) //allPlaces if place.demonym.isDefined
      demonym <- place.demonym
    } yield Set(
      Byť addPodmet vlado setComplement place.demonym.get asText,
      Byť addPodmet natália setComplement place.demonym.get asText,
      Byť addPodmet Pomenovanie("Jakub", MužskýŽivotný) addPodmet vlado
        setComplement place.demonym.get asText,
      Byť addPodmet Pomenovanie("Sofia", Ženský) addPodmet natália
        setComplement place.demonym.get asText
    )

    val languages = for {
      country <- List(Kanada) //allKrajiny
    } yield Set(
      Vedieť addPodmet vlado setPríslovka country.asPríslovka asText,
      Čítať addPodmet vlado setPríslovka country.asPríslovka asText,
      Hovoriť addPodmet vlado setPríslovka country.asPríslovka asText,
      Mať addPodmet Ja() setPredmet (Auto setPrídavnéMeno country.adjectival) asText,
      Mať addPodmet Ja() setPredmet (Kniha setPrídavnéMeno country.adjectival) asText,
      Mať addPodmet Ja() setPredmet (Obchod setPrídavnéMeno country.adjectival) asText
    )

    (places ++ demonyms ++ languages).flatten.toSet
  }

  /* Mistrík chapter 5 */
  val exM5nouns = Set(Chlap, Družstvo, Jar, Jeseň, Leto, Matka, Mesto, Otec, Práca, Priateľ, Rodina, Škola, Ulica, Zima, Žena)
  val exM5Verbs = Set[Sloveso](Bývať, Chodiť, Kričať, Počúvať, Pamätať, Poznať, Prichádzať, Robiť, Rozprávať, Sedieť, Spávať,
                               Spievať, Strácať, Vedieť, Vidieť, Začinať, Žiadať, Znamenať)
  def exM5locative: Set[String] = {
    val adjectives = Set[PrídavnéMeno](Bohatý, Chorý, Dobrý, Hlavný, Iný, Nový, Pekný, Posledný, Šťastný, Veľký, Vysoký, Starý, Ťažká, Známy)

    locative(exM5nouns, adjectives)
  }

  def exM5verbsNouns: Set[String] = {
    nominativeNounsVerbs(/*exM5Verbs*/ Set(Spávať), exM5nouns)
  }

  exM5verbsNouns foreach { line => println(line) }

}
