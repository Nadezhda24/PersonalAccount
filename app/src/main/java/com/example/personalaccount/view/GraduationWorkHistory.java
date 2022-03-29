package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.example.personalaccount.R;
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

        Bundle arguments = getIntent().getExtras();
        int id_task =  arguments.getInt("id_task");

        Toast.makeText(this, "Был выбран пункт " + id_task,
                Toast.LENGTH_SHORT).show();
        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewGraduationWork);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StatusAdapter StatusAdapter = new StatusAdapter(this, Statuses);

        recyclerView.setAdapter(StatusAdapter);

    }


    private void setInitialData(){

        Statuses.add(new Status("поставлена" , "12/12/12", "", "поставлена"));
        Statuses.add(new Status("в исполнении" , "12/12/12", "", "в исполнении"));
        Statuses.add(new Status("отправлена на проверку" , "12/12/12", "", "отправлена на проверку"));
        Statuses.add(new Status("на проверке" , "12/12/12", "", "на проверке"));
        Statuses.add(new Status("отправлена на доработку" , "12/12/12", "", "отправлена на доработку"));
        Statuses.add(new Status("в исполнении" , "12/12/12", "", "в исполнении"));
        Statuses.add(new Status("отправлена на проверку" , "12/12/12", "", "отправлена на проверку"));
        Statuses.add(new Status("на проверке" , "12/12/12", "", "на проверке"));
        Statuses.add(new Status("в исполнении" , "12/12/12", "", "в исполнении"));
        Statuses.add(new Status("отправлена на проверку" , "12/12/12", "", "отправлена на проверку"));
        Statuses.add(new Status("на проверке" , "12/12/12", "", "на проверке"));
        Statuses.add(new Status("выполнена" , "12/12/12", "", "выполнена"));


    }
}