package app.chronex.com.chronex.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PhoneBootReciever extends BroadcastReceiver {
    /* Recieves events when phone boot is completed */
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent myIntent = new Intent(context,AppBlockerService.class);
        context.startService(myIntent);


    }
}