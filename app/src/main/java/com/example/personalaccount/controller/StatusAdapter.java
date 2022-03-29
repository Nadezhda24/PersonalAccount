package com.example.personalaccount.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Status;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder>{

    private final int STAGED = 0; //поставлена
    private final int PERFORMED = 1; //в исполнении
    private final int SENT = 2; //отправлена на проверку
    private final int REVIEW = 3; //на проверке
    private final int REVISION = 4; //отправлена на доработку
    private final int COMPLETED = 5; //выполнена


    private final LayoutInflater inflater;
    private final List<Status> Statuses;

    public StatusAdapter(Context context, List<Status> Statuses){

        this.Statuses = Statuses;
        this.inflater = LayoutInflater.from(context);
    }

    public int getItemViewType(int position)
    {
        int type = 0;
        switch (Statuses.get(position).GetStatusType()){
            case "поставлена": type = STAGED; break;
            case "в исполнении": type = PERFORMED; break;
            case "отправлена на проверку": type = SENT; break;
            case "на проверке": type = REVIEW; break;
            case "отправлена на доработку": type = REVISION; break;
            case "выполнена": type = COMPLETED; break;
        }
        return type;
    }

    @Override
    public StatusAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        switch (viewType)
        {
            case STAGED:
                return new StatusAdapter.ViewHolder(inflater.inflate(R.layout.starus_text, parent, false));
            case PERFORMED:
                return new StatusAdapter.ViewHolder(inflater.inflate(R.layout.starus_text, parent, false));
            case SENT:
                return new StatusAdapter.ViewHolderFile(inflater.inflate(R.layout.starus_file, parent, false));
            case REVIEW:
                return new StatusAdapter.ViewHolder(inflater.inflate(R.layout.starus_text, parent, false));
            case REVISION:
                return new StatusAdapter.ViewHolderComment( inflater.inflate(R.layout.starus_comment, parent, false));
            case COMPLETED:
                return new StatusAdapter.ViewHolder(inflater.inflate(R.layout.starus_text, parent, false));
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }



    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(StatusAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Status Status = Statuses.get(position);

        switch (holder.getItemViewType()) {
            case STAGED:
                StatusAdapter.ViewHolder staged = (StatusAdapter.ViewHolder) holder;
                staged.Status.setText("Задача поставлена с " + Status.GetStatusDate());
                break;
            case PERFORMED:
                StatusAdapter.ViewHolder performed = (StatusAdapter.ViewHolder) holder;
                performed.Status.setText("Задача находится в исполнении с " + Status.GetStatusDate());
                break;
            case SENT:
                StatusAdapter.ViewHolderFile sent = (StatusAdapter.ViewHolderFile) holder;
                sent.Status.setText("Задача отправлена на проверку  " + Status.GetStatusDate());
                sent.File.setText(Status.GetStatusFile());
                break;
            case REVIEW:
                StatusAdapter.ViewHolder review = (StatusAdapter.ViewHolder) holder;
                review.Status.setText("Задача находится на проверке с " + Status.GetStatusDate());
                break;
            case REVISION:
                StatusAdapter.ViewHolderComment revision = (StatusAdapter.ViewHolderComment) holder;
                revision.Status.setText("Задача отправлена на доработку " + Status.GetStatusDate());
                break;
            case COMPLETED:
                StatusAdapter.ViewHolder completed = (StatusAdapter.ViewHolder) holder;
                completed.Status.setText("Задача выполнена " + Status.GetStatusDate());
                break;
           }

    }

    @Override
    public int getItemCount() {
        return Statuses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final FrameLayout frameLayout;
        final TextView Status;
        ViewHolder(View view){
            super(view);
            Status = (TextView) view.findViewById(R.id.Status);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }


    public static class ViewHolderFile extends ViewHolder {
        final TextView File;
        final TextView Status;
        ViewHolderFile(View view){
            super(view);
            Status = (TextView) view.findViewById(R.id.Status);
            File = (TextView) view.findViewById(R.id.FileName);
        }
    }

    public static class ViewHolderComment extends ViewHolder {
        final TextView  Comment;
        final TextView Status;
        ViewHolderComment(View view){
            super(view);
            Status = (TextView) view.findViewById(R.id.Status);
            Comment = (TextView) view.findViewById(R.id.Comment);
        }
    }
}
