package com.example.recycler_practice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_practice.POJO.NewsModel;

import java.util.ArrayList;

public class NewsAdapter_class extends RecyclerView.Adapter {

    Context context;
    ArrayList<NewsModel> al;
    public NewsAdapter_class(Context context,ArrayList<NewsModel> al) {
        this.context = context;
        this.al = al;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view;
        switch(viewType){
            case NewsModel.IMAGE_ONLY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_only,parent,false);
                return new MyViewHolder0(view);
            case NewsModel.IMAGE_TEXT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_only,parent,false);
                return new MyViewHolder2(view);
            case NewsModel.TEXT_ONLY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_text,parent,false);
                return new MyViewHolder1(view);

        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        NewsModel newsModel = al.get(position);
        String heading = newsModel.getHeading();
        String desc = newsModel.getSubheading();
        String time = newsModel.getTime();
        int image = newsModel.getImages();
        Log.v("al",heading+" heading" +"type=="+newsModel.type);

        switch(newsModel.type){
            case NewsModel.IMAGE_ONLY:
                Log.v("exe12","imageonly");
                int image1=newsModel.getImages();
                ((MyViewHolder0)holder).imageView.setImageResource(image1);
                break;
            case NewsModel.IMAGE_TEXT:
                Log.v("exe12","textimage");
                ((MyViewHolder1)holder).mainHeading.setText(heading);
                ((MyViewHolder1)holder).heading.setText(desc);
                ((MyViewHolder1)holder).time.setText(time);
                ((MyViewHolder1)holder).imageView.setImageResource(image);
                break;
            case NewsModel.TEXT_ONLY:
                Log.v("exe12","textonlu");
                ((MyViewHolder2)holder).mainHeading.setText(heading);
                ((MyViewHolder2)holder).heading.setText(desc);

                break;

        }

    }


    @Override
    public int getItemCount() {
        return al.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    private class MyViewHolder0 extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;


        public MyViewHolder0(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.card1);
        }
    }
    private class MyViewHolder1 extends  RecyclerView.ViewHolder {

        TextView mainHeading,heading,time;
        ImageView imageView;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            mainHeading = itemView.findViewById(R.id.t2);
            heading = itemView.findViewById(R.id.t3);
            imageView = itemView.findViewById(R.id.image1);
            time = itemView.findViewById(R.id.time);
        }
    }

    private class MyViewHolder2 extends  RecyclerView.ViewHolder {
        TextView mainHeading,heading;
        public MyViewHolder2(View view) {
            super(view);
            mainHeading=itemView.findViewById(R.id.t7);
            heading=itemView.findViewById(R.id.t8);

        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (al.get(position).type)
        {
            case 0:
                return NewsModel.IMAGE_ONLY;
            case 1:
                return NewsModel.IMAGE_TEXT;
            case 2:
                return NewsModel.TEXT_ONLY;
            default:
                return -1;

        }
    }
}
