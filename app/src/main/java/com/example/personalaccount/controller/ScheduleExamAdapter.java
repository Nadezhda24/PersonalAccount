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
import com.example.personalaccount.model.ScheduleExam;

import java.util.List;

public class ScheduleExamAdapter extends RecyclerView.Adapter<ScheduleExamAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<ScheduleExam> ScheduleExams;

    public ScheduleExamAdapter(Context context, List<ScheduleExam> ScheduleExams){
        this.ScheduleExams = ScheduleExams;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ScheduleExamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.schedule_exam, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ScheduleExamAdapter.ViewHolder holder, int position) {
        ScheduleExam ScheduleExam = ScheduleExams.get(position);
        holder.LessonDate.setText(ScheduleExam.GetLessonDate());
        holder.LessonTime.setText(ScheduleExam.GetLessonTime());
        holder.LessonName.setText(ScheduleExam.GetLessonName());
        holder.LessonType.setText(ScheduleExam.GetLessonType());
        holder.LessonRoom.setText(ScheduleExam.GetLessonRoom());
        holder.LessonTeacher.setText(ScheduleExam.GetLessonTeacher());

    }

    @Override
    public int getItemCount() {
        return ScheduleExams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView LessonDate,LessonTime,
                 LessonName, LessonType,
                LessonRoom, LessonTeacher;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            LessonDate = (TextView) view.findViewById(R.id.LessonDate);
            LessonTime = (TextView) view.findViewById(R.id.LessonTime);
            LessonName = (TextView) view.findViewById(R.id.LessonName);
            LessonType = (TextView) view.findViewById(R.id.LessonType);
            LessonRoom = (TextView) view.findViewById(R.id.LessonRoom);
            LessonTeacher = (TextView) view.findViewById(R.id.LessonTeacher);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

}
