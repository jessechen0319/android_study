package com.example.cheruixi.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class AnimationSetDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_set_demo);
    }

    public void startAnimation(View view) {
        ImageView imageView = findViewById(R.id.homer);
        AnimationSet set = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1,2,1,2,Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        set.addAnimation(scaleAnimation);
        RotateAnimation animation = new RotateAnimation(0, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setRepeatCount(3);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(3);
        animation.setRepeatMode(Animation.REVERSE);
        set.addAnimation(animation);
        set.setDuration(1000);

        imageView.startAnimation(set);
    }
}
