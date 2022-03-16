package com.example.personalaccount.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.TaskEmployeeAdapter;
import com.example.personalaccount.controller.TaskStudentAdapter;
import com.example.personalaccount.model.Task;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;

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
        int UserType = 0;

        if (UserType == 0){
            TaskStudentAdapter.OnTaskClickListener taskClickListener = new TaskStudentAdapter.OnTaskClickListener() {
                @Override
                public void onTaskClick(Task task, int position) {

                    Intent intent=new Intent(getContext(),GraduationWorkHistory.class);
                    startActivity(intent);

                    Toast.makeText(getActivity(), "Был выбран пункт " + task.GetTaskTopic(),
                            Toast.LENGTH_SHORT).show();
                }
            };

            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            TaskStudentAdapter TaskAdapter = new TaskStudentAdapter(getActivity(),Tasks, taskClickListener);

            recyclerView.setAdapter(TaskAdapter);
        }else {
            TaskEmployeeAdapter.OnTaskClickListener taskClickListener = new TaskEmployeeAdapter.OnTaskClickListener() {
                @Override
                public void onTaskClick(Task task, int position) {

                    Intent intent=new Intent(getContext(),GraduationWorkHistory.class);
                    startActivity(intent);

                    Toast.makeText(getActivity(), "Был выбран пункт " + task.GetTaskTopic(),
                            Toast.LENGTH_SHORT).show();
                }
            };
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            TaskEmployeeAdapter TaskAdapter = new TaskEmployeeAdapter(getActivity(),Tasks, taskClickListener);
            recyclerView.setAdapter(TaskAdapter);
        }


        return view;
    }

    private void setInitialData(){

        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "поставлена"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "в исполении"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "отправлена на проверку"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "на проверке"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "отправлена на доработку"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "выполнена"));

    }
}