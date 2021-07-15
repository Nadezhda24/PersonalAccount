package com.example.personalaccount.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.personalaccount.R;
import com.example.personalaccount.edu.Edu;
import com.example.personalaccount.edu.EduSubjectAdapter;

import java.util.ArrayList;

public class EduSubjectActivity extends AppCompatActivity {
    ArrayList<Edu> EduSubjectsScores = new ArrayList<Edu>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_subject);
        getSupportActionBar().setTitle("Ход образовательного процесса");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewEduSubject);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EduSubjectAdapter EduSubjectAdapter = new EduSubjectAdapter(this, EduSubjectsScores);

        recyclerView.setAdapter(EduSubjectAdapter);
    }

    private void setInitialData(){
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
        EduSubjectsScores.add(new Edu("23.07.21", "6"));
    }
}