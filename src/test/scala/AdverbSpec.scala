package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class PríslovkaSpec extends FlatSpec with Matchers {

  "An adverb" should "modify an irregular verb" in {
    slovník.Byť(podmet = Seq(Ja()), príslovka = Some(Príslovka("tu"))).asText shouldEqual "ja som tu"
  }

  "An adverb" should "modify a regular intransitive verb" in {
    (slovník.Bývať setPodmet Seq(Ja()) setPríslovka Príslovka("tu") asText) shouldEqual "ja bývam tu"
  }

  "An adverb" should "modify a regular transitive verb" in {
    (slovník.Mať setPodmet Seq(Ja()) setPredmet slovník.Kufor() setPríslovka Príslovka("tu") asText) shouldEqual
    "ja mám tu kufor"
  }

}
