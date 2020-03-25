package com.example.question4fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<String> ar =new ArrayList<>();
    Context context;
    public MyAdapter(ArrayList<String> ar,Context context) {

        this.ar = ar;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myadapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String a = ar.get(position);
        holder.textView.setText(a);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment2 fragment2=new fragment2();
                Bundle bundle=new Bundle();
                bundle.putInt("key",position);
                fragment2.setArguments(bundle);
                int val =context.getResources().getConfiguration().orientation;
                if(val == Configuration.ORIENTATION_LANDSCAPE){
                    ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.list,fragment2).addToBackStack(null).commit();
                }
                ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.list,fragment2).addToBackStack(null).commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        return ar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       public TextView textView;
       public CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = itemView.findViewById(R.id.names);
            cardView = itemView.findViewById(R.id.nameCard);
        }
    }
}
