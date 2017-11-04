package org.mackler.sknlg

import Čislo._

object Main extends App {
  import Slovník._

  val nouns = Set[PodstatméMeno](Kufor(), Auto())
  val pronouns = Set(Ja, Ty, On, Ona, To)

    for {
      pronoun <- pronouns
      number <- Čislo.values
    } {
      println( Byť(podmet = Seq(pronoun(number))).asText )
      for {
        noun <- nouns
      } {
        println(Mať(podmet = Seq(pronoun(number)), directPredmet = Some(noun)).asText)
      }
    }

}
