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
        taskAdapter = new TaskAdapter(this, new ArrayList<>()); // Pass the context and task list to the adapter
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
            if (task != null && (task.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(query.toLowerCase()))) {
                filteredTaskList.add(task);
            }
        }

        categorizeTasks(filteredTaskList);
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
            categorizeTasks(taskList);
        }
    }

    private void categorizeTasks(List<Task> tasks) {
        List<Object> itemList = new ArrayList<>();
        List<Task> incompleteTasks = new ArrayList<>();
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            } else {
                incompleteTasks.add(task);
            }
        }

        // Combine lists with headers
        if (!incompleteTasks.isEmpty()) {
            itemList.add("Incomplete Tasks");
            itemList.addAll(incompleteTasks);
        }
        if (!completedTasks.isEmpty()) {
            itemList.add("Complete Tasks");
            itemList.addAll(completedTasks);
        }

        taskAdapter.updateTaskList(itemList);
    }
}