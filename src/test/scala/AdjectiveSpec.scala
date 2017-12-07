package org.mackler.sknlg

import Rod._
import Čislo._
import Pád._
import org.scalatest._

class PrídavnéMenoSpec extends FlatSpec with Matchers {

  // Adjectives must be the same case as nouns to which they refer
  "An adjective referring to a masculine noun" should "generate the masculine adjective" in {
    (slovník.Kufor setPrídavnéMeno slovník.Pekný).asText() shouldEqual "pekný kufor"
  }
  "An adjective referring to a feminine noun" should "generate the feminine adjective" in {
    (slovník.Rieka setPrídavnéMeno slovník.Pekný asText()) shouldEqual "pekná rieka"
  }
  "An adjective referring to a neuter noun" should "generate the neuter adjective" in {
    (slovník.Auto setPrídavnéMeno slovník.Pekný).asText() shouldEqual "pekné auto"
  }
  "An long-syllable adjective referring to a masculine noun" should "generate the masculine masculine adjective" in {
    (slovník.Kufor setPrídavnéMeno slovník.Krázny).asText() shouldEqual "krázny kufor"
  }
  "An adjective referring to a feminine noun" should "generate the feminine adjective without two long vowels in a row" in {
    (slovník.Rieka setPrídavnéMeno slovník.Krázny asText()) shouldEqual "krázna rieka"
  }
  "An adjective referring to a neuter noun" should "generate the neuter adjective without two long vowels in a row" in {
    (slovník.Auto setPrídavnéMeno slovník.Krázny).asText() shouldEqual "krázne auto"
  }
  "A one-sylable adjective referring to a neuter noun" should "generate the neuter adjective" in {
    (slovník.Auto setPrídavnéMeno slovník.Zlý).asText() shouldEqual "zlé auto"
  }
  "An adjective with a root ending in a long syllable" should "obey the rhythmic rule in the nominative case" in {
    slovník.Kniha setPrídavnéMeno slovník.Nízky asText() shouldEqual "nízka kniha"
  }

  // If an adjective refers to a noun that becomes an adverb by use of a preposition, such adjective must have the
  // same case as such noun
  "An adjective referring to a masculine noun" should "have the correct case when the noun becomes an adverb" in {
    (slovník.Kvet setPrídavnéMeno slovník.Dobrý predložka "vo" asText) shouldEqual "v dobrom kvete"
  }
  "An adjective referring to a feminine noun" should "have the correct case when the noun becomes an adverb" in {
    (slovník.Stanica setPrídavnéMeno slovník.Hlavný predložka "pri" asText) shouldEqual "pri hlavnej stanici"
  }
  "An adjective referring to a neuter noun" should "have the correct case when the noun becomes an adverb" in {
    (slovník.Mesto setPrídavnéMeno slovník.Dobrý predložka "pri" asText) shouldEqual "pri dobrom meste"
  }
  // plural
  "An adjective referring to a plural masculine noun" should "have the correct case when the noun becomes an adverb" in {
    (slovník.Kvet setČislo Množné setPrídavnéMeno slovník.Dobrý predložka "vo" asText) shouldEqual "v dobrých kvetoch"
  }
  "An adjective referring to a plural feminine noun" should "have the correct case when the noun becomes an adverb" in {
    (slovník.Stanica setČislo Množné setPrídavnéMeno slovník.Hlavný predložka "pri" asText) shouldEqual "pri hlavných staniciach"
  }
  "An adjective referring to a plural neuter noun" should "have the correct case when the noun becomes an adverb" in {
    (slovník.Mesto setČislo Množné setPrídavnéMeno slovník.Dobrý predložka "pri" asText) shouldEqual "pri dobrých mestách"
  }

  // Combinations of gender, number & case

