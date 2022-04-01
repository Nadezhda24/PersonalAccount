package com.example.personalaccount.view;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.HTTPHandler;
import com.example.personalaccount.controller.StatusAdapter;
import com.example.personalaccount.model.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class GraduationWorkHistory extends AppCompatActivity {

    ArrayList<Status> Statuses = new ArrayList<Status>();
    StatusAdapter StatusAdapter;
    BufferedReader reader=null;
    InputStream stream = null;
    HttpsURLConnection connection = null;
    String jsonRes = null;

    private static String URL ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation_work_history);

        getSupportActionBar().setTitle("История изменений");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(108,164,208)));

        Bundle arguments = getIntent().getExtras();
        int id_task =  arguments.getInt("id_task");
        URL = "https://api.oreluniver.ru/api/task/history/" + Integer.toString(id_task);

        Toast.makeText(this, "Был выбран пункт " + id_task,
                Toast.LENGTH_SHORT).show();
        setInitialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewGraduationWork);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StatusAdapter = new StatusAdapter(this, Statuses);

        recyclerView.setAdapter(StatusAdapter);

    }


    private void setInitialData(){

           try {
            new GetData().execute().get();
        } catch (Exception e) { //TODO: сделать нормальное решение для catch
            Toast.makeText(GraduationWorkHistory.this, "Проверьте соединение с интернетом",
                    Toast.LENGTH_SHORT).show();
        }


       /* Statuses.add(new Status("поставлена" , "12/12/12", "", "поставлена"));
        Statuses.add(new Status("в исполнении" , "12/12/12", "", "в исполнении"));
        Statuses.add(new Status("отправлена на проверку" , "12/12/12", "", "отправлена на проверку"));
        Statuses.add(new Status("на проверке" , "12/12/12", "", "на проверке"));
        Statuses.add(new Status("отправлена на доработку" , "12/12/12", "", "отправлена на доработку"));
        Statuses.add(new Status("в исполнении" , "12/12/12", "", "в исполнении"));
        Statuses.add(new Status("отправлена на проверку" , "12/12/12", "", "отправлена на проверку"));
        Statuses.add(new Status("на проверке" , "12/12/12", "", "на проверке"));
        Statuses.add(new Status("в исполнении" , "12/12/12", "", "в исполнении"));
        Statuses.add(new Status("отправлена на проверку" , "12/12/12", "", "отправлена на проверку"));
        Statuses.add(new Status("на проверке" , "12/12/12", "", "на проверке"));
        Statuses.add(new Status("выполнена" , "12/12/12", "", "выполнена"));
*/

    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            HTTPHandler sh = new HTTPHandler();
            String jsonStr = sh.getData(URL,"GET");
            jsonRes = jsonStr;
            return null;
        }
        //выполняется после doInBackground
        @Override
        protected void onPostExecute(Void v) {


            if (jsonRes != null){
                JSONObject json = null;

                try {
                    json = new JSONObject("{\"versions\": " + jsonRes + " }");
                    JSONArray arr = json.getJSONArray("versions");
                    for (int i=0; i < arr.length(); i++){
                        JSONObject obj = arr.getJSONObject(i);
                        int type = obj.getInt("id_status");
                        String data_create =  obj.getString("data_create");
                        String comment = obj.getString("comment");
                        String file = obj.getString("file");
                        Statuses.add(new com.example.personalaccount.model.Status(GetStatus(type) , data_create, comment, file));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



                GraduationWorkHistory.this.runOnUiThread(new Runnable() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void run() {
                        if(StatusAdapter != null)
                            StatusAdapter.notifyDataSetChanged();
                    }
                });
            }
            else {
                Toast.makeText(GraduationWorkHistory.this, "У Вас нет задач",
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