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
    val nouns = Set[PodstatméMenoFactory](Auto, Býk, Dieťa, Dievča, Dunaj, Hrad, Kaviareň, Kocúr, Krava, Kufor, Mača, Mačka, Mesto, Muž, Namestie, Rieka, Radosť, Srdce, Teľa, Učiteľ, Učiteľka, Voda, Žena)
  val adjectives = Seq(Čistý, Zlý, Dobrý, Hnedý, Krázny, Malý, Mladý, Modrý, Nový, Pekný, Škaredý, Špinavý, Starý, Veľký)

    for {
      noun <- nouns
      adjective <- adjectives
    } {
      println(noun(demonstrative = true, prídavnéMeno = Some(adjective)).asText())
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
    } yield Byť(podmet = Seq(noun()), prísudok = Some(adjective)).asText

  }

  /* Exercise corresponding to Mistrík Chapter 3 - declining nouns: singular/plural, nominative/accusative */
  def exM3Nouns: Set[String] = {
    val nouns = Set(Auto, Breh, Cena, Dedina, Dom, Dvor, Hlava, Kniha, Kvet, Les, Lúka, Mesto, Minúta, Muž, Noha,
                    Obchod, Obraz, Otázka, Pán, Plot, Prst,
                    Rieka, Ruka, Škola, Stanica, Stavba, Stena, Strom, Trieda, Vec, Ulica, Večer, Voz, Záhrada)

    val singularNominative = nouns.map(noun => Byť(podmet = Seq(noun()), príslovka = Some("tu")).asText) 
    val pluralNominative = nouns.map(noun => Byť(podmet = Seq(noun(čislo = Množné)), príslovka = Some("tu")).asText)

    val verbs = Set(Hľadám)

    val accusative = for {
      verb <- verbs
      noun <- nouns
      number <- Set(Jednotné, Množné)
      subject <- subjects
    } yield verb( podmet = subject, directPredmet = Some(noun(čislo = number)) ).asText

    accusative
  }

  exM3Nouns foreach { line => println(line) }

}
