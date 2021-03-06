package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class VerbSpec extends FlatSpec with Matchers {

  // Before testing conjugation, we check some characteristics of verb objects
  "Two different verbs" should "not equal each other" in {
    slovník.Robiť should not equal slovník.Chodiť
  }


  // Ísť is irregular

  "The Ísť object without a subject noun" should "generate the infinitive" in {
    slovník.Ísť.asText shouldEqual "ísť"
  }
  "The Ísť object with a singular first person subject noun" should "generate the correct inflection" in {
    (slovník.Ísť addPodmet Ja).asText shouldEqual "ja idem"
  }
  "The Ísť object with a singular second person subject noun" should "generate the correct inflection" in {
    (slovník.Ísť addPodmet Ty).asText shouldEqual "ty ideš"
  }
  "The Ísť object with a singular third person subject noun" should "generate the correct inflection" in {
    (slovník.Ísť addPodmet On).asText shouldEqual "on ide"
  }
  "The Ísť object with a plural first person subject noun" should "generate the correct inflection" in {
    (slovník.Ísť addPodmet (Ja setČislo Množné)).asText shouldEqual "my ideme"
  }
  "The Ísť object with a plural second person subject noun" should "generate the correct inflection" in {
    (slovník.Ísť addPodmet (Ty setČislo Množné)).asText shouldEqual "vy idete"
  }
  "The Ísť object with a plural third person subject noun" should "generate the correct inflection" in {
    (slovník.Ísť addPodmet (On setČislo Množné)).asText shouldEqual "oni idú"
  }


  /*
   * Irregular verb "to know:" vedieť
   */

  "The Vedieť verb without a subject" should "generate the infinitive" in {
    slovník.Vedieť.asText shouldEqual "vedieť"
  }
  "The verb Vedieť" should "conjugate in the first person singular" in {
    (slovník.Vedieť addPodmet Ja asText) shouldEqual "ja viem"
  }
  "The verb Vedieť" should "conjugate in the second person singular" in {
    (slovník.Vedieť addPodmet Ty asText) shouldEqual "ty vieš"
  }
  "The verb Vedieť" should "conjugate in the third person singular" in {
    (slovník.Vedieť addPodmet On asText) shouldEqual "on vie"
  }
  "The verb Vedieť" should "conjugate in the first person plural" in {
    (slovník.Vedieť addPodmet (Ja setČislo Množné) asText) shouldEqual "my vieme"
  }
  "The verb Vedieť" should "conjugate in the second person plural" in {
    (slovník.Vedieť addPodmet (Ty setČislo Množné) asText) shouldEqual "vy viete"
  }
  "The verb Vedieť" should "conjugate in the third person plural" in {
    (slovník.Vedieť addPodmet (On setČislo Množné) asText) shouldEqual "oni vedia"
  }
  "The verb Vedieť negated" should "conjugate in the first person plural" in {
    (slovník.Vedieť addPodmet (Ja setČislo Množné) setZáporný true asText) shouldEqual "my nevieme"
  }

  /*
   * Regular Verbs
   */

  // Mať is a regular verb of Type 1 following "chytať" - "chytám"

  "The Mať verb without a subject" should "generate the infinitive" in {
    slovník.Mať.asText shouldEqual "mať"
  }
  "The verb Mať with a 1st/male/singular subject pronoun" should "return the first person singular" in {
    (slovník.Mať setPodmet Seq(Ja) asText) shouldEqual "ja mám"
  }
  "The verb Mať with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    (slovník.Mať setPodmet Seq(Ty) asText) shouldEqual "ty máš"
  }
  "The verb Mať with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    (slovník.Mať setPodmet Seq((Ja setČislo Množné)) asText) shouldEqual "my máme"
  }
  "The verb Mať with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    (slovník.Mať setPodmet Seq((Ty setČislo Množné)) asText) shouldEqual "vy máte"
  }
  "The verb Mať with a 3rd/male/singular subject pronoun" should "return the third person male singular" in {
    (slovník.Mať setPodmet Seq(On) asText) shouldEqual "on má"
  }
  "The verb Mať with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    (slovník.Mať setPodmet Seq(Ona) asText) shouldEqual "ona má"
  }
  "The verb Mať with a 3rd/neuter/singular subject pronoun" should "return the third person neuter singular" in {
    (slovník.Mať setPodmet Seq(To) asText) shouldEqual "to má"
  }
  "The verb Mať with a 3rd/neuter/plural subject pronoun" should "return the third person plural" in {
    (slovník.Mať setPodmet Seq((To setČislo Množné)) asText) shouldEqual "ony majú"
  }

  // A verb can be negated
  // ...by toggling
  "The verb Mať constructed with a 1st/male/plural subject pronoun" should "be negatable" in {
    (slovník.Mať setPodmet Seq((Ja setČislo Množné)) toggleZáporný() asText) shouldEqual "my nemáme"
  }
  "The verb Mať with a 1st/male/plural subject pronoun added" should "be negatable by toggle" in {
    slovník.Mať.addPodmet((Ja setČislo Množné)).toggleZáporný().asText shouldEqual "my nemáme"
  }
  "The verb Mať with a 3rd/male/singular subject pronoun" should "be negatable" in {
    (slovník.Mať setPodmet Seq(On) toggleZáporný() asText) shouldEqual "on nemá"
  }
  // ...and by setting
  "The verb Mať with a 1st/male/plural subject pronoun added" should "be negatable by setting" in {
    // note: true means negate it
    slovník.Mať.addPodmet((Ja setČislo Množné)).setZáporný(true).asText shouldEqual "my nemáme"
  }
  "The negated Mať object with a 1st/male/plural subject pronoun added" should "be un-negatable by setting" in {
    // note: false means the verb is in the affirmative
    (slovník.Mať addPodmet (Ja setČislo Množné) toggleZáporný() setZáporný(false) asText) shouldEqual "my máme"
  }

  // Transitive Verbs can have a direct object
  "The verb Mať 1st/sing with a direct object" should "return the correct text" in {
    (slovník.Mať setPodmet Seq(Ja) setPredmet slovník.Auto asText) shouldEqual "ja mám auto"
  }
  "The verb Mať 1st/plur with a direct object" should "return the correct text" in {
    (slovník.Mať setPodmet Seq((Ja setČislo Množné)) setPredmet slovník.Auto asText) shouldEqual "my máme auto"
  }

  // Verbs with a long vowel in the final syllable of their root have short vowels in their inflections
  "The Bývať object with a 1st/male/singular subject pronoun" should "return the first person singular" in {
    (slovník.Bývať setPodmet Seq(Ja) asText) shouldEqual "ja bývam"
  }
  "The Bývať object with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    (slovník.Bývať setPodmet Seq(Ty) asText) shouldEqual "ty bývaš"
  }
  "The Bývať object with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    (slovník.Bývať setPodmet Seq((Ja setČislo Množné)) asText) shouldEqual "my bývame"
  }
  "The Bývať object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    (slovník.Bývať setPodmet Seq((Ty setČislo Množné)) asText) shouldEqual "vy bývate"
  }
  "The Bývať object with a 3rd/male/singular subject pronoun" should "return the third person male singular" in {
    (slovník.Bývať setPodmet Seq(On) asText) shouldEqual "on býva"
  }
  "The Bývať object with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    (slovník.Bývať setPodmet Seq(Ona) asText) shouldEqual "ona býva"
  }
  "The Bývať object with a 3rd/neuter/singular subject pronoun" should "return the third person neuter singular" in {
    (slovník.Bývať setPodmet Seq(To) asText) shouldEqual "to býva"
  }
  "The Bývať object with a 3rd/neuter/plural subject pronoun" should "return the third person plural" in {
    (slovník.Bývať setPodmet Seq((To setČislo Množné)) asText) shouldEqual "ony bývajú"
  }

  // Intransitive Verb subjects may consist of multiple nouns
  "The Čakať verb with a subject of two proper nouns" should "conjugate as the third person plural" in {
    (slovník.Čakať setPodmet Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný)) asText) shouldEqual "Igor a Peter čakajú"
  }

  // Transitive Verb subjects may consist of multiple nouns
  "The Mať verb with a subject of two proper nouns" should "conjugate as the third person plural" in {
    (slovník.Mať setPodmet Seq(Pomenovanie("Igor", MužskýŽivotný), Pomenovanie("Peter", MužskýŽivotný))
       setPredmet slovník.Auto asText) shouldEqual "Igor a Peter majú auto"
  }

  // Regular verbs can be negated
  "The Mať verb negated" should "be in the negative" in {
    (slovník.Mať setPodmet Seq(Ja) setPredmet slovník.Auto setZáporný true asText) shouldEqual "ja nemám auto"
  }

  /*
   * other regular paradigms
   */

  // Type 1 verbs follow "chytať" - "chytám"
  "A long-final-syllable type-1 verb without a subject" should "generate the infinitive" in {
    slovník.Počúvať.asText shouldEqual "počúvať"
  }
  "A long-final-syllable type-1 verb with a 1st/male/singular subject" should "conjugate the first person singular" in {
    slovník.Počúvať.setPodmet(Seq(Ja)).asText shouldEqual "ja počúvam"
  }
  "A long-final-syllable type-1 verb with a 2nd/male/singular subject" should "conjugate the second person singular" in {
    slovník.Počúvať.setPodmet(Seq(Ty)).asText shouldEqual "ty počúvaš"
  }
  "A long-final-syllable type-1 verb with a 3rd/male/singular subject" should "conjugate the third person singular" in {
    slovník.Počúvať.setPodmet(Seq(On)).asText shouldEqual "on počúva"
  }
  "A long-final-syllable type-1 verb with a 3rd/female/singular subject" should "conjugate the third person singular" in {
    slovník.Počúvať.setPodmet(Seq(Ona)).asText shouldEqual "ona počúva"
  }
  "A long-final-syllable type-1 verb with a 3rd/neuter/singular subject" should "conjugate the third person singular" in {
    slovník.Počúvať.setPodmet(Seq(To)).asText shouldEqual "to počúva"
  }
  "A long-final-syllable type-1 verb with a 1st/male/plural subject" should "conjugate the first person plural" in {
    slovník.Počúvať.setPodmet(Seq((Ja setČislo Množné))).asText shouldEqual "my počúvame"
  }
  "A long-final-syllable type-1 verb with a 2nd/male/plural subject" should "conjugate the second person plural" in {
    slovník.Počúvať.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy počúvate"
  }
  "A long-final-syllable type-1 verb with a 3rd/neuter/plural subject" should "conjugate the third person plural" in {
    slovník.Počúvať.setPodmet(Seq((To setČislo Množné))).asText shouldEqual "ony počúvajú"
  }

  "A dipthong-final-syllable type-1 verb without a subject" should "generate the infinitive" in {
    slovník.Spievať.asText shouldEqual "spievať"
  }
  "A dipthong-final-syllable type-1 verb with a 1st/male/singular subject" should "conjugate the first person singular" in {
    slovník.Spievať.setPodmet(Seq(Ja)).asText shouldEqual "ja spievam"
  }
  "A dipthong-final-syllable type-1 verb with a 2nd/male/singular subject" should "conjugate the second person singular" in {
    slovník.Spievať.setPodmet(Seq(Ty)).asText shouldEqual "ty spievaš"
  }
  "A dipthong-final-syllable type-1 verb with a 3rd/male/singular subject" should "conjugate the third person singular" in {
    slovník.Spievať.setPodmet(Seq(On)).asText shouldEqual "on spieva"
  }
  "A dipthong-final-syllable type-1 verb with a 3rd/female/singular subject" should "conjugate the third person singular" in {
    slovník.Spievať.setPodmet(Seq(Ona)).asText shouldEqual "ona spieva"
  }
  "A dipthong-final-syllable type-1 verb with a 3rd/neuter/singular subject" should "conjugate the third person singular" in {
    slovník.Spievať.setPodmet(Seq(To)).asText shouldEqual "to spieva"
  }
  "A dipthong-final-syllable type-1 verb with a 1st/male/plural subject" should "conjugate the first person plural" in {
    slovník.Spievať.setPodmet(Seq((Ja setČislo Množné))).asText shouldEqual "my spievame"
  }
  "A dipthong-final-syllable type-1 verb with a 2nd/male/plural subject" should "conjugate the second person plural" in {
    slovník.Spievať.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy spievate"
  }
  "A dipthong-final-syllable type-1 verb with a 3rd/neuter/plural subject" should "conjugate the third person plural" in {
    slovník.Spievať.setPodmet(Seq((To setČislo Množné))).asText shouldEqual "ony spievajú"
  }

  // Type 1 verbs follow "chytať" - "chytám"
  "A type-6 verb without a subject" should "generate the infinitive" in {
    slovník.Brať.asText shouldEqual "brať"
  }
  "A type-6 verb with a 1st/male/singular subject" should "conjugate the first person singular" in {
    slovník.Brať.setPodmet(Seq(Ja)).asText shouldEqual "ja beriem"
  }
  "A type-6 verb with a 2nd/male/singular subject" should "conjugate the second person singular" in {
    slovník.Brať.setPodmet(Seq(Ty)).asText shouldEqual "ty berieš"
  }
  "A type-6 verb with a 3rd/male/singular subject" should "conjugate the third person singular" in {
    slovník.Brať.setPodmet(Seq(On)).asText shouldEqual "on berie"
  }
  "A type-6 verb with a 3rd/female/singular subject" should "conjugate the third person singular" in {
    slovník.Brať.setPodmet(Seq(Ona)).asText shouldEqual "ona berie"
  }
  "A type-6 verb with a 3rd/neuter/singular subject" should "conjugate the third person singular" in {
    slovník.Brať.setPodmet(Seq(To)).asText shouldEqual "to berie"
  }
  "A type-6 verb with a 1st/male/plural subject" should "conjugate the first person plural" in {
    slovník.Brať.setPodmet(Seq((Ja setČislo Množné))).asText shouldEqual "my berieme"
  }
  "A type-6 verb with a 2nd/male/plural subject" should "conjugate the second person plural" in {
    slovník.Brať.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy beriete"
  }
  "A type-6 verb with a 3rd/neuter/plural subject" should "conjugate the third person plural" in {
    slovník.Brať.setPodmet(Seq((To setČislo Množné))).asText shouldEqual "ony berú"
  }

  // Type 11 verbs follow "pracuvať" - "pracujem"
  "The Potrebovať verb" should "conjugate with a 1st person single subject pronoun" in {
    (slovník.Potrebovať setPodmet Seq(Ja) asText) shouldEqual "ja potrebujem"
  }


  // Type 12 verbs follow "robiť" - "robím"
  "A type-12 verb without podmet noun" should "generate the infinitive" in {
    slovník.Robiť.asText shouldEqual "robiť"
  }
  "A type-12 verb with a 1st/male/singular subject pronoun" should "conjugate the first person singular" in {
    slovník.Robiť.setPodmet(Seq(Ja)).asText shouldEqual "ja robím"
  }
  "A type-12 verb with a 2nd/male/singular subject pronoun" should "conjugate the second person singular" in {
    slovník.Robiť.setPodmet(Seq(Ty)).asText shouldEqual "ty robíš"
  }
  "A type-12 verb with a 3rd/male/singular subject pronoun" should "conjugate the third person male singular" in {
    slovník.Robiť.setPodmet(Seq(On)).asText shouldEqual "on robí"
  }
  "A type-12 verb with a 3rd/female/singular subject pronoun" should "conjugate the third person female singular" in {
    slovník.Robiť.setPodmet(Seq(Ona)).asText shouldEqual "ona robí"
  }
  "A type-12 verb with a 3rd/neuter/singular subject pronoun" should "conjugate the third person neuter singular" in {
    slovník.Robiť.setPodmet(Seq(To)).asText shouldEqual "to robí"
  }
  "A type-12 verb with a 1st/male/plural subject pronoun" should "conjugate the first person plural" in {
    slovník.Robiť.setPodmet(Seq((Ja setČislo Množné))).asText shouldEqual "my robíme"
  }
  "A type-12 verb with a 2nd/male/plural subject pronoun" should "conjugate the second person plural" in {
    slovník.Robiť.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy robíte"
  }
  "A type-12 verb with a 3rd/neuter/plural subject pronoun" should "conjugate the third person plural" in {
    slovník.Robiť.setPodmet(Seq((To setČislo Množné))).asText shouldEqual "ony robia"
  }
  // Type 12 verbs must conjugate in accordance with the rhythmic rule
  "The Obrátiť object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    slovník.Obrátiť.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy obrátite"
  }

  // Type 13 verbs follow "vidieť" - "vidím"
  "The Vidieť object without podmet noun" should "generate the infinitive" in {
    slovník.Vidieť.asText shouldEqual "vidieť"
  }
  "The Vidieť object with a 1st/male/singular subject pronoun" should "return the first person singular" in {
    slovník.Vidieť.setPodmet(Seq(Ja)).asText shouldEqual "ja vidím"
  }
  "The Vidieť object with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    slovník.Vidieť.setPodmet(Seq(Ty)).asText shouldEqual "ty vidíš"
  }
  "The Vidieť object with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    slovník.Vidieť.setPodmet(Seq((Ja setČislo Množné))).asText shouldEqual "my vidíme"
  }
  "The Vidieť object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    slovník.Vidieť.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy vidíte"
  }
  "The Vidieť object with a 3rd/male/singular subject pronoun" should "return the third person male singular" in {
    slovník.Vidieť.setPodmet(Seq(On)).asText shouldEqual "on vidí"
  }
  "The Vidieť object with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    slovník.Vidieť.setPodmet(Seq(Ona)).asText shouldEqual "ona vidí"
  }
  "The Vidieť object with a 3rd/neuter/singular subject pronoun" should "return the third person neuter singular" in {
    slovník.Vidieť.setPodmet(Seq(To)).asText shouldEqual "to vidí"
  }
  "The Vidieť object with a 3rd/neuter/plural subject pronoun" should "return the third person plural" in {
    slovník.Vidieť.setPodmet(Seq((To setČislo Množné))).asText shouldEqual "ony vidia"
  }

  // Type 14 verbs follow kričať
  "A type-14 verb without podmet noun" should "generate the infinitive" in {
    slovník.Kričať.asText shouldEqual "kričať"
  }
  "A type-14 verb with a 1st/male/singular subject pronoun" should "conjugate the first person singular" in {
    slovník.Kričať.setPodmet(Seq(Ja)).asText shouldEqual "ja kričím"
  }
  "A type-14 verb with a 2nd/male/singular subject pronoun" should "conjugate the second person singular" in {
    slovník.Kričať.setPodmet(Seq(Ty)).asText shouldEqual "ty kričíš"
  }
  "A type-14 verb with a 3rd/male/singular subject pronoun" should "conjugate the third person male singular" in {
    slovník.Kričať.setPodmet(Seq(On)).asText shouldEqual "on kričí"
  }
  "A type-14 verb with a 3rd/female/singular subject pronoun" should "conjugate the third person female singular" in {
    slovník.Kričať.setPodmet(Seq(Ona)).asText shouldEqual "ona kričí"
  }
  "A type-14 verb with a 3rd/neuter/singular subject pronoun" should "conjugate the third person neuter singular" in {
    slovník.Kričať.setPodmet(Seq(To)).asText shouldEqual "to kričí"
  }
  "A type-14 verb with a 1st/male/plural subject pronoun" should "conjugate the first person plural" in {
    slovník.Kričať.setPodmet(Seq((Ja setČislo Množné))).asText shouldEqual "my kričíme"
  }
  "A type-14 verb with a 2nd/male/plural subject pronoun" should "conjugate the second person plural" in {
    slovník.Kričať.setPodmet(Seq((Ty setČislo Množné))).asText shouldEqual "vy kričíte"
  }
  "A type-14 verb with a 3rd/neuter/plural subject pronoun" should "conjugate the third person plural" in {
    slovník.Kričať.setPodmet(Seq((To setČislo Množné))).asText shouldEqual "ony kričia"
  }


  /*
   * Verbs must put their associated direct object nouns and adjectives into the accusative case
   */
  // First Singular
  "The Mať verb with an adjective-modified masculine-animate 'chlap' direct object" should "put the noun phrase into singular accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Muž setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekného muža"
  }
  "The Mať verb with an adjective-modified masculine-inanimate 'dub' direct object" should "put the noun phrase into singular accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Hrad setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekný hrad"
  }
  "The Mať verb with an adjective-modified feminine 'žena' direct object" should "put the noun phrase into singular accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Žena setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám peknú ženu"
  }
  "The Mať verb with an adjective-modified feminine 'ulica' direct object" should "put the noun phrase into singular accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Stanica setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám peknú stanicu"
  }
  "The Mať verb with an adjective-modified feminine 'kosť' direct object" should "put the noun phrase into singular accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Vec setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám peknú vec"
  }
  "The Mať verb with an adjective-modified feminine 'mesto' direct object" should "put the noun phrase into singular accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Auto setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekné auto"
  }
  // Then Plural
  "The Mať verb with an adjective-modified masculine-animate 'chlap' direct object" should "put the noun phrase into plural accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Muž setČislo Množné setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekných mužov"
  }
  "The Mať verb with an adjective-modified masculine-inanimate 'dub' direct object" should "put the noun phrase into plural accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Hrad setČislo Množné setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekné hrady"
  }
  "The Mať verb with an adjective-modified feminine 'žena' direct object" should "put the noun phrase into plural accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Žena setČislo Množné setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekné ženy"
  }
  "The Mať verb with an adjective-modified feminine 'ulica' direct object" should "put the noun phrase into plural accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Stanica setČislo Množné setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekné stanice"
  }
  "The Mať verb with an adjective-modified feminine 'kosť' direct object" should "put the noun phrase into plural accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Vec setČislo Množné setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekné veci"
  }
  "The Mať verb with an adjective-modified feminine 'mesto' direct object" should "put the noun phrase into plural accusative case" in {
    (slovník.Mať addPodmet Ja setPredmet (slovník.Auto setČislo Množné setPrídavnéMeno slovník.Pekný) asText) shouldEqual "ja mám pekné autá"
  }

}
