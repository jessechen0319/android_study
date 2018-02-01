package com.example.cheruixi.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AddHeader extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_header);
        lv = findViewById(R.id.myListAddHeader);

        List list = new ArrayList();
        list.add("Jesse");
        list.add("Steven");
        list.add("David");
        ArrayAdapter adapter = new ArrayAdapter(AddHeader.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        //addHeader

        ImageView imageView = new ImageView(AddHeader.this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        imageView.setImageResource(R.drawable.acgn);

        lv.addHeaderView(imageView);


    }
}
