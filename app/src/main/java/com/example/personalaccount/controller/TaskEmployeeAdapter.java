package com.example.personalaccount.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Task;

import java.util.List;

public class TaskEmployeeAdapter<override> extends RecyclerView.Adapter<TaskEmployeeAdapter.ViewHolder>{

    private final int STAGED = 0; //поставлена
    private final int PERFORMED = 1; //в исполнении
    private final int SENT = 2; //отправлена на проверку
    private final int REVIEW = 3; //на проверке
    private final int REVISION = 4; //отправлена на доработку
    private final int COMPLETED = 5; //выполнена


    public interface OnTaskClickListener{
        void onTaskClick(Task task, int position);
    }

    private final OnTaskClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Task> Tasks;

    public TaskEmployeeAdapter(Context context, List<Task> Tasks, OnTaskClickListener onClickListener){
        this.onClickListener = onClickListener;
        this.Tasks = Tasks;
        this.inflater = LayoutInflater.from(context);
    }

    public int getItemViewType(int position)
    {
        int type = 0;
        switch (Tasks.get(position).GetTaskStatus()){
            case "поставлена": type = STAGED; break;
            case "в исполнении": type = PERFORMED; break;
            case "отправлена на проверку": type = SENT; break;
            case "на проверке": type = REVIEW; break;
            case "отправлена на доработку": type = REVISION; break;
            case "выполнена": type = COMPLETED; break;
            default: type = -1;
        }
        return type;
    }

    @Override
    public TaskEmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        switch (viewType)
        {
            case STAGED:
                return new ViewHolderSimple(inflater.inflate(R.layout.task_simple, parent, false));
            case PERFORMED:
                 return new ViewHolderSimple(inflater.inflate(R.layout.task_simple, parent, false));
            case SENT:
                return new ViewHolderFileButton(inflater.inflate(R.layout.task_file_button, parent, false));
            case REVIEW:
               return new ViewHolderComment(inflater.inflate(R.layout.task_comment, parent, false));
            case REVISION:
               return new ViewHolderFileComment( inflater.inflate(R.layout.task_file_comment, parent, false));
            case COMPLETED:
                return new ViewHolderSimple(inflater.inflate(R.layout.task_simple, parent, false));
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

    }

    public void Update(){
        notifyDataSetChanged();
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(TaskEmployeeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Task Task = Tasks.get(position);
        switch (holder.getItemViewType()){
            case STAGED:
                ViewHolderSimple staged = (ViewHolderSimple) holder;
                staged.TaskTopic.setText(Task.GetTaskTopic());
                staged.TaskDate.setText(Task.GetTaskDate());
                staged.TaskContent.setText(Task.GetTaskContent());
                staged.TaskStatus.setText(Task.GetTaskStatus());
                staged.TaskStatus.setTextColor(Color.parseColor("#CC0063"));

                staged.TaskStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Task.SetTaskStatus("в исполнении");
                        if (Task.GetTaskStatus() == "в исполнении") Update();
                    }
                });

