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
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí môjho brata"
  }
  "The possessive 'môj'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí môj hrad"
  }
  "The possessive 'môj'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojom bratovi"
  }

  // singular feminine
  "The possessive 'môj'" should "modify a feminine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "tá je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno slovník.Môj) asText) shouldEqual "tá je moja sestra"
  }
  "The possessive 'môj'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí moju sestru"
  }
  "The possessive 'môj'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojej sestre"
  }

  // singular neuter
  "The possessive 'môj'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno slovník.Môj) asText) shouldEqual "to je moje auto"
  }
  "The possessive 'môj'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setPrídavnéMeno slovník.Môj) asText) shouldEqual "on vidí moje auto"
  }
  "The possessive 'môj'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
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
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí mojich bratov"
  }
  "The possessive 'môj'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí moje hrady"
  }
  "The possessive 'môj'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojich bratoch"
  }

  // plural feminine
  "The possessive 'môj'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "tie sú moje sestry"
  }
  "The possessive 'môj'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí moje sestry"
  }
  "The possessive 'môj'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
      "on je pri mojich sestrách"
  }

  // plural neuter
  "The possessive 'môj'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "tie sú moje autá"
  }
  "The possessive 'môj'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "on vidí moje autá"
  }
  "The possessive 'môj'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "on je pri mojich autách"
  }

  // Second person
  "The possessive 'tvoj'" should "modify a masculine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "ten je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ten je tvoj brat"
  }
  "The possessive 'tvoj'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "on vidí tvojho brata"
  }
  "The possessive 'tvoj'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "on vidí tvoj hrad"
  }
  "The possessive 'tvoj'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "on je pri tvojom bratovi"
  }

  // singular feminine
  "The possessive 'tvoj'" should "modify a feminine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "tá je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "tá je tvoja sestra"
  }
  "The possessive 'tvoj'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "on vidí tvoju sestru"
  }
  "The possessive 'tvoj'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "on je pri tvojej sestre"
  }

  // singular neuter
  "The possessive 'tvoj'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "to je tvoje auto"
  }
  "The possessive 'tvoj'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "on vidí tvoje auto"
  }
  "The possessive 'tvoj'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "on je pri tvojom aute"
  }

  // Second person plural
  // plural masculine
  "The possessive 'tvoj'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "tí sú tvoji bratia"
  }
  "The possessive 'tvoj'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "tie sú tvoje hrady"
  }
  "The possessive 'tvoj'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "on vidí tvojich bratov"
  }
  "The possessive 'tvoj'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "on vidí tvoje hrady"
  }
  "The possessive 'tvoj'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "on je pri tvojich bratoch"
  }

  // plural feminine
  "The possessive 'tvoj'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "tie sú tvoje sestry"
  }
  "The possessive 'tvoj'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "on vidí tvoje sestry"
  }
  "The possessive 'tvoj'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
      "on je pri tvojich sestrách"
  }

  // plural neuter
  "The possessive 'tvoj'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "tie sú tvoje autá"
  }
  "The possessive 'tvoj'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "on vidí tvoje autá"
  }
  "The possessive 'tvoj'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "on je pri tvojich autách"
  }


  // Third person
  // Singular masculine
  "The possessive 'jeho'" should "modify a masculine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "ten je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ten je jeho brat"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho brata"
  }
  "The possessive 'jeho'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho hrad"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho bratovi"
  }
  // singular feminine
  "The possessive 'jeho'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno slovník.Jeho) asText) shouldEqual "tá je jeho sestra"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho sestru"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho sestre"
  }
  // singular neuter
  "The possessive 'jeho'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno slovník.Jeho) asText) shouldEqual "to je jeho auto"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho auto"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho aute"
  }

  // Second person plural
  // plural masculine
  "The possessive 'jeho'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tí sú jeho bratia"
  }
  "The possessive 'jeho'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tie sú jeho hrady"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho bratov"
  }
  "The possessive 'jeho'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho hrady"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho bratoch"
  }
  // plural feminine
  "The possessive 'jeho'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tie sú jeho sestry"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho sestry"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
      "ja som pri jeho sestrách"
  }
  // plural neuter
  "The possessive 'jeho'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tie sú jeho autá"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho autá"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho autách"
  }

}
