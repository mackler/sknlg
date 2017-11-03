package org.mackler.sknlg

import Gender._
import Number._
import org.scalatest._

class AdjectiveSpec extends FlatSpec with Matchers {

  "An adjective monifying a masculine noun" should "generate the masculine adjective" in {
    Vocabulary.Kufor(adjective = Some(Vocabulary.Pekný)).asText shouldEqual "pekný kufor"
  }
}
