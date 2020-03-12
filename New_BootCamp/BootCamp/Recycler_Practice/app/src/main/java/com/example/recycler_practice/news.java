package com.example.recycler_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycler_practice.POJO.NewsModel;

import java.util.ArrayList;

public class news extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<NewsModel> al = new ArrayList<>();
    NewsAdapter_class adapter1;
    ArrayList<String> Title = new ArrayList<>();
    ArrayList<String> desc = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerview2);
        for(int i = 0; i<10;i++){
            Title.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            desc.add("Australia's coronavirus pandemic plan: mass vaccinations and stadium quarantine");
            time.add("20200227T02:41:00+00:00");
        }
        for(int i= 0; i<10; i++){
            String Title1 = Title.get(i);
            String desc1 = desc.get(i);
            String time1 = time.get(i);
            if(i==0){
                al.add(new NewsModel(0,R.drawable.ice1,Title1,desc1,time1));
            }
            else if(i==1)
            {
                al.add(new NewsModel(1,R.drawable.ice1,Title1,desc1,time1));
            }
            else if(i%2==0)
                al.add(new NewsModel(2,R.drawable.ice1,Title1,desc1,time1));

            else
                al.add(new NewsModel(1,R.drawable.ice1,Title1,desc1,time1));

        }

        adapter1 = new NewsAdapter_class(this,al);
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


            }
        }
