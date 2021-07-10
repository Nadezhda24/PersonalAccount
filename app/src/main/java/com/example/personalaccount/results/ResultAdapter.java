package com.example.personalaccount.results;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>  {
    private final LayoutInflater inflater;
    private final List<Result> Resalts;

    public ResultAdapter(Context context, List<Result> Resalts){
        this.Resalts = Resalts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.subject_result, parent, false);
        return new ResultAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ResultAdapter.ViewHolder holder, int position) {
        Result Result = Resalts.get(position);
        holder.SubjectName.setText(Result.GetSubjectName());
        holder.SubjectTeacher.setText(Result.GetSubjectTeacher());
        holder.SubjectType.setText(Result.GetSubjectType());
        holder.SubjectResult.setText(Result.GetSubjectResult());
    }

    @Override
    public int getItemCount() {
        return Resalts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView SubjectName,SubjectTeacher, SubjectType, SubjectResult;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            SubjectName = (TextView) view.findViewById(R.id.SubjectName);
            SubjectTeacher = (TextView) view.findViewById(R.id.SubjectTeacher);
            SubjectType = (TextView) view.findViewById(R.id.SubjectType);
            SubjectResult = (TextView) view.findViewById(R.id.SubjectResult);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }


}
