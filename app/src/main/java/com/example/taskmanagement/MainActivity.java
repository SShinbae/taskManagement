//package com.example.taskmanagement;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.taskmanagement.Task;
//import com.example.taskmanagement.TaskAdapter;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private FloatingActionButton fabAddTask;
//    private List<Task> taskList; // Define taskList
//    private TaskAdapter taskAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        fabAddTask = findViewById(R.id.fabAddTask);
//
//        // Initialize the task list
//        taskList = new ArrayList<>();
//        populateTaskList(); // Add tasks (mock data or real data)
//
//        // Set up RecyclerView (adapter, layout manager, etc.)
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
//        recyclerView.setAdapter(taskAdapter);
//
//        // Add task button
//        fabAddTask.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, TaskAdapter.class);
//            startActivity(intent);
//        });
//    }
//
//    private void populateTaskList() {
//        // Add mock tasks for testing
//        taskList.add(new Task("Complete Project", "Finish the final report", System.currentTimeMillis() + 86400000, false));
//        taskList.add(new Task("Buy Groceries", "Milk, eggs, bread", System.currentTimeMillis() + 172800000, false));
//        taskList.add(new Task("Call John", "Discuss the new plan", System.currentTimeMillis() + 3600000, true));
//    }
//}
// package com.example.taskmanagement;

// import android.content.Intent;
// import android.content.SharedPreferences;
// import android.os.Bundle;

// import androidx.appcompat.app.AppCompatActivity;
// import androidx.recyclerview.widget.LinearLayoutManager;
// import androidx.recyclerview.widget.RecyclerView;

// import com.google.android.material.floatingactionbutton.FloatingActionButton;

// import java.util.ArrayList;
// import java.util.List;

// public class MainActivity extends AppCompatActivity {
//     private RecyclerView recyclerView;
//     private FloatingActionButton fabAddTask;
//     private List<Task> taskList; // Define taskList
//     private TaskAdapter taskAdapter;

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);

//         recyclerView = findViewById(R.id.recyclerView);
//         fabAddTask = findViewById(R.id.fabAddTask);

//         // Initialize the task list
//         taskList = new ArrayList<>();
//         populateTaskList(); // Add tasks (mock data or real data)

//         // Set up RecyclerView (adapter, layout manager, etc.)
//         recyclerView.setLayoutManager(new LinearLayoutManager(this));
//         taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
//         recyclerView.setAdapter(taskAdapter);

//         // Add task button
//         fabAddTask.setOnClickListener(view -> {
//             Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
//             startActivity(intent);
//         });
//     }

//     // private void populateTaskList() {
//     //     // Add mock tasks for testing
//     //     taskList.add(new Task("Complete Project", "Finish the final report", System.currentTimeMillis() + 86400000, false));
//     //     taskList.add(new Task("Buy Groceries", "Milk, eggs, bread", System.currentTimeMillis() + 172800000, false));
//     //     taskList.add(new Task("Call John", "Discuss the new plan", System.currentTimeMillis() + 3600000, true));
//     // }
// }
// public class MainActivity extends AppCompatActivity {
//     private RecyclerView recyclerView;
//     private FloatingActionButton fabAddTask;
//     private List<Task> taskList; // Define taskList
//     private TaskAdapter taskAdapter;
//     private SharedPreferences sharedPreferences;
//     private SharedPreferences.Editor editor;

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);

//         recyclerView = findViewById(R.id.recyclerView);
//         fabAddTask = findViewById(R.id.fabAddTask);

//         // Initialize the task list
//         taskList = new ArrayList<>();
//         //populateTaskList(); // Add tasks (mock data or real data)

//         // Set up RecyclerView (adapter, layout manager, etc.)
//         recyclerView.setLayoutManager(new LinearLayoutManager(this));
//         taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
//         recyclerView.setAdapter(taskAdapter);

//         // Initialize SharedPreferences
//         sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//         editor = sharedPreferences.edit();

//         // Save data to SharedPreferences
//         editor.putString("taskName", "Complete Project");
//         editor.putBoolean("isCompleted", false);
//         editor.apply(); // Don't forget to apply the changes

