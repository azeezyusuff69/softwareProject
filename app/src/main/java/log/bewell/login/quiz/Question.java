package log.bewell.login.quiz;

/**
 * Created by Azeez on 3/19/2018.
 */

public class Question {

    //Creating val
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNum;

    //Empty Constructor. When we carry data from Database we create empty Question object and we then set method so that it value on to the below object
    public Question(){}

    public Question(String question, String option1, String option2, String option3, int answerNum) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNum = answerNum;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }
}
