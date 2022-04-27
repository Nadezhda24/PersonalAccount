package com.example.personalaccount.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.MessageAdapter;
import com.example.personalaccount.model.File;
import com.example.personalaccount.model.Message;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {
    ArrayList<Message> Messages = new ArrayList<Message>();
    ArrayList<File> Files =  new ArrayList<File>();
    ImageView send;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getSupportActionBar().setTitle("Лукьянов Павел Вадимович");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));


        text = (EditText) findViewById(R.id.NewMessage);

        send = (ImageView) findViewById(R.id.SendMessage);
        ImageView addFile = (ImageView) findViewById(R.id.AddFile);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewMessages);

        setInitialData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter MessageAdapter = new MessageAdapter(this, Messages);

        recyclerView.setAdapter(MessageAdapter);






    }

    private void setInitialData(){
        DateFormat fmt = SimpleDateFormat.getTimeInstance(DateFormat.SHORT);

        Files.add (new File("Задания.docx"));
        Files.add (new File("Задания.docx"));
        Files.add (new File("Задания.docx"));
        Files.add (new File("Задания.docx"));
        Messages.add(new Message(  fmt.format(new Date()), "Здравствуйте, скажите, пожалуйста, как будут проходить лабораторные работы?", 0, Files) );

        Messages.add(new Message(  "Лукьянов П.В.", fmt.format(new Date()), "Здравствуйте. Вариант соответствует порядковому номеру в списке группы. Можно выполнять в парах. Для пары берём номер варианта любого из участников. Если делаете в парах желательно прислать мне список кто с кем делает и какой вариант. Варианты должны отличаться.", 1, Files) );
        Messages.add(new Message(  fmt.format(new Date()), "Спасибо большое", 0, Files) );

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_message = text.getText().toString();
                Messages.add(new Message(  fmt.format(new Date()), new_message,0, Files) );
                text.setText("");
            }
        });
    }




}