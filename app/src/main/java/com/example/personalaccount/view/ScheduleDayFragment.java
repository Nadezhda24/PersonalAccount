package com.example.personalaccount.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.ScheduleDayAdapter;
import com.example.personalaccount.model.ScheduleDay;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class ScheduleDayFragment extends Fragment {
    ArrayList<ScheduleDay> ScheduleDays = new ArrayList<ScheduleDay>();

    private Context context;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedueday,
                container, false);



        setInitialData();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        ScheduleDayAdapter ScheduleDayAdapter = new ScheduleDayAdapter(context, ScheduleDays);

        recyclerView.setAdapter(ScheduleDayAdapter);

        return view;
    }

    private void setInitialData(){
        ScheduleDays.add(new ScheduleDay("1", " 8:30", "10:00" ,"Функциональное и логическое программирование","лабораторная работа", "12-411",  "Гордиенко А.П."));
        ScheduleDays.add(new ScheduleDay("2", "10:10", "11:40" ,"Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)","лекция", "12-411",  "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("3", "12:00", "13:30" ,"Основы управления программными проектами\n(Промышленная разработка программного обеспечения)","практическое занятие", "12-411",  "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("4", "13:40", "15:10" ,"Программирование микроконтроллеров","экзамен", "12-411",  "Захарова О.В."));
    }


}