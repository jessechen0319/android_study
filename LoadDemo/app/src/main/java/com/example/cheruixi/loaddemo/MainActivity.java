package com.example.cheruixi.loaddemo;

import android.Manifest;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.cheruixi.loaddemo.helper.PermissionCheckHelper;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    ListView myListView;
    CursorAdapter adapter;
    private static ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.myListView);
        if(PermissionCheckHelper.checkPermission(MainActivity.this)){
            adapter = new SimpleCursorAdapter(MainActivity.this, R.layout.contacts, null, new String[]{
                    "_id", "display_name"
            }, new int[]{R.id.contact_id, R.id.contact_name});
            myListView.setAdapter(adapter);

            //load manager
            LoaderManager manager = getLoaderManager();
            manager.initLoader(1, null, this);

            //get resolver
            resolver = getContentResolver();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 100:
            {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }


    //create loader

    static class MyLoader extends AsyncTaskLoader<Cursor>{

        private Activity myContext;
        public MyLoader(Activity context){
            super(context);
            myContext = myContext;
        }
        //开始加载的时候调用的命令
        @Override
        protected void onStartLoading() {
            super.onStartLoading();
            forceLoad();
        }
        //后台加载数据的方法
        @Override
        public Cursor loadInBackground() {

                return resolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{
                        "_id", "display_name"
                }, null, null, null);
        }
    }
}
