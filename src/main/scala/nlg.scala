package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._

  def conjugations() {
    val subjects = Set(Ja, Ty)
    val nouns = Set(Slovník.Kufor)

    for {
      pronoun <- subjects
      number <- Čislo.values
    } {
      println( Byť(podmet = Seq(pronoun(number))).asText )
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
