package com.bignerdranch.android.styletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear",
    "Grape"};
    private ArrayList<Map<String,Object>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,data);
        ListView list = findViewById(R.id.list_view);
        list.setAdapter(adapter);

        initGridViewData();
        GridView gdv = findViewById(R.id.grid_view);
        String[] from = {"img", "text"};
        int[] to = {R.id.img, R.id.text};
        SimpleAdapter gAdapter = new SimpleAdapter(this,dataList,R.layout.gridview_item,
                from,to);
        gdv.setAdapter(gAdapter);
    }

    private void initGridViewData() {
        int icon[] = {R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.orange_pic,
         R.drawable.watermelon_pic, R.drawable.pear_pic, R.drawable.grape_pic};
        String name[] = {"Apple","Banana","Orange","Watermelon","Pear",
                "Grape"};
         dataList = new ArrayList<Map<String, Object>>();
         for(int i = 0; i < icon.length; i++){
             Map<String, Object> map = new HashMap<String, Object>(){};
             map.put("img",icon[i]);
             map.put("text",name[i]);
             dataList.add(map);
         }
    }


}
