# Android Notification Demonstration Project

This project is a simple yet powerful demonstration of how to implement a notification system in an Android application. It showcases the use of the NotificationManager and NotificationChannel classes in Android.

## Overview

The project consists of a single activity, `MainActivity`, which handles the creation and sending of notifications. The user interface is minimal, with a single button that triggers the notification when clicked.

## Code Structure

The code is organized into three main files:

1. `AndroidManifest.xml`: This is the manifest file for the Android application. It declares the application's components and required permissions.

2. `MainActivity.kt`: This is the main activity for the application. It handles the creation and sending of notifications.

3. `activity_main.xml`: This is the layout file for the main activity. It defines the user interface for the application.

## Key Features

- **Notification Creation**: The application creates a notification with a title, text, and small icon. The notification is ongoing, meaning it cannot be dismissed by the user.

- **Notification Channel**: The application creates a notification channel for sending the notification. This is a requirement for notifications on Android 8.0 (API level 26) and higher.

- **Permission Request**: The application requests the necessary permission to post notifications.

## How to Run

To run this project, you will need to have Android Studio installed on your machine. Once you have that, you can clone this repository, open the project in Android Studio, and run it on an emulator or a connected Android device.

## Contributions

Contributions to this project are welcome. If you find a bug or have a suggestion for an improvement, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

