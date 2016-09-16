package com.example.aravindachanta.applicationa2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class IndianapolisReciever extends BroadcastReceiver {
    public IndianapolisReciever() {
    }

    @Override
    // an Intent broadcast reciever to start the indianapolis activity.
    public void onReceive(Context context, Intent intent) {
        Intent v = new Intent();
        v.setClass(context,IndianapolisActivity.class);
        v.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(v);
    }
}
