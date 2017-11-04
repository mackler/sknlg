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
    val Mužský, Ženský, Stredný = Value
  }

  object Pád extends Enumeration {
    type Pád = Value
    val Nominative, Accusative  = Value
  }

}
