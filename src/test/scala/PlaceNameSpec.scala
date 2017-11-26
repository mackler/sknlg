package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import slovník._

import org.scalatest._


class PlaceNameSpec extends FlatSpec with Matchers {

  "A country name" should "have a gender" in {
    (Byť() addPodmet Británia() setComplement Pekný asText) shouldEqual "Británia je pekná"
  }
  "A masculine proper name" should "be complemented by a demonym" in {
    (Byť() addPodmet Pomenovanie("Peter", MužskýŽivotný) setComplement Slovensko.demonym asText) shouldEqual
    "Peter je Slovák"
  }
  "A feminine proper name" should "be complemented by a demonym" in {
    (Byť() addPodmet Pomenovanie("Maria", Ženský) setComplement Slovensko.demonym asText) shouldEqual
    "Maria je Slovenka"
  }
  "A masculine noun" should "be complemented by a geographic adjective" in {
    (Byť() addPodmet Hrad() setComplement Slovensko.adjectival asText) shouldEqual
    "hrad je slovenský"
  }
  "A feminine noun" should "be complemented by a geographic adjective" in {
    (Byť() addPodmet Kniha() setComplement Slovensko.adjectival asText) shouldEqual
    "kniha je slovenská"
  }
  "A neuter noun" should "be complemented by a geographic adjective" in {
    (Byť() addPodmet Sklo() setComplement Slovensko.adjectival asText) shouldEqual
    "sklo je slovenské"
  }

}

