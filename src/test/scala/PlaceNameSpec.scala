package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import slovník._

import org.scalatest._


class PlaceNameSpec extends FlatSpec with Matchers {

  "A country name" should "have a gender" in {
    (Byť addPodmet Európa setComplement Pekný asText) shouldEqual "Európa je pekná"
  }
  "A masculine proper name" should "be complemented by a demonym" in {
    (Byť addPodmet Pomenovanie("Peter", MužskýŽivotný) setComplement Slovensko.demonym.get asText) shouldEqual
    "Peter je Slovák"
  }
  "A feminine proper name" should "be complemented by a demonym" in {
    (Byť addPodmet Pomenovanie("Maria", Ženský) setComplement Slovensko.demonym.get asText) shouldEqual
    "Maria je Slovenka"
  }
  "A place name" should "generate a feminine demonym from a male" in {
    val myPlace = PlaceName(entry = "whatevera", rod = Ženský,
                            demonymMužský = "abc", adjectival = "whateversky")
    (Byť addPodmet Ona setComplement myPlace.demonym.get asText) shouldEqual "ona je abcka"
  }
  "A place name" should "generate a feminine demonym from a male anding in -ec" in {
    val myPlace = PlaceName(entry = "whatevera", rod = Ženský,
                            demonymMužský = "abec", adjectival = "whateversky")
    (Byť addPodmet Ona setComplement myPlace.demonym.get asText) shouldEqual "ona je abka"
  }
  "A place name" should "not generate a feminine demonym when one is given" in {
    val myPlace = PlaceName(entry = "whatevera", rod = Ženský,
                            demonymMužský = "abc", demonymŽenský = "othera", adjectival = "whateversky")
    (Byť addPodmet Ona setComplement myPlace.demonym.get asText) shouldEqual "ona je othera"
  }

  /* Multi-word place name */
  "A two-word place name" should "decline all words" in {
    (Vidieť addPodmet Ja setPredmet Británia asText) shouldEqual "ja vidím Veľkú Britániu"
  }

  /* Adjectival forms of place names */
  "A masculine noun" should "be complemented by a geographic adjective" in {
    (Byť addPodmet Hrad setComplement Slovensko.adjectival asText) shouldEqual
    "hrad je slovenský"
  }
  "A feminine noun" should "be complemented by a geographic adjective" in {
    (Byť addPodmet Kniha setComplement Slovensko.adjectival asText) shouldEqual
    "kniha je slovenská"
  }
  "A neuter noun" should "be complemented by a geographic adjective" in {
    (Byť addPodmet Sklo setComplement Slovensko.adjectival asText) shouldEqual
    "sklo je slovenské"
  }

  /* Place of origin */
  "A place name" should "convert to an origin phrase" in {
    (Francúzsko.asOrigin asText) shouldEqual "z Francúzska"
  }
  "A place name starting with the letter 'S'" should "convert to an origin phrase" in {
    (Slovensko.asOrigin asText) shouldEqual "zo Slovenska"
  }
  "A masculine place origin" should "complement a verb's subject" in {
    (Byť addPodmet Ja setComplement Vatikán.asOrigin asText) shouldEqual "ja som z Vatikána"
  }
  "A feminine place origin" should "complement a verb's subject" in {
    (Byť addPodmet Ja setComplement Amerika.asOrigin asText) shouldEqual "ja som z Ameriky"
  }
  "A neuter place origin" should "complement a verb's subject" in {
    (Byť addPodmet Ja setComplement Francúzsko.asOrigin asText) shouldEqual "ja som z Francúzska"
  }
  "A place origin starting with S" should "complement a verb's subject" in {
    (Byť addPodmet Ja setComplement Slovensko.asOrigin asText) shouldEqual "ja som zo Slovenska"
  }

  /* Knowing/speaking/reading/etc a language */
  "A place name" should "convert to an adverb phrase" in {
    (Slovensko.asPríslovka asText) shouldEqual "po slovensky"
  }
  "A place name's language adverb" should "apply to a verb" in {
    (Žiadať addPodmet Pomenovanie("Peter", MužskýŽivotný) setPríslovka Slovensko.asPríslovka asText) shouldEqual
    "Peter žiada po slovensky"
  }

  /* Adverbs and the locative case */
  "A feminine place name" should "allow a noun to be in it" in {
    (Byť addPodmet Ja setComplement (Amerika predložka "pri") asText) shouldEqual "ja som pri Amerike"
  }
  "A netur place name" should "allow a noun to be in it" in {
    (Byť addPodmet Ja setComplement (Slovensko predložka "pri") asText) shouldEqual "ja som pri Slovenske"
  }

}

