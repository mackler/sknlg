# Slovak NLG
**Natural Language Generation for learning Slovak grammar**

## Generating Phrases

### In General

Each object representing a word has a method named `asText` that will return a `String` value.  When you have assembled your phrase,
invoke the `asText` method to render it as a text string.

Words are in the `slovník` package.  You can import them all at once. There are also useful constants you may want to import for specifying gender, number, person and case:

    import org.mackler.sknlg.slovník._
    import org.mackler.sknlg._
    import org.mackler.sknlg.{Rod, Osoba, Čislo, Pád}
    import Pád._
    import Čislo._
    import Rod._

### Verbs

Verbs are instances of the `Sloveso` class.  Instances bear the name of the Slovak word they represent.
Invoking the `asText` method will generate the verb's infinitive form:

    > Čakať asText

returns

    čakať

#### Subjects

##### Pronouns

Pronouns implement the `Zámeno` trait.  They are named after their singular forms: `Ja`, `Ty`, `On`, `Ona`, and `Ten`.

Make them a subject by using the verb's `addPodmet()` method:

    > Čakať addPodmet Ja asText

returns

    ja čakám

Likewise:

    > Čakať addPodmet Ty asText

returns

    ty čakáš
    
##### Other Subject Nouns

All other nouns can be used as subjects in the same way:

    > Čakať addPodmet Brat asText

returns

    brat čaká

Verbs can have more than one subject:

    > Čakať addPodmet Brat addPodmet Sestra asText

returns

    brat a sestra čakajú

##### Proper Names

Generate a proper name using the `Pomenovanie()` constructor.  You must specify the gender, either `MužskýŽivotný` or `Ženský`:

    > Čakať addPodmet Pomenovanie("Igor", Rod.MužskýŽivotný) asText

returns

    Igor čaká

#### Negation

Negate (or un-negate) a verb using the `setZáporný()` method, which takes a boolean value.  Passing `true` negates:

    > Čakať addPodmet Brat setZáporný true asText

returns

    brat nečaká

#### Objects

Set a noun to be a direct object by using the `setPredmet()` method:

    > Mať addPodmet On setPredmet Kniha asText

returns

    on má knihu

#### Verbs as Copula

The verb `Byť` takes a complement rather than objects.  Set the complement using the `setComplement()` method:

    > Byť addPodmet Ona setComplement Učiteľka asText

returns

    ona je učiteľka

### Nouns

Nouns are represented by instances of `PodstatnéMeno`, which provides methods for setting the number.

You may want to import the contants for specifying number:

    import org.mackler.sknlg.Čislo.{Jednotné, Množné}

#### Number

By default, nouns will be rendered in the singular number.  Set the
number of a noun expressly by using the `setČislo()` method.  It takes
one of the constant values, either `Jednotné` or `Množné`.  Thus, to put the
direct object into the plural number:

    > Mať addPodmet Ja setPriamyPredmet (Kniha setČislo Množné) asText

returns

    ja mám knihy

The subject noun can be made plural in the same way.  Thus,

    > Mať addPodmet (Ja setČislo Množné) setPriamyPredmet Kniha asText

returns

    my máme knihu

#### Nouns Without Verbs

You can generate a noun independent of any verb using its `asText()` method. By default the noun will
be rendered in the nominative case, but you can pass a grammatical case.
The possible values of such argument are the constant members of the `Pád` enumeration:
`Nominatív`, `Genitív`, `Datív`, `Akusatív`, `Lokál`, `Inštrumentál`.

    > Kniha asText Akusatív

returns

    knihu

and

    > Kniha asText Lokál

returns

    knihe

and

    > Kniha asText()

returns

    kniha

#### Gender of a Noun

You can find the gender of a noun by examining its `rod` member.  Thus

    > Učiteľka.rod

returns

    Ženský

#### Geographical Place Names

Country names are nouns with some special methods.

##### Country of Origin

The `asOrigin` method returns an adverbial phrase
indicating place of origin using the preposition "zo":

    Byť addPodmet Ja setComplement Francúzsko.asOrigin asText

returns

    ja som z Francúzska

##### Countries as Adjectives

The value `adjectival` is the place as an adjective:

    > Byť addPodmet Auto setComplement Taliansko.adjectival asText

returns

    > auto je talianske

##### Countries as Adverbs

The method `asPríslovka` returns the place name in its adverbial form:

    > Hovoriť addPodmet Ja setZáporný true setPríslovka Slovensko.asPríslovka asText

