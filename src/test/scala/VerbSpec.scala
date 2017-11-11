package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class VerbSpec extends FlatSpec with Matchers {

  // Byť is an irregular verb

  "The Byť object without podmet noun" should "generate the infinitive" in {
    Slovník.Byť().asText shouldEqual "byť"
  }

  "The Byť object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Byť(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja som"
  }

  "The Byť object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Byť(podmet = Seq(Ja(Množné))).asText shouldEqual "my sme"
  }

  "The Byť object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Byť(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty si"
  }

  "The Byť object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Byť(podmet = Seq(Ty(Množné))).asText shouldEqual "vy ste"
  }

  "The Byť object with a 3nd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Byť(podmet = Seq(On(Jednotné))).asText shouldEqual "on je"
  }

  "The Byť object with a 3rd/male/plural podmet pronoun" should "return the third person male plural" in {
    Slovník.Byť(podmet = Seq(On(Množné))).asText shouldEqual "oni sú"
  }

  "The Byť object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Byť(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona je"
  }

  "The Byť object with a 3rd/neutar/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Byť(podmet = Seq(To(Jednotné))).asText shouldEqual "to je"
  }

  "The Byť object with a 3rd/neuter/plural podmet pronoun" should "return the third person neuter plural" in {
    Slovník.Byť(podmet = Seq(To(Množné))).asText shouldEqual "oni sú"
  }

  // Ísť is irregular

  "The Ísť object without a subject noun" should "generate the infinitive" in {
    Slovník.Ísť().asText shouldEqual "ísť"
  }
  "The Ísť object with a singular first person subject noun" should "generate the correct inflection" in {
    (Slovník.Ísť() setPodmet Ja(čislo = Jednotné)).asText shouldEqual "ja idem"
  }
  "The Ísť object with a singular second person subject noun" should "generate the correct inflection" in {
    (Slovník.Ísť() setPodmet Ty(čislo = Jednotné)).asText shouldEqual "ty ideš"
  }
  "The Ísť object with a singular third person subject noun" should "generate the correct inflection" in {
    (Slovník.Ísť() setPodmet On(čislo = Jednotné)).asText shouldEqual "on ide"
  }
  "The Ísť object with a plural first person subject noun" should "generate the correct inflection" in {
    (Slovník.Ísť() setPodmet Ja(čislo = Množné)).asText shouldEqual "my ideme"
  }
  "The Ísť object with a plural second person subject noun" should "generate the correct inflection" in {
    (Slovník.Ísť() setPodmet Ty(čislo = Množné)).asText shouldEqual "vy idete"
  }
  "The Ísť object with a plural third person subject noun" should "generate the correct inflection" in {
    (Slovník.Ísť() setPodmet On(čislo = Množné)).asText shouldEqual "oni idú"
  }


  /*
   * Regular Verbs
   */

  // Mať is a regular verb of Type 1 following "chytať" - "chytám"

  "The Mať object without podmet noun" should "generate the infinitive" in {
    Slovník.Mať().asText shouldEqual "mať"
  }
  "The Mať object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Mať(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja mám"
  }
  "The Mať object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Mať(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty máš"
  }
  "The Mať object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Mať(podmet = Seq(Ja(Množné))).asText shouldEqual "my máme"
  }
  "The Mať object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Mať(podmet = Seq(Ty(Množné))).asText shouldEqual "vy máte"
  }
  "The Mať object with a 3rd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Mať(podmet = Seq(On(Jednotné))).asText shouldEqual "on má"
  }
  "The Mať object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Mať(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona má"
  }
  "The Mať object with a 3rd/neuter/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Mať(podmet = Seq(To(Jednotné))).asText shouldEqual "to má"
  }
  "The Mať object with a 3rd/neuter/plural podmet pronoun" should "return the third person plural" in {
    Slovník.Mať(podmet = Seq(To(Množné))).asText shouldEqual "oni majú"
  }

  // A verb can be negated
  "The Mať object constructed with a 1st/male/plural podmet pronoun" should "be negatable" in {
    Slovník.Mať(podmet = Seq(Ja(Množné))).toggleZáporný().asText shouldEqual "my nemáme"
  }
  "The Mať object with a 1st/male/plural podmet pronoun added" should "be negatable" in {
    Slovník.Mať().setPodmet(Ja(Množné)).toggleZáporný().asText shouldEqual "my nemáme"
  }
  "The Mať object with a 3rd/male/singular podmet pronoun" should "be negatable" in {
    Slovník.Mať(podmet = Seq(On(Jednotné))).toggleZáporný.asText shouldEqual "on nemá"
  }

  // Transitive Verbs can have a direct object
  "The Mať object 1st/sing with a direct object" should "return the correct text" in {
    Slovník.Mať(podmet = Seq(Ja(Jednotné)), directPredmet = Some(Slovník.Auto())).asText shouldEqual "ja mám auto"
  }
  "The Mať object 1st/plur with a direct object" should "return the correct text" in {
    Slovník.Mať(podmet = Seq(Ja(Množné)), directPredmet = Some(Slovník.Auto())).asText shouldEqual "my máme auto"
  }

  // Verbs with a long vowel in the final syllable of their root have short vowels in their inflections
  "The Bývať object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Bývať(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja bývam"
  }
  "The Bývať object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Bývať(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty bývaš"
  }
  "The Bývať object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Bývať(podmet = Seq(Ja(Množné))).asText shouldEqual "my bývame"
  }
  "The Bývať object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Bývať(podmet = Seq(Ty(Množné))).asText shouldEqual "vy bývate"
  }
  "The Bývať object with a 3rd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Bývať(podmet = Seq(On(Jednotné))).asText shouldEqual "on býva"
  }
  "The Bývať object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Bývať(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona býva"
  }
  "The Bývať object with a 3rd/neuter/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Bývať(podmet = Seq(To(Jednotné))).asText shouldEqual "to býva"
  }
  "The Bývať object with a 3rd/neuter/plural podmet pronoun" should "return the third person plural" in {
    Slovník.Bývať(podmet = Seq(To(Množné))).asText shouldEqual "oni bývajú"
  }

  // Instransitive Verb subjects may consist of multiple nouns
  "The Čakať verb with a subject of two proper nouns" should "conjugate as the third person plural" in {
    Slovník.Čakať(podmet = Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný))).asText shouldEqual "Igor a Peter čakajú"
  }

  // Transitive Verb subjects may consist of multiple nouns
  "The Mať verb with a subject of two proper nouns" should "conjugate as the third person plural" in {
    Slovník.Mať(podmet = Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný)),
                directPredmet = Some(Slovník.Auto())).asText shouldEqual "Igor a Peter majú auto"
  }

  // Regular can be negated
  "The Mať verb negated" should "be in the negative" in {
    Slovník.Mať(podmet = Seq(Ja()), directPredmet = Some(Slovník.Auto()), záporný = true).asText shouldEqual "ja nemám auto"
  }

  // Byť can be negated
  "The Byť verb negated" should "be in the negative" in {
    Slovník.Byť(podmet = Seq(Ja()), príslovka = Some("tu"), záporný = true).asText shouldEqual "ja tu nie som"
  }

  // Byť can be a copula 
  "The Byť verb" should "connect a subject to a predicate adjective" in {
    Slovník.Byť(podmet = Seq(Ja()), prísudok = Some(Slovník.Dobrý)).asText shouldEqual "ja som dobrý"
  }

  // Type 11 verbs follow "pracuvať" - "pracujem"
  "The Potrebovať object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Potrebovať(podmet = Seq(Ja())).asText shouldEqual "ja potrebujem"
  }


  // Type 12 verbs follow "robiť" - "robím"
  "The Robiť object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Robiť(podmet = Seq(Ty(Množné))).asText shouldEqual "vy robíte"
  }
  // Type 12 verbs must conjugate in accordance with the rhythmic rule
  "The Obrátiť object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Obrátiť(podmet = Seq(Ty(Množné))).asText shouldEqual "vy obrátite"
  }

  // Type 13 verbs follow "vidieť" - "vidím"
  "The Vidieť object without podmet noun" should "generate the infinitive" in {
    Slovník.Vidieť().asText shouldEqual "vidieť"
  }
  "The Vidieť object with a 1st/male/singular podmet pronoun" should "return the first person singular" in {
    Slovník.Vidieť(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja vidím"
  }
  "The Vidieť object with a 2nd/male/singular podmet pronoun" should "return the second person singular" in {
    Slovník.Vidieť(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty vidíš"
  }
  "The Vidieť object with a 1st/male/plural podmet pronoun" should "return the first person plural" in {
    Slovník.Vidieť(podmet = Seq(Ja(Množné))).asText shouldEqual "my vidíme"
  }
  "The Vidieť object with a 2nd/male/plural podmet pronoun" should "return the second person plural" in {
    Slovník.Vidieť(podmet = Seq(Ty(Množné))).asText shouldEqual "vy vidíte"
  }
  "The Vidieť object with a 3rd/male/singular podmet pronoun" should "return the third person male singular" in {
    Slovník.Vidieť(podmet = Seq(On(Jednotné))).asText shouldEqual "on vidí"
  }
  "The Vidieť object with a 3rd/female/singular podmet pronoun" should "return the third person female singular" in {
    Slovník.Vidieť(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona vidí"
  }
  "The Vidieť object with a 3rd/neuter/singular podmet pronoun" should "return the third person neuter singular" in {
    Slovník.Vidieť(podmet = Seq(To(Jednotné))).asText shouldEqual "to vidí"
  }
  "The Vidieť object with a 3rd/neuter/plural podmet pronoun" should "return the third person plural" in {
    Slovník.Vidieť(podmet = Seq(To(Množné))).asText shouldEqual "oni vidia"
  }


}
