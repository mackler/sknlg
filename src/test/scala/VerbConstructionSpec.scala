package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class VerbConstructionSpec extends FlatSpec with Matchers {

  /*
   * We want to be able to construct verbs one part at a time, each step returning a new
   * instance with the given member set.
   */
  val infinitive = Slovník.Mať()
  "A regular Type1 verb object without parameters" should "generate the infinitive" in {
    infinitive.asText shouldEqual "mať"
  }

  // add a subject noun
  val withSubject = infinitive setPodmet Ja()
  "A regular Type1 verb without a subject" should "accept a subject noun" in {
    withSubject.asText shouldEqual "ja mám"
  }

  val infinitiveWithObject = infinitive setPredmet Slovník.Kufor()
  // add a direct object to the infinitive
  "A regular Type1 verb with no subject" should "accept a direct object" in {
    infinitiveWithObject.asText shouldEqual "mať kufor"
  }

  // add a direct object to the verb with a subject
  "A regular Type1 verb with a subject" should "accept a direct object" in {
    withSubject.setPredmet(Slovník.Kufor()).asText shouldEqual "ja mám kufor"
  }

  // add a subject to the verb with a direct object
  val withObjectAndSubject = infinitiveWithObject setPodmet Ja()
  "An infinitive Type1 verb with a direct object" should "accept a subject" in {
    withObjectAndSubject.asText shouldEqual "ja mám kufor"
  }

  // We can do the same for verbs of a different type
  val infinitive13 = Slovník.Vidieť()
  "A regular Type13 verb object without parameters" should "generate the infinitive" in {
    infinitive13.asText shouldEqual "vidieť"
  }

  // add a subject to the Type13 infinitive
  val type13WithSubject = infinitive13 setPodmet Ja()
  "An infinitive Type13 verb" should "accept a subject" in {
    type13WithSubject.asText shouldEqual "ja vidím"
  }

  // add an object to the Type13 that has a subject
  val type13WithSubjectAndObject = type13WithSubject setPredmet Slovník.Kufor()
  "An Type13 verb with a subject" should "accept a direct object" in {
    type13WithSubjectAndObject.asText shouldEqual "ja vidím kufor"
  }
}