returns

    > ja nehovorím po slovensky

##### Demonyms

Place names have an optional value named `demonym`.  Not all place names have
demonyms; for those that do you must get it using the `get` method on the value returned by `demonym`.

    > Byť addPodmet On setComplement Česko.demonym.get asText

returns

    > on je Čech

and

    > Byť addPodmet Ona setComplement Česko.demonym.get asText

returns

    ona je Češka


### Adjectives

You can modify a noun with an adjective by using the noun's `setPrídavnéMeno()` method:

    > Vidieť setPriamyPredmet (Žena setPrídavnéMeno Krásny) addPodmet Ja asText

returns

    ja vidím krásnu ženu

#### Possessive Adjectives

The possessives `Môj`, `Tvoj`, and `Jeho` can be used as adjectives:

    > Byť addPodmet Ten setComplement (Sestra setPrídavnéMeno Môj) asText

returns

    tá je moja sestra

The reflexive forms will be rendered where appropriate.  Thus

    > Byť addPodmet (Ty setČislo Množné) setComplement (Sestra setČislo Množné setPrídavnéMeno (Tvoj setČislo Množné)) asText

returns

    vy ste svoje sestry

### Adverbs

Adverbs are constructed using the `Príslovka()` constructor, and applied to a verb using the
`setPríslovka()` method:

    > Byť addPodmet Ja setPríslovka Príslovka("tu") asText

returns

    ja som tu

## Adding Vocabulary

A number of words are defined in the `slovník` package.  You can define new words depending on the part of speech.

### Defining Nouns

Define a noun using the `PodstatnéMeno()` constructor.  In the
simplest case, pass as a single argument the dictionary entry form of
the word in its singular number, nominative case.  The gender of the noun will be
guessed based on the form.  For example, in the following definition:

    val Dom = PodstatnéMeno("dom")

`Dom` is defined as a male inatimate noun, and thus

    Dom.rod

returns

    MužskýNeživotný

Male _animate_ nouns must be defined as such.  For example:

    val Muž = PodstatnéMeno("muž", MužskýŽivotný)

Most feminine nouns can be identified as such from their forms, for example:

    val Žena = PodstatnéMeno("žena")

However, if the form is unusual, such as ending with a consonant, then
you must specify the gender expressly, for example:

    val Dlaň = PodstatnéMeno("dlaň", Ženský)

The same is true for neuter nouns, thus

    val Mesto = PodstatnéMeno("mesto")

but

    val Dieťa = PodstatnéMeno("dieťa", Stredný)

If the noun declines irregularly, you can specify additional forms as
necessary with the `nominativePlural` and `genitiveSingular` 
parameters:

    val Brat = PodstatnéMeno("brat", MužskýŽivotný, nominativePlural = "bratia")
    val Jeseň = PodstatnéMeno("jeseň", Ženský, genitiveSingular = "jesene")

#### Defining Place Names

Define geographical place-names with the `PlaceName()` constructor.
Its parameters are `entry`, `rod`, `adjectival`, and, optionally, `demonymMužský` and `demonymŽenský`.
If `demonymMužský` is undefined, then the returned object's `demonym` value will be `None`.  If `demonymMužský`
is defined but `demonymŽenský` is undefined, the the feminine demonym will be derived from the masculine.

For example, Ukraine is defined as:

    val Ukrajina = PlaceName(entry = "Ukrajina", rod = Ženský, demonymMužský = "Ukrajinec", adjectival = "ukrajinský")

and so

    Byť addPodmet Ona setComplement Ukrajina.demonym.get asText

returns

    ona je Ukrajinka

but Czechia is defined as

    val Česko = PlaceName(entry = "Česko", rod = Stredný, demonymMužský = "Čech", demonymŽenský = "Češka", adjectival = "český")

because the feminine demonym cannot be inferred from the masculine.

### Defining Adjectives

Define an adjective using the `PrídavnéMeno()` costructor, passing as
a single argument the word in its singular, masculine, nominative
form:

    val Dobrý = PrídavnéMeno("dobrý")

### Defining Verbs

Define a verb using the `Sloveso()` constructor.  It takes two arguments: the verb in its infinitive form and
the verb in its third person singular present form.

    val Vidieť = Sloveso("vidieť", "vidí")

See the file named `Slovník.scala` for more examples.

## Conjugating a Verb

