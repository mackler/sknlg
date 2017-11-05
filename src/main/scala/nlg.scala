package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._

  val nouns = Set[PodstatméMenoFactory](Auto, Býk, Dieťa, Dievča, Dunaj, Hrad, Kaviareň, Kocúr, Krava, Kufor, Mača, Mačka, Mesto, Muž, Namestie, Rieka, Radosť, Srdce, Teľa, Učiteľ, Učiteľka, Voda, Žena)

  def conjgations {
    val pronouns = Set(Ja, Ty, On, Ona, To)

    for {
      pronoun <- pronouns
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

  val adjectives = Seq(Čistý, Zlý, Dobrý, Hnedý, Krázny, Malý, Mladý, Modrý, Nový, Pekný, Škaredý, Špinavý, Starý, Veľký)

  def genderedAdjectives() {
    for {
      noun <- nouns
      adjective <- adjectives
    } {
//      println("default without adjective: " + noun().asText())
      println(noun(prídavnéMeno = Some(adjective)).asText())
    }


  }

  genderedAdjectives()

}
