package org.mackler.sknlg

import Rod._
import Čislo._
import org.scalatest._

class ByťSpec extends FlatSpec with Matchers {

  /*
   * Byť, "to be" is an irregular verb
   */

  "The Byť object without subject noun" should "generate the infinitive" in {
    Slovník.Byť().asText shouldEqual "byť"
  }

  "The Byť object with a 1st/male/singular subject pronoun" should "return the first person singular" in {
    Slovník.Byť(podmet = Seq(Ja(Jednotné))).asText shouldEqual "ja som"
  }

  "The Byť object with a 1st/male/plural subject pronoun" should "return the first person plural" in {
    Slovník.Byť(podmet = Seq(Ja(Množné))).asText shouldEqual "my sme"
  }

  "The Byť object with a 2nd/male/singular subject pronoun" should "return the second person singular" in {
    Slovník.Byť(podmet = Seq(Ty(Jednotné))).asText shouldEqual "ty si"
  }

  "The Byť object with a 2nd/male/plural subject pronoun" should "return the second person plural" in {
    Slovník.Byť(podmet = Seq(Ty(Množné))).asText shouldEqual "vy ste"
  }

  "The Byť object with a 3nd/male/singular subject pronoun" should "return the third person male singular" in {
    Slovník.Byť(podmet = Seq(On(Jednotné))).asText shouldEqual "on je"
  }

  "The Byť object with a 3rd/male/plural subject pronoun" should "return the third person male plural" in {
    Slovník.Byť(podmet = Seq(On(Množné))).asText shouldEqual "oni sú"
  }

  "The Byť object with a 3rd/female/singular subject pronoun" should "return the third person female singular" in {
    Slovník.Byť(podmet = Seq(Ona(Jednotné))).asText shouldEqual "ona je"
  }

  "The Byť object with a 3rd/neutar/singular subject pronoun" should "return the third person neuter singular" in {
    Slovník.Byť(podmet = Seq(To(Jednotné))).asText shouldEqual "to je"
  }

  "The Byť object with a 3rd/neuter/plural subject pronoun" should "return the third person neuter plural" in {
    Slovník.Byť(podmet = Seq(To(Množné))).asText shouldEqual "ony sú"
  }

  // Byť can be negated
  "The Byť verb negated" should "be in the negative" in {
    Slovník.Byť(podmet = Seq(Ja()), príslovka = Some("tu"), záporný = true).asText shouldEqual "ja tu nie som"
  }

  /*
   *  Byť can be a copula, in which case it links a subject noun-phase to a complement noun-phrases
   *  A noun phrase can be: a common-noun, proper-noun, pronoun, adjective, or demonstrative.
   *  Moreover, the subject noun phrase can consist of one or more of the preceding things.
   */

  // When performing as a copula, Byť can have a subject that is a demonstrative pronoun
/*  "The Byť verb as a copula" should "match declination of a demonstrative pronoun subject and predicate noun" in {
    Slovník.Byť prísudok Some(Slovník.Rieka) setPodmet Slovník.Tento asText() shouldEqual "táto je rieka"
  }*/

  // New tests (as of Nov 14, 2017) start here

  // pronoun <-> common noun

