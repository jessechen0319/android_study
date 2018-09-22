package com.example.cheruixi.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterDemo extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_demo);

        listView = findViewById(R.id.mySimpleList);

        List list = new ArrayList();

        //prepare data
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("icon", R.drawable.icon1);
        map1.put("name", "Jesse");
        map1.put("age", "15");
        list.add(map1);
        map2.put("icon", R.drawable.icon2);
        map2.put("name", "Lisa");
        map2.put("age", "14");
        list.add(map2);

        //Create Simple Adapter
        SimpleAdapter adapter = new SimpleAdapter(SimpleAdapterDemo.this,
                list,
                R.layout.listview_simple1,
                new String[]{"icon", "name", "age"},
                new int[]{R.id.list_icon, R.id.list_name, R.id.list_age});
        listView.setAdapter(adapter);

    }


}
