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
import com.example.personalaccount.model.Status;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder>{


    private final LayoutInflater inflater;
    private final List<Status> Statuses;

    public StatusAdapter(Context context, List<Status> Statuses){

        this.Statuses = Statuses;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public StatusAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.status_history, parent, false);
        return new StatusAdapter.ViewHolder(view);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(StatusAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Status Status = Statuses.get(position);
        holder.StatusType.setText(Status.GetStatusType());
        holder.StatusDate.setText(Status.GetStatusDate());
        holder.StatusComment.setText(Status.GetStatusComment());
        holder.StatusFile.setText(Status.GetStatusFile());

    }

    @Override
    public int getItemCount() {
        return Statuses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView StatusType, StatusDate,StatusComment,StatusFile;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            StatusType = (TextView) view.findViewById(R.id.StatusType);
            StatusDate = (TextView) view.findViewById(R.id.StatusDate);
            StatusComment = (TextView) view.findViewById(R.id.Comment);
            StatusFile = (TextView) view.findViewById(R.id.FileName);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

}
