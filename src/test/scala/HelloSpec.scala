package org.mackler.sknlg

import org.scalatest._

class ByťSpec extends FlatSpec with Matchers {
  "The Byť object" should "return the infinitive" in {
    Vocabulary.Byť.infinitive shouldEqual "byť"
  }
}
