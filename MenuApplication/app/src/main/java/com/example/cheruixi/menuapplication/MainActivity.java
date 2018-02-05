package com.example.cheruixi.menuapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contextMenu(View view) {
        Intent intent = new Intent(MainActivity.this, ContextMenuDemo.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(MainActivity.this);

        inflater.inflate(R.menu.first, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Jesse:
                Log.i("jesse", "You clicked me");
                break;
            default:
                Log.i("jesse", "plese donot click me");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
