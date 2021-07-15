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
import com.example.personalaccount.edu.Edu;
import com.example.personalaccount.edu.EduAdapter;

import java.util.ArrayList;

public class EduActivity extends AppCompatActivity {
    ArrayList<Edu> EduSubjects = new ArrayList<Edu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        getSupportActionBar().setTitle("Ход образовательного процесса");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewEdu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EduAdapter EduAdapter = new EduAdapter(this, EduSubjects);

        recyclerView.setAdapter(EduAdapter);


    }

    private void setInitialData(){
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
        EduSubjects.add(new Edu("Функциональное и логическое программирование") );
    }

    public void BottomMenuOnClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_menu_schedule: {
                Intent intent = new Intent(EduActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_mark:{
                Intent intent = new Intent(EduActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_message:{
                Intent intent = new Intent(EduActivity.this, MessageSystemActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_education:{
                Intent intent = new Intent(EduActivity.this, EduActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_notes:{
                Intent intent = new Intent(EduActivity.this, NoteListActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}