package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.ListItemAdapter;
import com.example.personalaccount.model.ListItem;
import com.example.personalaccount.model.Result;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ChoiceSchedule extends AppCompatActivity {

    ArrayList<ListItem> Items = new ArrayList<ListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_schedule);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));
        getSupportActionBar().setTitle("Выбор расписания");

        TabLayout tabLayout =  (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("студент"));
        tabLayout.addTab(tabLayout.newTab().setText("преподаватель"));
        tabLayout.addTab(tabLayout.newTab().setText("аудитория"));

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView8 = (TextView) findViewById(R.id.textView8);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setText("Выбрать подразделение");
        button2.setText("Выбрать курс");
        button3.setText("Выбрать группу");


        Items.add(new ListItem("АСИ"));
        Items.add(new ListItem("ИЕНиБ"));
        Items.add(new ListItem("ИЕНиБ"));
        Items.add(new ListItem("ИВЗО"));
        Items.add(new ListItem("Иняз"));
        Items.add(new ListItem("ИПиП"));
        Items.add(new ListItem("ИПАИТ"));
        Items.add(new ListItem("ИФил"));
        Items.add(new ListItem("ИЭиУ"));
        Items.add(new ListItem("ИстФак"));
        Items.add(new ListItem("ЛФ"));
        Items.add(new ListItem("Асп"));
        Items.add(new ListItem("Ординатура"));
        Items.add(new ListItem("ПТИ"));
        Items.add(new ListItem("СоцФак"));
        Items.add(new ListItem("ФПСиФ"));
        Items.add(new ListItem("ФТПиС"));
        Items.add(new ListItem("ФФКС"));
        Items.add(new ListItem("ФизМат"));
        Items.add(new ListItem("Филос"));
        Items.add(new ListItem("ХГФ"));
        Items.add(new ListItem("ЮИ"));
        final Dialog[] dialog = new Dialog[1];
        dialog[0] = new Dialog(ChoiceSchedule.this);
        dialog[0].getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog[0].setContentView(R.layout.dialog);


        RecyclerView recyclerView = (RecyclerView)  dialog[0].findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(dialog[0].getContext()));
        ListItemAdapter listItemAdapter = new ListItemAdapter(dialog[0].getContext(), Items);
        recyclerView.setAdapter(listItemAdapter);

                button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog[0].show();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog[0].show();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog[0].show();

            }
        });


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText() == "студент") {
                    button1.setText("Выбрать подразделение");
                    button2.setText("Выбрать курс");
                    button3.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                    textView8.setVisibility(View.VISIBLE);
                    button3.setText("Выбрать группу");
                }
                if (tab.getText() == "преподаватель") {
                    button1.setText("Выбрать подразделение");
                    button2.setText("Выбрать кафедру");
                    button3.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                    textView8.setVisibility(View.VISIBLE);
                    button3.setText("Выбрать преподавателя");
                }
                if (tab.getText() == "аудитория") {
                    button1.setText("Выбрать курпус");
                    button2.setText("Выбрать аудиторию");
                    button3.setVisibility(View.GONE);
                    textView5.setVisibility(View.GONE);
                    textView8.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }


    public void onClick(View view) {

    }
}