package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.personalaccount.R;

public class GraduationWorkHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation_work_history);

        getSupportActionBar().setTitle("История изменений");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

    }

}