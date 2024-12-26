package com.example.taskmanagement;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskDatabase {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String description;
    public long dueDate;
    public boolean isCompleted;

    // Constructor
    public TaskDatabase(String title, String description, long dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    // Getters and Setters (optional if needed for specific use cases)
}
