package com.example.cheruixi.contentproviderdemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static final String CALL_LOG_URI = "content://call_log/calls";
    private ContentResolver contentResolver;
    private String[] columns = new String[]{
            CallLog.Calls._ID, CallLog.Calls.NUMBER, CallLog.Calls.DATE, CallLog.Calls.TYPE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv);
        contentResolver = getContentResolver();
    }

    public void getCallLog(View view) {

        int calllogPermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALL_LOG);

        if(calllogPermission!=PackageManager.PERMISSION_GRANTED){
            Log.i("jesse", "do not get the permission");
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CALL_LOG}, 1);
        } else {
            Log.i("jesse", "get the permission");
            Cursor cursor = contentResolver.query(Uri.parse(CALL_LOG_URI), columns, null, null, null);
            Log.i("jesse", "is have data:"+cursor.moveToNext());
            CursorAdapter adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.calllogs, cursor, columns, new int[]{
                    R.id.number,
                    R.id.date,
                    R.id.type
            }, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            listView.setAdapter(adapter);
        }


    }
}
