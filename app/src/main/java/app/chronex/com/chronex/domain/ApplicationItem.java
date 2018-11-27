package app.chronex.com.chronex.domain;

import android.graphics.drawable.Drawable;

/**
 * Created by paradigm on 11/26/2018.
 */

public class ApplicationItem {

    private String name;
    private boolean isSelected;
    private Drawable icon;

    public ApplicationItem(String appName, boolean b, Drawable icon) {
        this.icon = icon;
        isSelected = b;
        name = appName;
    }

    public ApplicationItem(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