                staged.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });


                break;
            case PERFORMED:
                ViewHolderSimple performed = (ViewHolderSimple) holder;
                performed.TaskTopic.setText(Task.GetTaskTopic());
                performed.TaskDate.setText(Task.GetTaskDate());
                performed.TaskContent.setText(Task.GetTaskContent());
                performed.TaskStatus.setText(Task.GetTaskStatus());
                performed.TaskStatus.setTextColor(Color.parseColor("#CC0063"));

                performed.TaskStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Task.SetTaskStatus("отправлена на проверку");
                        if (Task.GetTaskStatus() == "отправлена на проверку") Update();
                    }
                });

                performed.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });
                break;
            case SENT:
                ViewHolderFileButton sent = (ViewHolderFileButton) holder;
                sent.TaskTopic.setText(Task.GetTaskTopic());
                sent.TaskDate.setText(Task.GetTaskDate());
                sent.TaskContent.setText(Task.GetTaskContent());
                sent.TaskStatus.setText(Task.GetTaskStatus());
                sent.TaskStatus.setTextColor(R.color.DarkBlue);
                sent.FileName.setText(Task.GetTaskStatus());
                sent.ButtonСonfirm.setText("Подтвердить получение файла");

                sent.ButtonСonfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Подтвердить получение файла" ,
                            Toast.LENGTH_SHORT).show();

                    Task.SetTaskStatus("на проверке");
                    if (Task.GetTaskStatus() == "на проверке") Update();

                }
            });

                sent.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });
                break;
            case REVIEW:
                ViewHolderComment review = (ViewHolderComment) holder;
                review.TaskTopic.setText(Task.GetTaskTopic());
                review.TaskDate.setText(Task.GetTaskDate());
                review.TaskContent.setText(Task.GetTaskContent());
                review.TaskStatus.setText(Task.GetTaskStatus());
                review.TaskStatus.setTextColor(R.color.DarkBlue);
                review.FileName.setText(Task.GetTaskStatus());
                review.Button2.setText("Отправить на доработку");
                review.Button3.setText("Задача выполнена");

                review.Button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(v.getContext(), "Отправить на доработку" ,
                                Toast.LENGTH_SHORT).show();

                        Task.SetTaskStatus("отправлена на доработку");
                        if (Task.GetTaskStatus() == "отправлена на доработку") Update();

                    }
                });

                review.Button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "Задача выполнена" ,
                                Toast.LENGTH_SHORT).show();

                        Task.SetTaskStatus("выполнена");
                        if (Task.GetTaskStatus() == "выполнена") Update();

                    }
                });

                review.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });
                break;
            case REVISION:
                ViewHolderFileComment revision = (ViewHolderFileComment) holder;
                revision.TaskTopic.setText(Task.GetTaskTopic());
                revision.TaskDate.setText(Task.GetTaskDate());
                revision.TaskContent.setText(Task.GetTaskContent());
                revision.TaskStatus.setText(Task.GetTaskStatus());
                revision.TaskStatus.setTextColor(R.color.DarkBlue);
                revision.FileName.setText(Task.GetTaskStatus());

                revision.TaskStatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Task.SetTaskStatus("в исполнении");
                        if (Task.GetTaskStatus() == "в исполнении") Update();
                    }
                });

                revision.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });
                break;
            case COMPLETED:
                ViewHolderSimple completed = (ViewHolderSimple) holder;
                completed.TaskTopic.setText(Task.GetTaskTopic());
                completed.TaskDate.setText(Task.GetTaskDate());
                completed.TaskContent.setText(Task.GetTaskContent());
                completed.TaskStatus.setText(Task.GetTaskStatus());
                completed.TaskStatus.setTextColor(Color.parseColor("#00B796"));

                completed.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.onTaskClick(Task, position);
                    }
                });
                break;
        }

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

    public static class ViewHolderFileButton extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus, FileName;
        Button ButtonСonfirm;
        ViewHolderFileButton(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            FileName = (TextView) view.findViewById(R.id.FileName);
            ButtonСonfirm = (Button) view.findViewById(R.id.button2);
        }
    }

    public static class ViewHolderButton extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus, FileName;
        Button Button;
        ViewHolderButton(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            FileName = (TextView) view.findViewById(R.id.FileName);
            Button = (Button) view.findViewById(R.id.button);
        }
    }

    public static class ViewHolderComment extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus, FileName;
        Button Button2, Button3;
        ViewHolderComment(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            FileName = (TextView) view.findViewById(R.id.FileName);
            Button2 = (Button) view.findViewById(R.id.button2);
            Button3 = (Button) view.findViewById(R.id.button3);
        }
    }

    public static class ViewHolderFileComment extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus, FileName, Comment;
        ViewHolderFileComment(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            FileName = (TextView) view.findViewById(R.id.FileName);
            Comment = (TextView) view.findViewById(R.id.Comment);
        }
    }

    public static class ViewHolderFileCommentButton extends ViewHolder {
        TextView TaskTopic, TaskDate,TaskContent,TaskStatus, FileName, Comment;
        Button Button;
        ViewHolderFileCommentButton(View view) {
            super(view);
            TaskTopic = (TextView) view.findViewById(R.id.TaskTopic);
            TaskDate = (TextView) view.findViewById(R.id.TaskDate);
            TaskContent = (TextView) view.findViewById(R.id.TaskContent);
            TaskStatus = (TextView) view.findViewById(R.id.TaskStatus);
            FileName = (TextView) view.findViewById(R.id.FileName);
            Comment = (TextView) view.findViewById(R.id.Comment);
            Button = (Button) view.findViewById(R.id.button4);
        }
    }
}
