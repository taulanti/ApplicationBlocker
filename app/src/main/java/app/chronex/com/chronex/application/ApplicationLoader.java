package app.chronex.com.chronex.application;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import app.chronex.com.chronex.domain.ApplicationItem;

/**
 * Created by paradigm on 11/27/2018.
 */

public class ApplicationLoader {

    List<ApplicationItem> applicationItemList;
    PackageManager packageManager;
    public static ApplicationLoader loader;
    private ApplicationLoader(PackageManager packageManager) {
        applicationItemList = new ArrayList<>();
        this.packageManager = packageManager;
    }

    public static ApplicationLoader load(PackageManager packageManager){
        if(loader == null){
            loader = new ApplicationLoader(packageManager);
        }
        return loader;
    }

    public List<ApplicationItem> get() {
        List<ApplicationInfo> packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for(ApplicationInfo a : packages){
            String appName = packageManager.getApplicationLabel(a).toString();
            Drawable icon = packageManager.getApplicationIcon(a);
            applicationItemList.add(new ApplicationItem(appName, false, icon));
        }

        return applicationItemList;
    }
}
