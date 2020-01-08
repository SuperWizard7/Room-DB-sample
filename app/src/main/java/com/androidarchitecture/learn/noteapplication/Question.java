package com.androidarchitecture.learn.noteapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "questions")
public class Question {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id = 0;

    @NonNull
    @ColumnInfo(name = "question")
    private String question;

    @NonNull
    @ColumnInfo(name = "option1")
    private String option1;

    @NonNull
    @ColumnInfo(name = "option2")
    private String option2;

    @NonNull
    @ColumnInfo(name = "option3")
    private String option3;

    @NonNull
    public int getId() {
        return id;
    }

    @NonNull
    public String getQuestion() {
        return this.question;
    }

    @NonNull
    public String getOption1() {
        return this.option1;
    }

    @NonNull
    public String getOption2() {
        return this.option2;
    }

    @NonNull
    public String getOption3() { return this.option3; }

    public Question(String question, String option1, String option2, String option3) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
    }

}