  // subject is a 1st person pronoun, complement a single common noun
  // I AM A TEACHER
  "The Byť verb" should "connect a 1st person subject pronoun to a singular common noun" in {
    (Slovník.Byť() addPodmet Ja() setComplement Slovník.Učiteľ() asText) shouldEqual "ja som učiteľ"
  }
  // subject is a 2nd person pronoun, complement a single common noun
  // YOU ARE A TEACHER
  "The Byť verb" should "connect a 2nd person subject pronoun to a singular common noun" in {
    (Slovník.Byť() addPodmet Ty() setComplement Slovník.Učiteľ() asText) shouldEqual "ty si učiteľ"
  } 
  // subject is a 3rd person pronoun, complement a single common noun
  // HE IS A TEACHER
  "The Byť verb" should "connect a 3rd person subject pronoun to a singular common noun" in {
    (Slovník.Byť() addPodmet On() setComplement Slovník.Učiteľ() asText) shouldEqual "on je učiteľ"
  }
  // subject is a 1st person pronoun, complement a plural common noun
  // WE (M) ARE TEACHERS
  "The Byť verb" should "connect a 1st person subject pronoun to a plural common noun" in {
    (Slovník.Byť() addPodmet Ja() setComplement Slovník.Učiteľ(čislo = Množné) asText) shouldEqual "my sme učiteľi"
  }
  // subject is a 2nd person pronoun, complement a plural common noun
  // YOU ALL (M) ARE TEACHERS
  "The Byť verb" should "connect a 2nd person subject pronoun to a plural common noun" in {
    (Slovník.Byť() addPodmet Ty() setComplement Slovník.Učiteľ(čislo = Množné) asText) shouldEqual "vy ste učiteľi"
  } 
  // subject is a 3rd person pronoun, complement a plural common noun
  // THEY (M) ARE TEACHERS
  "The Byť verb" should "connect a plural 3rd person subject pronoun to a plural common noun" in {
    (Slovník.Byť() addPodmet On() setComplement Slovník.Učiteľ(čislo = Množné) asText) shouldEqual "oni sú učiteľi"
  }

  // demonstrative <-> common noun

  // subject is a demonstrative pronoun, complement a singular masculine common noun
  // THAT IS A CASTLE
  "The Byť verb" should "connect a demonstrative subject pronoun to a masculine singular common noun" in {
    (Slovník.Byť() addPodmet Ten setComplement Slovník.Hrad() asText) shouldEqual "ten je hrad"
  }
  // subject is a demonstrative pronoun, complement a singular feminine common noun
  // THAT IS A WOMAN
  "The Byť verb" should "connect a demonstrative subject pronoun to a singular feminine common noun" in {
    (Slovník.Byť() addPodmet Ten setComplement Slovník.Žena() asText) shouldEqual "tá je žena"
  }
  // subject is a demonstrative pronoun, complement a singular neuter common noun
  // THAT IS A TOWN
  "The Byť verb" should "connect a demonstrative subject pronoun to a singular neuter common noun" in {
    (Slovník.Byť() addPodmet Ten setComplement Slovník.Mesto() asText) shouldEqual "to je mesto"
  }
  // subject is a demonstrative pronoun, complement a plural masculine common noun
  // THOSE ARE CASTLES
  "The Byť verb" should "connect a demonstrative subject pronoun to a masculine plural common noun" in {
    (Slovník.Byť() addPodmet Ten setComplement Slovník.Hrad(čislo = Množné) asText) shouldEqual "tie sú hrady"
  }
  // subject is a demonstrative pronoun, complement a plural feminine common noun
  // THOSE ARE WOMEN
  "The Byť verb" should "connect a demonstrative subject pronoun to a plural feminine common noun" in {
    (Slovník.Byť() addPodmet Ten setComplement Slovník.Žena(čislo = Množné) asText) shouldEqual "tie sú ženy"
  }
  // subject is a demonstrative pronoun, complement a plural neuter common noun
  // THOSE ARE TOWNS
  "The Byť verb" should "connect a demonstrative subject pronoun to a plural neuter common noun" in {
    (Slovník.Byť() addPodmet Ten setComplement Slovník.Mesto(čislo = Množné) asText) shouldEqual "tie sú mestá"
  }

  // proper noun(s) <-> common noun
  val igor = Pomenovanie("Igor", MužskýŽivotný)
  val peter = Pomenovanie("Peter", MužskýŽivotný)

