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
        ScheduleDays.add(new ScheduleDay("Инновационный менеджмент", "Куприянов А.Н."));
        ScheduleDays.add(new ScheduleDay("Иностранный язык в профессиональной сфере", "Попова И.Ю."));
        ScheduleDays.add(new ScheduleDay("Межкультурная коммуникация в профессиональной сфере общения", "Чалых М.В."));
        ScheduleDays.add(new ScheduleDay("Проектная деятельность (профиль: Промышленная разработка программного обеспечения)", "Гордиенко А.П."));
        ScheduleDays.add(new ScheduleDay("Функциональное и логическое программирование (профиль: Промышленная разработка программного обеспечения)", "Гордиенко А.П."));
        ScheduleDays.add(new ScheduleDay("Качество и тестирование программного обеспечения (профиль: Промышленная разработка программного обеспечения)", "Ужаринский А.Ю."));
        ScheduleDays.add(new ScheduleDay("Программирование микроконтроллеров (профиль: Промышленная разработка программного обеспечения)", "Захарова О.В."));
    }
}