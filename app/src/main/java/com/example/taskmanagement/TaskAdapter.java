// package com.example.taskmanagement;

// import android.view.LayoutInflater;
// import android.view.View;
// import android.view.ViewGroup;
// import android.widget.TextView;

// import androidx.annotation.NonNull;
// import androidx.recyclerview.widget.RecyclerView;

// import java.text.SimpleDateFormat;
// import java.util.List;
// import java.util.Locale;

// public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
//     private final List<Task> taskList;

//     public TaskAdapter(List<Task> taskList) {
//         this.taskList = taskList;
//     }

//     @NonNull
//     @Override
//     public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_task_adapters, parent, false);
//         return new TaskViewHolder(view);
//     }

// //    @Override
// //    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
// //        Task task = taskList.get(position);
// //        holder.title.setText(task.getTitle());
// //        holder.description.setText(task.getDescription());
// //        holder.dueDate.setText(formatDate(task.getDueDate()));
// //    }

//     @Override
//     public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
//         Task task = taskList.get(position);
//         holder.title.setText(task.getTitle()); // Use the getter
//         holder.description.setText(task.getDescription()); // Use the getter
//         holder.dueDate.setText(formatDate(task.getDueDate())); // Use the getter
//     }


//     @Override
//     public int getItemCount() {
//         return taskList.size();
//     }

//     static class TaskViewHolder extends RecyclerView.ViewHolder {
//         TextView title, description, dueDate;

//         public TaskViewHolder(@NonNull View itemView) {
//             super(itemView);
//             title = itemView.findViewById(R.id.taskTitle);
//             description = itemView.findViewById(R.id.taskDescription);
//             dueDate = itemView.findViewById(R.id.taskDueDate);
//         }
//     }

//     private String formatDate(long timestamp) {
//         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//         return sdf.format(timestamp);
//     }
// }

// package com.example.taskmanagement;

// import android.content.Context;
// import android.content.Intent;
// import android.view.LayoutInflater;
// import android.view.View;
// import android.view.ViewGroup;
// import android.widget.TextView;

// import androidx.annotation.NonNull;
// import androidx.recyclerview.widget.RecyclerView;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.List;
// import java.util.Locale;

// public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
//     private final List<Task> taskList;
//     private final Context context;

//     public TaskAdapter(Context context, List<Task> taskList) {
//         this.context = context;
//         this.taskList = taskList;
//     }

//     @NonNull
//     @Override
//     public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_task_adapters, parent, false);
//         return new TaskViewHolder(view);
//     }

//     @Override
//     public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
//         Task task = taskList.get(position);
//         holder.title.setText(task.getTitle());
//         holder.description.setText(task.getDescription());
//         holder.dueDate.setText(formatDate(task.getDueDate()));

//         holder.itemView.setOnClickListener(v -> {
//             Intent intent = new Intent(context, TaskDetailActivity.class);
//             intent.putExtra("TASK_ID", task.id);
//             context.startActivity(intent);
//         });
//     }

//     @Override
//     public int getItemCount() {
//         return taskList.size();
//     }

//     static class TaskViewHolder extends RecyclerView.ViewHolder {
//         TextView title, description, dueDate;

//         public TaskViewHolder(@NonNull View itemView) {
//             super(itemView);
//             title = itemView.findViewById(R.id.taskTitle);
//             description = itemView.findViewById(R.id.taskDescription);
//             dueDate = itemView.findViewById(R.id.taskDueDate);
//         }
//     }

//     private String formatDate(long timestamp) {
//         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//         return sdf.format(new Date(timestamp));
//     }
// }

// package com.example.taskmanagement;

// import android.content.Context;
// import android.content.Intent;
// import android.view.LayoutInflater;
// import android.view.View;
// import android.view.ViewGroup;
// import android.widget.TextView;

// import androidx.annotation.NonNull;
// import androidx.recyclerview.widget.RecyclerView;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.List;
// import java.util.Locale;

// public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
//     private final List<Task> taskList;
//     private final Context context;

//     public TaskAdapter(Context context, List<Task> taskList) {
//         this.context = context;
//         this.taskList = taskList;
//     }

//     @NonNull
//     @Override
//     public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_task_adapters, parent, false);
//         return new TaskViewHolder(view);
//     }

//     @Override
//     public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
//         Task task = taskList.get(position);
//         holder.title.setText(task.getTitle());
//         holder.description.setText(task.getDescription());
//         holder.dueDate.setText(formatDate(task.getDueDate()));

//         holder.itemView.setOnClickListener(v -> {
//             Intent intent = new Intent(context, TaskDetailActivity.class);
//             intent.putExtra("TASK_ID", task.id);
//             context.startActivity(intent);
//         });
//     }

//     @Override
//     public int getItemCount() {
//         return taskList.size();
//     }

//     static class TaskViewHolder extends RecyclerView.ViewHolder {
//         TextView title, description, dueDate;

//         public TaskViewHolder(@NonNull View itemView) {
//             super(itemView);
//             title = itemView.findViewById(R.id.taskTitle);
//             description = itemView.findViewById(R.id.taskDescription);
//             dueDate = itemView.findViewById(R.id.taskDueDate);
//         }
//     }

//     private String formatDate(long timestamp) {
//         SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
//         return sdf.format(new Date(timestamp));
//     }
// }
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

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private final List<Task> taskList;
    private final Context context;

    public TaskAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
        sortTaskList();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_task_adapters, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.title.setText(task.getTitle());
        holder.description.setText(task.getDescription());
        holder.dueDate.setText(formatDate(task.getDueDate()));

        // Set background color based on completion status
        if (task.isCompleted()) {
            holder.itemView.setBackgroundColor(Color.GREEN);
        } else {
            holder.itemView.setBackgroundColor(Color.RED);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TaskDetailActivity.class);
            intent.putExtra("TASK_ID", task.id);
            context.startActivity(intent);
        });
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

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }
}