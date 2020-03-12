package com.example.recycler_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter_class extends RecyclerView.Adapter<Adapter_class.MyViewHolder> {

    ArrayList<String> arrayList = new ArrayList<>();
    Context context;

    public Adapter_class(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_class,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final  String a = arrayList.get(position);
        holder.textView.setText(a);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,news.class));
                Log.v("exe123","exe");
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.names);
            cardView = itemView.findViewById(R.id.nameCard);
        }
    }
}
