package com.example.personalaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        View view = inflater.inflate(R.layout.lesson_day_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScheduleDayAdapter.ViewHolder holder, int position) {
        ScheduleDay ScheduleDay = ScheduleDays.get(position);

        holder.LessonsName.setText(ScheduleDay.GetLessonName());
        holder.LessonsTeaher.setText(ScheduleDay.GetTeacherName());
    }

    @Override
    public int getItemCount() {
        return ScheduleDays.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView LessonsName, LessonsTeaher;
        ViewHolder(View view){
            super(view);
            LessonsName = (TextView) view.findViewById(R.id.LessonsName);
            LessonsTeaher = (TextView) view.findViewById(R.id.LessonsTeacher);
        }
    }

}
