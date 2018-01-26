package com.example.cheruixi.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cheruixi.POJO.User;
import com.example.cheruixi.application.MyApplication;

public class MainActivity extends AppCompatActivity {

    private MyApplication myApplication;
    private static final int CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view){
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("name","Jesse");
        startActivity(intent);
    }

    public void sendBundleMessage(View view){
        Intent intent = new Intent(MainActivity.this, BundleTransfer.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", "Jesse");
        bundle.putInt("age", 29);
        bundle.putBoolean("christian", true);
        intent.putExtra("myBundle", bundle);
        startActivity(intent);
    }

    public void applicationSend(View view){
        Intent intent = new Intent(MainActivity.this, ApplicationTransfer.class);
        MyApplication application = (MyApplication) getApplication();
        User jesse = new User();
        jesse.setName("jesse");
        jesse.setAge(28);
        application.setUser(jesse);
        startActivity(intent);
    }

    public void callbackSend(View view){
        Intent intent = new Intent(MainActivity.this, ResultCallBackActivity.class);
        EditText name = findViewById(R.id.name);
        String nameValue = name.getText().toString();
        intent.putExtra("name", nameValue);
        startActivityForResult(intent, CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE && resultCode== Activity.RESULT_OK){
            String welcome = data.getStringExtra("result");
            TextView result = findViewById(R.id.result);
            result.setText(welcome);
        }
    }
}
