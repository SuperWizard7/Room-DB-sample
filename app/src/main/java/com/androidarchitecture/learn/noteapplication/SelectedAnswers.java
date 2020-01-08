package com.androidarchitecture.learn.noteapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "selected_answers",
        primaryKeys = {"qId","userId"},
        foreignKeys = {@ForeignKey(entity = Question.class,
        parentColumns = "id",
        childColumns = "questionID",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Score.class,
        parentColumns = "userid",
        childColumns = "userID",
        onDelete = ForeignKey.CASCADE)})
public class SelectedAnswers {

    @ColumnInfo(name = "questionID")
    private int qId;

    @ColumnInfo(name = "userID")
    private int userId;

    @ColumnInfo(name = "selectedAns")
    private int selectedAns;

    public SelectedAnswers(int qId, int userId, int selectedAns) {
        this.qId = qId;
        this.userId = userId;
        this.selectedAns = selectedAns;
    }

    public int getqId() {
        return qId;
    }

    public int getUserId() {
        return userId;
    }

    public int getSelectedAns() {
        return selectedAns;
    }

}
