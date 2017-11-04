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
    Vocabulary.Byť(subject = Seq(Ja(Singular))).asText shouldEqual "ja som"
  }

  "The Byť object with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    Vocabulary.Byť(subject = Seq(Ja(Plural))).asText shouldEqual "my sme"
  }

  "The Byť object with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    Vocabulary.Byť(subject = Seq(Ty(Singular))).asText shouldEqual "ty si"
  }

  "The Byť object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    Vocabulary.Byť(subject = Seq(Ty(Plural))).asText shouldEqual "vy ste"
  }

  "The Byť object with a 3nd/male/singular subject pronoun" should "return the third person male singular" in {
    Vocabulary.Byť(subject = Seq(On(Singular))).asText shouldEqual "on je"
  }

  "The Byť object with a 3rd/male/plural subject pronoun" should "return the third person male plural" in {
    Vocabulary.Byť(subject = Seq(On(Plural))).asText shouldEqual "oni sú"
  }

  "The Byť object with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    Vocabulary.Byť(subject = Seq(Ona(Singular))).asText shouldEqual "ona je"
  }

  "The Byť object with a 3rd/neutar/singular subject pronoun" should "return the third person neuter singular" in {
    Vocabulary.Byť(subject = Seq(To(Singular))).asText shouldEqual "to je"
  }

  "The Byť object with a 3rd/neuter/plural subject pronoun" should "return the third person neuter plural" in {
    Vocabulary.Byť(subject = Seq(To(Plural))).asText shouldEqual "oni sú"
  }


  // Mať is a regular verb

  "The Mať object without subject noun" should "generate the infinitive" in {
    Vocabulary.Mať().asText shouldEqual "mať"
  }
  "The mať object with a 1st/male/singular subject pronoun" should "return the first person singular" in {
    Vocabulary.Mať(subject = Seq(Ja(Singular))).asText shouldEqual "ja mám"
  }
  "The mať object with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    Vocabulary.Mať(subject = Seq(Ty(Singular))).asText shouldEqual "ty máš"
  }
  "The mať object with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    Vocabulary.Mať(subject = Seq(Ja(Plural))).asText shouldEqual "my máme"
  }
  "The mať object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    Vocabulary.Mať(subject = Seq(Ty(Plural))).asText shouldEqual "vy máte"
  }
  "The mať object with a 3rd/male/singular subject pronoun" should "return the third person male singular" in {
    Vocabulary.Mať(subject = Seq(On(Singular))).asText shouldEqual "on má"
  }
  "The mať object with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    Vocabulary.Mať(subject = Seq(Ona(Singular))).asText shouldEqual "ona má"
  }
  "The mať object with a 3rd/neuter/singular subject pronoun" should "return the third person neuter singular" in {
    Vocabulary.Mať(subject = Seq(To(Singular))).asText shouldEqual "to má"
  }
  "The mať object with a 3rd/neuter/plural subject pronoun" should "return the third person plural" in {
    Vocabulary.Mať(subject = Seq(To(Plural))).asText shouldEqual "oni majú"
  }

  // Transitive Verbs can have a direct object

  "The mať object 1st/sing with a direct object" should "return the correct text" in {
    Vocabulary.Mať(subject = Seq(Ja(Singular)), directObject = Some(Vocabulary.Auto())).asText shouldEqual "ja mám auto"
  }
  "The mať object 1st/plur with a direct object" should "return the correct text" in {
    Vocabulary.Mať(subject = Seq(Ja(Plural)), directObject = Some(Vocabulary.Auto())).asText shouldEqual "my máme auto"
  }

}
