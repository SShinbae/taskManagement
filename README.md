# Task Management App

## Overview
This is a Task Management application built using Android and Java. It allows users to create, update, delete, and categorize tasks.

## Installation

### Prerequisites
- Android Studio
- Java Development Kit (JDK) 11 or higher
- Gradle

### Steps
1. Clone the repository:
    ```sh
    git clone <github.com/SShinbae/taskManagement>
    ```
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Build and run the project on an emulator or physical device.

## Dependencies
The project uses the following dependencies:
- AndroidX Libraries
- Material Components
- Room Database
- Navigation Component

These dependencies are managed in the `build.gradle` files and `gradle/libs.versions.toml`.

## Features
- **Add Task**: Users can add new tasks with a title, description, due date, and priority.
- **Edit Task**: Users can edit existing tasks.
- **Delete Task**: Users can delete tasks.
- **Categorize Tasks**: Tasks are categorized into incomplete and completed tasks.
- **Search Tasks**: Users can search for tasks by title or description.

## Functions
- `AddTaskActivity`: Handles the creation and editing of tasks.
- `MainActivity`: Displays the list of tasks and handles task categorization and search.
- `TaskDetailActivity`: Displays the details of a selected task and allows marking it as complete or deleting it.
- `TaskAdapter`: Adapter for displaying tasks in a RecyclerView.
- `DatabaseApp`: Initializes the Room database.

## Users Involved
- **Developers**: Responsible for maintaining and enhancing the application.
- **End Users**: Individuals who use the application to manage their tasks.

## License
This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
