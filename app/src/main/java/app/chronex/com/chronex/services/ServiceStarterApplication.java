package app.chronex.com.chronex.services;

import android.app.Application;
import android.content.Intent;

/**
 * Created by paradigm on 11/30/2018.
 */

public class ServiceStarterApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, AppBlockerService.class));
    }
}
