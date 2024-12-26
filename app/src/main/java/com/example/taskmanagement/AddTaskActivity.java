package com.example.taskmanagement;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskmanagement.databinding.ActivityAddTaskBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddTaskActivity extends AppCompatActivity {

    private ActivityAddTaskBinding binding;
    private TaskDao taskDao;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        taskDao = DatabaseApp.getDatabase(this).taskDao();

        binding.btnSave.setOnClickListener(v -> saveTask());

        binding.editDueDate.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    Calendar selectedCalendar = Calendar.getInstance();
                    selectedCalendar.set(selectedYear, selectedMonth, selectedDay);
                    binding.editDueDate.setText(dateFormat.format(selectedCalendar.getTime()));
                },
                year,
                month,
                day
        );
        datePickerDialog.show();
    }

    private void saveTask() {
        String title = binding.editTitle.getText().toString().trim();
        String description = binding.editDescription.getText().toString().trim();
        String dueDateString = binding.editDueDate.getText().toString().trim();

        if (title.isEmpty() || description.isEmpty() || dueDateString.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Date dueDate = dateFormat.parse(dueDateString);
            long dueDateMillis = dueDate.getTime();
            Task newTask = new Task(title, description, dueDateMillis, false);
            executorService.execute(() -> {
                try {
                    taskDao.insert(newTask);
                    runOnUiThread(() -> {
                        Toast.makeText(AddTaskActivity.this, "Task added successfully", Toast.LENGTH_SHORT).show();
                        finish(); // Close AddTaskActivity and return to MainActivity
                    });
                } catch (Exception e) {
                    Log.e("AddTaskActivity", "Error inserting task", e);
                }
            });
        } catch (ParseException e) {
            Toast.makeText(this, "Invalid date format", Toast.LENGTH_SHORT).show();
            Log.e("AddTaskActivity", "Date parsing error", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}