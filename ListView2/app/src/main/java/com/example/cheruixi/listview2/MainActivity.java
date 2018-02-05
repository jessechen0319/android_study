package com.example.cheruixi.listview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void basicListView(View view){
        Intent intent = new Intent(this, Simple.class);
        startActivity(intent);
    }

    public void arrayAdapter(View view){
        Intent intent = new Intent(this, ArrayAdapterDemo.class);
        startActivity(intent);
    }

    public void addHeader(View view){
        Intent intent = new Intent(this, AddHeader.class);
        startActivity(intent);
    }

    public void demoSimple(View view){
        Intent intent = new Intent(this, SimpleAdapterDemo.class);
        startActivity(intent);
    }

    public void demoBase(View view){
        Intent intent = new Intent(this, BaseAdapterDemo.class);
        startActivity(intent);
    }
}
