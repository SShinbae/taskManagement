//this is my addTaskActivity code
// package com.example.taskmanagement;

// import android.content.Intent;
// import android.os.Bundle;
// import android.widget.Button;
// import android.widget.TextView;
// import android.widget.Toast;

// import androidx.appcompat.app.AppCompatActivity;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.Locale;

//public class addTaskActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_add_task2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}
// public class TaskDetailActivity extends AppCompatActivity {
//     private TextView taskTitle, taskDescription, taskDueDate, taskPriority;
//     private Button btnMarkComplete, btnEditTask, btnDeleteTask;

//     private Task currentTask; // Assume Task is a model class
//     private TaskDao taskDao; // DAO for database operations

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_task_details);

//         // Initialize views
//         taskTitle = findViewById(R.id.taskTitle);
//         taskDescription = findViewById(R.id.taskDescription);
//         taskDueDate = findViewById(R.id.taskDueDate);
//         taskPriority = findViewById(R.id.taskPriority);
//         btnMarkComplete = findViewById(R.id.btnMarkComplete);
//         btnEditTask = findViewById(R.id.btnEditTask);
//         btnDeleteTask = findViewById(R.id.btnDeleteTask);

//         // Retrieve task data passed via intent
//         int taskId = getIntent().getIntExtra("TASK_ID", -1);
//         DatabaseApp AppDatabase = null;
//         taskDao = AppDatabase.getDatabase(this).taskDao();
//         currentTask = taskDao.getTaskById(taskId);

//         if (currentTask != null) {
//             // Populate data
//             taskTitle.setText(currentTask.title);
//             taskDescription.setText(currentTask.description);
//             taskDueDate.setText("Due Date: " + formatDate(currentTask.dueDate));
//             taskPriority.setText("Priority: " + currentTask.priority);
//             btnMarkComplete.setText(currentTask.isCompleted ? "Mark as Incomplete" : "Mark as Complete");
//         }

//         // Mark as Complete/Incomplete
//         btnMarkComplete.setOnClickListener(v -> {
//             currentTask.setCompleted(!currentTask.isCompleted);
//             taskDao.update(currentTask);
//             btnMarkComplete.setText(currentTask.isCompleted ? "Mark as Incomplete" : "Mark as Complete");
//             Toast.makeText(this, "Task updated successfully", Toast.LENGTH_SHORT).show();
//         });

//         // Edit Task
//         btnEditTask.setOnClickListener(v -> {
//             Intent intent = new Intent(TaskDetailActivity.this, AddTaskActivity.class);
//             intent.putExtra("TASK_ID", currentTask.id);
//             startActivity(intent);
//         });

//         // Delete Task
//         btnDeleteTask.setOnClickListener(v -> {
//             taskDao.delete(currentTask);
//             Toast.makeText(this, "Task deleted successfully", Toast.LENGTH_SHORT).show();
//             finish(); // Go back to Main Activity
//         });
//     }

//     private String formatDate(long timestamp) {
//         // Utility to format date
//         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//         return sdf.format(new Date(timestamp));
//     }
// }
// package com.example.taskmanagement;

// import android.content.Intent;
// import android.os.AsyncTask;
// import android.os.Bundle;
// import android.widget.Button;
// import android.widget.TextView;
// import android.widget.Toast;

// import androidx.appcompat.app.AppCompatActivity;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.Locale;

// public class TaskDetailActivity extends AppCompatActivity {
//     private TextView taskTitle, taskDescription, taskDueDate, taskPriority;
//     private Button btnMarkComplete, btnEditTask, btnDeleteTask;

//     private Task currentTask; // Assume Task is a model class
//     private TaskDao taskDao; // DAO for database operations

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_task_details);

//         // Initialize views
//         taskTitle = findViewById(R.id.taskTitle);
//         taskDescription = findViewById(R.id.taskDescription);
//         taskDueDate = findViewById(R.id.taskDueDate);
//         taskPriority = findViewById(R.id.taskPriority);
//         btnMarkComplete = findViewById(R.id.btnMarkComplete);
//         btnEditTask = findViewById(R.id.btnEditTask);
//         btnDeleteTask = findViewById(R.id.btnDeleteTask);

//         // Initialize TaskDao
//         taskDao = DatabaseApp.getDatabase(this).taskDao();

//         // Retrieve task data passed via intent
//         int taskId = getIntent().getIntExtra("TASK_ID", -1);
//         new LoadTaskAsyncTask().execute(taskId);

