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
    val MužskýŽivotný, MužskýNeživotný, Ženský, Stredný = Value
  }

  object Pád extends Enumeration {
    type Pád = Value
    val Nominative, Accusative  = Value
  }

  object Skloňovanie extends Enumeration {
    type Skloňovanie = Value
    val Chlap, Hrdina, Dub, Stroj, Žena, Ulica, Dlaň, Kosť, Mesto, Srdce, Vysvedčenie, Dievča = Value
  }

  /* This is a utility function, used when we want to
   *  make the final vowel short if the preceding syllable is long.
   * TODO obviously this will fail with a non-vowel vowel, i.e. 'ŕ' or 'ĺ'
   */
  def finalSyllableIsLong(s: String): Boolean = {
    if (s.length <= 1) false // root contains no vowel
    else s.last match {
      case 'a' | 'e' | 'i' | 'o' | 'u' | 'y' => false // last syllable in the root is short
      case 'á' | 'é' | 'í' | 'ó' | 'ú' | 'ý' => true
      case _ => finalSyllableIsLong(s.init)
    }
  }

}
