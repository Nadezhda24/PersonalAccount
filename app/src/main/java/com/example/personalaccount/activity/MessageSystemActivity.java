package com.example.personalaccount.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.personalaccount.R;
import com.example.personalaccount.message.Chat;
import com.example.personalaccount.message.ChatAdapter;

import java.util.ArrayList;

public class MessageSystemActivity extends AppCompatActivity {
    ArrayList<Chat> Chats = new ArrayList<Chat>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_system);

        getSupportActionBar().setTitle("Система сообщений");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewChats);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChatAdapter  ChatAdapter = new ChatAdapter(this,Chats );

        recyclerView.setAdapter(ChatAdapter);

    }

    private void setInitialData(){
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
    }

    public void BottomMenuOnClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_menu_schedule: {
                Intent intent = new Intent(MessageSystemActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_mark:{
                Intent intent = new Intent(MessageSystemActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_message:{
                Intent intent = new Intent(MessageSystemActivity.this, MessageSystemActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_education:{
                Intent intent = new Intent(MessageSystemActivity.this, EduActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_notes:{
                Intent intent = new Intent(MessageSystemActivity.this, NoteListActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}