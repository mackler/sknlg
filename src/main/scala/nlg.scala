package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._
  import Rod._

  def conjugations() {
    val pronouns = Set(Ja, Ty)
    val nouns = Set(Slovník.Kufor)
    val properNouns = Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný))

    for {
      pronoun <- pronouns
      number <- Čislo.values
    } {
      val subjects: Set[Seq[Noun]] =
        Set(Seq[Noun](pronoun(number))) ++
        Set(if (number == Jednotné) Seq[Noun](pronoun(number), properNouns(1)) else Seq.empty[Noun])
      for {
        subject <- subjects
      } {
        println( Byť(podmet = subject).asText )
      }

      for {
        noun <- nouns
      } {
        println(Mať(podmet = Seq(pronoun(number)), directPredmet = Some(noun())).asText)
      }
    }
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

  conjugations()

}
