package com.example.personalaccount.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.ListItemAdapter;
import com.example.personalaccount.model.ListItem;
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



        final Dialog[] dialog = new Dialog[1];
        dialog[0] = new Dialog(ChoiceSchedule.this);
        dialog[0].getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog[0].setContentView(R.layout.dialog);



                button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Items = new ArrayList<ListItem>();
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
                RecyclerView recyclerView = (RecyclerView)  dialog[0].findViewById(R.id.RecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(dialog[0].getContext()));
                ListItemAdapter listItemAdapter = new ListItemAdapter(dialog[0].getContext(), Items);
                recyclerView.setAdapter(listItemAdapter);

                dialog[0].show();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Items = new ArrayList<ListItem>();
                Items.add(new ListItem("1"));
                Items.add(new ListItem("2"));
                Items.add(new ListItem("3"));
                Items.add(new ListItem("4"));
                RecyclerView recyclerView = (RecyclerView)  dialog[0].findViewById(R.id.RecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(dialog[0].getContext()));
                ListItemAdapter listItemAdapter = new ListItemAdapter(dialog[0].getContext(), Items);
                recyclerView.setAdapter(listItemAdapter);

                dialog[0].show();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Items = new ArrayList<ListItem>();
                Items.add(new ListItem("81АП"));
                Items.add(new ListItem("81БС"));
                Items.add(new ListItem("81ИБ"));
                Items.add(new ListItem("81ИВТ"));
                Items.add(new ListItem("81ИК"));
                Items.add(new ListItem("81ИТ"));
                Items.add(new ListItem("81КЭ"));
                Items.add(new ListItem("81ПГ"));
                Items.add(new ListItem("81ПИ"));
                Items.add(new ListItem("81УТ"));
                Items.add(new ListItem("81ЭЭ"));
                Items.add(new ListItem("82ПИ"));
                RecyclerView recyclerView = (RecyclerView)  dialog[0].findViewById(R.id.RecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(dialog[0].getContext()));
                ListItemAdapter listItemAdapter = new ListItemAdapter(dialog[0].getContext(), Items);
                recyclerView.setAdapter(listItemAdapter);

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