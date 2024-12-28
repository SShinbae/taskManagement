package com.example.taskmanagement;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_TASK = 0;
    private static final int VIEW_TYPE_SEPARATOR = 1;

    private final List<Task> taskList;
    private final Context context;
    private boolean separatorAdded = false;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
        sortTaskList();
    }

    @Override
    public int getItemViewType(int position) {
        if (taskList.get(position) == null) {
            return VIEW_TYPE_SEPARATOR;
        } else {
            return VIEW_TYPE_TASK;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_TASK) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_task_adapters, parent, false);
            return new TaskViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_separator, parent, false);
            return new SeparatorViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_TASK) {
            TaskViewHolder taskViewHolder = (TaskViewHolder) holder;
            Task task = taskList.get(position);
            taskViewHolder.title.setText(task.getTitle());
            taskViewHolder.description.setText(task.getDescription());
            taskViewHolder.dueDate.setText(formatDate(task.getDueDate()));

            // Set background color based on completion status
            if (task.isCompleted()) {
                taskViewHolder.itemView.setBackgroundColor(Color.GREEN);
            } else {
                taskViewHolder.itemView.setBackgroundColor(Color.RED);
            }

            taskViewHolder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, TaskDetailActivity.class);
                intent.putExtra("TASK_ID", task.id);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void updateTaskList(List<Task> newTaskList) {
        taskList.clear();
        taskList.addAll(newTaskList);
        sortTaskList();
        notifyDataSetChanged();
    }

    private void sortTaskList() {
        Collections.sort(taskList, (task1, task2) -> {
            if (task1.isCompleted() && !task2.isCompleted()) {
                return 1;
            } else if (!task1.isCompleted() && task2.isCompleted()) {
                return -1;
            } else {
                return 0;
            }
        });

        // Add separator if not already added
        if (!separatorAdded) {
            for (int i = 0; i < taskList.size() - 1; i++) {
                if (!taskList.get(i).isCompleted() && taskList.get(i + 1).isCompleted()) {
                    taskList.add(i + 1, null); // Add null as a separator
                    separatorAdded = true;
                    break;
                }
            }
        }
    }

    static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, dueDate;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.taskTitle);
            description = itemView.findViewById(R.id.taskDescription);
            dueDate = itemView.findViewById(R.id.taskDueDate);
        }
    }

    static class SeparatorViewHolder extends RecyclerView.ViewHolder {
        public SeparatorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }
}