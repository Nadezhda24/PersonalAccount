package com.example.personalaccount.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.ChatAdapter;
import com.example.personalaccount.controller.HTTPHandler;
import com.example.personalaccount.model.Chat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SystemMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemMessageFragment extends Fragment {

    ArrayList<Chat> Chats = new ArrayList<Chat>();

    String jsonRes = null;

    private static String URL = "https://api.oreluniver.ru/api/task/0";

    ChatAdapter ChatAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SystemMessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SystemMessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SystemMessageFragment newInstance(String param1, String param2) {
        SystemMessageFragment fragment = new SystemMessageFragment();
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
        View view = inflater.inflate(R.layout.fragment_system_message, container, false);


        //int id_user =  getArguments().getInt("id");
        int id_user = 180820;
        URL = "https://api.oreluniver.ru/api/dialogue/" + id_user;


        setInitialData();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewChats);

        ChatAdapter.OnChatClickListener chatClickListener = new ChatAdapter.OnChatClickListener() {
            @Override
            public void onChatClick(Chat chat, int position) {
                Toast.makeText(getActivity(), "Был выбран пункт " + chat.GetChatTitle(),
                        Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getContext(),ChatActivity.class);
                startActivity(intent);
            }
        } ;

        android.widget.ImageView ImageView = (ImageView) view.findViewById(R.id.add);
        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),ChoiseActivity.class);
                startActivity(intent);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ChatAdapter = new ChatAdapter(getActivity(),Chats, chatClickListener);

        recyclerView.setAdapter(ChatAdapter);




        return view;
    }



    private void setInitialData(){
        Chats.add(new Chat("Функциональное и логическое программирование",  ""));
        Chats.add(new Chat("Функциональное и логическое программирование", ""));
      }

/*
    private void setInitialData(){
        try {
            new GetData().execute().get();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Проверьте соединение с интернетом",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private class GetData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            HTTPHandler sh = new HTTPHandler();
            String jsonStr = sh.getData(URL, "GET");
            jsonRes = jsonStr;
            return null;
        }
        //выполняется после doInBackground
        @Override
        protected void onPostExecute(Void v) {


            if (jsonRes != null){
                JSONObject json = null;

                try {
                    json = new JSONObject("{\"chats\": " + jsonRes + " }");
                    JSONArray arr = json.getJSONArray("chats");
                    for (int i=0; i < arr.length(); i++) {

                        //  Chats.add(new Chat());
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }



                getActivity().runOnUiThread(new Runnable() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void run() {
                        ChatAdapter.notifyDataSetChanged();
                    }
                });
            }
            else {
                Toast.makeText(getActivity(), "У Вас нет задач",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
*/
}