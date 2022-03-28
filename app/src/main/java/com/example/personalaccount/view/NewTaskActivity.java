package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalaccount.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {

    EditText editText,editTask;
    TextView text;
    String TaskTitle, Task, selectedDate;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        getSupportActionBar().setTitle("Новая задача");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));


         editText = findViewById(R.id.EditTitle);
         TaskTitle = editText.getText().toString();
         editTask = findViewById(R.id.EditTask);
         Task = editTask.getText().toString();
         text = findViewById(R.id.EditCalendar);

        CalendarView CalendarView = findViewById(R.id.Calendar);
        Date date = new Date();
        CalendarView.setMinDate(date.getTime());

        CalendarView.setOnDateChangeListener(new android.widget.CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month;
                int mDay = dayOfMonth;
                selectedDate = new StringBuilder().append(mDay)
                        .append(".").append(mMonth + 1).append(".").append(mYear)
                        .append(" ").toString();
                text.setText("Выбранная дата: " + selectedDate );
            }
        });

    }

    public void onClick(View view) {

        Toast.makeText(getApplicationContext(), "Задача: " + TaskTitle + "Описание: " + Task + "Дата: " +  selectedDate, Toast.LENGTH_LONG).show();

    }
}