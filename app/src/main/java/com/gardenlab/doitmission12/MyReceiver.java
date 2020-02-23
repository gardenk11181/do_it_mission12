package com.gardenlab.doitmission12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("String");
        Log.d("Process","Start BroadCast: "+msg);
        Intent recieveIntent = new Intent(context,MainActivity.class);
        recieveIntent.putExtra("String",msg);
        recieveIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(recieveIntent);
    }
}
