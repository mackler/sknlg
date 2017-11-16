package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._
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
    val nouns = Set(Slovník.Kufor)

    val r =for {
      subject <- subjects
      negate <- Set(true, false)
    } yield {
      Set(Bývať(podmet = subject, príslovka = Some("tu"), záporný = negate).asText,
       Byť(podmet = subject, príslovka = Some("tu"), záporný = negate).asText,
       Čakať(podmet = subject, záporný = negate).asText) ++
      nouns.map{ noun => Mať(podmet = subject, directPredmet = Some(noun()), záporný = negate).asText }
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
    val verbs = Set(Hľadať() setPodmet Ja(),
                    Mať() setPodmet Ja(),
                    Poznať() setPodmet Ty(čislo = Množné),
                    Vidieť() setPodmet Ja(),
                    Obrátiť().setPodmet(Ty(čislo = Množné)),
                    Potrebovať().setPodmet(Ja()),
                    Mať().setPodmet(Ty(čislo = Jednotné)),
                    Mať().setPodmet(On(čislo = Množné)),
                    Mať().setPodmet(Ja(čislo = Množné)).toggleZáporný,
                    Mať().setPodmet(On()).toggleZáporný
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
      number <- Set(Jednotné, Množné)
    } yield {
      val modifiedNoun = noun() setČislo number setPrídavnéMeno adjective
      Set(
        Mať() setPodmet Ja() setPredmet modifiedNoun asText/*,
        Byť setPodmet modifiedNoun*/
      )
    }

    r.flatten
  }

  // we do singular and plural separately because there are some duplicate forms between them
  exM3Adjectives(Jednotné) foreach { line => println(line) }

}
