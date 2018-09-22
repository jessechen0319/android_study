package com.example.administrator.calendarmanager;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.calendarmanager.model.TaskStatus;

import java.util.ArrayList;
import java.util.HashMap;

public class TasksRecycleViewAdapter extends RecyclerView.Adapter<TasksRecycleViewAdapter.ViewHolder>{

    private static final String TAG = "TasksRecycleViewAdapter";

    private ArrayList<HashMap<String, String>> data;
    private MainActivity context;

    public TasksRecycleViewAdapter( MainActivity context,  ArrayList<HashMap<String, String>> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: Init View Holder");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tasks, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: fill content");
        viewHolder.taskTitle.setText(data.get(i).get("title"));
        viewHolder.taskContent.setText(data.get(i).get("content"));
        if(data.get(i).get("status").equals(TaskStatus.FINISHED)){
            viewHolder.status.setBackgroundColor(Color.parseColor("#0bf71b"));
            viewHolder.finishBar.setVisibility(View.GONE);
        } else {
            viewHolder.finishBar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    data.get(i).put("status", TaskStatus.FINISHED);
                    notifyItemChanged(i);
                    context.refreshView();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{

        TextView taskTitle;
        TextView taskContent;
        View status;
        Button finishBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.task_title);
            taskContent = itemView.findViewById(R.id.task_desc);
            status = itemView.findViewById(R.id.status_bar);
            finishBar = itemView.findViewById(R.id.finish_button);
        }
    }
}
