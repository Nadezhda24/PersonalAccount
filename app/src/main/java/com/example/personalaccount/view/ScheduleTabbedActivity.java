package com.example.personalaccount.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.personalaccount.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.personalaccount.ui.main.SectionsPagerAdapter;
import com.example.personalaccount.databinding.ActivityScheduleTabbedBinding;

public class ScheduleTabbedActivity extends AppCompatActivity {

    private ActivityScheduleTabbedBinding binding;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding = ActivityScheduleTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);


    }


    public void BottomMenuOnClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_menu_schedule: {
                Intent intent = new Intent(this, ScheduleTabbedActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_mark:{
                Intent intent = new Intent(this, ResultsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_message:{
                Intent intent = new Intent(this, MessageSystemActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_education:{
                Intent intent = new Intent(this, EduActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_notes:{
                Intent intent = new Intent(this, NoteListActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
