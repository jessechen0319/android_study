package com.example.cheruixi.gradeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridTest);

        //prepare data
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 1; i<=8; i++){
            Map map = new HashMap();
            Integer id = getResources().getIdentifier("com.example.cheruixi.gradeview:drawable/a2", null, null);
            Log.i("jesse", id.toString());
            String title = "item"+i;
            map.put("title", title);
            map.put("icon", id);
            data.add(map);
        }

        //create simpleAdapter
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, data, R.layout.simplelayout, new String[]{"title", "icon"}, new int[]{R.id.title, R.id.icon} );

        //add adapter
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map item = (Map) parent.getItemAtPosition(position);
                Log.i("jesse", item.get("title").toString());
            }
        });
    }
}
