package org.mackler.sknlg

import Gender._
import Number._
import org.scalatest._

class VerbSpec extends FlatSpec with Matchers {

  // Byť is an irregular verb

  "The Byť object without subject noun" should "generate the infinitive" in {
    Vocabulary.Byť().asText shouldEqual "byť"
  }

  "The Byť object with a 1st/male/singular subject pronoun" should "return the first person singular" in {
    Vocabulary.Byť().subject(Ja(Singular)).asText shouldEqual "ja som"
  }

  "The Byť object with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    Vocabulary.Byť().subject(Ja(Plural)).asText shouldEqual "my sme"
  }

  "The Byť object with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    Vocabulary.Byť().subject(Ty(Singular)).asText shouldEqual "ty si"
  }

  "The Byť object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    Vocabulary.Byť().subject(Ty(Plural)).asText shouldEqual "vy ste"
  }

  "The Byť object with a 3nd/male/singular subject pronoun" should "return the third person male singular" in {
    Vocabulary.Byť().subject(On(Singular)).asText shouldEqual "on je"
  }

  "The Byť object with a 3rd/male/plural subject pronoun" should "return the third person male plural" in {
    Vocabulary.Byť().subject(On(Plural)).asText shouldEqual "oni sú"
  }

  "The Byť object with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    Vocabulary.Byť().subject(Ona(Singular)).asText shouldEqual "ona je"
  }

  "The Byť object with a 3rd/neutar/singular subject pronoun" should "return the third person neuter singular" in {
    Vocabulary.Byť().subject(To(Singular)).asText shouldEqual "to je"
  }

  "The Byť object with a 3rd/neuter/plural subject pronoun" should "return the third person neuter plural" in {
    Vocabulary.Byť().subject(To(Plural)).asText shouldEqual "oni sú"
  }


  // Mať is a regular verb

  "The Mať object without subject noun" should "generate the infinitive" in {
    Vocabulary.Mať.asText shouldEqual "mať"
  }

}
