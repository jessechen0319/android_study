package com.example.cheruixi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cheruixi.POJO.User;
import com.example.cheruixi.application.MyApplication;

public class ApplicationTransfer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_transfer);
        MyApplication application = (MyApplication) getApplication();
        User user = application.getUser();
        TextView nameTV = findViewById(R.id.name);
        nameTV.setText(user.getName());
        TextView ageTV = findViewById(R.id.age);
        ageTV.setText(String.valueOf(user.getAge()));
    }
}
