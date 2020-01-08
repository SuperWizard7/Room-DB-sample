package com.androidarchitecture.learn.noteapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface QuestionDao {

    @Insert
    void insert(Question question);

    @Query("SELECT * FROM questions")
    LiveData<List<Question>> getAllQuestions();

    @Query("SELECT * FROM questions WHERE id=:qID")
    LiveData<Question> getQuestion(int qID);

    @Update
    void update(Question question);

    @Delete
    long delete(Question question);
}
