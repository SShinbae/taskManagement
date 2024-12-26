package com.example.taskmanagement;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String description;
    public long dueDate;
    public boolean isCompleted;
    public String priority;
    //public boolean isCompleted;

    // Constructor
    public Task(String title, String description, long dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.priority = priority;
        //this.isCompleted = isCompleted;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }


    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
