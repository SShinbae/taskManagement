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
//         taskAdapter = new TaskAdapter(this, taskList); // Pass the context and task list to the adapter
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
//         protectged void onPostExecute(List<Task> tasks) {
//             taskList.clear();
//             taskList.addAll(tasks);
//             taskAdapter.notifyDataSetChanged();
//         }
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
//         taskAdapter = new TaskAdapter(this, taskList); // Pass the context and task list to the adapter
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
//             taskAdapter.updateTaskList(tasks);
//         }
//     }
// }
//package com.example.taskmanagement;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.textfield.TextInputEditText;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private FloatingActionButton fabAddTask;
//    private List<Task> taskList; // Define taskList
//    private TaskAdapter taskAdapter;
//    private SharedPreferences sharedPreferences;
//    private TextInputEditText searchBar;
//    private FloatingActionButton searchTextInputLayout;
//    private SharedPreferences.Editor editor;
//    private TaskDao taskDao;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        fabAddTask = findViewById(R.id.fabAddTask);
//        searchBar = findViewById(R.id.searchBar);
//        searchTextInputLayout = findViewById(R.id.searchTextInputLayout);
//
//        // Initialize the task list
//        taskList = new ArrayList<>();
//        //populateTaskList(); // Add tasks (mock data or real data)
//
//        // Set up RecyclerView (adapter, layout manager, etc.)
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        taskAdapter = new TaskAdapter(this, taskList); // Pass the context and task list to the adapter
//        recyclerView.setAdapter(taskAdapter);
//
//        // Add custom ItemDecoration
//        recyclerView.addItemDecoration(new TaskDividerItemDecoration(this, taskList));
//
//        // Initialize SharedPreferences
//        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//
//        // Initialize TaskDao
//        taskDao = DatabaseApp.getDatabase(this).taskDao();
//
//        // Add task button
//        fabAddTask.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class); // Replace with the correct activity
//            startActivity(intent);
//        });
//
//        //Search Functionality
////        searchTextInputLayout.setEndIconOnClickListener(v -> SearchTasks(searchBar.getText().toString()));
//        searchTextInputLayout.setEndIconOnClickListener(v -> SearchTasks(searchBar.getText().toString()));
//
//        searchBar.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        new LoadTasksAsyncTask().execute();
//    }
//
//    private void SearchTasks(String query) {
//        List<Task> filteredTasks = new ArrayList<>();
//        for (Task task : taskList){
//            if (task.getTitle().toLowerCase().contains(query.toLowerCase()) || task.getDescription().toLowerCase().contains(query.toLowerCase())){
//                filteredTasks.add(task);
//            }
//        }
//        taskAdapter.updateTaskList(filteredTasks);
//    }
//
//    private class LoadTasksAsyncTask extends AsyncTask<Void, Void, List<Task>> {
//        @Override
//        protected List<Task> doInBackground(Void... voids) {
//            return taskDao.getAllTasks();
//        }
//
//        @Override
//        protected void onPostExecute(List<Task> tasks) {
//            taskList.clear();
//            taskList.addAll(tasks);
//            taskAdapter.updateTaskList(tasks);
//        }
//    }
//}
package com.example.taskmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
    private TextInputEditText searchBar;
    private TextInputLayout searchTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddTask = findViewById(R.id.fabAddTask);
        searchBar = findViewById(R.id.searchBar);
        searchTextInputLayout = findViewById(R.id.searchTextInputLayout);

        // Initialize the task list
        taskList = new ArrayList<>();
        //populateTaskList(); // Add tasks (mock data or real data)

        // Set up RecyclerView (adapter, layout manager, etc.)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(this, taskList); // Pass the context and task list to the adapter
        recyclerView.setAdapter(taskAdapter);

        // Add custom ItemDecoration
        recyclerView.addItemDecoration(new TaskDividerItemDecoration(this, taskList));

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

        // Search functionality
        searchTextInputLayout.setEndIconOnClickListener(v -> searchTasks(searchBar.getText().toString()));

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchTasks(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new LoadTasksAsyncTask().execute();
    }

    private void searchTasks(String query) {
        List<Task> filteredTaskList = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(query.toLowerCase())) {
                filteredTaskList.add(task);
            }
        }
        taskAdapter.updateTaskList(filteredTaskList);
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
            taskAdapter.updateTaskList(tasks);
        }
    }
}