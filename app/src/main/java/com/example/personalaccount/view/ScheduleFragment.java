package com.example.personalaccount.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalaccount.R;
import com.example.personalaccount.controller.ScheduleDayAdapter;
import com.example.personalaccount.model.ScheduleDay;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleFragment extends Fragment {
    ArrayList<ScheduleDay> ScheduleDays = new ArrayList<ScheduleDay>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        setInitialData();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewShedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ScheduleDayAdapter ScheduleDayAdapter = new ScheduleDayAdapter(getActivity(), ScheduleDays);

        recyclerView.setAdapter(ScheduleDayAdapter);
        return view;
    }

    private void setInitialData(){
        ScheduleDays.add(new ScheduleDay("1", " 8:30", "10:00" ,"Этические основы коммуникации в поликультурном пространстве","практическое занятие", "11-445",  "Гревцева А.А."));
        ScheduleDays.add(new ScheduleDay("2", "10:10", "11:40" ,"Автоматизированные системы управления предприятием","лекция", "11-445",  "Раков В.И."));
        ScheduleDays.add(new ScheduleDay("3", "12:00", "13:30" ,"Автоматизированные системы управления предприятием","лабораторная работа", "11-346",  "Раков В.И."));
        ScheduleDays.add(new ScheduleDay("4", "13:40", "15:10" ,"Автоматизированные системы управления предприятием","лабораторная работа", "11-346",  "Раков В.И."));
    }
}