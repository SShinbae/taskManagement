package com.example.taskmanagement;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.taskmanagement.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);

    @Query("SELECT * FROM Task WHERE id = :taskId LIMIT 1")
    Task getTaskById(int taskId);

    @Query("SELECT * FROM Task")
    List<Task> getAllTasks();
}