  // subject is a proper noun, complement a masculine common noun
  // IGOR IS A TEACHER
  "The Byť verb" should "connect a proper noun to a masculine singular common noun" in {
    (Slovník.Byť() addPodmet igor setComplement Slovník.Učiteľ() asText) shouldEqual "Igor je učiteľ"
  }
  // subject is two proper nouns, complement a masculine common noun
  // IGOR AND PETER ARE TEACHERS
  "The Byť verb" should "connect two proper nouns to a masculine common noun" in {
    (Slovník.Byť() addPodmet igor addPodmet peter setComplement Slovník.Učiteľ() asText) shouldEqual "Igor a Peter sú učiteľi"
  }

  // proper noun + pronoun <-> common noun

  // subject is proper nouns + 1st per pronoun, complement a masculine common noun
  // IGOR AND I ARE TEACHERS
  "The Byť verb" should "connect a proper nouns plus 1st per pronoun to a masculine common noun" in {
    (Slovník.Byť() addPodmet igor addPodmet Ja() setComplement Slovník.Učiteľ() asText) shouldEqual "Igor a ja sme učiteľi"
  }
  // subject is proper nouns + 2nd per pronoun, complement a masculine common noun
  // IGOR AND YOU ARE TEACHERS
  "The Byť verb" should "connect a proper nouns plus 2nd per pronoun to a masculine common noun" in {
    (Slovník.Byť() addPodmet igor addPodmet Ty() setComplement Slovník.Učiteľ() asText) shouldEqual "Igor a ty ste učiteľi"
  }

  // common-noun <-> adjective

