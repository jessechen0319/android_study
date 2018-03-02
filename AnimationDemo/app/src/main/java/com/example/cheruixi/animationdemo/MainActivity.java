package com.example.cheruixi.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTween(View view) {
        startActivity(new Intent(MainActivity.this, TweenAnimationDemo.class));
    }

    public void goToTranslation(View view) {
        startActivity(new Intent(MainActivity.this, TranslationAnimationDemo.class));
    }

    public void toAnimationSet(View view) {
        startActivity(new Intent(MainActivity.this, AnimationSetDemo.class));
    }
}
