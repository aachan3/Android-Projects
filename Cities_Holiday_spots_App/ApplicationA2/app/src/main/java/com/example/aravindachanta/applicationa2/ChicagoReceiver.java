package com.example.aravindachanta.applicationa2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ChicagoReceiver extends BroadcastReceiver {
    public ChicagoReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast reciever to start the chicago activity.
        Intent k = new Intent();
        k.setClass(context,ChicagoActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(k);
    }
}