  // subject is singular masculine animate common noun, complement an adjective
  // THE MAN IS TALL
  "The Byť verb" should "connect a singular masculine-animate common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Muž() setComplement Slovník.Vysoký asText) shouldEqual "muž je vysoký"
  }
  // subject is plural masculine animate common noun, complement an adjective
  // THE MEN ARE TALL
  "The Byť verb" should "connect a plural masculine-animate common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Muž(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "muži sú vysokí"
  }
  // subject is singular masculine inanimate common noun, complement an adjective
  // THE FENCE IS TALL
  "The Byť verb" should "connect a singular masculine-inanimate common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Plot() setComplement Slovník.Vysoký asText) shouldEqual "plot je vysoký"
  }
  // subject is plural masculine inanimate common noun, complement an adjective
  // THE FENCES ARE TALL
  "The Byť verb" should "connect a plural masculine-inanimate common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Plot(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "ploty sú vysoké"
  }
  // subject is singular feminine common noun, complement an adjective
  // THE WOMAN IS TALL
  "The Byť verb" should "connect a singular feminine common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Žena() setComplement Slovník.Vysoký asText) shouldEqual "žena je vysoká"
  }
  // subject is plural feminine common noun, complement an adjective
  // THE WOMEN ARE TALL
  "The Byť verb" should "connect a plural feminine common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Žena(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "ženy sú vysoké"
  }
  // subject is singular neuter common noun, complement an adjective
  // THE TOWN IS TALL
  "The Byť verb" should "connect a singular neuter common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Mesto() setComplement Slovník.Vysoký asText) shouldEqual "mesto je vysoké"
  }
  // subject is plural neuter inanimate common noun, complement an adjective
  // THE TOWNS ARE TALL
  "The Byť verb" should "connect a plural neuter common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Mesto(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "mestá sú vysoké"
  }
  // Two masculine subjects, one animate the other not, complement an adjective
  // THE MAN AND THE CASTLE ARE TALL
  "The Byť verb" should "connect a masculine-animate common noun and masculine inanimate common noun to a adjective" in {
    (Slovník.Byť() addPodmet Slovník.Muž() addPodmet Slovník.Hrad() setComplement Slovník.Vysoký asText) shouldEqual "muž a hrad sú vysokí"
  }

  // (common-noun <-> adverb

  // subject is singular masculine animate common noun, complement an adverb
  // THE MAN IS HERE
  "The Byť verb" should "connect a singular masculine-animate common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Muž() setComplement Príslovka("tu") asText) shouldEqual "muž je tu"
  }
  // subject is plural masculine animate common noun, complement an adverb
  // THE MEN ARE HERE
  "The Byť verb" should "connect a plural masculine-animate common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Muž(čislo = Množné) setComplement Príslovka("tu") asText) shouldEqual "muži sú tu"
  }
  // subject is singular masculine inanimate common noun, complement an adverb
  // THE FENCE IS HERE
  "The Byť verb" should "connect a singular masculine-inanimate common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Plot() setComplement Príslovka("tu") asText) shouldEqual "plot je tu"
  }
  // subject is plural masculine inanimate common noun, complement an adverb
  // THE FENCES ARE HERE
  "The Byť verb" should "connect a plural masculine-inanimate common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Plot(čislo = Množné) setComplement Príslovka("tu") asText) shouldEqual "ploty sú tu"
  }
  // subject is singular feminine common noun, complement an adverb
  // THE WOMAN IS HERE
  "The Byť verb" should "connect a singular feminine common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Žena() setComplement Príslovka("tu") asText) shouldEqual "žena je tu"
  }
  // subject is plural feminine common noun, complement an adverb
  // THE WOMEN ARE HERE
  "The Byť verb" should "connect a plural feminine common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Žena(čislo = Množné) setComplement Príslovka("tu") asText) shouldEqual "ženy sú tu"
  }
  // subject is singular neuter common noun, complement an adverb
  // THE TOWN IS HERE
  "The Byť verb" should "connect a singular neuter common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Mesto() setComplement Príslovka("tu") asText) shouldEqual "mesto je tu"
  }
  // subject is plural neuter inanimate common noun, complement an adverb
  // THE TOWNS ARE HERE
  "The Byť verb" should "connect a plural neuter common noun to a adverb" in {
    (Slovník.Byť() addPodmet Slovník.Mesto(čislo = Množné) setComplement Príslovka("tu") asText) shouldEqual "mestá sú tu"
  }

  // pronoun <-> adjective
  // I (M) AM TALL
  "The Byť verb" should "connect a 1st per singular pronoun to an adjective" in {
    (Slovník.Byť() addPodmet Ja() setComplement Slovník.Vysoký asText) shouldEqual "ja som vysoký"
  }
  // YOU (M) ARE TALL
  "The Byť verb" should "connect a 2nd per singular pronoun to an adjective" in {
    (Slovník.Byť() addPodmet Ty() setComplement Slovník.Vysoký asText) shouldEqual "ty si vysoký"
  }
  // HE IS TALL
  "The Byť verb" should "connect a 3rd per singular masculine pronoun to an adjective" in {
    (Slovník.Byť() addPodmet On() setComplement Slovník.Vysoký asText) shouldEqual "on je vysoký"
  }
  // SHE IS TALL
  "The Byť verb" should "connect a 3rd per singular feminine pronoun to an adjective" in {
    (Slovník.Byť() addPodmet Ona() setComplement Slovník.Vysoký asText) shouldEqual "ona je vysoká"
  }
  // WE (M) ARE TALL
  "The Byť verb" should "connect a 1st per plural pronoun to an adjective" in {
    (Slovník.Byť() addPodmet Ja(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "my sme vysokí"
  }
  // YOU ALL ARE TALL
  "The Byť verb" should "connect a 2nd per plural pronoun to an adjective" in {
    (Slovník.Byť() addPodmet Ty(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "vy ste vysokí"
  }
  // THEY (M) ARE TALL
  "The Byť verb" should "connect a 3rd per singular masculine pronoun to a adjective" in {
    (Slovník.Byť() addPodmet On(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "oni sú vysokí"
  }
  // THEY (F) ARE TALL
  "The Byť verb" should "connect a 3rd per singular feminine pronoun to a adjective" in {
    (Slovník.Byť() addPodmet Ona(čislo = Množné) setComplement Slovník.Vysoký asText) shouldEqual "ony sú vysoké"
  }

}
