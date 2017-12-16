package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

/*
 * To Go: Isť
 */

class ToGoSpec extends FlatSpec with Matchers {

  "To go as infinitive with 'via'" should "take a masculine direct object" in {
    (slovník.Ísť setPredložka "cez" setPredmet slovník.Dvor asText) shouldEqual "ísť cez dvor"
  }
  "To go with a subject and 'via'" should "take a masculine direct object" in {
    (slovník.Ísť addPodmet (Ty setČislo Množné) setPredložka "cez" setPredmet slovník.Dvor asText) shouldEqual
    "vy idete cez dvor"
  }
  "To go with a subject and 'via'" should "take a žena-feminine direct object" in {
    (slovník.Ísť addPodmet (Ty setČislo Množné) setPredložka "cez" setPredmet slovník.Dedina asText) shouldEqual
    "vy idete cez dedinu"
  }
  "To go with a subject and 'via'" should "take an ulica-feminine direct object" in {
    (slovník.Ísť addPodmet (Ty setČislo Množné) setPredložka "cez" setPredmet slovník.Ulica asText) shouldEqual
    "vy idete cez ulicu"
  }
  "To go with a subject and 'via'" should "take a neuter direct object" in {
    (slovník.Ísť addPodmet (Ty setČislo Množné) setPredložka "cez" setPredmet slovník.Mesto asText) shouldEqual
    "vy idete cez mesto"
  }

}
