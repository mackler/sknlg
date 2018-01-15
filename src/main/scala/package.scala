package org.mackler

package object sknlg {

  // Constant enumerations

  object Osoba extends Enumeration {
    type Osoba = Value
    val First, Second, Third  = Value
  }

  object Čislo extends Enumeration {
    type Čislo = Value
    val Jednotné, Množné = Value
  }

  object Rod extends Enumeration {
    type Rod = Value
    val MužskýŽivotný, MužskýNeživotný, Ženský, Stredný, Neznámy = Value
  }

  object Pád extends Enumeration {
    type Pád = Value
    val Nominatív, Genitív, Datív, Akusatív, Lokál, Inštrumentál  = Value
  }

  object Skloňovanie extends Enumeration {
    type Skloňovanie = Value
    val Chlap, Hrdina, Dub, Stroj, Žena, Ulica, Dlaň, Kosť, Mesto, Srdce, Vysvedčenie, Dievča = Value
  }

  /* This is a utility function, used when we want to
   *  make the final vowel short if the preceding syllable is long.
   * TODO obviously this will fail with a non-vowel vowel, i.e. 'ŕ' or 'ĺ'
   */
  // this is the first version I wrote.  I doesn't detect dipthongs as long, but
  // I'm leaving it here until I'm sure the regexp version works for all possible cases.
/*  def finalSyllableIsLong(s: String): Boolean = {
    if (s.length <= 1) false // root contains no vowel
    else s.last match {
      case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => false // last syllable in the root is short
      case 'á' | 'é' | 'í' | 'ó' | 'ú' | 'ý' => true
      case _ => finalSyllableIsLong(s.init)
    }
  }*/
  def finalSyllableIsLong(s: String): Boolean = s.matches(".*(i(e|a|u)|[áéíóúý])[^aáäeéiíoóuúyý]+$")

  // supertrait for adjectives, place names and demonstratives
  // TODO need a better name: common nouns decline, but their gender is fixed.
  trait Declines extends NounPhrase {
    def asText(rod: Rod.Value, čislo: Čislo.Value, pád: Pád.Value): String
  }

  trait NounPhrase { def asText(pád: Pád.Value): String }

  implicit def stringToPríslovka(s: String) = Príslovka(s)

  /*
   * If a possessive adjective refers to the subject of a sentence, it takes the reflexive form.
   * This method takes a noun possibly modified by an adjective, and a noun possible a pronoun.
   * If the given adjective is a possessive corresponding to the given pronoun, then change the
   * adjective to the reflexive form.
   */
  import Čislo._
  def reflexivisePossessive(podmet: Seq[NounPhrase], predmet: PodstatnéMeno) = {
    predmet.prídavnéMeno map { prídavnéMeno: PrídavnéMeno =>
      import slovník.{Môj, Náš, Tvoj, Váš, Svoj}
      val adjective: PrídavnéMeno = if (podmet.length == 1) podmet(0) match {
        // TODO get rid of the alternative--we want to check for one one
        case Ja | JaInstance(Jednotné) => if (prídavnéMeno == Môj) Svoj else prídavnéMeno
        case JaInstance(Množné) => if (prídavnéMeno == Náš) Svoj else prídavnéMeno
        case Ty | TyInstance(Jednotné) => if (prídavnéMeno == Tvoj) Svoj else prídavnéMeno
        case TyInstance(Množné) => if (prídavnéMeno == Váš) Svoj else prídavnéMeno
        case _ => prídavnéMeno // subject is neither first nor second person pronoun
      } else prídavnéMeno // more than one subject, trying to be flexive too complicated
      if (adjective != prídavnéMeno) predmet.setPrídavnéMeno(adjective) else predmet
    } getOrElse(predmet)
  }

}
