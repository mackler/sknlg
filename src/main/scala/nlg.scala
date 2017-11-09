package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._
  import Rod._

  def conjugations(): Set[String] = {
    val pronouns = Set(Ja, Ty, On, Ona)
    val nouns = Set(Slovník.Kufor)
    val properNouns: Seq[Noun] = Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný))

    val subjects: Set[Seq[Noun]] =
      Čislo.values.flatMap { number =>
        pronouns flatMap { pronoun =>
          val proper: Set[Seq[Noun]] = Set(Seq[Noun](pronoun(number)))
          val pro: Set[Seq[Noun]] = if (number == Jednotné && (pronoun == Ja || pronoun == Ty))
                                      Set(Seq[Noun](pronoun(number), properNouns(1)))
                                    else Set.empty[Seq[Noun]]
          proper ++ pro
        }
      } ++ Set(Seq(properNouns(0)), Seq(properNouns(1)), properNouns)

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

  def genderedAdjectives() {
    val nouns = Set[PodstatméMenoFactory](Auto, Býk, Dieťa, Dievča, Dunaj, Hrad, Kaviareň, Kocúr, Krava, Kufor, Mača, Mačka, Mesto, Muž, Namestie, Rieka, Radosť, Srdce, Teľa, Učiteľ, Učiteľka, Voda, Žena)
  val adjectives = Seq(Čistý, Zlý, Dobrý, Hnedý, Krázny, Malý, Mladý, Modrý, Nový, Pekný, Škaredý, Špinavý, Starý, Veľký)

    for {
      noun <- nouns
      adjective <- adjectives
    } {
      println(noun(demonstrative = true, prídavnéMeno = Some(adjective)).asText())
    }


  }

  conjugations() foreach { line => println(line) }

}
