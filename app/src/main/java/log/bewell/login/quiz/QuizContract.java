package log.bewell.login.quiz;

import android.provider.BaseColumns;

/**
 * Created by Azeez on 3/19/2018.
 */


public final class QuizContract {

    private  QuizContract(){}

    public static  class QuestionsTable implements BaseColumns {
        public  static  final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NUM = "answer_nr";
    }

}
