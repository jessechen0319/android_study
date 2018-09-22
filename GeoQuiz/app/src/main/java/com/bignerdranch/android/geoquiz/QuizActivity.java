package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mPrevButton;
    private Button mNextButton;
    private TextView mTextView;
    private Button mCheatButton;

    private Answer[] mAnswer = new Answer[]{
            new Answer(R.string.question_1, false),
            new Answer(R.string.question_2, true),
            new Answer(R.string.question_3, true),
            new Answer(R.string.question_4,true),
            new Answer(R.string.question_5, false)};
    private int currcentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //获取控件实例
        getWidget();

        int questionId = mAnswer[currcentIndex].getId();
        mTextView.setText(questionId);
        mTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nextQuestion(1);
            }
        });

        //跳转页面，传值
        mCheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                boolean answer = mAnswer[currcentIndex].getAnswer();
                i.putExtra(CheatActivity.EXTRA_ANSWER_IS_TURE, answer);
                startActivityForResult(i,0);
            }
        });
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //
                //checkAnswer(true);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
                checkAnswer(false);
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nextQuestion(-1);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nextQuestion(1);
            }
        });
    }

    private void checkAnswer(boolean userSelected){

        boolean answer = mAnswer[currcentIndex].getAnswer();
         if(userSelected == answer) {
             Toast.makeText(QuizActivity.this,
                     R.string.correct_toast, Toast.LENGTH_SHORT).show();
         } else {
             Toast.makeText(QuizActivity.this,
                     R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    private void nextQuestion(int symbol){
        if (currcentIndex == 0 && symbol == -1) {
            currcentIndex = mAnswer.length - 1;
        }
        currcentIndex = (currcentIndex + symbol) % mAnswer.length;
        int questionId = mAnswer[currcentIndex].getId();
        mTextView.setText(questionId);
    }

    private void getWidget() {
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mTextView = (TextView)findViewById(R.id.question_text_view);
        mCheatButton = findViewById(R.id.cheat_button);
        mNextButton = findViewById(R.id.next_button);
        mPrevButton = findViewById(R.id.prev_button);
    }
}
