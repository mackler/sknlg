package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class CanSpec extends FlatSpec with Matchers {

  /*
   * Môcť, "to be able" is an irregular verb
   */

  "The verb Môcť verb without neither subject nor verb" should "generate the infinitive" in {
    slovník.Môcť.asText shouldEqual "môcť"
  }

  // with subject but no verb
  "The verb Môcť without without a verb" should "conjugate in the singular first person" in {
    (slovník.Môcť addPodmet Ja asText) shouldEqual "ja môžem"
  }
  "The verb Môcť without without a verb" should "conjugate in the singular second person" in {
    (slovník.Môcť addPodmet Ty asText) shouldEqual "ty môžeš"
  }
  "The verb Môcť without without a verb" should "conjugate in the singular third person" in {
    (slovník.Môcť addPodmet On asText) shouldEqual "on môže"
  }

  "The verb Môcť without without a verb" should "conjugate in the plural first person" in {
    (slovník.Môcť addPodmet (Ja setČislo Množné) asText) shouldEqual "my môžeme"
  }
  "The verb Môcť without without a verb" should "conjugate in the plural second person" in {
    (slovník.Môcť addPodmet (Ty setČislo Množné) asText) shouldEqual "vy môžete"
  }
  "The verb Môcť without without a verb" should "conjugate in the plural third person" in {
    (slovník.Môcť addPodmet (On setČislo Množné) asText) shouldEqual "oni môžu"
  }

  // with auxiliary verb
  "The verb Môcť as auxiliary verb" should "conjugate in the singular first person" in {
    (slovník.Môcť addPodmet Ja setAuxiliary slovník.Čítať asText) shouldEqual "ja môžem čítať"
  }
  "The verb Môcť as auxiliary to verb with subject" should "conjugate in the singular first person" in {
    (slovník.Môcť setAuxiliary (slovník.Čítať addPodmet Ja) asText) shouldEqual "ja môžem čítať"
  }

}
