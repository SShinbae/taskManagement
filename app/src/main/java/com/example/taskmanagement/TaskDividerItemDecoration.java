package com.example.taskmanagement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskDividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Paint paint;
    private final int dividerHeight;
    private final List<Task> taskList;

    public TaskDividerItemDecoration(Context context, List<Task> taskList) {
        this.paint = new Paint();
        this.paint.setColor(context.getResources().getColor(android.R.color.darker_gray));
        this.dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        this.taskList = taskList;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(canvas, parent, state);

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            if (position < taskList.size() - 1 && taskList.get(position) != null && taskList.get(position + 1) != null &&
                taskList.get(position).isCompleted() != taskList.get(position + 1).isCompleted()) {
                float left = parent.getPaddingLeft();
                float right = parent.getWidth() - parent.getPaddingRight();
                float top = child.getBottom();
                float bottom = top + dividerHeight;

                canvas.drawRect(left, top, right, bottom, paint);
            }
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position < taskList.size() - 1 && taskList.get(position) != null && taskList.get(position + 1) != null &&
            taskList.get(position).isCompleted() != taskList.get(position + 1).isCompleted()) {
            outRect.bottom = dividerHeight;
        } else {
            outRect.bottom = 0;
        }
    }
}