package com.example.backgroundtask2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Alarm extends BroadcastReceiver {
    private static final String TAG = "ALARM";
    private static String CHANNEL_ID="CHANNEL_1";
    private static String NOTIFICATION_ID_1 = "1";
    private NotificationManagerCompat notificationManagerCompat;

    private static int count = 2;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG,"---------"+"onReceived");
        notificationManagerCompat = NotificationManagerCompat.from(context) ;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext(),NOTIFICATION_ID_1);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setAutoCancel(true);
        builder.setPriority(Notification.PRIORITY_MAX);

        NotificationChannel notificationChannel= null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if (count % 2 == 0){
                //notification with sound and vibration

                notificationChannel = new NotificationChannel(CHANNEL_ID,"ALARM_NOTIFICATION_CHANNEL",NotificationManager.IMPORTANCE_HIGH);
                builder.setContentTitle("Notification 1");
                builder.setContentText("This is repeated notification 1");
                notificationChannel.enableVibration(true);
                notificationChannel.setDescription("This is repeated notification 1");
                notificationChannel.setSound(null,null);
                Uri notification = Uri.parse("android.resource://"+context.getPackageName()+"/"+ R.raw.alarm);
                Ringtone r = RingtoneManager.getRingtone(context.getApplicationContext(),notification);
                r.play();

            } else {
                notificationChannel = new NotificationChannel(CHANNEL_ID,"ALARM_NOTIFICATION_CHANNEL",NotificationManager.IMPORTANCE_LOW);
                builder.setContentTitle("Notification 2");
                builder.setContentText("This is repeated notification 2");
                notificationChannel.setDescription("This is repeated notification 2");
            }
            notificationManagerCompat.createNotificationChannel(notificationChannel);
            builder.setChannelId(CHANNEL_ID);
        }

        count++;
        notificationManagerCompat.notify(Integer.parseInt(NOTIFICATION_ID_1),builder.build());

    }
}
