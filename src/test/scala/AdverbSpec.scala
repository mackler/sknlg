package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class PríslovkaSpec extends FlatSpec with Matchers {

  "An adverb" should "modify an irregular verb" in {
    Slovník.Byť(podmet = Seq(Ja()), príslovka = Some("tu")).asText shouldEqual "ja tu som"
  }

  "An adverb" should "modify a regular intransitive verb" in {
    (Slovník.Bývať setPodmet Seq(Ja()) setPríslovka "tu" asText) shouldEqual "ja tu bývam"
  }

  "An adverb" should "modify a regular transitive verb" in {
    (Slovník.Mať setPodmet Seq(Ja()) setPredmet Slovník.Kufor() setPríslovka "tu" asText) shouldEqual "ja tu mám kufor"
  }

}
