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
    Slovník.Učiteľ(čislo = Množné).asText() shouldEqual "učiteli"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case singular" in {
    Slovník.Učiteľ().asText(pád = Akusatív) shouldEqual "učitela"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case plural" in {
    Slovník.Učiteľ(čislo = Množné).asText(pád = Akusatív) shouldEqual "učitelov"
  }

  "A masculine, inanimate noun ending in a soft consonant" should "decline in the accusative case singular" in {
    Slovník.Dunaj(čislo = Množné).asText(pád = Akusatív) shouldEqual "Dunaj"
  }

  "A feminine noun ending in soft consonant -a" should "decline in the nominative case singular" in {
    Slovník.Krava().asText() shouldEqual "krava"
  }

  "A feminine noun following dlaň" should "decline in the accusative case singular" in {
    Slovník.Radosť(čislo = Množné).asText(pád = Akusatív) shouldEqual "radosť"
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

  "A feminine noun following ulica" should "decline in the accusative case singular" in {
    Slovník.Ulica(čislo = Jednotné).asText(pád = Akusatív) shouldEqual "ulicu"
  }
  "A feminine noun following ulica" should "decline in the accusative case plural" in {
    Slovník.Ulica(čislo = Množné).asText(pád = Akusatív) shouldEqual "ulice"
  }



  /*
   * Pluralize Nouns in the Nominatív Case
   */
 
  "A masculine noun following dub" should "decline in the nominative plural" in {
    Slovník.Voz(čislo = Množné).asText() shouldEqual "vozy"
  }

  "A feminine noun following žena" should "decline in the nominative plural" in {
    Slovník.Stavba(čislo = Množné).asText() shouldEqual "stavby"
  }

  "A feminine noun following ulica" should "decline in the nominative plural" in {
    Slovník.Stanica(čislo = Množné).asText() shouldEqual "stanice"
  }

  "A feminine noun following kosť" should "decline in the nominative plural" in {
    Slovník.Vec(čislo = Množné).asText() shouldEqual "veci"
  }

  "A neuter noun following mesto" should "decline in the nominative plural" in {
    Slovník.Auto(čislo = Množné).asText() shouldEqual "autá"
  }

  // more declinations
  "A feminine noun following žena" should "decline in the accusative singular" in {
    Slovník.Stavba(čislo = Jednotné).asText(pád = Akusatív) shouldEqual "stavbu"
  }
  "A feminine noun following žena" should "decline in the accusative plural" in {
    Slovník.Stavba(čislo = Množné).asText(pád = Akusatív) shouldEqual "stavby"
  }

  "A masculine noun following chlap" should "decline in the nominative singular" in {
    Slovník.Muž(čislo = Jednotné).asText(pád = Nominatív) shouldEqual "muž"
  }
  "A masculine noun following chlap" should "decline in the nominative plural" in {
    Slovník.Muž(čislo = Množné).asText(pád = Nominatív) shouldEqual "muži"
  }
  "A masculine noun following chlap" should "decline in the accusative singular" in {
    Slovník.Muž(čislo = Jednotné).asText(pád = Akusatív) shouldEqual "muža"
  }
  "A masculine noun following chlap" should "decline in the accusative plural" in {
    Slovník.Muž(čislo = Množné).asText(pád = Akusatív) shouldEqual "mužov"
  }


  /*
   * Prepositions
   */
  val withPreposition = Slovník.Auto() predložka "cez"
  "A noun" should "take a preposition" in {
    withPreposition.asText() shouldEqual "cez auto"
  }
  // if a noun already has a preposition, we should be able to change it's number
  "A noun with a preposition" should "change its number" in {
    (withPreposition setČislo Množné).asText() shouldEqual "cez autá"
  }
  // a noun's preposition (or lack of) is accessible
  "A noun" should "return its preposition" in {
    withPreposition.predložka() shouldEqual Some("cez")
  }

}
