package com.example.cheruixi.popupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private PopupWindow mWindow;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = getLayoutInflater().inflate(R.layout.popupwindow, null);
        mWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mWindow.setOutsideTouchable(true);

        mView.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mWindow.isShowing()){
                    mWindow.dismiss();
                }
            }
        });

        mView.findViewById(R.id.img_like).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you like me", Toast.LENGTH_LONG).show();
            }
        });

        mView.findViewById(R.id.img_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you share me", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void showPopupWindow(View view){
        if(!mWindow.isShowing()){
            mWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);
        }

    }


}
