package org.mackler

package object sknlg {

  // Contant enumerations

  object Person extends Enumeration {
    type Person = Value
    val First, Second, Third  = Value
  }

  object Number extends Enumeration {
    type Number = Value
    val Singular, Plural = Value
  }

  object Gender extends Enumeration {
    type Gender = Value
    val Male, Female, Neuter = Value
  }

  // Case
  object Case extends Enumeration {
    type Case = Value
    val Nominative, Accusative  = Value
  }

}
