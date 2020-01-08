package com.androidarchitecture.learn.noteapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "scores")
public class Score
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int userid = 1;

    @NonNull
    @ColumnInfo(name = "pScore")
    private int pScore;

    @NonNull
    @ColumnInfo(name = "kScore")
    private int kScore;

    @NonNull
    @ColumnInfo(name = "vScore")
    private int vScore;

    public Score(int pScore, int kScore, int vScore) {
        this.pScore = pScore;
        this.kScore = kScore;
        this.vScore = vScore;
    }

    @NonNull
    public int getUserid() {
        return userid;
    }

    @NonNull
    public int getpScore() {
        return this.pScore;
    }

    @NonNull
    public int getkScore() {
        return this.kScore;
    }

    @NonNull
    public int getvScore() {
        return this.vScore;
    }

}
