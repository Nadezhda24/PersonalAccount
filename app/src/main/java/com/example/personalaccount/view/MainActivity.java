package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Bottom Navigation View.
        BottomNavigationView navView = findViewById(R.id.bottomNav_view);

        //Pass the ID's of Different destinations
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_schedule, R.id.navigation_result, R.id.navigation_messager, R.id.navigation_edu, R.id.navigation_note )
                .build();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));


        //Initialize NavController.
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.choise_schedule, menu);


        return true;
    }

    public void onClick(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, ChoiceSchedule.class);
        startActivity(intent);

    }
}