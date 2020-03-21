package com.example.backgroundtask2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = "Main Activity";
    private AlarmManager alarmManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager =(AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void stopAlarm(View view) {
        Log.e(TAG,"_________"+"Stop");
        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction("com.example.backgroundtask2.Message");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClass(this,Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        alarmManager.cancel(pendingIntent);
    }

    public void startAlarm(View view) {
        Log.e(TAG,"-------------"+"Start");
        Toast.makeText(this, "Alarm Started...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction("com.example.backgroungtask2.Message");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setClass(this,Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),10*3,pendingIntent);
    }
}
