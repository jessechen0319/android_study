package com.example.cheruixi.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        List data = new ArrayList<>();
        data.add("武汉");
        data.add("长沙");
        data.add("重庆");
        data.add("南昌");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);

        ListView lv = findViewById(R.id.mylist);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String city =  adapterView.getItemAtPosition(i).toString();
                Log.i("Jesse", city);
                Toast.makeText(ArrayAdapterDemo.this, city, Toast.LENGTH_SHORT);
            }
        });

    }
}
