package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class PrídavnéMenoSpec extends FlatSpec with Matchers {

  "A prídavnéMeno referring to a masculine noun" should "generate the masculine prídavnéMeno" in {
    Slovník.Kufor(prídavnéMeno = Some(Slovník.Pekný)).asText() shouldEqual "pekný kufor"
  }

  "A prídavnéMeno referring to a feminine noun" should "generate the feminine prídavnéMeno" in {
    Slovník.Rieka(prídavnéMeno = Some(Slovník.Pekný)).asText() shouldEqual "pekná rieka"
  }

  "A prídavnéMeno referring to a neuter noun" should "generate the neuter prídavnéMeno" in {
    Slovník.Auto(prídavnéMeno = Some(Slovník.Pekný)).asText() shouldEqual "pekné auto"
  }

  "A prídavnéMeno referring to a masculine noun" should "generate the masculine prídavnéMeno without two long vowels in a row" in {
    Slovník.Kufor(prídavnéMeno = Some(Slovník.Krázny)).asText() shouldEqual "krázny kufor"
  }

  "A prídavnéMeno referring to a feminine noun" should "generate the feminine prídavnéMeno without two long vowels in a row" in {
    Slovník.Rieka(prídavnéMeno = Some(Slovník.Krázny)).asText() shouldEqual "krázna rieka"
  }

  "A prídavnéMeno referring to a neuter noun" should "generate the neuter prídavnéMeno without two long vowels in a row" in {
    Slovník.Auto(prídavnéMeno = Some(Slovník.Krázny)).asText() shouldEqual "krázne auto"
  }

  "A one-sylable prídavnéMeno referring to a neuter noun" should "generate the neuter prídavnéMeno" in {
    Slovník.Auto(prídavnéMeno = Some(Slovník.Zlý)).asText() shouldEqual "zlé auto"
  }

  "A adjective with a root ending in a long syllable" should "obey the rhythmic rule in the nominative case" in {
    Slovník.Kniha().setPrídavnéMeno(Slovník.Nízky).asText() shouldEqual "nízka kniha"
  }
}
