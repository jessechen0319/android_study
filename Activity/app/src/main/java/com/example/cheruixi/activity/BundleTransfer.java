package com.example.cheruixi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BundleTransfer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle_transfer);
        Bundle bundle = getIntent().getBundleExtra("myBundle");
        TextView nameTextView = findViewById(R.id.name);
        nameTextView.setText(bundle.getString("name"));
        TextView ageTextView = findViewById(R.id.ageValue);
        ageTextView.setText(String.valueOf(bundle.getInt("age")));
        TextView christianTextView = findViewById(R.id.isChristian);
        christianTextView.setText(bundle.getBoolean("christian")?"是":"否");
    }
}
