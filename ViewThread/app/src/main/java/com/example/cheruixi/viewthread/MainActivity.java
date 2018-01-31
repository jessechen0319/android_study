package com.example.cheruixi.viewthread;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 100){
                System.out.println("come into main");
                String name = msg.getData().getString("name", "noName");
                System.out.println(name);
                result.setText(name);
            }
        }
    };

    public void startCount(View view) throws InterruptedException {


        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    Message message = new Message();
                    Bundle data = new Bundle();
                    data.putString("name", "jesse");
                    message.setData(data);
                    message.what = 100;
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        td.start();
    }

    public void goToAsync(View view){
        Intent intent = new Intent(this, AsyncTaskActivity.class);
        startActivity(intent);
    }
}
