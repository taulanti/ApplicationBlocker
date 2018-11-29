package app.chronex.com.chronex.application;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.chronex.com.chronex.domain.ApplicationItem;
import app.chronex.com.chronex.domain.ApplicationName;
import app.chronex.com.chronex.persistence.AppDatabase;

/**
 * Created by paradigm on 11/27/2018.
 */

public class ApplicationLoader {

    List<ApplicationItem> applicationItemList;
    Context context;
    public static ApplicationLoader loader;
    private ApplicationLoader(Context context) {
        applicationItemList = new ArrayList<>();
        this.context = context;
    }

    public static ApplicationLoader load(Context context){
        if(loader == null){
            loader = new ApplicationLoader(context);
        }
        return loader;
    }

    public List<ApplicationItem> get() {
        //TOOD merre listen prej dbs
        AppDatabase database = AppDatabase.getAppDatabase(context);
        List<ApplicationName> list = Arrays.asList(database.applicationNameDao().getAll());
        if(!applicationItemList.isEmpty())
            return applicationItemList;
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for(ApplicationInfo a : packages){
            if(packageManager.getLaunchIntentForPackage(a.packageName) != null){
                String appName = packageManager.getApplicationLabel(a).toString();
                Drawable icon = packageManager.getApplicationIcon(a);
                applicationItemList.add(new ApplicationItem(appName, list.contains(new ApplicationName(appName)), icon));
            }
        }

        return applicationItemList;
    }
}
