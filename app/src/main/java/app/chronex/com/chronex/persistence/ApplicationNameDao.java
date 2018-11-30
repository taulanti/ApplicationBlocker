package app.chronex.com.chronex.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import app.chronex.com.chronex.domain.ApplicationDetails;

/**
 * Created by paradigm on 11/29/2018.
 */
@Dao
public interface ApplicationNameDao {

    @Insert
    void insert(ApplicationDetails... applicationName);

    @Delete
    void delete(ApplicationDetails... applicationName);


    @Query("Select * from ApplicationDetails")
    ApplicationDetails[] getAll();
}
