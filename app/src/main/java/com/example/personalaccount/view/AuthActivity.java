package com.example.personalaccount.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalaccount.R;


public class AuthActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportActionBar().hide();

    }

    public void onClick(View view) {
        EditText editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        intent.putExtra( "id", editTextTextPassword.getText());
        startActivity(intent);
    }
}