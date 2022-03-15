package com.example.personalaccount.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Task;

import java.util.List;

public class TaskAdapter<override> extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    private final int LAYOUT1 = 0; //поставлена
    private final int LAYOUT2 = 1; //в исполнении
    private final int LAYOUT3 = 2; //отправлена на проверку
    private final int LAYOUT4 = 3; //на проверке
    private final int LAYOUT5 = 4; //отправлена на доработку
    private final int LAYOUT6 = 5; //выполнена


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

    public int GetItemViewType(int position)
    {
        int type = 0;
        switch (Tasks.get(position).GetTaskStatus()){
            case "поставлена": type = LAYOUT1; break;
            case "в исполении": type = LAYOUT2; break;
            case "отправлена на проверку": type = LAYOUT3; break;
            case "на проверке": type = LAYOUT4; break;
            case "отправлена на боработку": type = LAYOUT5; break;
            case "выполнена": type = LAYOUT6; break;
        }
        return type;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view = null;
        switch (viewType)
        {
            case LAYOUT1:
                view = inflater.inflate(R.layout.task_file, parent, false);
                return new ViewHolderFile(view);
            case LAYOUT2:
                view = inflater.inflate(R.layout.task_file, parent, false);
                return new ViewHolderFile(view);
            case LAYOUT3:
                view = inflater.inflate(R.layout.task_simple, parent, false);
                return new ViewHolder(view);
            case LAYOUT4:
                view = inflater.inflate(R.layout.task_simple, parent, false);
                return new ViewHolder(view);
            case LAYOUT5:
                view = inflater.inflate(R.layout.task_simple, parent, false);
                return new ViewHolder(view);
            case LAYOUT6:
                view = inflater.inflate(R.layout.task_simple, parent, false);
                return new ViewHolder(view);
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Task Task = Tasks.get(position);
        //switch (GetItemViewType(position)){
         //   case LAYOUT1:
       /*         ViewHolderSimple viewSimple = (ViewHolderSimple) holder;
                viewSimple.TaskTopic.setText(Task.GetTaskTopic());
                viewSimple.TaskDate.setText(Task.GetTaskDate());
                viewSimple.TaskContent.setText(Task.GetTaskContent());
                viewSimple.TaskStatus.setText(Task.GetTaskStatus());

                viewSimple.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });

        */
        //        break;
        //    case LAYOUT2:
                ViewHolderFile view = (ViewHolderFile) holder;
                view.TaskTopic.setText(Task.GetTaskTopic());
                view.TaskDate.setText(Task.GetTaskDate());
                view.TaskContent.setText(Task.GetTaskContent());
                view.TaskStatus.setText(Task.GetTaskStatus());
                view.FileName.setText(Task.GetTaskStatus());
                view.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });
         //       break;
        //}

    }

    @Override
    public int getItemCount() {
        return Tasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);

            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }

    }

    public static class ViewHolderSimple extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus;
        ViewHolderSimple(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
        }
    }

    public static class ViewHolderFile extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus, FileName;
        ViewHolderFile(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            FileName = (TextView) view.findViewById(R.id.FileName);
        }
    }






}
