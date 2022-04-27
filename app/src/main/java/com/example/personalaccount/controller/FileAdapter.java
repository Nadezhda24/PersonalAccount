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
import com.example.personalaccount.model.File;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<File> Files;

    public FileAdapter(Context context, List<File> Files){
        this.Files = Files;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.file, parent, false);
        return new FileAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(FileAdapter.ViewHolder holder, int position) {
        File File = Files.get(position);
        holder.FileName.setText(File.getName());

    }

    @Override
    public int getItemCount() {
        return Files.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView FileName;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            FileName = (TextView) view.findViewById(R.id.FileName);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

}
