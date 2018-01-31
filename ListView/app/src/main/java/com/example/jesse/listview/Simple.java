package com.example.jesse.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simple extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple2);

        listView = findViewById(R.id.simpleListView);


        List<Map<String, ?>> list = new ArrayList<>();

        Map map1 = new HashMap();
        map1.put("name", "Jesse");
        map1.put("age", "15");
        map1.put("address", "上海市浦东新区益江路511弄");
        Map map2 = new HashMap();
        map2.put("name", "Jesse");
        map2.put("age", "15");
        map2.put("address", "上海市浦东新区益江路511弄");

        list.add(map1);
        list.add(map2);

       // Adapter adapter = new SimpleAdapter(this, list, R.layout.simple, new String[]{"name", "age", "address"}, new int[]{R.id.name, R.id.age, R.id.address});


    }
}
