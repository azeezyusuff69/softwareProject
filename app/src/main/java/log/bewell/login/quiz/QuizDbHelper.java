package log.bewell.login.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import log.bewell.login.quiz.QuizContract.QuestionsTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azeez on 3/19/2018.
 */

public class QuizDbHelper extends SQLiteOpenHelper {

    //Two constant
    private static final String DATABASE_NAME = "BeWellQuiz.db";
    private static final int DATABASE_VERSION = 1;

    //Ref to the database so we can add some valve to it later
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = " CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    // int i, int i1
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }
    //Saving the question in SQLiteDB

    private void fillQuestionsTable() {
        Question q1 = new Question( "How many people will experience some kind of mental health problem in the course of a year?", "1 in 4", "1 in 10", "1 in 6", 1);
        addQuestion(q1);
        Question q2 = new Question("What percentage of children have a mental health problem at any given time?", "5%", "20%", "10%", 3);
        addQuestion(q2);
        Question q3 = new Question("How many people does depression affect?", "1 in 5", "1 in 10", "1 in 12", 1);
        addQuestion(q3);
        Question q4 = new Question("Who is most likely to die from committing suicide?", "Same Ratio", "Women", "Men ", 3);
        addQuestion(q4);
        Question q5 = new Question("How many prisoners have a mental disorder?", "1 in 2", "1 in 5", "9 in 10", 2);
        addQuestion(q5);
        Question q6 = new Question( "What is the female to male ratio of Obsessive Compulsive Disorder", "1 in 5", "1 in 10", "1 in 12", 1);
        addQuestion(q6);
        Question q7 = new Question("What are not physical symptoms of depression?",  "Sleeping for longer", "Lessened sex drive", "Loss of appetite",1);
        addQuestion(q7);
        Question q8 = new Question("On how many days a week should you aim to be active for at least 30 minutes?", "5 days", "2 days", "Everyday", 2);
        addQuestion(q8);
        Question q9 = new Question("After exercise you are better able to cope with the stresses and strains of life?", "Maybe", "False", "True", 3);
        addQuestion(q9);
        Question q10 = new Question("Exercise can be as effective as medication in treating depression? ", "True", "Maye", "False", 1);
        addQuestion(q10);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUM, question.getAnswerNum());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    //Retriving the date back from SQLiteDB
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNum(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;

    }

}
