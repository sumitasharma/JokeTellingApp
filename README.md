# JokeTellingApp
JokeTellingApp is an app which displays random jokes from a java library to an android library through a button on an android app.

## Libraries
Espresso, Self created Android and Java Library, namely Joketellingandroidlibrary and JokeTellingLibrary.

## Project Overview
In this Project I have included :
* Fragment has a button, which on clicking, would start an Asynchronous task calling a random joke from a java library.
* The java library is running in google Cloud Engine (GCE) .
* GCE must be up and running to fetch the jokes.
* Once the app returns a joke, it is then passed to an Android library and is displayed through its activity.
* I have also used a progressbar which runs as soon as the joketelling button is called and stops when the search is over.

## Project Flavors
I have added two flavors to the app namely, free and paid.
In the free flavor, Google Ads are displayed at the bottom of the screen.
In the paid flavor, Google Ads are not displayed.

## Android Connected Test
Since the project uses Android framework, hence the test cannot be java test and I have created java test. This test shows that the joke telling button must be pressed and asynchronous task is called and must return a value.

## Gradle Task
I have added a gradle task called "myJokeTellingTest" which will :
* Run GCE.
* Run Android Connected Test
* Stop GCE.

## Installation
Clone the GitHub repository.
```
$ git clone https://github.com/sumitasharma/JokeTellingApp.git
```


