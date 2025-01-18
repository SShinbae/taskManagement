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
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_TASK = 0;
    private static final int VIEW_TYPE_HEADER = 1;

    private final List<Object> itemList;
    private final Context context;

    public TaskAdapter(Context context, List<Object> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getItemViewType(int position) {
        if (itemList.get(position) instanceof String) {
            return VIEW_TYPE_HEADER;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            return new HeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VIEW_TYPE_TASK) {
            TaskViewHolder taskViewHolder = (TaskViewHolder) holder;
            Task task = (Task) itemList.get(position);
            taskViewHolder.title.setText(task.getTitle());
            taskViewHolder.description.setText(task.getDescription());
            taskViewHolder.dueDate.setText(formatDate(task.getDueDate()));

            // Set text color based on completion status
//            int textColor = task.isCompleted() ? Color.GREEN : Color.RED;
//            taskViewHolder.title.setTextColor(textColor);
//            taskViewHolder.description.setTextColor(textColor);
//            taskViewHolder.dueDate.setTextColor(textColor);

            taskViewHolder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, TaskDetailActivity.class);
                intent.putExtra("TASK_ID", task.id);
                context.startActivity(intent);
            });
        } else {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.headerTitle.setText((String) itemList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void updateTaskList(List<Object> newItemList) {
        itemList.clear();
        itemList.addAll(newItemList);
        notifyDataSetChanged();
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

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.headerTitle);
        }
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault());
        return sdf.format(new Date(timestamp));
    }
}