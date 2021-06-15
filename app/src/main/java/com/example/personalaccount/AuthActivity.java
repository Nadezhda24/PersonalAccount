package com.example.personalaccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class AuthActivity extends AppCompatActivity {

    ArrayList<ScheduleDay> ScheduleDays = new ArrayList<ScheduleDay>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewScheduleDay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ScheduleDayAdapter ScheduleDayAdapter = new ScheduleDayAdapter(this, ScheduleDays);

        recyclerView.setAdapter(ScheduleDayAdapter);

    }
    private void setInitialData(){
        ScheduleDays.add(new ScheduleDay("1", " 8:30", "10:00" ,"Функциональное и логическое программирование","лекция", "12-411",  "Гордиенко А.П."));
        ScheduleDays.add(new ScheduleDay("2", "10:10", "11:40" ,"Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)","лекция", "12-411",  "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("3", "12:00", "13:30" ,"Основы управления программными проектами\n(Промышленная разработка программного обеспечения)","лекция", "12-411",  "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("4", "13:40", "15:10" ,"Программирование микроконтроллеров","лекция", "12-411",  "Захарова О.В."));
      }
}