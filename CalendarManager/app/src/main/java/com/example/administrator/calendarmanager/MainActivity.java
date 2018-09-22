package com.example.administrator.calendarmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.calendarmanager.model.TaskStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<HashMap<String, String>> tasks = new ArrayList<>();

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

        HashMap<String, String> task1 = new HashMap<>();
        task1.put("title","灵修");
        task1.put("content", "中午看完每日灵粮");
        task1.put("status", TaskStatus.NEW);
        tasks.add(task1);

        HashMap<String, String> task2 = new HashMap<>();
        task2.put("title","看书");
        task2.put("content", "看完几页书");
        task2.put("status", TaskStatus.FINISHED);
        tasks.add(task2);

        /*}列表模板*/

//        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
//                tasks,
//                R.layout.tasks,
//                new String[]{"title", "content"},
//                new int[]{R.id.task_title, R.id.task_desc});
//        ListView listView = findViewById(R.id.tasks);
//        listView.setAdapter(adapter);
        RecyclerView recyclerView = findViewById(R.id.tasks);
        TasksRecycleViewAdapter adapter = new TasksRecycleViewAdapter(this, tasks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshView();

    }

    @Override
    public void setContentView(View view) {

        super.setContentView(view);
    }

    public void refreshView(){
        /*设置时间*/
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd");
        long now=System.currentTimeMillis();
        String formatedDate = aDate.format(now);
        TextView nowDateLabel = findViewById(R.id.current_date);
        nowDateLabel.setText(formatedDate);

        /*设置总任务数*/
        TextView totalTask = findViewById(R.id.totalTask_display);
        totalTask.setText(String.valueOf(tasks.size()));

        /*设置未完成任务数*/
        int uncompleteTask = 0;
        for (Map task : tasks){
            if(task.get("status") == TaskStatus.NEW){
                uncompleteTask++;
            }
        }
        TextView uncompleteTasks = findViewById(R.id.uncompleteTasks);
        uncompleteTasks.setText(String.valueOf(uncompleteTask));

        //refresh

    }
}
