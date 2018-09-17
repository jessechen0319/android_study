package com.example.administrator.calendarmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.administrator.calendarmanager.model.TaskStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Map<String, String>> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.barColor));

        /*列表模板{*/

        Map<String, String> task1 = new HashMap<>();
        task1.put("title","灵修");
        task1.put("content", "中午看完每日灵粮");
        task1.put("status", TaskStatus.NEW);
        tasks.add(task1);

        /*}列表模板*/
    }

    @Override
    public void setContentView(View view) {

        super.setContentView(view);
    }
}
