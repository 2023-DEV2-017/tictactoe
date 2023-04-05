# About this App

This is a programming exercise using Kotlin for Android including ViewModel, LiveData and Compose.
Starting point was the Android Studio Empty Compose App. 
Implementation test driven.

Original requirements: https://github.com/2023-DEV2-017/katas/blob/master/TicTacToe.md

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