package com.example.cheruixi.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class TweenAnimationDemo extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation_demo);
        imageView = findViewById(R.id.homer_simpson);
    }

    public void starAnimation(View view) {
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1f);
        animation.setDuration(1000);
        animation.setRepeatCount(1);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }
}
