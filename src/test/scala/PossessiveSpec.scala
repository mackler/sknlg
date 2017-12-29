package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

/*
 * Possessive Pronouns
 */

class PrivlastňovacíSpec extends FlatSpec with Matchers {

  /*
   *  Begin by having the possessor be singular in number.
   */

  // First person
  // possessed noun is Singular masculine
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
  // reflexive
  "The reflexive possessive 'môj'" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Učiteľ setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja som svoj učiteľ"
  }
  "The reflexive possessive 'môj'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja vidím svojho brata"
  }
  "The reflexive possessive 'môj'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja vidím svoj hrad"
  }
  "The reflexive possessive 'môj'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "ja som pri svojom bratovi"
  }

  // possessed noun is singular feminine
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
  // reflexive
  "The reflexive possessive 'môj'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Učiteľka setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja som svoja učiteľka"
  }
  "The reflexive possessive 'môj'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja vidím svoju sestru"
  }
  "The reflexive possessive 'môj'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "ja som pri svojej sestre"
  }

  // possessed noun is singular neuter
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
  // reflexive
  "The reflexive possessive 'môj'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja som svoje auto"
  }
  "The reflexive possessive 'môj'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setPrídavnéMeno slovník.Môj) asText) shouldEqual "ja vidím svoje auto"
  }
  "The reflexive possessive 'môj'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "ja som pri svojom aute"
  }

  // First person plural
  // possessed noun is plural masculine
  "The possessive 'môj'" should "modify a plural masculine noun in the nominative" in {
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
  // reflexive
  "The reflexive possessive 'môj'" should "modify a plural masculine noun in the nominative" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "my sme svoji bratia" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'môj'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "my sme svoje hrady" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'môj'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "ja vidím svojich bratov"
  }
  "The reflexive possessive 'môj'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "ja vidím svoje hrady"
  }
  "The reflexive possessive 'môj'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "ja som pri svojich bratoch"
  }

  // possessed noun is plural feminine
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
  // reflexive
  "The reflexive possessive 'môj'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "my sme svoje sestry" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'môj'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "ja vidím svoje sestry"
  }
  "The reflexive possessive 'môj'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
      "ja som pri svojich sestrách"
  }

  // possessed noun is plural neuter
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
  // reflexive
  "The reflexive possessive 'môj'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "my sme svoje autá" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'môj'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj) asText) shouldEqual
      "ja vidím svoje autá"
  }
  "The reflexive possessive 'môj'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Môj predložka "pri") asText) shouldEqual
    "ja som pri svojich autách"
  }

  /*
   * possessed noun is Second person
   */
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
  // reflexive
  "The reflexive possessive 'tvoj'" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Brat setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty si svoj brat"
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Brat setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty vidíš svojho brata"
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Hrad setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty vidíš svoj hrad"
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Brat setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "ty si pri svojom bratovi"
  }

  // possessed noun is singular feminine
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
  // reflexive
  "The reflexive possessive 'tvoj'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Sestra setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty si svoja sestra"
  }
  "The reflexive possessive 'tvoj'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Sestra setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty vidíš svoju sestru"
  }
  "The reflexive possessive 'tvoj'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Sestra setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "ty si pri svojej sestre"
  }

  // possessed noun is singular neuter
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
  // reflexive
  "The reflexive possessive 'tvoj'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Auto setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty si svoje auto"
  }
  "The reflexive possessive 'tvoj'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Auto setPrídavnéMeno slovník.Tvoj) asText) shouldEqual "ty vidíš svoje auto"
  }
  "The reflexive possessive 'tvoj'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Auto setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "ty si pri svojom aute"
  }

  // Second person plural
  // possessed noun is plural masculine
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
  // reflexive
  "The reflexive possessive 'tvoj'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "vy ste svoji bratia" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "vy ste svoje hrady" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "ty vidíš svojich bratov"
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "ty vidíš svoje hrady"
  }
  "The reflexive possessive 'tvoj'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "ty si pri svojich bratoch"
  }

  // possessed noun is plural feminine
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
  // reflexive
  "The reflexive possessive 'tvoj'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "vy ste svoje sestry" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'tvoj'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "ty vidíš svoje sestry"
  }
  "The reflexive possessive 'tvoj'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
      "ty si pri svojich sestrách"
  }

  // possessed noun is plural neuter
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
  // reflexive
  "The reflexive possessive 'tvoj'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "vy ste svoje autá" // subject number gets modified because the complement is plural
  }
  "The reflexive possessive 'tvoj'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ty setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Tvoj) asText) shouldEqual
      "ty vidíš svoje autá"
  }
  "The reflexive possessive 'tvoj'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet Ty setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Tvoj predložka "pri") asText) shouldEqual
    "ty si pri svojich autách"
  }

  // Third person
  // possessed noun is Singular masculine
  "The possessive 'jeho'" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ten je jeho brat"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "ten je jej brat"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho brata"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "ja vidím jej brata"
  }
  "The possessive 'jeho'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho hrad"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "ja vidím jej hrad"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho bratovi"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setPrídavnéMeno (slovník.Jeho setRod Ženský) predložka "pri") asText) shouldEqual
    "ja som pri jej bratovi"
  }
  // possessed noun is singular feminine
  "The possessive 'jeho'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno slovník.Jeho) asText) shouldEqual "tá je jeho sestra"
  }
  "The possessive 'jeho' with a female possessor" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "tá je jej sestra"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho sestru"
  }
  "The possessive 'jeho' with a female possessor" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "ja vidím jej sestru"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho sestre"
  }
  "The possessive 'jeho' with a female possessor" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setPrídavnéMeno (slovník.Jeho setRod Ženský) predložka "pri") asText) shouldEqual
    "ja som pri jej sestre"
  }
  // possessed noun is singular neuter
  "The possessive 'jeho'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno slovník.Jeho) asText) shouldEqual "to je jeho auto"
  }
  "The possessive 'jeho' with a female possessor" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "to je jej auto"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setPrídavnéMeno slovník.Jeho) asText) shouldEqual "ja vidím jeho auto"
  }
  "The possessive 'jeho' with a female possessor" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual "ja vidím jej auto"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho aute"
  }
  "The possessive 'jeho' with a female possessor" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setPrídavnéMeno (slovník.Jeho setRod Ženský) predložka "pri") asText) shouldEqual
    "ja som pri jej aute"
  }

  // Second person plural
  // possessed noun is plural masculine
  "The possessive 'jeho'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tí sú jeho bratia"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "tí sú jej bratia"
  }
  "The possessive 'jeho'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tie sú jeho hrady"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "tie sú jej hrady"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho bratov"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "ja vidím jej bratov"
  }
  "The possessive 'jeho'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho hrady"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "ja vidím jej hrady"
  }
  "The possessive 'jeho'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setČislo Množné setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho bratoch"
  }
  "The possessive 'jeho' with a female possessor" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský) predložka "pri") asText) shouldEqual
    "ja som pri jej bratoch"
  }
  // possessed noun is plural feminine
  "The possessive 'jeho'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tie sú jeho sestry"
  }
  "The possessive 'jeho' with a female possessor" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "tie sú jej sestry"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho sestry"
  }
  "The possessive 'jeho' with a female possessor" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "ja vidím jej sestry"
  }
  "The possessive 'jeho'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
      "ja som pri jeho sestrách"
  }
  "The possessive 'jeho' with a female possessor" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský) predložka "pri") asText) shouldEqual
      "ja som pri jej sestrách"
  }
  // possessed noun is plural neuter
  "The possessive 'jeho'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "tie sú jeho autá"
  }
  // possessed noun is plural neuter
  "The possessive 'jeho' with a female possessor" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "tie sú jej autá"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Jeho) asText) shouldEqual
      "ja vidím jeho autá"
  }
  "The possessive 'jeho' with a female possessor" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský)) asText) shouldEqual
      "ja vidím jej autá"
  }
  "The possessive 'jeho'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Jeho predložka "pri") asText) shouldEqual
    "ja som pri jeho autách"
  }
  "The possessive 'jeho' with a female possessor" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Jeho setRod Ženský) predložka "pri") asText) shouldEqual
    "ja som pri jej autách"
  }

  /*
   * Now where the possessor is plural in number
   */

  // First person
  // possessed noun is Singular masculine
  "The possessive 'náš'" should "modify a masculine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "ten je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "ten je náš brat"
  }
  "The possessive 'náš'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "on vidí nášho brata"
  }
  "The possessive 'náš'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "on vidí náš hrad"
  }
  "The possessive 'náš'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri našom bratovi"
  }
  // reflexive
  "The reflexive possessive 'náš'" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Brat setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "ja som svoj brat" // subject number gets modified because the complement is singular
  }
  "The reflexive possessive 'náš'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Brat setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "my vidíme svojho brata"
  }
  "The reflexive possessive 'náš'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Hrad setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "my vidíme svoj hrad"
  }
  "The reflexive possessive 'náš'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Brat setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "my sme pri svojom bratovi"
  }

  // possessed noun is singular feminine
  "The possessive 'náš'" should "modify a feminine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "tá je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "tá je naša sestra"
  }
  "The possessive 'náš'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "on vidí našu sestru"
  }
  "The possessive 'náš'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri našej sestre"
  }
  // reflexive
  "The reflexive possessive 'náš'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Sestra setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "ja som svoja sestra" // subject number gets modified because the complement is singular
  }
  "The reflexive possessive 'náš'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Sestra setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "my vidíme svoju sestru"
  }
  "The reflexive possessive 'náš'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Sestra setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "my sme pri svojej sestre"
  }

  // possessed noun is singular neuter
  "The possessive 'náš'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "to je naše auto"
  }
  "The possessive 'náš'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual "on vidí naše auto"
  }
  "The possessive 'náš'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri našom aute"
  }
  // reflexive
  "The reflexive possessive 'náš'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Auto setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "ja som svoje auto" // subject number gets modified because the complement is singular
  }
  "The reflexive possessive 'náš'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Auto setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
    "my vidíme svoje auto"
  }
  "The reflexive possessive 'náš'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Auto setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "my sme pri svojom aute"
  }

  // First person plural
  // possessed noun is plural masculine
  "The possessive 'náš'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "tí sú naši bratia"
  }
  "The possessive 'náš'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "tie sú naše hrady"
  }
  "The possessive 'náš'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "on vidí našich bratov"
  }
  "The possessive 'náš'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "on vidí naše hrady"
  }
  "The possessive 'náš'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri našich bratoch"
  }
  // reflexive
  "The reflexive possessive 'náš'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my sme svoji bratia"
  }
  "The reflexive possessive 'náš'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my sme svoje hrady"
  }
  "The reflexive possessive 'náš'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my vidíme svojich bratov"
  }
  "The reflexive possessive 'náš'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my vidíme svoje hrady"
  }
  "The reflexive possessive 'náš'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "my sme pri svojich bratoch"
  }

  // possessed noun is plural feminine
  "The possessive 'náš'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "tie sú naše sestry"
  }
  "The possessive 'náš'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "on vidí naše sestry"
  }
  "The possessive 'náš'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
      "on je pri našich sestrách"
  }
  // reflexive
  "The reflexive possessive 'náš'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my sme svoje sestry"
  }
  "The reflexive possessive 'náš'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my vidíme svoje sestry"
  }
  "The reflexive possessive 'náš'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
      "my sme pri svojich sestrách"
  }

  // possessed noun is plural neuter
  "The possessive 'náš'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "tie sú naše autá"
  }
  "The possessive 'náš'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "on vidí naše autá"
  }
  "The possessive 'náš'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri našich autách"
  }
  // reflexive
  "The reflexive possessive 'náš'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my sme svoje autá"
  }
  "The reflexive possessive 'náš'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ja setČislo Množné) setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné)) asText) shouldEqual
      "my vidíme svoje autá"
  }
  "The reflexive possessive 'náš'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet (Ja setČislo Množné) setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Môj setČislo Množné) predložka "pri") asText) shouldEqual
    "my sme pri svojich autách"
  }

  // possessed noun is Second person
  "The possessive 'váš'" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "ten je váš brat"
  }
  "The possessive 'váš'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "on vidí vášho brata"
  }
  "The possessive 'váš'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "on vidí váš hrad"
  }
  "The possessive 'váš'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri vašom bratovi"
  }
  // reflexive
  "The reflexive possessive 'váš'" should "modify a masculine noun in the nominative singular" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Brat setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "ty si svoj brat" // subject number gets modified because the complement is singular
  }
  "The reflexive possessive 'váš'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Brat setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "vy vidíte svojho brata"
  }
  "The reflexive possessive 'váš'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Hrad setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "vy vidíte svoj hrad"
  }
  "The reflexive possessive 'váš'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Brat setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "vy ste pri svojom bratovi"
  }

  // possessed noun is singular feminine
  "The possessive 'váš'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "tá je vaša sestra"
  }
  "The possessive 'váš'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "on vidí vašu sestru"
  }
  "The possessive 'váš'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri vašej sestre"
  }
  // reflexive
  "The reflexive possessive 'váš'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Sestra setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "ty si svoja sestra" // subject number gets modified because the complement is singular
  }
  "The reflexive possessive 'váš'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Sestra setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "vy vidíte svoju sestru"
  }
  "The reflexive possessive 'váš'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Sestra setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "vy ste pri svojej sestre"
  }

  // possessed noun is singular neuter
  "The possessive 'váš'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "to je vaše auto"
  }
  "The possessive 'váš'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual "on vidí vaše auto"
  }
  "The possessive 'váš'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri vašom aute"
  }
  // reflexive
  "The reflexive possessive 'váš'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Auto setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "ty si svoje auto" // subject number gets modified because the complement is singular
  }
  "The reflexive possessive 'váš'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Auto setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
    "vy vidíte svoje auto"
  }
  "The reflexive possessive 'váš'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Auto setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "vy ste pri svojom aute"
  }

  // Second person plural
  // possessed noun is plural masculine
  "The possessive 'váš'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "tí sú vaši bratia"
  }
  "The possessive 'váš'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "tie sú vaše hrady"
  }
  "The possessive 'váš'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "on vidí vašich bratov"
  }
  "The possessive 'váš'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "on vidí vaše hrady"
  }
  "The possessive 'váš'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri vašich bratoch"
  }
  // reflexive
  "The reflexive possessive 'váš'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy ste svoji bratia"
  }
  "The reflexive possessive 'váš'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy ste svoje hrady"
  }
  "The reflexive possessive 'váš'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy vidíte svojich bratov"
  }
  "The reflexive possessive 'váš'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy vidíte svoje hrady"
  }
  "The reflexive possessive 'váš'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "vy ste pri svojich bratoch"
  }

  // possessed noun is plural feminine
  "The possessive 'vaš'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "tie sú vaše sestry"
  }
  "The possessive 'váš'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "on vidí vaše sestry"
  }
  "The possessive 'váš'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
      "on je pri vašich sestrách"
  }
  // reflexive
  "The reflexive possessive 'vaš'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy ste svoje sestry"
  }
  "The reflexive possessive 'váš'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy vidíte svoje sestry"
  }
  "The reflexive possessive 'váš'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
      "vy ste pri svojich sestrách"
  }

  // possessed noun is plural neuter
  "The possessive 'váš'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "tie sú vaše autá"
  }
  "The possessive 'váš'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet On setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "on vidí vaše autá"
  }
  "The possessive 'váš'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet On setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "on je pri vašich autách"
  }
  // reflexive
  "The reflexive possessive 'váš'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy ste svoje autá"
  }
  "The reflexive possessive 'váš'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet (Ty setČislo Množné) setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné)) asText) shouldEqual
      "vy vidíte svoje autá"
  }
  "The reflexive possessive 'váš'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet (Ty setČislo Množné) setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Tvoj setČislo Množné) predložka "pri") asText) shouldEqual
    "vy ste pri svojich autách"
  }

  // Third person
  // possessed noun is Singular masculine
  "The possessive 'ich'" should "modify a masculine noun in the nominative singular" in {
    // TODO I'm unsure whether it should be "ten je" or "to je" (but that's not what we're testing here)
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "ten je ich brat"
  }
  "The possessive 'ich'" should "modify a masculine-animate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "ja vidím ich brata"
  }
  "The possessive 'ich'" should "modify a masculine-inanimate noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "ja vidím ich hrad"
  }
  "The possessive 'ich'" should "modify a masculine-animate noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setPrídavnéMeno (slovník.Jeho setČislo Množné) predložka "pri") asText) shouldEqual
    "ja som pri ich bratovi"
  }
  // possessed noun is singular feminine
  "The possessive 'ich'" should "modify a feminine noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "tá je ich sestra"
  }
  "The possessive 'ich'" should "modify a feminine noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "ja vidím ich sestru"
  }
  "The possessive 'ich'" should "modify a feminine noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setPrídavnéMeno (slovník.Jeho setČislo Množné) predložka "pri") asText) shouldEqual
    "ja som pri ich sestre"
  }
  // possessed noun is singular neuter
  "The possessive 'ich'" should "modify a neuter noun in the nominative singular" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "to je ich auto"
  }
  "The possessive 'ich'" should "modify a neuter noun in the accusative singular" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual "ja vidím ich auto"
  }
  "The possessive 'ich'" should "modify a neuter noun in the locative singular" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setPrídavnéMeno (slovník.Jeho setČislo Množné) predložka "pri") asText) shouldEqual
    "ja som pri ich aute"
  }

  // Second person plural
  // possessed noun is plural masculine
  "The possessive 'ich'" should "modify a masculine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "tí sú ich bratia"
  }
  "The possessive 'ich'" should "modify a masculine-inanimate noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "tie sú ich hrady"
  }
  "The possessive 'ich'" should "modify a masculine-animate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "ja vidím ich bratov"
  }
  "The possessive 'ich'" should "modify a masculine-inanimate noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "ja vidím ich hrady"
  }
  "The possessive 'ich'" should "modify a masculine-animate noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Brat setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné) predložka "pri") asText) shouldEqual
    "ja som pri ich bratoch"
  }
  // possessed noun is plural feminine
  "The possessive 'ich'" should "modify a feminine noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "tie sú ich sestry"
  }
  "The possessive 'ich'" should "modify a feminine noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "ja vidím ich sestry"
  }
  "The possessive 'ich'" should "modify a feminine noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Sestra setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné) predložka "pri") asText) shouldEqual
      "ja som pri ich sestrách"
  }
  // possessed noun is plural neuter
  "The possessive 'ich'" should "modify a neuter noun in the nominative plural" in {
    (slovník.Byť addPodmet Ten setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "tie sú ich autá"
  }
  "The possessive 'ich'" should "modify a neuter noun in the accusative plural" in {
    (slovník.Vidieť addPodmet Ja setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné)) asText) shouldEqual
      "ja vidím ich autá"
  }
  "The possessive 'ich'" should "modify a neuter noun in the locative plural" in {
    (slovník.Byť addPodmet Ja setComplement (slovník.Auto setČislo Množné setPrídavnéMeno (slovník.Jeho setČislo Množné) predložka "pri") asText) shouldEqual
    "ja som pri ich autách"
  }

}
