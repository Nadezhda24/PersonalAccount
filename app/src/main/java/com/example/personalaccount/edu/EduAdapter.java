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

public class EduAdapter extends RecyclerView.Adapter<EduAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Edu>  Subjects;

    public EduAdapter(Context context, List<Edu> Subjects){
        this.Subjects = Subjects;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public EduAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.edu_subject, parent, false);
        return new EduAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(EduAdapter.ViewHolder holder, int position) {
        Edu Subject = Subjects.get(position);
        holder.SubjectTitle.setText(Subject.GetSubjectTitle());

    }

    @Override
    public int getItemCount() {
        return Subjects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView SubjectTitle;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            SubjectTitle = (TextView) view.findViewById(R.id.SubjectTitle);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }
}
