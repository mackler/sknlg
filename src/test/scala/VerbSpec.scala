package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class VerbSpec extends FlatSpec with Matchers {

  // Byť is an irregular verb

  "The Byť object without podmet noun" should "generate the infinitive" in {
    Slovník.Byť().asText shouldEqual "byť"
  }

  "The Byť object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Byť(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja som"
  }

  "The Byť object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Byť(podmet = Seq(Ja(Množné))).asText shouldEqual "my sme"
  }

  "The Byť object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Byť(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty si"
  }

  "The Byť object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Byť(podmet = Seq(Ty(Množné))).asText shouldEqual "vy ste"
  }

  "The Byť object with a 3nd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Byť(podmet = Seq(On(Jednotné))).asText shouldEqual "on je"
  }

  "The Byť object with a 3rd/male/plural podmet pronoun" should "return the third person male plural" in {
    Slovník.Byť(podmet = Seq(On(Množné))).asText shouldEqual "oni sú"
  }

  "The Byť object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Byť(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona je"
  }

  "The Byť object with a 3rd/neutar/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Byť(podmet = Seq(To(Jednotné))).asText shouldEqual "to je"
  }

  "The Byť object with a 3rd/neuter/plural podmet pronoun" should "return the third person neuter plural" in {
    Slovník.Byť(podmet = Seq(To(Množné))).asText shouldEqual "oni sú"
  }

  // Mať is a regular verb

  "The Mať object without podmet noun" should "generate the infinitive" in {
    Slovník.Mať().asText shouldEqual "mať"
  }
  "The Mať object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Mať(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja mám"
  }
  "The Mať object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Mať(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty máš"
  }
  "The Mať object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Mať(podmet = Seq(Ja(Množné))).asText shouldEqual "my máme"
  }
  "The Mať object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Mať(podmet = Seq(Ty(Množné))).asText shouldEqual "vy máte"
  }
  "The Mať object with a 3rd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Mať(podmet = Seq(On(Jednotné))).asText shouldEqual "on má"
  }
  "The Mať object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Mať(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona má"
  }
  "The Mať object with a 3rd/neuter/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Mať(podmet = Seq(To(Jednotné))).asText shouldEqual "to má"
  }
  "The Mať object with a 3rd/neuter/plural podmet pronoun" should "return the third person plural" in {
    Slovník.Mať(podmet = Seq(To(Množné))).asText shouldEqual "oni majú"
  }

  // Transitive Verbs can have a direct object

  "The Mať object 1st/sing with a direct object" should "return the correct text" in {
    Slovník.Mať(podmet = Seq(Ja(Jednotné)), directPredmet = Some(Slovník.Auto())).asText shouldEqual "ja mám auto"
  }
  "The Mať object 1st/plur with a direct object" should "return the correct text" in {
    Slovník.Mať(podmet = Seq(Ja(Množné)), directPredmet = Some(Slovník.Auto())).asText shouldEqual "my máme auto"
  }

  // Verbs with a long vowel in the final syllable of their root have short vowels in their inflections
  "The Bývať object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Bývať(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja bývam"
  }
  "The Bývať object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Bývať(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty bývaš"
  }
  "The Bývať object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Bývať(podmet = Seq(Ja(Množné))).asText shouldEqual "my bývame"
  }
  "The Bývať object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Bývať(podmet = Seq(Ty(Množné))).asText shouldEqual "vy bývate"
  }
  "The Bývať object with a 3rd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Bývať(podmet = Seq(On(Jednotné))).asText shouldEqual "on býva"
  }
  "The Bývať object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Bývať(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona býva"
  }
  "The Bývať object with a 3rd/neuter/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Bývať(podmet = Seq(To(Jednotné))).asText shouldEqual "to býva"
  }
  "The Bývať object with a 3rd/neuter/plural podmet pronoun" should "return the third person plural" in {
    Slovník.Bývať(podmet = Seq(To(Množné))).asText shouldEqual "oni bývajú"
  }

}
