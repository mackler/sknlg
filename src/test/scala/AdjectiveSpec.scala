package org.mackler.sknlg

import Gender._
import Number._
import org.scalatest._

class AdjectiveSpec extends FlatSpec with Matchers {

  "An adjective referring to a masculine noun" should "generate the masculine adjective" in {
    Vocabulary.Kufor(adjective = Some(Vocabulary.Pekný)).asText() shouldEqual "pekný kufor"
  }

  "An adjective referring to a feminine noun" should "generate the feminine adjective" in {
    Vocabulary.Rieka(adjective = Some(Vocabulary.Pekný)).asText() shouldEqual "pekná rieka"
  }

}
