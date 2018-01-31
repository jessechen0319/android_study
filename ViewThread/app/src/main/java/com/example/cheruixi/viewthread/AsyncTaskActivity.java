package com.example.cheruixi.viewthread;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        result = findViewById(R.id.result);
    }

    public void printName(View view){
        Object[] names = new String[]{"jesse", "steven", "david"};
        PrintTask printTask = new PrintTask();

        //printTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, names);
        PrintTask printTask1 = new PrintTask();
        printTask.execute(names);
        printTask1.execute(names);
        //printTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, names);
    }

    class  PrintTask extends AsyncTask{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            String resultValue = (String) result.getText();
            result.setText(resultValue+"start printing...");
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String resultValue = (String) result.getText();
            for( Object object: objects){
                String name = object.toString();
//                if(resultValue.equals("result")){
//                    resultValue = "";
//                }
                resultValue += " ";
                resultValue += name;
            }
            return resultValue;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            String resultString = o.toString();
            result.setText(resultString);
        }
    }
}


