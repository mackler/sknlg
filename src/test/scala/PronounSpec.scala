package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class ZámenoSpec extends FlatSpec with Matchers {

  "A second-person pronoun" should "default to singular" in {
    Ty().asText() shouldEqual "ty"
  }

}
