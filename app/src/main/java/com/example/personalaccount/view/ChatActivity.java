package com.example.personalaccount.view;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.HTTPHandler;
import com.example.personalaccount.controller.MessageAdapter;
import com.example.personalaccount.model.Chat;
import com.example.personalaccount.model.File;
import com.example.personalaccount.model.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class ChatActivity extends AppCompatActivity {
    ArrayList<Message> Messages = new ArrayList<Message>();
    ArrayList<File> Files =  new ArrayList<File>();
    ImageView send;
    EditText text;
    String URL;
    BufferedReader reader=null;
    InputStream stream = null;
    HttpsURLConnection connection = null;
    String jsonRes = null;
    Chat Dialog = new Chat();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        Bundle arguments = getIntent().getExtras();
        int id_dialog =  arguments.getInt("id_dialog");
        int id_user =  arguments.getInt("id_user");
        String topic =  arguments.getString("topic");
        URL = "https://api.oreluniver.ru/api/dialogue/" + id_user + "/" + id_dialog;

        getSupportActionBar().setTitle(topic);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dialogue_info, menu);
        return true;
    }

    private void setInitialData(){
        DateFormat fmt = SimpleDateFormat.getTimeInstance(DateFormat.SHORT);

        Files =  new ArrayList<File>();
        Messages.add(new Message(fmt.format(new Date()), "Здравствуйте, скажите, пожалуйста, как будут проходить лабораторные работы?", 0, 1, Files) );
        Files =  new ArrayList<File>();
        Files.add (new File("Задания.docx"));

        Messages.add(new Message(  "Лукьянов П.В.", fmt.format(new Date()), "Здравствуйте. Вариант соответствует порядковому номеру в списке группы. Можно выполнять в парах. Для пары берём номер варианта любого из участников. Если делаете в парах желательно прислать мне список кто с кем делает и какой вариант. Варианты должны отличаться.", 1, Files) );
        Files =  new ArrayList<File>();
        Messages.add(new Message(fmt.format(new Date()), "Спасибо большое", 0,0, Files) );

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Files =  new ArrayList<File>();
                String new_message = text.getText().toString();
                Messages.add(new Message(  fmt.format(new Date()), new_message,0,0, Files) );
                text.setText("");
            }
        });
    }




}