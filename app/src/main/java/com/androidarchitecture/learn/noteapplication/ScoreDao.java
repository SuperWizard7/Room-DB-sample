package com.androidarchitecture.learn.noteapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface ScoreDao {

    @Insert
    long insert(Score score);

    @Query("SELECT * FROM scores WHERE userid=:uID")
    LiveData<Score> getScore(int uID);

    @Update
    void update(Score score);

    @Delete
    long delete(Score score);

}
