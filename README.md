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
    git clone github.com/SShinbae/taskManagement
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

## Screenshots
### Main Menu
![Screenshot 2025-02-07 173017](https://github.com/user-attachments/assets/a652961a-2b52-4b5f-8de5-11f0b0f07a89)

### Add Task Menu
![Screenshot 2025-02-07 173656](https://github.com/user-attachments/assets/ce1e2e2d-7310-434b-b80b-1ac32ca0fef2)

### Add Task Notifications/ Toast
![Screenshot 2025-02-07 173846](https://github.com/user-attachments/assets/ae00a49d-742b-4974-8d36-09cc4a74d021)

### Edit Task Menu
![Screenshot 2025-02-07 174022](https://github.com/user-attachments/assets/f76202b6-6078-4df9-8275-dafdd61796cb)

### Successfully Edit / Completed Task
![Screenshot 2025-02-07 174105](https://github.com/user-attachments/assets/10006496-c11f-4708-9b27-d410562193ca)

### Delete Task
![Screenshot 2025-02-07 174243](https://github.com/user-attachments/assets/40a20e4c-18c8-4206-bb34-f953feae597e)

### Search Functions
![Screenshot 2025-02-07 174436](https://github.com/user-attachments/assets/047adbe4-9297-49d3-9266-f9beca7f2662)



## Users Involved
- **Developers**: Responsible for maintaining and enhancing the application.
- **End Users**: Individuals who use the application to manage their tasks.

## License
This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