The methods described above can be combined to generate phrases as desired.  One common task is to conjugate a verb.
You can do this in the desired forms by using a `for` expression.  For example:

    for {
        pronoun <- Set(Ja, Ty, On);
        number  <- Set(Jednotné, Množné)
    } println(Byť addPodmet (pronoun setČislo number) asText)

prints

    ja som
    my sme
    ty si
    vy ste
    on je
    oni sú

You can add more generators to the `for` expression as desired.  For example:

    for {
        pronoun <- Set(Ja, Ty, On)
        number  <- Set(Jednotné, Množné)
        negate  <- Set(false, true)
    } println(Bývať setZáporný negate addPodmet (pronoun setČislo number) asText)

prints

    ja bývam
    ja nebývam
    my bývame
    my nebývame
    ty bývaš
    ty nebývaš
    vy bývate
    vy nebývate
    on býva
    on nebýva
    oni bývajú
    oni nebývajú

## Using the Exercises

The file `nlg.scala` defines useful functions for generating learning
exercises.  The main method is invoked when the application is run.
Edit this method to generate the desired exercise.

These functions are defined in the `Main` object:

    import org.mackler.sknlg.Main._

The functions are documented in the comments, but a few are described here.

### Subject Nouns with Verbs

The `nominativeNounsVerbs()` function takes a set of nouns and a set
of verbs and returns all combinations of the nouns as subjects with
the verbs, including negation, and including plurals by combining the
subject nouns with pronouns.  So, for example

    nominativeNounsVerbs(Set(Sedieť, Poznať), Set(Muž, Žena)) foreach println

prints

    muž nesedí
    muž a ja nepoznáme
    muž sedí
    ženy poznajú
    žena pozná
    ty a žena nesedíte
    muži nesedia
    muž a ja sedíme
    ty a muž poznáte
    žena a ja nesedíme
    muž nepozná
    muž a ja poznáme
    muž a ja nesedíme
    žena nepozná
    ženy nesedia
    ty a žena nepoznáte
    ty a žena sedíte
    muži poznajú
    žena a ja poznáme
    muži sedia
    muž pozná
    žena a ja nepoznáme
    ty a muž nepoznáte
    žena sedí
    ženy sedia
    muži nepoznajú
    ty a žena poznáte
    žena nesedí
    ty a muž nesedíte
    žena a ja sedíme
    ty a muž sedíte
    ženy nepoznajú

### Nouns and Adjectives in the Nominative Case

The `nominativeNounsAdjectives()` function combines nouns and adjectives in the nominative case:

    nominativeNounsAdjectives(Set(Kniha, Auto), Set(Dobrý, Pekný)) foreach println

prints

    kniha je dobrá
    kniha je pekná
    auto je dobré
    auto je pekné

### Other Exercise Functions

A number of other exercise functions are defined in the `Main` object
that demonstrate various grammatical characteristics.


## Generating Audio Cards

The generated phrases are in Slovak only.  To use these phrases for generating audio flashcards I
translate each phrase into English.
If there are very many phrases then this takes too long to do manually.  There is a utility script named `sandr`
that will attempt such translations.  One possible workflow looks like this:

### 1. Run the application and save the output into a file

In this example, I have named this file `exercise-sk`.

### 2. Copy this file

In this example, I have named this copy of the first file `exercise-en`

    cp ~/tmp/exercise-sk ~/tmp/exercise-en

### 3. Run the `sandr` script on this second file:

This (hopefully) translates the contents of the second file from Slovak to English.

    sh util/sandr ~/tmp/exercise-en

### 4. Combine the two files using the `paste` command:

The `-d` option tells `paste` to separate the two versions of the phrase on each line with a vertical-bar character.

    paste -d\| exercise-en exercise-sk > ~/tmp/exercise.sh

### 5. Process this combined file into a script that generates the flashcards

This turns each line into a command that will generate one MP3 flashcard that contains the phrase in each language.

    perl -i -p -e 's/^([^|]+)\|(.+)$/skcard . "$1" "$2"/' ~/tmp/exercise.sh

Here, `skcard` refers to the script of that name available as a separate repository on this github account.
From the command above you can see that I have `skcard` in my search path.  Path-qualify this name as necessary.

### 6. Execute the script that results from the previous step.

    sh ~/tmp/exercise.sh

## How to Contribute

This is a very nascent project that implements only a very small portion of the Slovak language.
Pull requests for bug-fixes and new features are welcome along with any other feedback.
