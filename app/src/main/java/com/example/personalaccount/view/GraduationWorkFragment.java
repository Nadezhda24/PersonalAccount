package com.example.personalaccount.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.ChatAdapter;
import com.example.personalaccount.controller.HTTPHandler;
import com.example.personalaccount.controller.TaskAdapter;
import com.example.personalaccount.model.Chat;
import com.example.personalaccount.model.Task;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraduationWorkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraduationWorkFragment extends Fragment {

    ArrayList<Task> Tasks = new ArrayList<Task>();
    BufferedReader reader=null;
    InputStream stream = null;
    HttpsURLConnection connection = null;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GraduationWorkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GraduationWorkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GraduationWorkFragment newInstance(String param1, String param2) {
        GraduationWorkFragment fragment = new GraduationWorkFragment();
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


        View view = inflater.inflate(R.layout.fragment_graduation_work, container, false);

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewGraduationWork);

        TaskAdapter.OnTaskClickListener taskClickListener = new TaskAdapter.OnTaskClickListener() {
            @Override
            public void onTaskClick(Task task, int position) {

                Intent intent=new Intent(getContext(),GraduationWorkHistory.class);
                startActivity(intent);

                Toast.makeText(getActivity(), "Был выбран пункт " + task.GetTaskTopic(),
                        Toast.LENGTH_SHORT).show();
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TaskAdapter  TaskAdapter = new TaskAdapter(getActivity(),Tasks, taskClickListener);

        recyclerView.setAdapter(TaskAdapter);

        return view;
    }

    private void setInitialData(){
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "в исполении"));

        for (int i =0; i < 10; i++){
            Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "поставлена"));
        }

    }
}