package com.example.sammy1997.androidcsdcourse.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.example.sammy1997.R;
import com.example.sammy1997.androidcsdcourse.MainActivity;

import java.net.URI;

import static android.app.NotificationManager.*;

public class NotificationService extends Service {
    public NotificationService() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Activity started",Toast.LENGTH_SHORT).show();
        createNotification("Hey Bro");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Activity started",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void createNotification(String message){
        String channel_id = "anything123" ;

        Intent intent = new Intent(this, MainActivity.class) ;
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 23, intent, 0) ;
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification.Builder nb = new Notification.Builder(this)
                .setContentTitle("Android CSD").setContentText(message)
                .setSmallIcon(R.drawable.twitter).setContentIntent(pendingIntent)
                .setSound(sound).addAction(R.drawable.twitter, "view", pendingIntent) ;
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE) ;

        assert notificationManager!= null;
        NotificationChannel channel ;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(channel_id, "Mychannel", IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
            nb.setChannelId(channel_id) ;
        }

        Notification n = nb.build();
        notificationManager.notify(2, n);
    }

}
