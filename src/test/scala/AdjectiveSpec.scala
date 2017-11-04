package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class AdjectiveSpec extends FlatSpec with Matchers {

  "An adjective referring to a masculine noun" should "generate the masculine adjective" in {
    Slovník.Kufor(adjective = Some(Slovník.Pekný)).asText() shouldEqual "pekný kufor"
  }

  "An adjective referring to a feminine noun" should "generate the feminine adjective" in {
    Slovník.Rieka(adjective = Some(Slovník.Pekný)).asText() shouldEqual "pekná rieka"
  }

  "An adjective referring to a neuter noun" should "generate the neuter adjective" in {
    Slovník.Auto(adjective = Some(Slovník.Pekný)).asText() shouldEqual "pekné auto"
  }

  "An adjective referring to a masculine noun" should "generate the masculine adjective without two long vowels in a row" in {
    Slovník.Kufor(adjective = Some(Slovník.Krázny)).asText() shouldEqual "krázny kufor"
  }

  "An adjective referring to a feminine noun" should "generate the feminine adjective without two long vowels in a row" in {
    Slovník.Rieka(adjective = Some(Slovník.Krázny)).asText() shouldEqual "krázna rieka"
  }

  "An adjective referring to a neuter noun" should "generate the neuter adjective without two long vowels in a row" in {
    Slovník.Auto(adjective = Some(Slovník.Krázny)).asText() shouldEqual "krázne auto"
  }

}