//         // Retrieve data from SharedPreferences
//         String taskName = sharedPreferences.getString("taskName", "defaultTaskName");
//         boolean isCompleted = sharedPreferences.getBoolean("isCompleted", false);

//         // Add task button
//         fabAddTask.setOnClickListener(view -> {
//             Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
//             startActivity(intent);
//         });
//     }

// //     private void populateTaskList() {
// //         // Add mock tasks for testing
// //         taskList.add(new Task("Complete Project", "Finish the final report", System.currentTimeMillis() + 86400000, false));
// //         taskList.add(new Task("Buy Groceries", "Milk, eggs, bread", System.currentTimeMillis() + 172800000, false));
// //         taskList.add(new Task("Call John", "Discuss the new plan", System.currentTimeMillis() + 3600000, true));
// //     }
// }
// package com.example.taskmanagement;

// import android.content.Intent;
// import android.content.SharedPreferences;
// import android.os.Bundle;

// import androidx.appcompat.app.AppCompatActivity;
// import androidx.recyclerview.widget.LinearLayoutManager;
// import androidx.recyclerview.widget.RecyclerView;

// import com.google.android.material.floatingactionbutton.FloatingActionButton;

// import java.util.ArrayList;
// import java.util.List;

// public class MainActivity extends AppCompatActivity {
//     private RecyclerView recyclerView;
//     private FloatingActionButton fabAddTask;
//     private List<Task> taskList; // Define taskList
//     private TaskAdapter taskAdapter;
//     private SharedPreferences sharedPreferences;
//     private SharedPreferences.Editor editor;
//     private TaskDao taskDao;

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);

//         recyclerView = findViewById(R.id.recyclerView);
//         fabAddTask = findViewById(R.id.fabAddTask);

//         // Initialize the task list
//         taskList = new ArrayList<>();
//         //populateTaskList(); // Add tasks (mock data or real data)

//         // Set up RecyclerView (adapter, layout manager, etc.)
//         recyclerView.setLayoutManager(new LinearLayoutManager(this));
//         taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
//         recyclerView.setAdapter(taskAdapter);

//         // Initialize SharedPreferences
//         sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//         editor = sharedPreferences.edit();

//         // Save data to SharedPreferences
//         editor.putString("taskName", "Complete Project");
//         editor.putBoolean("isCompleted", false);
//         editor.apply(); // Don't forget to apply the changes

//         // Retrieve data from SharedPreferences
//         String taskName = sharedPreferences.getString("taskName", "defaultTaskName");
//         boolean isCompleted = sharedPreferences.getBoolean("isCompleted", false);

//         // Initialize TaskDao
//         taskDao = DatabaseApp.getDatabase(this).taskDao();

//         // Add task button
//         fabAddTask.setOnClickListener(view -> {
//             Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
//             startActivity(intent);
//         });
//     }

//     @Override
//     protected void onResume() {
//         super.onResume();
//         loadTasks();
//     }

//     private void loadTasks() {
//         taskList.clear();
//         taskList.addAll(taskDao.getAllTasks());
//         taskAdapter.notifyDataSetChanged();
//     }
// }
// package com.example.taskmanagement;

// import android.content.Intent;
// import android.content.SharedPreferences;
// import android.os.Bundle;

// import androidx.appcompat.app.AppCompatActivity;
// import androidx.recyclerview.widget.LinearLayoutManager;
// import androidx.recyclerview.widget.RecyclerView;

// import com.google.android.material.floatingactionbutton.FloatingActionButton;

// import java.util.ArrayList;
// import java.util.List;

// public class MainActivity extends AppCompatActivity {
//     private RecyclerView recyclerView;
//     private FloatingActionButton fabAddTask;
//     private List<Task> taskList; // Define taskList
//     private TaskAdapter taskAdapter;
//     private SharedPreferences sharedPreferences;
//     private SharedPreferences.Editor editor;
//     private TaskDao taskDao;

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);

//         recyclerView = findViewById(R.id.recyclerView);
//         fabAddTask = findViewById(R.id.fabAddTask);

//         // Initialize the task list
//         taskList = new ArrayList<>();
//         //populateTaskList(); // Add tasks (mock data or real data)

