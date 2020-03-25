package com.example.question4fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment1 extends Fragment {

    private static final String TAG = "Fragment1";
    RecyclerView recyclerView;
    View rootview;
    ArrayList<String> ar = new ArrayList<>();
    MyAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment1,container,false);


        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler);

        recyclerView .setLayoutManager(new LinearLayoutManager(getActivity()));
        ar.add("Ujjwal");
        ar.add("Bharat");
        ar.add("Akaanksha");
        ar.add("Astha");
        ar.add("Priya");
        ar.add("Tanvi");
        ar.add("Naveen");
        ar.add("Ashutosh");

        adapter = new MyAdapter(ar, getActivity());
        recyclerView.setAdapter(adapter);
        return rootview;

    }

}
