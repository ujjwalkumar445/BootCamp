package com.example.notification_exercise;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static String CHANNEL_ID="CHANNEL_1";
    private  static String CHANNEL_NAME="notification";
    private static int NOTIFICATION_ID=1;
    NotificationManager mNotifyManager;
    NotificationChannel channel;
    NotificationCompat.Builder notifyBuilder;

    TextView notificationTitle,notificationDescription;
    Button notify,cancel,update;
    MyService myService=new MyService();
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotifyManager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
        channel.enableLights(true);
        channel.setLightColor(Color.RED);
        channel.enableVibration(false);
        channel.setDescription("Basic Description");
        notify=findViewById(R.id.notify);
        cancel=findViewById(R.id.cancel);
        update=findViewById(R.id.update);
        notificationTitle=findViewById(R.id.notificationTitle);
        notificationDescription=findViewById(R.id.notificationDescription);
        mNotifyManager.createNotificationChannel(channel);
        Intent notificationintent=new Intent(MainActivity.this,MainActivity.class);
        PendingIntent notificationPendingIntent=PendingIntent.getActivity(this,NOTIFICATION_ID, notificationintent
                ,PendingIntent.FLAG_UPDATE_CURRENT);
        notifyBuilder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("you've been notified")
                .setContentText("this is notofication text")
                .setSmallIcon(R.drawable.ice1)
                .setContentIntent(notificationPendingIntent)
                .addAction(R.drawable.ice1,"this is action",notificationPendingIntent)
                .addAction(R.drawable.ice1,"this is action",notificationPendingIntent)
                .setAutoCancel(true);
        notify.setOnClickListener(this);
        cancel.setOnClickListener(this);
        update.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.notify:
                mNotifyManager.notify(NOTIFICATION_ID,notifyBuilder.build());
                break;
            case R.id.cancel:
                mNotifyManager.cancel(NOTIFICATION_ID);
                break;
            case R.id.update:
                updateNotification();

        }

    }

    private void updateNotification() {
        Bitmap androidImage= BitmapFactory
                .decodeResource(getResources(),R.drawable.ice1);
        notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(androidImage)
                .setBigContentTitle("Notification updated"));
    }
}