package com.gardenlab.doitmission12;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String ACTION_MY_SERVICE = "com.gardenlab.doitmission12.MY_SERVICE";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        processCommand(intent);

        return super.onStartCommand(intent, flags, startId);
    }

    public void processCommand(Intent intent) {
        String msg = intent.getStringExtra("String");
        Log.d("Process","Start Service: "+msg);
        Intent toBroadIntent = new Intent(ACTION_MY_SERVICE);
        toBroadIntent.putExtra("String",msg);
        sendBroadcast(toBroadIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
