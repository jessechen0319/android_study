package com.bignerdranch.android.geoquiz;

/**
 * Created by jesse on 2018/5/7.
 */

public class Answer {
    private int mId;

    private Boolean mAnswer;

    public Answer(int id, Boolean answer) {
        this.mId = id;
        this.mAnswer = answer;
    }

    public int getId(){
        return mId;
    }
    public void setId(int id){
        this.mId = id;
    }

    public Boolean getAnswer() {
        return mAnswer;
    }
    public void setAnswer(Boolean answer){
        this.mAnswer = answer;
    }
}