//         // Mark as Complete/Incomplete
//         btnMarkComplete.setOnClickListener(v -> {
//             currentTask.setCompleted(!currentTask.isCompleted);
//             new UpdateTaskAsyncTask().execute(currentTask);
//         });

//         // Edit Task
//         btnEditTask.setOnClickListener(v -> {
//             Intent intent = new Intent(TaskDetailActivity.this, AddTaskActivity.class);
//             intent.putExtra("TASK_ID", currentTask.id);
//             startActivity(intent);
//         });

//         // Delete Task
//         btnDeleteTask.setOnClickListener(v -> {
//             new DeleteTaskAsyncTask().execute(currentTask);
//         });
//     }

//     private class LoadTaskAsyncTask extends AsyncTask<Integer, Void, Task> {
//         @Override
//         protected Task doInBackground(Integer... params) {
//             int taskId = params[0];
//             return taskDao.getTaskById(taskId);
//         }

//         @Override
//         protected void onPostExecute(Task task) {
//             currentTask = task;
//             if (currentTask != null) {
//                 // Populate data
//                 taskTitle.setText(currentTask.title);
//                 taskDescription.setText(currentTask.description);
//                 taskDueDate.setText("Due Date: " + formatDate(currentTask.dueDate));
//                 taskPriority.setText("Priority: " + currentTask.priority);
//                 btnMarkComplete.setText(currentTask.isCompleted ? "Mark as Incomplete" : "Mark as Complete");
//             }
//         }
//     }

//     private class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {
//         @Override
//         protected Void doInBackground(Task... tasks) {
//             taskDao.update(tasks[0]);
//             return null;
//         }

//         @Override
//         protected void onPostExecute(Void aVoid) {
//             Toast.makeText(TaskDetailActivity.this, "Task updated successfully", Toast.LENGTH_SHORT).show();
//         }
//     }

//     private class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
//         @Override
//         protected Void doInBackground(Task... tasks) {
//             taskDao.delete(tasks[0]);
//             return null;
//         }

//         @Override
//         protected void onPostExecute(Void aVoid) {
//             Toast.makeText(TaskDetailActivity.this, "Task deleted successfully", Toast.LENGTH_SHORT).show();
//             finish(); // Go back to Main Activity
//         }
//     }

//     private String formatDate(long timestamp) {
//         // Utility to format date
//         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//         return sdf.format(new Date(timestamp));
//     }
// }

// package com.example.taskmanagement;

// import android.content.Intent;
// import android.os.AsyncTask;
// import android.os.Bundle;
// import android.widget.Button;
// import android.widget.TextView;
// import android.widget.Toast;

// import androidx.appcompat.app.AppCompatActivity;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.Locale;

// public class TaskDetailActivity extends AppCompatActivity {
//     private TextView taskTitle, taskDescription, taskDueDate, taskPriority;
//     private Button btnMarkComplete, btnEditTask, btnDeleteTask;

//     private Task currentTask; // Assume Task is a model class
//     private TaskDao taskDao; // DAO for database operations

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_task_details);

//         // Initialize views
//         taskTitle = findViewById(R.id.taskTitle);
//         taskDescription = findViewById(R.id.taskDescription);
//         taskDueDate = findViewById(R.id.taskDueDate);
//         taskPriority = findViewById(R.id.taskPriority);
//         btnMarkComplete = findViewById(R.id.btnMarkComplete);
//         btnEditTask = findViewById(R.id.btnEditTask);
//         btnDeleteTask = findViewById(R.id.btnDeleteTask);

//         // Initialize TaskDao
//         taskDao = DatabaseApp.getDatabase(this).taskDao();

//         // Retrieve task data passed via intent
//         int taskId = getIntent().getIntExtra("TASK_ID", -1);
//         new LoadTaskAsyncTask().execute(taskId);

//         // Mark as Complete/Incomplete
//         btnMarkComplete.setOnClickListener(v -> {
//             currentTask.setCompleted(!currentTask.isCompleted());
//             new UpdateTaskAsyncTask().execute(currentTask);
//         });

//         // Edit Task
//         btnEditTask.setOnClickListener(v -> {
//             Intent intent = new Intent(TaskDetailActivity.this, AddTaskActivity.class);
//             intent.putExtra("TASK_ID", currentTask.id);
//             startActivity(intent);
//         });

//         // Delete Task
//         btnDeleteTask.setOnClickListener(v -> {
//             new DeleteTaskAsyncTask().execute(currentTask);
//         });
//     }

//     private class LoadTaskAsyncTask extends AsyncTask<Integer, Void, Task> {
//         @Override
//         protected Task doInBackground(Integer... params) {
//             int taskId = params[0];
//             return taskDao.getTaskById(taskId);
//         }

