package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.EduSubjectAdapter;
import com.example.personalaccount.controller.StatusAdapter;
import com.example.personalaccount.model.Status;

import java.util.ArrayList;

public class GraduationWorkHistory extends AppCompatActivity {

    ArrayList<Status> Statuses = new ArrayList<Status>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation_work_history);

        getSupportActionBar().setTitle("История изменений");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewGraduationWork);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StatusAdapter StatusAdapter = new StatusAdapter(this, Statuses);

        recyclerView.setAdapter(StatusAdapter);

    }


    private void setInitialData(){

        Statuses.add(new Status("sdsd" , "12/12/12", "", ""));

        for (int i =0; i < 10; i++){
            Statuses.add(new Status("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "Поставлена"));
        }



    }
}