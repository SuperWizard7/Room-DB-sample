package com.androidarchitecture.learn.noteapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private QuestionDao questionDao;
    private QRoomDatabase questionDB;
    private LiveData<List<Question>> allQuestions;

    public NoteViewModel(Application application) {
        super(application);

        questionDB = QRoomDatabase.getDatabase(application);
        questionDao = questionDB.questionDao();
        allQuestions = questionDao.getAllQuestions();
    }

    public void insert(Question question) {
        new InsertAsyncTask(questionDao).execute(question);
    }

    LiveData<List<Question>> getAllQuestions() {
        return allQuestions;
    }

    public void update(Question question) {
        new UpdateAsyncTask(questionDao).execute(question);
    }

    public void delete(Question question) {
        new DeleteAsyncTask(questionDao).execute(question);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    private class OperationsAsyncTask extends AsyncTask<Question, Void, Void> {

        QuestionDao mAsyncTaskDao;

        OperationsAsyncTask(QuestionDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Question... questions) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(QuestionDao qDao) {
            super(qDao);
        }

        @Override
        protected Void doInBackground(Question... questions) {
            mAsyncTaskDao.insert(questions[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends OperationsAsyncTask {

        UpdateAsyncTask(QuestionDao questionDao) {
            super(questionDao);
        }

        @Override
        protected Void doInBackground(Question... questions) {
            mAsyncTaskDao.update(questions[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends OperationsAsyncTask {

        public DeleteAsyncTask(QuestionDao questionDao) {
            super(questionDao);
        }

        @Override
        protected Void doInBackground(Question... questions) {
            mAsyncTaskDao.delete(questions[0]);
            return null;
        }
    }
}
