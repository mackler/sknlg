# Slovak NLG
**Natural Language Generation for learning Slovak grammar**

## Generating Phrases

### In General

Each object representing a word has a method named `asText` that will return a `String` value.  When you have assembled your phrase,
invoke the `asText` method to render it as a text string.

Words are in the `slovník` package.  You can import them all at once:

    import org.mackler.sknlg.slovník._

There are also useful constants you may want to import for specifying gender, number, person and case:

    import org.mackler.sknlg.{Rod, Čislo, Osoba, Pád}

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

Set a noun to be a direct object by using the `setPriamyPredmet()` method:

    > Mať addPodmet On setPriamyPredmet Kniha asText

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



## Using the Exercises

The file named `nlg.scala` contains functions that generate useful exercises for learning the Slovak language.
The main method is invoked when the application is run.  Edit this method to generate the desired exercise.

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

