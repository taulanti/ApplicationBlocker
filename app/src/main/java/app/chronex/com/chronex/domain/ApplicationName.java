package app.chronex.com.chronex.domain;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by paradigm on 11/28/2018.
 */
@Entity(tableName = "Application")
public class ApplicationName {

    @PrimaryKey
    @NonNull
    private String name;

    public String getName() {
        return name;
    }

    @Ignore
    public ApplicationName() {
    }

    public ApplicationName(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationName that = (ApplicationName) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
