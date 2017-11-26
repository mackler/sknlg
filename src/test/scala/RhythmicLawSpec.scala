package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class RytmickéKrátenieSpec extends FlatSpec with Matchers {

  // TODO, there are other tests of rhythmic shortening in other files.  Put them here?
  "A verb with an 'ie' dipthong in its final stem vomel" should "shorten its ending" in {
    (slovník.Chodievať addPodmet On() asText) shouldEqual "on chodieva"
  }
  "A verb with an 'ia' dipthong in its final stem vomel" should "shorten its ending" in {
    (slovník.Žiadať addPodmet On() asText) shouldEqual "on žiada"
  }

}

