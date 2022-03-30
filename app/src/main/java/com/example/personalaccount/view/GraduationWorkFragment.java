package com.example.personalaccount.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.HTTPHandler;
import com.example.personalaccount.controller.TaskEmployeeAdapter;
import com.example.personalaccount.controller.TaskStudentAdapter;
import com.example.personalaccount.model.Status;
import com.example.personalaccount.model.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    ArrayList<Status> Statuses = new ArrayList<Status>();
    BufferedReader reader=null;
    InputStream stream = null;
    HttpsURLConnection connection = null;
    String jsonRes = null;
    RecyclerView.Adapter TaskAdapter ;
    private static String URL = "https://api.oreluniver.ru/api/task/0";
    //private static String URL = "http://q90932z7.beget.tech/server.php?action=select_languages";
    int UserType = 0;

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

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewGraduationWork);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (UserType == 0){
            TaskStudentAdapter.OnTaskClickListener taskClickListener = new TaskStudentAdapter.OnTaskClickListener() {
                @Override
                public void onTaskClick(Task task, int position) {

                    Intent intent=new Intent(getContext(),GraduationWorkHistory.class);
                    intent.putExtra( "id_task",task.GetTaskId());
                    startActivity(intent);

                }
            };


            TaskAdapter = new TaskStudentAdapter(getActivity(),Tasks, taskClickListener);

            recyclerView.setAdapter(TaskAdapter);
        }else {


            LinearLayout Layout = (LinearLayout) view.findViewById(R.id.Layout);
            Button NewTask = new Button(getActivity());
            NewTask.setText("Поставить новую задачу");
            Layout.addView(NewTask);

            NewTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), NewTaskActivity.class);
                    startActivity(intent);
                }
            });


            TaskEmployeeAdapter.OnTaskClickListener taskClickListener = new TaskEmployeeAdapter.OnTaskClickListener() {
                @Override
                public void onTaskClick(Task task, int position) {

                    Intent intent=new Intent(getContext(),GraduationWorkHistory.class);
                    intent.putExtra( "id_task",task.GetTaskId());
                    startActivity(intent);

                }

            };

            TaskAdapter = new TaskEmployeeAdapter(getActivity(),Tasks, taskClickListener);
            recyclerView.setAdapter(TaskAdapter);
        }

        setInitialData();
        return view;
    }

    private void setInitialData(){
        try {
            new GetData().execute().get();
        } catch (Exception e) { //TODO: сделать нормальное решение для catch
            Toast.makeText(getActivity(), "Проверьте соединение с интернетом",
                    Toast.LENGTH_SHORT).show();

        }

       /* Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "поставлена"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "в исполении"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "отправлена на проверку"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "на проверке"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "отправлена на доработку"));
        Tasks.add(new Task("sdsd" , "12/12/12", "LKSMDLCKSMDLKCSLKDMLCKMSLDKMCLSDKCSLD", "выполнена")); */

    }


    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            HTTPHandler sh = new HTTPHandler();
            String jsonStr = sh.getData(URL);
            jsonRes = jsonStr;
          /*  jsonRes = "[\n" +
                    "    {\n" +
                    "        \"id\": 9,\n" +
                    "        \"id_work\": \"1\",\n" +
                    "        \"topic\": \"g\",\n" +
                    "        \"date_completion\": null,\n" +
                    "        \"content\": \"ggg\",\n" +
                    "        \"id_status\": \"1\",\n" +
                    "        \"version\": [\n" +
                    "            {\n" +
                    "                \"id\": 40,\n" +
                    "                \"id_task\": \"9\",\n" +
                    "                \"data_create\": \"2022-02-09\",\n" +
                    "                \"comment\": null,\n" +
                    "                \"file\": null,\n" +
                    "                \"id_status\": \"0\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"id\": 10,\n" +
                    "        \"id_work\": \"1\",\n" +
                    "        \"topic\": \"g\",\n" +
                    "        \"date_completion\": null,\n" +
                    "        \"content\": \"ggg\",\n" +
                    "        \"id_status\": \"1\",\n" +
                    "        \"version\": [\n" +
                    "            {\n" +
                    "                \"id\": 41,\n" +
                    "                \"id_task\": \"10\",\n" +
                    "                \"data_create\": \"2022-02-09\",\n" +
                    "                \"comment\": null,\n" +
                    "                \"file\": null,\n" +
                    "                \"id_status\": \"0\"\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "]";
            */
            return null;
        }
        //выполняется после doInBackground
        @Override
        protected void onPostExecute(Void v) {


            if (jsonRes != null){
                JSONObject json = null;

                try {
                    json = new JSONObject("{\"tasks\": " + jsonRes + " }");
                    JSONArray arr = json.getJSONArray("tasks");
                   for (int i=0; i < arr.length(); i++){
                        JSONObject obj = arr.getJSONObject(i);
                        int id = obj.getInt("id");
                        String topic = obj.getString("topic");
                        String date_completion = obj.getString("date_completion");
                        String content =  obj.getString("content");
                        int id_status = Integer.parseInt( obj.getString("id_status"));
                       /* JSONArray statuses = json.getJSONArray("version");
                        for (int j=0;j<statuses.length(); j++){
                            JSONObject status = arr.getJSONObject(i);
                            int type = status.getInt("id_status");
                            String data_create =  obj.getString("data_create");
                            String comment = obj.getString("comment");
                            String file = obj.getString("file");
                            Statuses.add(new com.example.personalaccount.model.Status(GetStatus(type),data_create,comment,file));
                    }*/
                       Tasks.add(new Task(id,topic , date_completion, content, GetStatus(id_status)));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



                getActivity().runOnUiThread(new Runnable() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void run() {
                        if(TaskAdapter != null)
                            TaskAdapter.notifyDataSetChanged();
                    }
                });
            }
           else {
                Toast.makeText(getActivity(), "У Вас нет задач",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }


    String GetStatus (int type) {
        switch (type) {
            case 0:
                return "поставлена";
            case 1:
                return "в исполнении";
            case 2:
                return "отправлена на проверку";
            case 3:
                return "на проверке";
            case 4:
                return "отправлена на доработку";
            case 5:
                return "выполнена";
            default:
                return "null";
        }
    }


}
