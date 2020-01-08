package com.androidarchitecture.learn.noteapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Question.class, Score.class, SelectedAnswers.class}, version = 1)
public abstract class QRoomDatabase extends RoomDatabase {

    public abstract QuestionDao questionDao();
    public abstract ScoreDao scoreDao();
    public abstract SelectedAnswersDao selectedAnswersDao();

    private static volatile QRoomDatabase questionRoomInstance;

    static QRoomDatabase getDatabase(final Context context) {
        if (questionRoomInstance == null) {
            synchronized (QRoomDatabase.class) {
                if (questionRoomInstance == null) {
                    questionRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                            QRoomDatabase.class, "question_database")
                            .build();
                }
            }
        }
        return questionRoomInstance;
    }
}
