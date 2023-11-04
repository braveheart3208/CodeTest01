# CodeTest01
This project is a code challenge from Entain, details of the challenge can be found [here](https://github.com/braveheart3208/CodeTest01/blob/development/Entain_Technical_Task_-_Android.docx).

The application is developed by Alex (Twan) Duong, in accordance with the requirements defined by the above coding challenge. The app intends to show a list of retrieved races and display the information such as name and count down timer by category sections accordingly.

## Images
<div style="display: flex; justify-content: space-between; align-items: center;">
  <img src="https://github.com/braveheart3208/CodeTest01/blob/development/Entain_screenshot.png" alt="Poke List" width="200px" />
</div>

## Installation

Download the app from Github, import and run it in the Android Studio with Android Emulator/Physical Android Device.

Setting up the emulator can be found [here](https://developer.android.com/design-for-safety/privacy-sandbox/download#:~:text=Set%20up%20an%20Android%20device%20emulator%20image,-To%20set%20up&text=In%20Android%20Studio%2C%20go%20to,it%20isn't%20already%20installed.)

Alternatively, you can build the .apk or .bundle to test the app.

## Usage
Launching - Simply launch the app by tapping on the app icon

Refreshing - Kill and Relaunch

## Architecture and Design decisions

This application has two main features:

* To retrieve the race list from the provided server endpoint.
* To display the available race list information for each entry accordingly to Category, Time sorted.

The main focus area in the code test is to implement the MVI design-pattern in conjunction with Clean Architecture in order to provide the testability and scalability of the project.
Additionally, writing unit tests is also an important part of the application.

## Technologies and Libraries Usage
The project uses 100% Kotlin and made use of the following libraries:
### Feature Dev
* Retrofit - for making API calls
* Dagger Hilt - Dependencies injections.
* Coroutines - Work threading
* Jetpack Compose - UI rendering
* Kotlinx Date time
### Testing
* Mockk
* JUnit

## Improvements to be made
* The app has not been tested with 100% coverage properly.
* List refreshing is not smooth.

## Acknowledgement
* Much appreciate Billy-Hlaing for always encouraging me to build portfolio applications, taking test challenges.
* Thanks to Phillip Lackner, who always has a great walk-through of Android Development processes and the latest news.

## Contributing
* Please feel free to make PRs
* For major changes, please open an issue to discuss what you would like to change.
* And very last, please make sure to update tests as appropriate.
