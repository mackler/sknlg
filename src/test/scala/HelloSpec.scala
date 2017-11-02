package org.mackler.sknlg

import Gender._
import Number._
import org.scalatest._

class VerbSpec extends FlatSpec with Matchers {
  "The Byť object without subject noun" should "generate the infinitive" in {
    Vocabulary.Byť().asText shouldEqual "byť"
  }

  "The Byť object with a subject pronoun" should "return the first person singular" in {
    Vocabulary.Byť().subject(Ja(Male, Singular)).asText shouldEqual "ja som"
  }

  "The Mať object without subject noun" should "generate the infinitive" in {
    Vocabulary.Mať.asText shouldEqual "mať"
  }

}
