package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class PodstatméMenoSpec extends FlatSpec with Matchers {

  // first test the meta-aspects of nouns: the equals method

  "Two different nouns" should "not equal each other" in {
    PodstatnéMeno("muž", MužskýNeživotný) == PodstatnéMeno("žena", Ženský) shouldEqual false
  }

  "Two instances of the same noun with different numberns" should "not equal each other" in {
    slovník.Muž should not equal slovník.Muž.setČislo(Množné)
  }

  "Two different nouns" should "have different hash codes" in {
    PodstatnéMeno("muž", MužskýNeživotný).hashCode should not equal PodstatnéMeno("Žena", Ženský).hashCode
  }

  "Two equivalent nouns" should "have the same hash code" in {
    PodstatnéMeno("muž", MužskýNeživotný).hashCode shouldEqual PodstatnéMeno("muž", Ženský).hashCode
  }

  "A noun-object in a Set" should "allow companion class construction using default parameters" in {
    val set = Set[PodstatnéMeno](slovník.Kufor, slovník.Auto)
    for {
      noun <- set if noun.eq(slovník.Kufor)
    } {
      noun.asText() shouldEqual "kufor"
    }
  }

  // now we test the declension of nouns

  /*
   * Masculine Nouns
   */
  // Following CHLAP
  "A masculine noun following chlap" should "decline in the nominative singular" in {
    (slovník.Muž setČislo Jednotné asText Nominatív) shouldEqual "muž"
  }
  "A masculine, animate noun not ending in 'a'" should "decline in the nominative case singular" in {
    slovník.Učiteľ.asText() shouldEqual "učiteľ"
  }
  "A masculine noun following chlap" should "decline in the accusative singular" in {
    (slovník.Muž setČislo Jednotné asText Akusatív) shouldEqual "muža"
  }
  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case singular" in {
    (slovník.Učiteľ asText(pád = Akusatív)) shouldEqual "učiteľa"
  }
  "A masculine, animate noun not ending in 'a'" should "decline in the locative case singular" in {
    slovník.Učiteľ.asText(Lokatív) shouldEqual "učiteľovi"
  }
  // plural
  "A masculine noun following chlap" should "decline in the nominative plural" in {
    (slovník.Muž setČislo Množné asText Nominatív) shouldEqual "muži"
  }
  "A masculine, animate noun not ending in 'a'" should "decline in the nominative case plural" in {
    (slovník.Učiteľ setČislo Množné asText()) shouldEqual "učiteľi"
  }
  "A masculine noun following chlap" should "decline in the accusative plural" in {
    (slovník.Muž setČislo Množné asText Akusatív) shouldEqual "mužov"
  }
  "A masculine, animate noun not ending in 'a'" should "decline in the accusative case plural" in {
    slovník.Učiteľ setČislo Množné asText Akusatív shouldEqual "učiteľov"
  }
  "A masculine, animate noun not ending in 'a'" should "decline in the locative case plural" in {
    slovník.Učiteľ setČislo Množné asText Lokatív shouldEqual "učiteľoch"
  }
  // with a fleeting 'e'
  "A masculine, animate noun not ending in 'a' with fleeting 'e'" should "decline in the locative case singular" in {
    slovník.Otec.asText(Lokatív) shouldEqual "otcovi"
  }

  // Following DUB
  "A masculine, inanimate noun ending in a hard consonant" should "decline in the nominative case singular" in {
    slovník.Hrad asText Nominatív shouldEqual "hrad"
  }
  "A masculine, inanimate noun ending in a hard consonant" should "decline in the accusative case singular" in {
    slovník.Hrad asText Akusatív shouldEqual "hrad"
  }
  "A masculine, inanimate noun ending in a hard consonant" should "decline in the locative case singular" in {
    slovník.Hrad asText Lokatív shouldEqual "hrade"
  }
  "A masculine, inanimate noun ending in a hard consonant" should "decline in the locative case plural" in {
    slovník.Hrad setČislo Množné asText Lokatív shouldEqual "hradoch"
  }

  // Following STROJ
  "A masculine, inanimate noun ending in a soft consonant" should "decline in the accusative case singular" in {
    (slovník.Dunaj asText Akusatív) shouldEqual "Dunaj"
  }
  "A masculine, inanimate noun ending in a soft consonant" should "decline in the accusative case plural" in {
    (slovník.Dunaj setČislo Množné asText Akusatív) shouldEqual "Dunaje"
  }

  "A masculine noun following dub" should "decline in the nominative plural" in {
    (slovník.Voz setČislo Množné asText()) shouldEqual "vozy"
  }


  "A proper noun" should "be usable as a verb subject" in {
    (slovník.Byť addPodmet Pomenovanie("Igor", MužskýŽivotný) asText) shouldEqual "Igor je"
  }

  /*
   * Feminine Nouns
   */

  "A feminine noun ending in soft consonant -a" should "decline in the nominative case singular" in {
    slovník.Krava.asText() shouldEqual "krava"
  }

  // Following ŽENA

  "A feminine noun following žena" should "decline in the locative singular" in {
    (slovník.Matka asText Lokatív) shouldEqual "matke"
  }
  "A feminine noun following žena" should "decline in the locative plural" in {
    (slovník.Matka setČislo Množné asText Lokatív) shouldEqual "matkách"
  }

  "A feminine noun following žena" should "turn into an adverb with preposition \"pri\"" in {
    (slovník.Matka predložka "pri" asText) shouldEqual "pri matke"
  }
  "A feminine noun following žena" should "turn into an adverb with preposition \"vo\"" in {
    (slovník.Matka predložka "vo" asText) shouldEqual "v matke"
  }
  "A feminine \"žena\" noun starting with \"v\"" should "turn into an adverb with preposition \"vo\"" in {
    (slovník.Voda predložka "vo" asText) shouldEqual "vo vode"
  }


  // Following ULICA
  // Singular
  "A feminine noun following ulica" should "decline in the nominative singular" in {
    (slovník.Stanica asText Nominatív) shouldEqual "stanica"
  }
  "A feminine noun following ulica" should "decline in the genitive singular" in {
    (slovník.Stanica asText Genitív) shouldEqual "stanice"
  }
  "A feminine noun following ulica" should "decline in the accusative case singular" in {
    (slovník.Ulica asText Akusatív) shouldEqual "ulicu"
  }
  "A feminine noun following ulica" should "decline in the locative case singular" in {
    (slovník.Ulica asText Lokatív) shouldEqual "ulici"
  }
  // Plural
  "A feminine noun following ulica" should "decline in the nominative plural" in {
    slovník.Stanica setČislo Množné asText() shouldEqual "stanice"
  }
  "A feminine noun following ulica" should "decline in the genitive case plural" in {
    slovník.Ulica setČislo Množné asText Genitív shouldEqual "ulic"
  }
  "A feminine noun following ulica" should "decline in the accusative case plural" in {
    slovník.Ulica setČislo Množné asText Akusatív shouldEqual "ulice"
  }
  "A feminine noun following ulica" should "decline in the locative case plural" in {
    slovník.Ulica setČislo Množné asText Lokatív shouldEqual "uliciach"
  }
  // Rhythmic Rule for ulica
  "A noun following ulica with a long syllable" should "decline in the dative case plural" in {
    slovník.Práca setČislo Množné asText Datív shouldEqual "prácam"
  }
  "A noun following ulica with a long syllable" should "decline in the locative case plural" in {
    slovník.Práca setČislo Množné asText Lokatív shouldEqual "prácach"
  }

  // following DLAŇ
  "A feminine noun following dlaň" should "decline in the nominative case singular" in {
    slovník.Dlaň asText Nominatív shouldEqual "dlaň"
  }
  "A feminine noun following dlaň" should "decline in the genitive case singular" in {
    slovník.Dlaň asText Genitív shouldEqual "dlane"
  }
  "A feminine noun following dlaň" should "decline in the accusative case singular" in {
    slovník.Dlaň asText Akusatív shouldEqual "dlaň"
  }
  "A feminine noun following dlaň" should "decline in the locative case singular" in {
    slovník.Dlaň asText Lokatív shouldEqual "dlani"
  }
  // Plural
  "A feminine noun following dlaň" should "decline in the nominative case plural" in {
    slovník.Dlaň setČislo Množné asText Nominatív shouldEqual "dlane"
  }
  "A feminine noun following dlaň" should "decline in the genitive case plural" in {
    slovník.Dlaň setČislo Množné asText Genitív shouldEqual "dlaní"
  }
  "A feminine noun following dlaň" should "decline in the dative case plural" in {
    slovník.Dlaň setČislo Množné asText Datív shouldEqual "dlaniam"
  }
  "A feminine noun following dlaň" should "decline in the accusative case plural" in {
    slovník.Dlaň setČislo Množné asText Akusatív shouldEqual "dlane"
  }
  "A feminine noun following dlaň" should "decline in the locative case plural" in {
    slovník.Dlaň setČislo Množné asText Lokatív shouldEqual "dlaniach"
  }
  // Different dlaň-noun with a dipthong long final syllable
  "A final-dipthong feminine noun following dlaň" should "decline in the nominative case singular" in {
    slovník.Kaviareň asText Nominatív shouldEqual "kaviareň"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the genitive case singular" in {
    slovník.Kaviareň asText Genitív shouldEqual "kaviarne"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the accusative case singular" in {
    slovník.Kaviareň asText Akusatív shouldEqual "kaviareň"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the locative case singular" in {
    slovník.Kaviareň asText Lokatív shouldEqual "kaviarni"
  }
  // Plural
  // dipthong syllable with fleeting-e
  "A final-dipthong feminine noun following dlaň" should "decline in the nominative case plural" in {
    slovník.Kaviareň setČislo Množné asText Nominatív shouldEqual "kaviarne"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the genitive case plural" in {
    slovník.Kaviareň setČislo Množné asText Genitív shouldEqual "kaviarní"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the dative case plural" in {
    slovník.Kaviareň setČislo Množné asText Datív shouldEqual "kaviarňam"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the accusative case plural" in {
    slovník.Kaviareň setČislo Množné asText Akusatív shouldEqual "kaviarne"
  }
  "A final-dipthong feminine noun following dlaň" should "decline in the locative case plural" in {
    slovník.Kaviareň setČislo Množné asText Lokatív shouldEqual "kaviarňach"
  }
  // With a long-mark long final-syllable
  "A long-final-syllable feminine noun following dlaň" should "decline in the dative case pleral" in {
    slovník.Továreň setČislo Množné asText Datív shouldEqual "továrňam"
  }
  "A long-final-syllable feminine noun following dlaň" should "decline in the locative case plural" in {
    slovník.Továreň setČislo Množné asText Lokatív shouldEqual "továrňach"
  }
  // ends in "eň" WITHOUT fleeting-e
  "A 'eň'-ending feminine noun following dlaň without fleeting e" should "decline in the nominative case singular" in {
    slovník.Jeseň asText Nominatív shouldEqual "jeseň"
  }
  "A 'eň'-ending feminine noun following dlaň without fleeting e" should "decline in the accusative case singular" in {
    slovník.Jeseň asText Akusatív shouldEqual "jeseň"
  }
  "A 'eň'-ending feminine noun following dlaň without fleeting e" should "decline in the locative case singular" in {
    slovník.Jeseň asText Lokatív shouldEqual "jeseni"
  }
  // plural
  "A 'eň'-ending feminine noun following dlaň without fleeting e" should "decline in the nominative case plural" in {
    slovník.Jeseň setČislo Množné asText Nominatív shouldEqual "jesene"
  }
  "A 'eň'-ending feminine noun following dlaň without fleeting e" should "decline in the accusative case plural" in {
    slovník.Jeseň setČislo Množné asText Akusatív shouldEqual "jesene"
  }
  "A 'eň'-ending feminine noun following dlaň without fleeting e" should "decline in the locative case plural" in {
    slovník.Jeseň setČislo Množné asText Lokatív shouldEqual "jeseniach"
  }


  // following KOSŤ
  "A feminine noun following kosť" should "decline in the accusative case plural" in {
    (slovník.Radosť setČislo Množné asText Akusatív) shouldEqual "radosťi"
  }
  "A feminine noun following kosť" should "decline in the locative case singular" in {
    (slovník.Radosť asText Lokatív) shouldEqual "radosťi"
  }
  "A feminine noun following kosť" should "decline in the locative case plural" in {
    (slovník.Radosť setČislo Množné asText Lokatív) shouldEqual "radosťiach"
  }
  // "jar" follows "kosť" even though it ends with an "r", which usually follows "dlaň"
  "The noun 'jar'" should "follow 'kosť' in the genitive singular" in {
    (slovník.Jar asText Genitív) shouldEqual "jari"
  }
  "The noun 'jar'" should "follow 'kosť' in the nominative plural" in {
    (slovník.Jar setČislo Množné asText Nominatív) shouldEqual "jari"
  }
  "The noun 'jar'" should "follow 'kosť' in the accusative plural" in {
    (slovník.Jar setČislo Množné asText Akusatív) shouldEqual "jari"
  }

  /*
   * Pluralize Nouns in the Nominatív Case
   */
 
  "A feminine noun following žena" should "decline in the nominative plural" in {
    (slovník.Stavba setČislo Množné asText()) shouldEqual "stavby"
  }


  "A feminine noun following kosť" should "decline in the nominative plural" in {
    (slovník.Vec setČislo Množné asText()) shouldEqual "veci"
  }

  "A neuter noun following mesto" should "decline in the nominative plural" in {
    (slovník.Auto setČislo Množné).asText() shouldEqual "autá"
  }

  // more declinations
  "A feminine noun following žena" should "decline in the accusative singular" in {
    (slovník.Stavba setČislo Jednotné asText Akusatív) shouldEqual "stavbu"
  }
  "A feminine noun following žena" should "decline in the accusative plural" in {
    (slovník.Stavba setČislo Množné asText Akusatív) shouldEqual "stavby"
  }


  /*
   * Neuter Nouns
   */

  "A neuter noun ending in '-o'" should "decline in the locative case singular" in {
    slovník.Mesto asText Lokatív shouldEqual "meste"
  }
  "A neuter noun ending in '-o'" should "decline in the locative case plural" in {
    slovník.Mesto setČislo Množné asText Lokatív shouldEqual "mestách"
  }

  "A neuter noun ending in '-e'" should "decline in the nominative case singular" in {
    slovník.Srdce.asText() shouldEqual "srdce"
  }

  "A neuter noun ending in '-ie'" should "decline in the nominative case singular" in {
    slovník.Namestie.asText() shouldEqual "namestie"
  }

  "A neuter noun ending in '-a'" should "decline in the nominative case singular" in {
    slovník.Mača.asText() shouldEqual "mača"
  }


  // whatever...
  "A feminine noun following žena" should "decline in the genitive singular" in {
    slovník.Žena.asText(pád = Genitív) shouldEqual "ženy"
  }
  "A neuter noun following mesto" should "decline in the genitive singular" in {
    slovník.Mesto.asText(pád = Genitív) shouldEqual "mesta"
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
    slovník.Muž.rod shouldEqual MužskýŽivotný
  }

}
