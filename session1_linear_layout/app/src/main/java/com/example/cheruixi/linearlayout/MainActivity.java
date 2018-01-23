package com.example.cheruixi.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private int[] imageArray = {R.drawable.shaonv1,R.drawable.shaonv2,R.drawable.shaonv3,R.drawable.shaonv4};
    private ImageView iv;
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.iv1);
        iv.setImageResource(R.drawable.shaonv1);
    }

    public void  previousImg(View view){
        index--;
        if(index<0){
            index=0;
            Toast.makeText(this, "已经是第一张", Toast.LENGTH_SHORT).show();
        } else {
            iv.setImageResource(imageArray[index]);
        }
    }

    public void  nextImg(View view){
        index++;
        if(index>imageArray.length-1){
            index--;
            Toast.makeText(this, "已经是最后一张", Toast.LENGTH_SHORT).show();
        } else {
            iv.setImageResource(imageArray[index]);
        }
    }

    public void clickSubmit(View view){
        Toast.makeText(this, "jesse is here", Toast.LENGTH_SHORT).show();
    }
}
