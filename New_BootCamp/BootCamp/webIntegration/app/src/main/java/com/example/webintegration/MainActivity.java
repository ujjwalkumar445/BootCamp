package com.example.webintegration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;
    Button ImageBtn,HttpBtn,RetroBtn;
    public static final String URL ="https://image.freepik.com/free-photo/image-human-brain_99433-298.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.llayout);
        ImageBtn = findViewById(R.id.setImage);
        HttpBtn = findViewById(R.id.httpBtn);
        RetroBtn = findViewById(R.id.RetrofitBtn);
        ImageBtn.setOnClickListener(this);
        HttpBtn.setOnClickListener(this);
        RetroBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.setImage){
            setBackgroundImage();
        }
        if(v.getId()==R.id.httpBtn){
            Log.e("http","Http URL Connection");
            Intent intent = new Intent(MainActivity.this,HttpList.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.RetrofitBtn){
            Log.e("Retrofit","Retrofit");
            Intent intent = new Intent(MainActivity.this,RetrofitList.class);
            startActivity(intent);
        }

    }

    private void setBackgroundImage() {
        Glide.with(MainActivity.this)
                .load(URL)
                .into(new CustomTarget<Drawable>() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        linearLayout.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

    }
}
