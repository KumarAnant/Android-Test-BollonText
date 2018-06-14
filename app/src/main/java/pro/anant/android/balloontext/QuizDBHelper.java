package pro.anant.android.balloontext;
import pro.anant.android.balloontext.QuizContract.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HKExcelQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;


    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable(){
        Question q1 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(q1);
        Question q2 = new Question("D is correct", "A", "B", "C", "D", 4);
        addQuestion(q1);
        Question q1 = new Question("A is correct", "A", "B", "C", "D", 1);
        addQuestion(q1);
        Question q1 = new Question("C is correct", "A", "B", "C", "D", 3);
        addQuestion(q1);
        Question q1 = new Question("B is correct", "A", "B", "C", "D", 2);
        addQuestion(q1);

    }

    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswer_nr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);

    }


}
