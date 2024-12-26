package com.example.taskmanagement;

import android.app.Application;
import androidx.room.Room;

public class DatabaseApp extends Application {
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(this, AppDatabase.class, "task-database").build();
    }

    public static AppDatabase getDatabase(android.content.Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "task-database").build();
        }
        return database;
    }
}