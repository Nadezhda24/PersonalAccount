package com.example.personalaccount.edu;

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

public class EduSubjectAdapter extends RecyclerView.Adapter<EduSubjectAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Edu>  Scores;

    public EduSubjectAdapter(Context context, List<Edu> Scores){
        this.Scores = Scores;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public EduSubjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.edu_score_subject, parent, false);
        return new EduSubjectAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(EduSubjectAdapter.ViewHolder holder, int position) {
        Edu Score = Scores.get(position);
        holder.SubjectDate.setText(Score.GetSubjectDate());
        holder.SubjectScore.setText(Score.GetSubjectScore());

    }

    @Override
    public int getItemCount() {
        return Scores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView SubjectDate, SubjectScore;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            SubjectDate = (TextView) view.findViewById(R.id.SubjectDate);
            SubjectScore = (TextView) view.findViewById(R.id.SubjectScore);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }
}
