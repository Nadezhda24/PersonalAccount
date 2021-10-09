package com.example.personalaccount.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.personalaccount.R;
import com.example.personalaccount.model.Result;
import com.example.personalaccount.controller.ResultAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Result> Results = new ArrayList<Result>();

    public ResultFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResultFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResultFragment newInstance(String param1, String param2) {
        ResultFragment fragment = new ResultFragment();
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

        View view = inflater.inflate(R.layout.fragment_result, container, false);

        setInitialData();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewResults);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ResultAdapter ResultAdapter = new ResultAdapter(getActivity(), Results);

        recyclerView.setAdapter(ResultAdapter);
        return view;

    }


    private void setInitialData(){
        Results.add(new Result("Функциональное и логическое программирование", "Гордиенко А.П.", "Зачет", "Зачтено"));
        Results.add(new Result("Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Основы управления программными проектами\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Программирование микроконтроллеров", "Захарова О.В.", "Экзамен", "Отлично"));
        Results.add(new Result("Функциональное и логическое программирование", "Гордиенко А.П.", "Зачет", "Зачтено"));
        Results.add(new Result("Качество и тестирование программного обеспечения\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Основы управления программными проектами\n(Промышленная разработка программного обеспечения)", "Ужаринский А.Ю.", "Экзамен", "Отлично"));
        Results.add(new Result("Программирование микроконтроллеров", "Захарова О.В.", "Экзамен", "Отлично"));

    }
}