package com.example.cheruixi.intent_parameter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMe(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17501480923"));
        startActivity(intent);
    }

    public void hiddenCall(View view){
        Intent intent = new Intent("jesseAction");
        intent.addCategory("jesseCategory");
        startActivity(intent);
    }
}
