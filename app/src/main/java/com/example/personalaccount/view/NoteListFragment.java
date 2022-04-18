package com.example.personalaccount.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.NoteAdapter;
import com.example.personalaccount.model.Note;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteListFragment extends Fragment {
    ArrayList<Note> Notes = new ArrayList<Note>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoteListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteListFragment newInstance(String param1, String param2) {
        NoteListFragment fragment = new NoteListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);


        TabLayout tabLayout =  (TabLayout) view.findViewById(R.id.tabLayout) ;
        //добавление семестров обучения
        int count_category = 3;
        for (int i=0; i < count_category; i ++){
            tabLayout.addTab(tabLayout.newTab().setText("Категория " + String.valueOf(i+1)));
        }

        setInitialData(-1);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Toast.makeText(getActivity(), String.valueOf(tab.getText()),
                        Toast.LENGTH_SHORT).show();
                setInitialData(Integer.parseInt(String.valueOf(tab.getId())));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NoteAdapter NoteAdapter = new NoteAdapter(getActivity(), Notes);

        recyclerView.setAdapter(NoteAdapter);



        ImageView ImageView = (ImageView) view.findViewById(R.id.add_note);
        ImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),NewNoteActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void setInitialData(int category){
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));
        Notes.add(new Note("Новая записка", "Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп Сдать лабу по Филп"));

    }

}