package com.example.cheruixi.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.myNameValue);
    }

    public void saveName(View view){

        String myName = String.valueOf(nameEditText.getText());
        Log.i("jesse", myName);
        if(myName != null &&!"".equals(myName.trim())){
            SharedPreferences sp = getSharedPreferences("names", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("MyName", myName);
            editor.commit();
        }
    }

    public void readData(View view){

        SharedPreferences sp = getSharedPreferences("names", Context.MODE_PRIVATE);
        Toast.makeText(MainActivity.this, "you name is:"+sp.getString("MyName", "没有名字存储在本地"), Toast.LENGTH_SHORT).show();
    }

    public void clearSP(View view){
        SharedPreferences sp = getSharedPreferences("names", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
        Toast.makeText(MainActivity.this, "clear is finished", Toast.LENGTH_SHORT);
    }
}
