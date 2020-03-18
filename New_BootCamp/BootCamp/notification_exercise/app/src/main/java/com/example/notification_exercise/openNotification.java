package com.example.notification_exercise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

class openNotification extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_notification);

        textView = findViewById(R.id.notificationBody);
        imageView =findViewById(R.id.notificationImage);
        Intent intent = new Intent();
        String price = intent.getStringExtra("value");
        String url = intent.getStringExtra("url");
        String body = intent.getStringExtra("body");
        String title = intent.getStringExtra("title");
        textView.setText("title"+title+"\n"+"body : "+body+"\n"+"price = "+price);

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ice1)
                .error(R.drawable.ice1)
                .into(imageView);


    }
}