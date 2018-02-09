package com.example.cheruixi.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.cheruixi.sqlitedemo.db.DemoDBHelper;

public class ShowResult extends AppCompatActivity {

    SQLiteDatabase db;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        DemoDBHelper helper = new DemoDBHelper(ShowResult.this);
        db = helper.getWritableDatabase();
        lv = findViewById(R.id.iv);

        Cursor cursor = db.query("name", null, null, null, null, null, null);

        CursorAdapter adapter = new SimpleCursorAdapter(ShowResult.this, R.layout.name_db_show, null, new String[]{"name", "age"}, new int[]{R.id.name, R.id.age}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        adapter.swapCursor(cursor);
        adapter.notifyDataSetChanged();

        lv.setAdapter(adapter);

    }
}
