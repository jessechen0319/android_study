package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class CheatActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER_IS_TURE =
            "com.bignerdranch.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN =
            "com.bignerdranch.android,geoquiz.answer_shown";

    private TextView mTextView;
    private Boolean mAnswerIsTrue;
    private Button mShowAnsmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        //获取传入的值
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TURE, false);
        //获取控件实例
        getWidget();
        mTextView.setText(mAnswerIsTrue.toString());



    }

    private void getWidget() {
        mTextView = findViewById(R.id.cheat_button);
    }

    private void setAnswerShownResult(Boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
}
}
