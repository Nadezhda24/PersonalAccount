package com.example.personalaccount.view;

import android.content.Intent;
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
import com.example.personalaccount.model.Chat;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SystemMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemMessageFragment extends Fragment {

    ArrayList<Chat> Chats = new ArrayList<Chat>();
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
        ChatAdapter  ChatAdapter = new ChatAdapter(getActivity(),Chats, chatClickListener);

        recyclerView.setAdapter(ChatAdapter);

        return view;
    }



    private void setInitialData(){
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
        Chats.add(new Chat("Функциональное и логическое программирование", "Функциональное и логическое программирование", ""));
      }

}