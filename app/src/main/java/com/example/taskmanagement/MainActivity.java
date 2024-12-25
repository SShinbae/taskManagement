package com.example.taskmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fabAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddTask = findViewById(R.id.fabAddTask);


        // Set up RecyclerView (adapter, layout manager, etc.)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TaskAdapter(taskList));

        // Add task button
        fabAddTask.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, addTaskActivity.class);
            startActivity(intent);
        });
    }


}

