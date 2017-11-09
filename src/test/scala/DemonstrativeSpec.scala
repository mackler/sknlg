package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class DemonstrativeSpec extends FlatSpec with Matchers {

  "A demonstartive referring to a masculine noun" should "decline in the nominative case singular" in {
      Slovník.Hrad(demonstrative = true).asText() shouldEqual "ten hrad"
  }

  "A demonstartive referring to a masculine noun with an adjective" should "decline in the nominative case singular" in {
      Slovník.Hrad(demonstrative = true, prídavnéMeno = Some(Slovník.Pekný)).asText() shouldEqual "ten pekný hrad"
  }

  "A demonstartive referring to a feminine noun" should "decline in the nominative case singular" in {
      Slovník.Rieka(demonstrative = true).asText() shouldEqual "tá rieka"
  }

  "A demonstartive referring to a feminine noun with an adjective" should "decline in the nominative case singular" in {
      Slovník.Rieka(demonstrative = true, prídavnéMeno = Some(Slovník.Pekný)).asText() shouldEqual "tá pekná rieka"
  }

  "A demonstartive referring to a neuter noun" should "decline in the nominative case singular" in {
      Slovník.Mesto(demonstrative = true).asText() shouldEqual "to mesto"
  }

  "A demonstartive referring to a neuter noun with an adjective" should "decline in the nominative case singular" in {
      Slovník.Mesto(demonstrative = true, prídavnéMeno = Some(Slovník.Pekný)).asText() shouldEqual "to pekné mesto"
  }

}