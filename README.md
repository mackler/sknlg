# Slovak NLG
**Natural Language Generation for learning Slovak grammar**

The file named `nlg.scala` contains functions that generate useful exercises for learning the Slovak language.
The main method is invoked when the application is run.  Edit this method to generate the desired exercise.

The generated phrases are in Slovak only.  To use these phrases for generating audio flashcards I
translate each phrase into English.
If there are very many phrases then this takes too long to do manually.  There is a utility script named `sandr`
that will attempt such translations.  One possible workflow looks like this:

## 1. Run the application and save the output into a file

In this example, I have named this file `exercise-sk`.

## 2. Copy this file

In this example, I have named this copy of the first file `exercise-en`

    cp ~/tmp/exercise-sk ~/tmp/exercise-en

## 3. Run the `sandr` script on this second file:

This (hopefully) translates the contents of the second file from Slovak to English.

    sh util/sandr ~/tmp/exercise-en

## 4. Combine the two files using the `paste` command:

The `-d` option tells `paste` to separate the two versions of the phrase on each line with a vertical-bar character.

    paste -d\| exercise-en exercise-sk > ~/tmp/exercise.sh

## 5. Process this combined file into a script that generates the flashcards

This turns each line into a command that will generate one MP3 flashcard that contains the phrase in each language.

    perl -i -p -e 's/^([^|]+)\|(.+)$/skcard . "$1" "$2"/' ~/tmp/exercise.sh

Here, `skcard` refers to the script of that name available as a separate repository on this github account.
From the command above you can see that I have `skcard` in my search path.  Path-qualify this name as necessary.

## 6. Execute the script that results from the previous step.

    sh ~/tmp/exercise.sh

