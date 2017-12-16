package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

/*
 * Possessive Pronouns
 */

class PrivlastňovacíSpec extends FlatSpec with Matchers {

  // First person
  // Singular masculine
  "The possessive 'môj'" should "modify a masculine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "ten je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno slovník.Môj) asText) shouldEqual "ten je môj brat"
  }
  "The possessive 'môj'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Brat setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí môjho brata"
  }
  "The possessive 'môj'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Hrad setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí môj hrad"
  }
  "The possessive 'môj'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet On() setComplement (slovník.Brat setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojom bratovi"
  }

  // singular feminine
  "The possessive 'môj'" should "modify a feminine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "tá je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno slovník.Môj) asText) shouldEqual "tá je moja sestra"
  }
  "The possessive 'môj'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Sestra setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí moju sestru"
  }
  "The possessive 'môj'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet On() setComplement (slovník.Sestra setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojej sestre"
  }

  // singular neuter
  "The possessive 'môj'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno slovník.Môj) asText) shouldEqual "to je moje auto"
  }
  "The possessive 'môj'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Auto setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí moje auto"
  }
  "The possessive 'môj'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet On() setComplement (slovník.Auto setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojom aute"
  }

  // First person plural
  // plural masculine
  "The possessive 'môj'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "tí sú moji bratia"
  }
  "The possessive 'môj'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "tie sú moje hrady"
  }
  "The possessive 'môj'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí mojich bratov"
  }
  "The possessive 'môj'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí moje hrady"
  }
  "The possessive 'môj'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet On() setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojich bratoch"
  }

  // plural feminine
  "The possessive 'môj'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "tie sú moje sestry"
  }
  "The possessive 'môj'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí moje sestry"
  }
  "The possessive 'môj'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet On() setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
      "on je pri mojich sestrách"
  }

  // plural neuter
  "The possessive 'môj'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "tie sú moje autá"
  }
  "The possessive 'môj'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On() setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí moje autá"
  }
  "The possessive 'môj'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet On() setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojich autách"
  }
}

