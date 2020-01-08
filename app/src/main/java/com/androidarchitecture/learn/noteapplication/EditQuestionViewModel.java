package com.androidarchitecture.learn.noteapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

public class EditQuestionViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private QuestionDao questionDao;
    private QRoomDatabase db;

    public EditQuestionViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "Edit ViewModel");
        db = QRoomDatabase.getDatabase(application);
        questionDao = db.questionDao();
    }

    public LiveData<Question> getQuestion(int qId) {
        return questionDao.getQuestion(qId);
    }
}
