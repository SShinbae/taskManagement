package com.example.taskmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskmanagement.Task;
import com.example.taskmanagement.TaskAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fabAddTask;
    private List<Task> taskList; // Define taskList
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddTask = findViewById(R.id.fabAddTask);

        // Initialize the task list
        taskList = new ArrayList<>();
        populateTaskList(); // Add tasks (mock data or real data)

        // Set up RecyclerView (adapter, layout manager, etc.)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(taskList); // Pass the task list to the adapter
        recyclerView.setAdapter(taskAdapter);

        // Add task button
        fabAddTask.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TaskAdapter.class);
            startActivity(intent);
        });
    }

    private void populateTaskList() {
        // Add mock tasks for testing
        taskList.add(new Task("Complete Project", "Finish the final report", System.currentTimeMillis() + 86400000, false));
        taskList.add(new Task("Buy Groceries", "Milk, eggs, bread", System.currentTimeMillis() + 172800000, false));
        taskList.add(new Task("Call John", "Discuss the new plan", System.currentTimeMillis() + 3600000, true));
    }
}
