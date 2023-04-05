# About this App

This is a programming exercise using Kotlin for Android including ViewModel, LiveData and Compose.
Starting point was the Android Studio Empty Compose App. 
Implementation test driven.

# Game Rules 

From original requirements: https://github.com/2023-DEV2-017/katas/blob/master/TicTacToe.md

```
The rules are described below :

    X always goes first.
    Players cannot play on a played position.
    Players alternate placing X’s and O’s on the board until either:
        One player has three in a row, horizontally, vertically or diagonally
        All nine squares are filled.
    If a player is able to draw three X’s or three O’s in a row, that player wins.
    If all nine squares are filled and neither player has three in a row, the game is a draw.
```

# How to run tests

From command line within project folder run following command to execute all tests created:

```
./gradlew test
```

More info at https://developer.android.com/studio/test/command-line

# How to build & run app

Building and running the app itself can be done with the following commands. Note that for this a
(single) running emulator or device should be connected. 

```
./gradlew assembleDebug
./gradlew installDebug
```

More info at https://developer.android.com/build/building-cmdline