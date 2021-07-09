package com.example.personalaccount.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.example.personalaccount.R;
import com.example.personalaccount.results.Result;
import com.example.personalaccount.results.ResultAdapter;
import com.example.personalaccount.schedule.ScheduleDay;


import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    ArrayList<Result> Results = new ArrayList<Result>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getSupportActionBar().setTitle(Html.fromHtml("Промежуточная аттестация"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ResultAdapter ResultAdapter = new ResultAdapter(this, Results);

        recyclerView.setAdapter(ResultAdapter);

    }

    private void setInitialData(){
        Results.add(new Result("Функциональное и логическое программирование", "Гордиенко А.П.", "Зачет", "Зачтено"));
        Results.add(new Result("Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Основы управления программными проектами\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Программирование микроконтроллеров", "Захарова О.В.", "Экзамен", "Отлично"));
        Results.add(new Result("Функциональное и логическое программирование", "Гордиенко А.П.", "Зачет", "Зачтено"));
        Results.add(new Result("Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Основы управления программными проектами\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Программирование микроконтроллеров", "Захарова О.В.", "Экзамен", "Отлично"));

    }

    public void BottomMenuOnClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_menu_schedule: {
                Intent intent = new Intent(ResultsActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_mark:{
                Intent intent = new Intent(ResultsActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_message:{
                Intent intent = new Intent(ResultsActivity.this, MessageSystemActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_education:{
                Intent intent = new Intent(ResultsActivity.this, EducationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_notes:{
                Intent intent = new Intent(ResultsActivity.this, NoteActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}