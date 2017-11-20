package org.mackler.sknlg

import Čislo._

object Main extends App {
  import slovník._
  import Rod._

  /* Combinations of sentence subjects, both singular and plural, proper names and pronouns. */
  val subjects: Set[Seq[Noun]] = {
    val pronouns = Set(Ja, Ty, On, Ona)
    val properNouns: Seq[Noun] = Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný))

      Čislo.values.flatMap { number =>
        pronouns flatMap { pronoun =>
          val proper: Set[Seq[Noun]] = Set(Seq[Noun](pronoun(number)))
          val pro: Set[Seq[Noun]] = if (number == Jednotné && (pronoun == Ja || pronoun == Ty))
                                      Set(Seq[Noun](pronoun(number), properNouns(1)))
                                    else Set.empty[Seq[Noun]]
          proper ++ pro
        }
      } ++ Set(Seq(properNouns(0)), Seq(properNouns(1)), properNouns)
  }

  /* Exercises corresponding to Naughton Unit 1 Verb Conjugation and negation */
  def exN1ATypeVerbs(): Set[String] = {
    val nouns = Set(Kufor)

    val r =for {
      subject <- subjects
      negate <- Set(true, false)
    } yield {
      Set(Bývať setPodmet subject setPríslovka "tu" setZáporný negate asText,
       Byť(podmet = subject, príslovka = Some("tu"), záporný = negate).asText,
       Čakať setPodmet subject setZáporný negate asText) ++
      nouns.map{ noun => Mať setPodmet subject setPredmet noun() setZáporný negate asText }
    }

    r.flatten
  }

  /* Exercises corresponding to Naughton Unit 1 Adjectives */
  def exN1AGendersAdjective() {
    val nouns = Set[PodstatnéMenoFactory](Auto, Býk, Dieťa, Dievča, Dunaj, Hrad, Kaviareň, Kocúr, Krava, Kufor, Mača, Mačka, Mesto, Muž, Namestie, Rieka, Radosť, Srdce, Teľa, Učiteľ, Učiteľka, Voda, Žena)
  val adjectives = Seq(Čistý, Zlý, Dobrý, Hnedý, Krázny, Malý, Mladý, Modrý, Nový, Pekný, Škaredý, Špinavý, Starý, Veľký)

    for {
      noun <- nouns
      adjective <- adjectives
    } {
// change demonstrative to determiner
//      println(noun(demonstrative = true, prídavnéMeno = Some(adjective)).asText())
    }


  }

  /* Exercise corresponding to Mistrík Chapter 2 - adjective, noun gender */
  def exM2Adjectives: Set[String] = {
    val nouns = Set(Čelo, Dedina, Deň, Dieťa, Dlaň, Dom, Hlava, Chlapec, Kniha, Kôň, Les, Lúka, Mesto, Mlieko, Muž, Noha, Obraz, Oko, Pani, Pán,
                    Prst, Rameno, Ráno, Ruka, Sklo, Stena, Strom, Škola, Trieda, Tvár, Ulica, Večer, Voda, Záhrada)
    val adjectives = Set(Čistý, Dobrý, Malý, Nový, Pekný, Veľký, Vysoký, Zelený, Zlý)

    for {
      noun <- nouns
      adjective <- adjectives
    } yield Byť(podmet = Seq(noun()), complement = Some(adjective)).asText

  }

  /* Exercises corresponding to Mistrík Chapter 3 - declining nouns: singular/plural, nominative/accusative */
  val exM3Nouns = Set(Auto, Breh, Cena, Dedina, Dom, Dvor, Hlava, Kniha, Kvet, Les, Lúka, Mesto, Minúta, Muž, Noha,
    Obchod, Obraz, Otázka, Pán, Plot, Prst,
    Rieka, Ruka, Škola, Stanica, Stavba, Stena, Strom, Trieda, Vec, Ulica, Večer, Voz, Záhrada)
  def exM3Plural: Set[String] = {
    val singularNominative = exM3Nouns.map(noun => Byť(podmet = Seq(noun()), príslovka = Some("tu")).asText) 
    val pluralNominative = exM3Nouns.map(noun => Byť(podmet = Seq(noun(čislo = Množné)), príslovka = Some("tu")).asText)
    singularNominative ++ pluralNominative
  }
  def exM3Accusative: Set[String] = {
    val verbs = Set(/*Hľadať addPodmet Ja(),
                    Mať addPodmet Ja(),
                    Poznať addPodmet Ty(čislo = Množné),
                    Vidieť addPodmet Ja(),
                    Obrátiť.addPodmet(Ty(čislo = Množné)),
                    Potrebovať.addPodmet(Ja()),
                    Mať.addPodmet(Ty(čislo = Jednotné)),
                    Mať.addPodmet(On(čislo = Množné)),
                    Mať.addPodmet(Ja(čislo = Množné)).toggleZáporný,
                    Mať.addPodmet(On()).toggleZáporný*/
                    Ísť.setPredložka("cez").addPodmet(Ty(čislo = Množné))
    )

    val accusative: Set[String] = for {
      verb <- verbs
      noun <- exM3Nouns
      number <- Set(Jednotné, Množné)
      subject <- subjects
    } yield {
      val directObject = noun() setČislo number
      verb setPredmet directObject asText
    }
    accusative
  }

  def exM3Adjectives(number: Čislo): Set[String] = {
    val adjectives = Set(Dobrý, Hlavný, Jednoduchý, Ktorý, Nejaký, Nízky, Nový, Posledný, Pekný, Pravý, Široký, Taký, Vysoký)

    val r = for {
      adjective <- adjectives
      noun <- exM3Nouns
    } yield {
      val modifiedNoun = noun() setČislo number setPrídavnéMeno adjective
      Set(
        Mať addPodmet Ja() setPredmet modifiedNoun asText,
        Byť() addPodmet Príslovka("tu") setComplement modifiedNoun asText
      )
    }

    r.flatten
  }

  /* Some words from Krížom Krážom */
  val KK1nouns = Set(Manžel, Manželka, Izba, Spolubývajúci, Spolubývajúca)
  val KK1adjectives = Set(Slobodný, Ženatý, Zaujímavý )

  /* Exercise corresponding to Mistrík chapter 4 */
/*  def exM4: Set[String] = {
    val verbs = Set(Vstávať, Mať, Byť, Bývať, Začinať, Poznať, Chodievať, Žiadať, konať, znamenať, Nevychaádzať,
                 Nechávať, Nerozprávať, Prichádzať, Nespávať, Pamätať)
    val nouns = Set(Večer, Vlak, Učiteľ, Poriadok, Práca, Auto, Obraz, Čislo)
    val adjectives = Set(Voľný, Čistý, Dobrý, Nový, Veľký, Nejaký, Vlastný, Iný)
    Set.empty[String]
  }*/

  // we do singular and plural separately because there are some duplicate forms between them
  exM3Accusative foreach { line => println(line) }

}
