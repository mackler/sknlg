package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._

  val nouns = Set[PodstatméMenoFactory](Kufor, Rieka, Auto)

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
      println("default without adjective: " + noun().asText())
      println("with specified adjective: " + noun(prídavnéMeno = Some(adjective)).asText())
    }


  }

  genderedAdjectives()

}
