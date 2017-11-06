package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class PodstatméMenoSpec extends FlatSpec with Matchers {

  "A noun-object in a Set" should "allow companion class construction using default parameters" in {
    val set = Set(Slovník.Kufor, Slovník.Auto)
    for {
      noun <- set if noun.eq(Slovník.Kufor)
    } {
      noun().asText() shouldEqual "kufor"
    }
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the nominative case singular" in {
    Slovník.Učiteľ().asText() shouldEqual "učitel"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the nominative case plural" in {
    Slovník.Učiteľ(čislo = Množné).asText() shouldEqual "učitel"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case singular" in {
    Slovník.Učiteľ().asText(pád = Accusative) shouldEqual "učitel"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case plural" in {
    Slovník.Učiteľ(čislo = Množné).asText(pád = Accusative) shouldEqual "učitel"
  }

  "A masculine, inanimate noun ending in a soft consonant" should "decline in the accusative case singular" in {
    Slovník.Dunaj(čislo = Množné).asText(pád = Accusative) shouldEqual "Dunaj"
  }

  "A feminine noun ending in soft consonant -a" should "decline in the nominative case singular" in {
    Slovník.Krava().asText() shouldEqual "krava"
  }

  "A feminine noun following dlaň" should "decline in the accusative case singular" in {
    Slovník.Radosť(čislo = Množné).asText(pád = Accusative) shouldEqual "radosť"
  }

  "A neuter noun ending in '-e'" should "decline in the nominative case singular" in {
    Slovník.Srdce().asText() shouldEqual "srdce"
  }

  "A neuter noun ending in '-ie'" should "decline in the nominative case singular" in {
    Slovník.Namestie().asText() shouldEqual "namestie"
  }

  "A neuter noun ending in '-a'" should "decline in the nominative case singular" in {
    Slovník.Mača().asText() shouldEqual "mača"
  }

  "A proper noun" should "be usable as a verb subject" in {
    Slovník.Byť(podmet = Seq(Pomenovanie("Igor", MužskýŽivotný))).asText shouldEqual "Igor je"
  }

}