  "An adjective" should "decline in the male-animate-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Nominatív) shouldEqual "pekný"
  }
  "An adjective" should "decline in the male-animate-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Akusatív) shouldEqual "pekného"
  }
  "An adjective" should "decline in the male-animate, singular, locative case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Lokatív) shouldEqual "peknom"
  }

  "An adjective" should "decline in the male-inanimate-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Nominatív) shouldEqual "pekný"
  }
  "An adjective" should "decline in the male-inanimate-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Akusatív) shouldEqual "pekný"
  }
  "An adjective" should "decline in the male-inanimate, singular, locative case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Lokatív) shouldEqual "peknom"
  }

  "An adjective" should "decline in the feminine-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Nominatív) shouldEqual "pekná"
  }
  "An adjective" should "decline in the feminine-gender, singular-number, genitive-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Genitív) shouldEqual "peknej"
  }
  "An adjective" should "decline in the feminine-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Akusatív) shouldEqual "peknú"
  }
  "An adjective" should "decline in the feminine, singular, locative case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Jednotné, pád = Lokatív) shouldEqual "peknej"
  }

  "An adjective" should "decline in the neuter-gender, singular-number, nominative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Jednotné, pád = Nominatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the neuter-gender, singular-number, accusative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Jednotné, pád = Akusatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the neuter, singular, locative case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Jednotné, pád = Lokatív) shouldEqual "peknom"
  }

  // Plural
  "An adjective" should "decline in the male-animate-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Množné, pád = Nominatív) shouldEqual "pekní"
  }
  "An adjective" should "decline in the male-animate-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Množné, pád = Akusatív) shouldEqual "pekných"
  }
  "An adjective" should "decline in the male-animate, plural, locative case" in {
    slovník.Pekný.asText(rod = MužskýŽivotný, čislo = Množné, pád = Lokatív) shouldEqual "pekných"
  }

  "An adjective" should "decline in the male-inanimate-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Množné, pád = Nominatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the male-inanimate-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Množné, pád = Akusatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the male-inanimate, plural, locative case" in {
    slovník.Pekný.asText(rod = MužskýNeživotný, čislo = Množné, pád = Lokatív) shouldEqual "pekných"
  }

  "An adjective" should "decline in the feminine-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Množné, pád = Nominatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the feminine-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Množné, pád = Akusatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the feminine, plural, locative case" in {
    slovník.Pekný.asText(rod = Ženský, čislo = Množné, pád = Lokatív) shouldEqual "pekných"
  }

  "An adjective" should "decline in the neuter-gender, plural-number, nominative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Množné, pád = Nominatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the neuter-gender, plural-number, accusative-case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Množné, pád = Akusatív) shouldEqual "pekné"
  }
  "An adjective" should "decline in the neuter, plural, locative case" in {
    slovník.Pekný.asText(rod = Stredný, čislo = Množné, pád = Lokatív) shouldEqual "pekných"
  }

  // same as above, but with an adjective whose stem ends with a long syllable

  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Nominatív) shouldEqual "nízky"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Jednotné, pád = Akusatív) shouldEqual "nízkeho"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Nominatív) shouldEqual "nízky"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Jednotné, pád = Akusatív) shouldEqual "nízky"
  }
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Jednotné, pád = Nominatív) shouldEqual "nízka"
  }
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Jednotné, pád = Akusatív) shouldEqual "nízku"
  }
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, singular-number, nominative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Jednotné, pád = Nominatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, singular-number, accusative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Jednotné, pád = Akusatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Množné, pád = Nominatív) shouldEqual "nízki"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-animate-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýŽivotný, čislo = Množné, pád = Akusatív) shouldEqual "nízkych"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Množné, pád = Nominatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the male-inanimate-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = MužskýNeživotný, čislo = Množné, pád = Akusatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Množné, pád = Nominatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the feminine-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = Ženský, čislo = Množné, pád = Akusatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, plural-number, nominative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Množné, pád = Nominatív) shouldEqual "nízke"
  }
  "An adjective whose stem has a long final syllable" should "decline in the neuter-gender, plural-number, accusative-case" in {
    slovník.Nízky.asText(rod = Stredný, čislo = Množné, pád = Akusatív) shouldEqual "nízke"
  }

}

