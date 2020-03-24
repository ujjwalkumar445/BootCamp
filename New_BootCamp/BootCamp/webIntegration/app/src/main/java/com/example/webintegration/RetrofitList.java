package com.example.webintegration;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitList extends AppCompatActivity {
    RecyclerView recyclerView;
    public static ArrayList<ListItems> arrayList = new ArrayList<>();
    MyAdapter myAdapter;
    public static final String URL="https://storage.googleapis.com/network-security-conf-codelab.appspot.com/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.httplist);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getData();
    }

    private void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlaceHolderApi request = retrofit.create(PlaceHolderApi.class);
        Call<model> call = request.getJsonObjectData();
        call.enqueue(new Callback<model>() {
            @Override
            public void onResponse(Call<model> call, Response<model> response) {
                model jsonResponse = response.body();

                Log.e("body",jsonResponse.getPosts().length+"");
                ArrayList<ListItems> data = new ArrayList(Arrays.asList(jsonResponse.getPosts()));
                String name = data.get(0).getName();
                Log.e("name",name+"");
                MyAdapter adapter = new MyAdapter(data,RetrofitList.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<model> call, Throwable t) {
                Log.e("Error",t.getMessage());

            }
        });

    }
}
