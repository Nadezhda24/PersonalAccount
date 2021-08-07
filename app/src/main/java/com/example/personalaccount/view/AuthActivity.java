package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.personalaccount.MainActivity;
import com.example.personalaccount.R;


public class AuthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportActionBar().hide();

    }

    public void onClick(View view) {
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        startActivity(intent);
    }
}