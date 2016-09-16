package com.example.aravindachanta.applicationa1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiverIndiana extends BroadcastReceiver {
    public MyReceiverIndiana() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Opening IndianaPolis APP", Toast.LENGTH_SHORT).show();
    }
}
