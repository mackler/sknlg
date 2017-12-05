package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class PrídavnéMenoSpec extends FlatSpec with Matchers {

  "A prídavnéMeno referring to a masculine noun" should "generate the masculine prídavnéMeno" in {
    (slovník.Kufor setPrídavnéMeno slovník.Pekný).asText() shouldEqual "pekný kufor"
  }

  "A prídavnéMeno referring to a feminine noun" should "generate the feminine prídavnéMeno" in {
    (slovník.Rieka setPrídavnéMeno slovník.Pekný asText()) shouldEqual "pekná rieka"
  }

  "A prídavnéMeno referring to a neuter noun" should "generate the neuter prídavnéMeno" in {
    (slovník.Auto setPrídavnéMeno slovník.Pekný).asText() shouldEqual "pekné auto"
  }

  "An long-syllable adjective referring to a masculine noun" should "generate the masculine masculine adjective" in {
    (slovník.Kufor setPrídavnéMeno slovník.Krázny).asText() shouldEqual "krázny kufor"
  }

  "A prídavnéMeno referring to a feminine noun" should "generate the feminine prídavnéMeno without two long vowels in a row" in {
    (slovník.Rieka setPrídavnéMeno slovník.Krázny asText()) shouldEqual "krázna rieka"
  }

  "A prídavnéMeno referring to a neuter noun" should "generate the neuter prídavnéMeno without two long vowels in a row" in {
    (slovník.Auto setPrídavnéMeno slovník.Krázny).asText() shouldEqual "krázne auto"
  }

  "A one-sylable prídavnéMeno referring to a neuter noun" should "generate the neuter prídavnéMeno" in {
    (slovník.Auto setPrídavnéMeno slovník.Zlý).asText() shouldEqual "zlé auto"
  }

  "An adjective with a root ending in a long syllable" should "obey the rhythmic rule in the nominative case" in {
    slovník.Kniha setPrídavnéMeno slovník.Nízky asText() shouldEqual "nízka kniha"
  }

  // Combinations of gender, number & case

  // Singular: Nominative Case, Masculine-animate
  "An adjective" should "decline in the male-animate-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Nominatív) shouldEqual "pekný"
  }
  // Singular: Accusative Case, Masculine-animate
  "An adjective" should "decline in the male-animate-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Akusatív) shouldEqual "pekného"
  }
  // Singular: Nominative Case, Masculine-inanimate
  "An adjective" should "decline in the male-inanimate-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Nominatív) shouldEqual "pekný"
  }
  // Singular: Accusative Case, Masculine-inanimate
  "An adjective" should "decline in the male-inanimate-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Akusatív) shouldEqual "pekný"
  }
  // Singular: Nominative Case, Feminine
  "An adjective" should "decline in the feminine-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Nominatív) shouldEqual "pekná"
  }
  "An adjective" should "decline in the feminine-gender, singular-number, genitive-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Genitív) shouldEqual "peknej"
  }
  // Singular: Accusative Case, Feminine
  "An adjective" should "decline in the feminine-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Akusatív) shouldEqual "peknú"
  }
  // Singular: Nominative Case, Neuter
  "An adjective" should "decline in the neuter-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Jednotné, pád = Nominatív) shouldEqual "pekné"
  }
  // Singular: Accusative Case, Neuter
  "An adjective" should "decline in the neuter-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Jednotné, pád = Akusatív) shouldEqual "pekné"
  }
  // Plural: Nominative Case, Masucine-animate
  "An adjective" should "decline in the male-animate-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Množné, pád = Nominatív) shouldEqual "pekní"
  }
  // Plural: Accusative Case, Masculine-animate
  "An adjective" should "decline in the male-animate-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Množné, pád = Akusatív) shouldEqual "pekných"
  }
  // Plural: Nominative Case, masculine-inanimate
  "An adjective" should "decline in the male-inanimate-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Množné, pád = Nominatív) shouldEqual "pekné"
  }
  // Plural: Accusative Case, masculine-inanimate
  "An adjective" should "decline in the male-inanimate-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Množné, pád = Akusatív) shouldEqual "pekné"
  }
  // Plural: Nominative Case, feminine gender
  "An adjective" should "decline in the feminine-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Množné, pád = Nominatív) shouldEqual "pekné"
  }
  // Plural: Accusative Case, feminine gender
  "An adjective" should "decline in the feminine-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Množné, pád = Akusatív) shouldEqual "pekné"
  }
  // Plural: Nominative Case, Other than masculine-animate:
  "An adjective" should "decline in the neuter-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Množné, pád = Nominatív) shouldEqual "pekné"
  }
  // Plural: Accusative Case, Other than masculine-animate
  "An adjective" should "decline in the neuter-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Množné, pád = Akusatív) shouldEqual "pekné"
  }

  // same as above, but with an adjective whose stem ends with a long syllable

  // Singular: Nominative Case, Masculine-animate
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Nominatív) shouldEqual "nízky"
  }
  // Singular: Accusative Case, Masculine-animate
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Akusatív) shouldEqual "nízkeho"
  }
  // Singular: Nominative Case, Masculine-inanimate
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Nominatív) shouldEqual "nízky"
  }
  // Singular: Accusative Case, Masculine-inanimate
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Akusatív) shouldEqual "nízky"
  }
  // Singular: Nominative Case, Feminine
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Jednotné, pád = Nominatív) shouldEqual "nízka"
  }
  // Singular: Accusative Case, Feminine
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Jednotné, pád = Akusatív) shouldEqual "nízku"
  }
  // Singular: Nominative Case, Neuter
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Jednotné, pád = Nominatív) shouldEqual "nízke"
  }
  // Singular: Accusative Case, Neuter
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Jednotné, pád = Akusatív) shouldEqual "nízke"
  }
  // Plural: Nominative Case, Masucine-animate
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Množné, pád = Nominatív) shouldEqual "nízki"
  }
  // Plural: Accusative Case, Masculine-animate
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Množné, pád = Akusatív) shouldEqual "nízkych"
  }
  // Plural: Nominative Case, masculine-inanimate
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Množné, pád = Nominatív) shouldEqual "nízke"
  }
  // Plural: Accusative Case, masculine-inanimate
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Množné, pád = Akusatív) shouldEqual "nízke"
  }
  // Plural: Nominative Case, feminine gender
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Množné, pád = Nominatív) shouldEqual "nízke"
  }
  // Plural: Accusative Case, feminine gender
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Množné, pád = Akusatív) shouldEqual "nízke"
  }
  // Plural: Nominative Case, Other than masculine-animate:
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Množné, pád = Nominatív) shouldEqual "nízke"
  }
  // Plural: Accusative Case, Other than masculine-animate
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Množné, pád = Akusatív) shouldEqual "nízke"
  }

}

