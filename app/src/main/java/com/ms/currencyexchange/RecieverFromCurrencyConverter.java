package com.ms.currencyexchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RecieverFromCurrencyConverter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent activityIntent = new Intent(context, MainActivity.class);
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activityIntent.putExtra("msg1", intent.getStringExtra("message1"));
        activityIntent.putExtra("msg2", intent.getStringExtra("message2"));
        context.startActivity(activityIntent);
        if(MainActivity.txt != null && MainActivity.crt !=null) {

            MainActivity.txt.setText(intent.getStringExtra("message1"));
            MainActivity.crt.setText(intent.getStringExtra("message2"));
        }
    }
}