//         // Set up RecyclerView (adapter, layout manager, etc.)
//         recyclerView.setLayoutManager(new LinearLayoutManager(this));
//         taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
//         recyclerView.setAdapter(taskAdapter);

//         // Initialize SharedPreferences
//         sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//         editor = sharedPreferences.edit();

//         // Initialize TaskDao
//         taskDao = DatabaseApp.getDatabase(this).taskDao();

//         // Add task button
//         fabAddTask.setOnClickListener(view -> {
//             Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
//             startActivity(intent);
//         });
//     }

//     @Override
//     protected void onResume() {
//         super.onResume();
//         loadTasks();
//     }

//     private void loadTasks() {
//         taskList.clear();
//         taskList.addAll(taskDao.getAllTasks());
//         taskAdapter.notifyDataSetChanged();
//     }

// }
// package com.example.taskmanagement;

// import android.content.Intent;
// import android.content.SharedPreferences;
// import android.os.AsyncTask;
// import android.os.Bundle;

// import androidx.appcompat.app.AppCompatActivity;
// import androidx.recyclerview.widget.LinearLayoutManager;
// import androidx.recyclerview.widget.RecyclerView;

// import com.google.android.material.floatingactionbutton.FloatingActionButton;

// import java.util.ArrayList;
// import java.util.List;

// public class MainActivity extends AppCompatActivity {
//     private RecyclerView recyclerView;
//     private FloatingActionButton fabAddTask;
//     private List<Task> taskList; // Define taskList
//     private TaskAdapter taskAdapter;
//     private SharedPreferences sharedPreferences;
//     private SharedPreferences.Editor editor;
//     private TaskDao taskDao;

//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);

//         recyclerView = findViewById(R.id.recyclerView);
//         fabAddTask = findViewById(R.id.fabAddTask);

//         // Initialize the task list
//         taskList = new ArrayList<>();
//         //populateTaskList(); // Add tasks (mock data or real data)

//         // Set up RecyclerView (adapter, layout manager, etc.)
//         recyclerView.setLayoutManager(new LinearLayoutManager(this));
//         taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
//         recyclerView.setAdapter(taskAdapter);

//         // Initialize SharedPreferences
//         sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//         editor = sharedPreferences.edit();

//         // Initialize TaskDao
//         taskDao = DatabaseApp.getDatabase(this).taskDao();

//         // Add task button
//         fabAddTask.setOnClickListener(view -> {
//             Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
//             startActivity(intent);
//         });
//     }

//     @Override
//     protected void onResume() {
//         super.onResume();
//         new LoadTasksAsyncTask().execute();
//     }

//     private class LoadTasksAsyncTask extends AsyncTask<Void, Void, List<Task>> {
//         @Override
//         protected List<Task> doInBackground(Void... voids) {
//             return taskDao.getAllTasks();
//         }

//         @Override
//         protected void onPostExecute(List<Task> tasks) {
//             taskList.clear();
//             taskList.addAll(tasks);
//             taskAdapter.notifyDataSetChanged();
//         }
//     }
// }

package com.example.taskmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fabAddTask;
    private List<Task> taskList; // Define taskList
    private TaskAdapter taskAdapter;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TaskDao taskDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddTask = findViewById(R.id.fabAddTask);

        // Initialize the task list
        taskList = new ArrayList<>();
        //populateTaskList(); // Add tasks (mock data or real data)

        // Set up RecyclerView (adapter, layout manager, etc.)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(this, taskList); // Pass the context and task list to the adapter
        recyclerView.setAdapter(taskAdapter);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Initialize TaskDao
        taskDao = DatabaseApp.getDatabase(this).taskDao();

        // Add task button
        fabAddTask.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new LoadTasksAsyncTask().execute();
    }

    private class LoadTasksAsyncTask extends AsyncTask<Void, Void, List<Task>> {
        @Override
        protected List<Task> doInBackground(Void... voids) {
            return taskDao.getAllTasks();
        }

        @Override
        protected void onPostExecute(List<Task> tasks) {
            taskList.clear();
            taskList.addAll(tasks);
            taskAdapter.notifyDataSetChanged();
        }
    }
}