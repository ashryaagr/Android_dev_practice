package com.example.sammy1997.androidcsdcourse.adapters.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "intent is built", Toast.LENGTH_SHORT).show();
    }
}
