package com.example.personalaccount.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{


    public interface OnTaskClickListener{
        void onTaskClick(Task task, int position);
    }

    private final OnTaskClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Task> Tasks;

    public TaskAdapter(Context context, List<Task> Tasks, OnTaskClickListener onClickListener){
        this.onClickListener = onClickListener;
        this.Tasks = Tasks;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.task, parent, false);
        return new TaskAdapter.ViewHolder(view);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Task Task = Tasks.get(position);
        holder.TaskTopic.setText(Task.GetTaskTopic());
        holder.TaskDate.setText(Task.GetTaskDate());
        holder.TaskContent.setText(Task.GetTaskContent());
        holder.TaskStatus.setText(Task.GetTaskStatus());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onTaskClick(Task, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView TaskTopic, TaskDate,TaskContent,TaskStatus;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }






}
