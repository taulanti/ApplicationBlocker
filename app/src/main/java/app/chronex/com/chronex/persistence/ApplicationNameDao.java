package app.chronex.com.chronex.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import app.chronex.com.chronex.domain.ApplicationName;

/**
 * Created by paradigm on 11/29/2018.
 */
@Dao
public interface ApplicationNameDao {

    @Insert
    void insert(ApplicationName... applicationName);

    @Delete
    void delete(ApplicationName... applicationName);


    @Query("Select * from Application")
    ApplicationName [] getAll();
}