//         @Override
//         protected void onPostExecute(Task task) {
//             currentTask = task;
//             if (currentTask != null) {
//                 // Populate data
//                 taskTitle.setText(currentTask.getTitle());
//                 taskDescription.setText(currentTask.getDescription());
//                 taskDueDate.setText("Due Date: " + formatDate(currentTask.getDueDate()));
//                 taskPriority.setText("Priority: " + currentTask.priority);
//                 btnMarkComplete.setText(currentTask.isCompleted() ? "Mark as Incomplete" : "Mark as Complete");
//             }
//         }
//     }

//     private class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {
//         @Override
//         protected Void doInBackground(Task... tasks) {
//             taskDao.update(tasks[0]);
//             return null;
//         }

//         @Override
//         protected void onPostExecute(Void aVoid) {
//             Toast.makeText(TaskDetailActivity.this, "Task updated successfully", Toast.LENGTH_SHORT).show();
//         }
//     }

//     private class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
//         @Override
//         protected Void doInBackground(Task... tasks) {
//             taskDao.delete(tasks[0]);
//             return null;
//         }

//         @Override
//         protected void onPostExecute(Void aVoid) {
//             Toast.makeText(TaskDetailActivity.this, "Task deleted successfully", Toast.LENGTH_SHORT).show();
//             finish(); // Go back to Main Activity
//         }
//     }

//     private String formatDate(long timestamp) {
//         // Utility to format date
//         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//         return sdf.format(new Date(timestamp));
//     }
// }
package com.example.taskmanagement;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskDetailActivity extends AppCompatActivity {
    private TextView taskTitle, taskDescription, taskDueDate, taskPriority;
    private Button btnMarkComplete, btnEditTask, btnDeleteTask;

    private Task currentTask; // Assume Task is a model class
    private TaskDao taskDao; // DAO for database operations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        // Initialize views
        taskTitle = findViewById(R.id.taskTitle);
        taskDescription = findViewById(R.id.taskDescription);
        taskDueDate = findViewById(R.id.taskDueDate);
        taskPriority = findViewById(R.id.taskPriority);
        btnMarkComplete = findViewById(R.id.btnMarkComplete);
        btnEditTask = findViewById(R.id.btnEditTask);
        btnDeleteTask = findViewById(R.id.btnDeleteTask);

        // Initialize TaskDao
        taskDao = DatabaseApp.getDatabase(this).taskDao();

        // Retrieve task data passed via intent
        int taskId = getIntent().getIntExtra("TASK_ID", -1);
        new LoadTaskAsyncTask().execute(taskId);

        // Mark as Complete/Incomplete
        btnMarkComplete.setOnClickListener(v -> {
            currentTask.setCompleted(!currentTask.isCompleted());
            new UpdateTaskAsyncTask().execute(currentTask);
        });

        // Edit Task
        btnEditTask.setOnClickListener(v -> {
            Intent intent = new Intent(TaskDetailActivity.this, AddTaskActivity.class);
            intent.putExtra("TASK_ID", currentTask.id);
            startActivity(intent);
        });

        // Delete Task
        btnDeleteTask.setOnClickListener(v -> {
            new DeleteTaskAsyncTask().execute(currentTask);
        });
    }

    private class LoadTaskAsyncTask extends AsyncTask<Integer, Void, Task> {
        @Override
        protected Task doInBackground(Integer... params) {
            int taskId = params[0];
            return taskDao.getTaskById(taskId);
        }

        @Override
        protected void onPostExecute(Task task) {
            currentTask = task;
            if (currentTask != null) {
                // Populate data
                taskTitle.setText(currentTask.getTitle());
                taskDescription.setText(currentTask.getDescription());
                taskDueDate.setText("Due Date: " + formatDate(currentTask.getDueDate()));
                taskPriority.setText("Priority: " + currentTask.priority);
                btnMarkComplete.setText(currentTask.isCompleted() ? "Mark as Incomplete" : "Mark as Complete");
            }
        }
    }

    private class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.update(tasks[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(TaskDetailActivity.this, "Task updated successfully", Toast.LENGTH_SHORT).show();
            finish(); // Close TaskDetailActivity and return to MainActivity
        }
    }

    private class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.delete(tasks[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(TaskDetailActivity.this, "Task deleted successfully", Toast.LENGTH_SHORT).show();
            finish(); // Go back to Main Activity
        }
    }

    private String formatDate(long timestamp) {
        // Utility to format date
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }
}