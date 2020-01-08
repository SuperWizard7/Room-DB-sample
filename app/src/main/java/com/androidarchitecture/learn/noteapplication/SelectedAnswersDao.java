package com.androidarchitecture.learn.noteapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface SelectedAnswersDao {

    @Insert
    void insert(SelectedAnswers selectedAnswers);

    @Query("SELECT selectedAns FROM selected_answers WHERE userid=:uID and questionID=:qID")
    LiveData<Integer> getSelectedAnswer(int uID, int qID);

    @Update
    void update(SelectedAnswers selectedAnswers);

    @Delete
    long delete(SelectedAnswers selectedAnswers);

}

