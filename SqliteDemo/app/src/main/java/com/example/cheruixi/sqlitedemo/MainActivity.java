package com.example.cheruixi.sqlitedemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cheruixi.sqlitedemo.db.DemoDBHelper;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DemoDBHelper helper = new DemoDBHelper(MainActivity.this);
        db = helper.getWritableDatabase();
    }

    public void saveInfomation(View view){
        ContentValues contentValues = new ContentValues();
        EditText name = findViewById(R.id.myName);
        String nameString = name.getText().toString();
        EditText age = findViewById(R.id.myAge);
        int ageValue = Integer.valueOf(age.getText().toString());

        contentValues.put("name", nameString);
        contentValues.put("age", ageValue);

        long result = db.insert("name", null, contentValues);
        if(result>0){
            Toast.makeText(MainActivity.this, "insert successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "insert failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void queryData(View view){
        Cursor cursor = db.query("name", null, "name=?", new String[]{"Steven"}, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            Toast.makeText(MainActivity.this, "name is "+name+", age is "+age, Toast.LENGTH_SHORT).show();
        }
    }

    public void showResults(View view){
        Intent intent = new Intent(MainActivity.this, ShowResult.class);
        startActivity(intent);
    }
}
