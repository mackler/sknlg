package org.mackler.sknlg

import Number._

object Main extends App {
  import Vocabulary._

  val nouns = Set[Noun](Kufor(), Auto())
  val pronouns = Set(Ja, Ty, On, Ona, To)

    for {
      pronoun <- pronouns
      number <- Number.values
    } {
      println( Byť(subject = Seq(pronoun(number))).asText )
      for {
        noun <- nouns
      } {
        println(Mať(subject = Seq(pronoun(number)), directObject = Some(noun)).asText)
      }
    }

}
