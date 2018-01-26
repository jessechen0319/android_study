package com.example.cheruixi.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultCallBackActivity extends AppCompatActivity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_call_back);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        TextView nameTV = findViewById(R.id.name);
        nameTV.setText(name);
    }

    public void callback(View view){
        EditText editText = findViewById(R.id.welcome);
        String welCome = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("result", welCome + ": " + name );
        setResult(Activity.RESULT_OK, intent);
        ResultCallBackActivity.this.finish();
    }
}
