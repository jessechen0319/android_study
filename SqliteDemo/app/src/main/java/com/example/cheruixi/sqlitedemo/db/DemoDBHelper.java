package com.example.cheruixi.sqlitedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cheruixi on 2018/2/8.
 */

public class DemoDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "jesse_test";

    public DemoDBHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_name_sql = "create table name (_id INTEGER primary key autoincrement not null, name VARCHAR(100), age INTEGER)";
        db.execSQL(create_name_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion != oldVersion){
            String dropNameTable = "drop table if exists name";
            db.execSQL(dropNameTable);
            onCreate(db);
        }
    }
}
