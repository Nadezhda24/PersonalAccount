package com.example.personalaccount.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalaccount.R;

import java.text.SimpleDateFormat;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        getSupportActionBar().setTitle("Новая задача");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));
    }

    public void onClick(View view) {

        EditText editText = findViewById(R.id.EditTitle);
        String TaskTitle = editText.getText().toString();
        EditText editTask = findViewById(R.id.EditTask);
        String Task = editTask.getText().toString();
        TextView text = findViewById(R.id.EditCalendar);

        CalendarView CalendarView = findViewById(R.id.Calendar);
        Long CalendarDate = CalendarView.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String Date = sdf.format(CalendarDate);

        text.setText("Задача: " + TaskTitle + " Описание: " + Task + "Дата: " + Date);

    }
}