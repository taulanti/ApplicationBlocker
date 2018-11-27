package app.chronex.com.chronex.domain;

/**
 * Created by paradigm on 11/26/2018.
 */

public class Application {

    private String name;
    private boolean isSelected;

    public Application() {
    }

    public Application(String name, boolean isSelected) {
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
}
