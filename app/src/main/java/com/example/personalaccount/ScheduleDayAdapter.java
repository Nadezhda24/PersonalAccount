package com.example.personalaccount;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleDayAdapter extends RecyclerView.Adapter<ScheduleDayAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<ScheduleDay> ScheduleDays;

    ScheduleDayAdapter(Context context, List<ScheduleDay> ScheduleDays){
        this.ScheduleDays = ScheduleDays;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ScheduleDayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.schedule_day, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ScheduleDayAdapter.ViewHolder holder, int position) {
        ScheduleDay ScheduleDay = ScheduleDays.get(position);
        holder.LessonNumder.setText(ScheduleDay.GetLessonNumder());
        holder.LessonStart.setText(ScheduleDay.GetLessonStart());
        holder.LessonEnd.setText(ScheduleDay.GetLessonEnd());
        holder.LessonName.setText(ScheduleDay.GetLessonName());
        holder.LessonType.setText(ScheduleDay.GetLessonType());
        holder.LessonRoom.setText(ScheduleDay.GetLessonRoom());
        holder.LessonTeacher.setText(ScheduleDay.GetLessonTeacher());

        if (ScheduleDay.GetLessonType() == "лекция") holder.frameLayout.setBackgroundResource(R.color.LK);
        else if (ScheduleDay.GetLessonType() == "лабораторная работа") holder.frameLayout.setBackgroundResource(R.color.LB);
        else if (ScheduleDay.GetLessonType() == "практическое занятие") holder.frameLayout.setBackgroundResource(R.color.PZ);
        else if (ScheduleDay.GetLessonType() == "экзамен") holder.frameLayout.setBackgroundResource(R.color.Exam);
        else if (ScheduleDay.GetLessonType() == "зачет") holder.frameLayout.setBackgroundResource(R.color.Exam);
        else if (ScheduleDay.GetLessonType() == "консультация") holder.frameLayout.setBackgroundResource(R.color.Exam);
        else  holder.frameLayout.setBackgroundColor(R.color.black);

    }

    @Override
    public int getItemCount() {
        return ScheduleDays.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView LessonNumder,LessonStart,
                LessonEnd, LessonName, LessonType,
                LessonRoom, LessonTeacher;
        final FrameLayout frameLayout;
        ViewHolder(View view){
            super(view);
            LessonNumder = (TextView) view.findViewById(R.id.LessonNumder);
            LessonStart = (TextView) view.findViewById(R.id.LessonStart);
            LessonEnd = (TextView) view.findViewById(R.id.LessonEnd);
            LessonName = (TextView) view.findViewById(R.id.LessonName);
            LessonType = (TextView) view.findViewById(R.id.LessonType);
            LessonRoom = (TextView) view.findViewById(R.id.LessonRoom);
            LessonTeacher = (TextView) view.findViewById(R.id.LessonTeacher);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

}
