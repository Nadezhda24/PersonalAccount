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

       Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "Поставлена"));

     /*   String url = "http://api/api/task/1";
        ArrayList<HashMap<String,String>> TaskList = null;

        HTTPHandler sh = new HTTPHandler();
        String Json =   sh.getData(url);
        System.out.println("Response " + Json);
        if(Json != null){
            try{
                JSONObject jsonObject = new JSONObject(Json);
                JSONArray tasks = jsonObject.getJSONArray("tasks");
                for (int i = 0; i < tasks.length(); i++){
                    JSONObject task = tasks.getJSONObject(i);

                    String id = task.getString("id");
                    String topic = task.getString("topic");
                    String date_completion = task.getString("date_completion");
                    String content = task.getString("content");
                    String id_work = task.getString("id_work");

                    HashMap<String,String> t = new HashMap<>();
                    t.put("id", id);
                    t.put("topic", topic );
                    t.put("date_completion", date_completion);
                    t.put("content", content);
                    t.put("id_work", id_work);

                    TaskList.add(t);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Can't get json from server");
        } */

       for (int i =0; i < 10; i++){
            Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "Поставлена"));
        }



    }
}