package com.example.personalaccount.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Note;
import com.example.personalaccount.controller.NoteAdapter;

import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {
    ArrayList<Note> Notes = new ArrayList<Note>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        getSupportActionBar().setTitle("Заметки");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NoteAdapter NoteAdapter = new NoteAdapter(this, Notes);

        recyclerView.setAdapter(NoteAdapter);


    }

    private void setInitialData(){
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));

    }



    public void BottomMenuOnClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_menu_schedule: {
                Intent intent = new Intent(NoteListActivity.this, ScheduleTabbedActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_mark:{
                Intent intent = new Intent(NoteListActivity.this, ResultsActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_message:{
                Intent intent = new Intent(NoteListActivity.this, MessageSystemActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_education:{
                Intent intent = new Intent(NoteListActivity.this, EduActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bottom_menu_notes:{
                Intent intent = new Intent(NoteListActivity.this, NoteListActivity.class);
                startActivity(intent);
            }
            break;
        }
    }

    public void onClick(View view) {

    }

    public void BottomMenuOnClick(MenuItem item) {
    }
}