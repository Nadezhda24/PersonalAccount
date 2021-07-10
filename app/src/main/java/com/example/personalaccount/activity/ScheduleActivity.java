package com.example.personalaccount.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.personalaccount.R;
import com.example.personalaccount.schedule.ScheduleDay;
import com.example.personalaccount.schedule.ScheduleDayAdapter;

import java.util.ArrayList;



public class ScheduleActivity extends AppCompatActivity {
    ArrayList<ScheduleDay> ScheduleDays = new ArrayList<ScheduleDay>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        getSupportActionBar().setTitle("Расписание");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ScheduleDayAdapter ScheduleDayAdapter = new ScheduleDayAdapter(this, ScheduleDays);

        recyclerView.setAdapter(ScheduleDayAdapter);

    }
    private void setInitialData(){
        ScheduleDays.add(new ScheduleDay("1", " 8:30", "10:00" ,"Функциональное и логическое программирование","лабораторная работа", "12-411",  "Гордиенко А.П."));
        ScheduleDays.add(new ScheduleDay("2", "10:10", "11:40" ,"Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)","лекция", "12-411",  "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("3", "12:00", "13:30" ,"Основы управления программными проектами\n(Промышленная разработка программного обеспечения)","практическое занятие", "12-411",  "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("4", "13:40", "15:10" ,"Программирование микроконтроллеров","экзамен", "12-411",  "Захарова О.В."));
    }

    public void BottomMenuOnClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_menu_schedule: {
                Intent intent = new Intent(ScheduleActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_mark:{
                Intent intent = new Intent(ScheduleActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_message:{
                Intent intent = new Intent(ScheduleActivity.this, MessageSystemActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_education:{
                Intent intent = new Intent(ScheduleActivity.this, EducationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_notes:{
                Intent intent = new Intent(ScheduleActivity.this, NoteActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}