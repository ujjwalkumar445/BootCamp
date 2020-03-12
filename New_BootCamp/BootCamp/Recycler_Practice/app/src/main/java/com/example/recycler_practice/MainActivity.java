package com.example.recycler_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<String> arrayList = new ArrayList<String>();
    Adapter_class adapter;
    boolean isScrolling = false;
    int currentItems,TotalItems,ScrolledOutItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressbar);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        arrayList.add("Ujjwal");
        arrayList.add("Bharat");
        arrayList.add("Akaanksha");
        arrayList.add("Astha");
        arrayList.add("Priya");
        arrayList.add("Tanvi");
        arrayList.add("Naveen");
        arrayList.add("Ashutosh");
        arrayList.add("Subarno");
        arrayList.add("Ankit");
        arrayList.add("Anupam");
        arrayList.add("Lakshya");

        adapter = new Adapter_class(arrayList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = linearLayoutManager.getChildCount();
                TotalItems = linearLayoutManager.getItemCount();
                ScrolledOutItem = linearLayoutManager.findFirstVisibleItemPosition();
                if(isScrolling &&(ScrolledOutItem+currentItems==TotalItems)){
                    isScrolling=false;
                    fetchdata();
                }
            }
        });
    }

    public void fetchdata (){
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<5; i++){
                    arrayList.add(Math.floor(Math.random()*100)+"");
                    adapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);
            }
        },5000);
    }
}
