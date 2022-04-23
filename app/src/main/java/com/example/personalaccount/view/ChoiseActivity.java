package com.example.personalaccount.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.NoteAdapter;
import com.example.personalaccount.model.Note;

import java.util.ArrayList;


public class ChoiseActivity extends AppCompatActivity {

    ArrayList<Note> Notes = new ArrayList<Note>();
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise);

        getSupportActionBar().setTitle("Создание диалога");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));


        dialog = new Dialog(ChoiseActivity.this);// Установите заголовок
        dialog.setTitle("Выбор подразделения");
        dialog.setContentView(R.layout.choise);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView)  dialog.findViewById(R.id.RecyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoteAdapter NoteAdapter = new NoteAdapter(this, Notes);
        recyclerView.setAdapter(NoteAdapter);

    }


    private void setInitialData(){

        Notes.add(new Note("АСИ", ""));
        Notes.add(new Note("ИЕНиБ", ""));
        Notes.add(new Note("ИЕНиБ", ""));
        Notes.add(new Note("ИВЗО", ""));
        Notes.add(new Note("Иняз", ""));
        Notes.add(new Note("ИПиП", ""));
        Notes.add(new Note("ИФил", ""));
        Notes.add(new Note("ИЭиУ", ""));
        Notes.add(new Note("Истфак", ""));
        Notes.add(new Note("ЛФ", ""));
        Notes.add(new Note("Асп", ""));
        Notes.add(new Note("Ординатура", ""));


    }

    public void onClick(View view) {

        dialog.show();
    }
}