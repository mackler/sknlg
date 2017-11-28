package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class PodstatméMenoSpec extends FlatSpec with Matchers {

  "A noun-object in a Set" should "allow companion class construction using default parameters" in {
    val set = Set(slovník.Kufor, slovník.Auto)
    for {
      noun <- set if noun.eq(slovník.Kufor)
    } {
      noun().asText() shouldEqual "kufor"
    }
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the nominative case singular" in {
    slovník.Učiteľ().asText() shouldEqual "učiteľ"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the nominative case plural" in {
    slovník.Učiteľ(čislo = Množné).asText() shouldEqual "učiteľi"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case singular" in {
    slovník.Učiteľ().asText(pád = Akusatív) shouldEqual "učiteľa"
  }

  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case plural" in {
    slovník.Učiteľ(čislo = Množné).asText(pád = Akusatív) shouldEqual "učiteľov"
  }

  "A masculine, inanimate noun ending in a soft consonant" should "decline in the accusative case singular" in {
    slovník.Dunaj(čislo = Množné).asText(pád = Akusatív) shouldEqual "Dunaj"
  }

  "A feminine noun ending in soft consonant -a" should "decline in the nominative case singular" in {
    slovník.Krava().asText() shouldEqual "krava"
  }

  "A feminine noun following dlaň" should "decline in the accusative case plural" in {
    slovník.Radosť(čislo = Množné).asText(pád = Akusatív) shouldEqual "radosť"
  }

  "A neuter noun ending in '-e'" should "decline in the nominative case singular" in {
    slovník.Srdce().asText() shouldEqual "srdce"
  }

  "A neuter noun ending in '-ie'" should "decline in the nominative case singular" in {
    slovník.Namestie().asText() shouldEqual "namestie"
  }

  "A neuter noun ending in '-a'" should "decline in the nominative case singular" in {
    slovník.Mača().asText() shouldEqual "mača"
  }

  "A proper noun" should "be usable as a verb subject" in {
    slovník.Byť(podmet = Seq(Pomenovanie("Igor", MužskýŽivotný))).asText shouldEqual "Igor je"
  }

  /*
   * Feminine Nouns
   */
  // Following ULICA
  // Singular
  "A feminine noun following ulica" should "decline in the nominative singular" in {
    slovník.Stanica().asText(pád = Nominatív) shouldEqual "stanica"
  }
  "A feminine noun following ulica" should "decline in the genitive singular" in {
    slovník.Stanica().asText(pád = Genitív) shouldEqual "stanice"
  }
  "A feminine noun following ulica" should "decline in the accusative case singular" in {
    slovník.Ulica().asText(pád = Akusatív) shouldEqual "ulicu"
  }
  // Plural
  "A feminine noun following ulica" should "decline in the nominative plural" in {
    slovník.Stanica(čislo = Množné).asText() shouldEqual "stanice"
  }
  "A feminine noun following ulica" should "decline in the genitive case plural" in {
    slovník.Ulica(čislo = Množné).asText(pád = Genitív) shouldEqual "ulic"
  }
  "A feminine noun following ulica" should "decline in the accusative case plural" in {
    slovník.Ulica(čislo = Množné).asText(pád = Akusatív) shouldEqual "ulice"
  }

  /*
   * Pluralize Nouns in the Nominatív Case
   */
 
  "A masculine noun following dub" should "decline in the nominative plural" in {
    slovník.Voz(čislo = Množné).asText() shouldEqual "vozy"
  }

  "A feminine noun following žena" should "decline in the nominative plural" in {
    slovník.Stavba(čislo = Množné).asText() shouldEqual "stavby"
  }


  "A feminine noun following kosť" should "decline in the nominative plural" in {
    slovník.Vec(čislo = Množné).asText() shouldEqual "veci"
  }

  "A neuter noun following mesto" should "decline in the nominative plural" in {
    slovník.Auto(čislo = Množné).asText() shouldEqual "autá"
  }

  // more declinations
  "A feminine noun following žena" should "decline in the accusative singular" in {
    slovník.Stavba(čislo = Jednotné).asText(pád = Akusatív) shouldEqual "stavbu"
  }
  "A feminine noun following žena" should "decline in the accusative plural" in {
    slovník.Stavba(čislo = Množné).asText(pád = Akusatív) shouldEqual "stavby"
  }

  "A masculine noun following chlap" should "decline in the nominative singular" in {
    slovník.Muž(čislo = Jednotné).asText(pád = Nominatív) shouldEqual "muž"
  }
  "A masculine noun following chlap" should "decline in the nominative plural" in {
    slovník.Muž(čislo = Množné).asText(pád = Nominatív) shouldEqual "muži"
  }
  "A masculine noun following chlap" should "decline in the accusative singular" in {
    slovník.Muž(čislo = Jednotné).asText(pád = Akusatív) shouldEqual "muža"
  }
  "A masculine noun following chlap" should "decline in the accusative plural" in {
    slovník.Muž(čislo = Množné).asText(pád = Akusatív) shouldEqual "mužov"
  }


  // whatever...
  "A feminine noun following žena" should "decline in the genitive singular" in {
    slovník.Žena().asText(pád = Genitív) shouldEqual "ženy"
  }
  "A neuter noun following mesto" should "decline in the genitive singular" in {
    slovník.Mesto().asText(pád = Genitív) shouldEqual "mesta"
  }

  /*
   * Prepositions
   */

// I've changed my mind about "cez" since I wrote these tests.
// I now think "ísť cez" is the verb that takes a direct object, ie, the
// preposition goes with the verb, not with the noun as these tests imply.
/*  val withPreposition = slovník.Auto() predložka "cez"
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
  }*/

  /*
   * Noun Phrases can be nouns, pronouns, adjectives, determinatives, etc.
   * Some may have the gender fixed, such as a common noun.  Some can have their
   * gender set, such as adjectives
   */
  "A common noun" should "provide its gender" in {
    slovník.Muž().rod shouldEqual MužskýŽivotný
  }

}

