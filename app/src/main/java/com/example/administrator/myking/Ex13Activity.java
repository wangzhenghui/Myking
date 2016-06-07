package com.example.administrator.myking;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Ex13Activity extends BaseActivity {
    public int[] a = {R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};

    public int i = 0;
    int alpha = 255;
    ImageView imgView;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex13_layout);
        imgView = (ImageView) findViewById(R.id.imagess);
        imgView.setImageResource(a[0]);
    }

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex13_layout);
        imgView = (ImageView) findViewById(R.id.imagess);
        imgView.setImageResource(a[0]);
    }*/
    public void btn1(View view)
    {
        imgView.setImageResource(a[Math.abs(--i)%5]);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void btn2(View view)
    {
        alpha+=15;
        if(alpha > 255){
            imgView.setImageAlpha(255);
            alpha = 255;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void btn3(View view)
    {
        alpha-=15;
        if(alpha < 0){
            imgView.setImageAlpha(0);
            alpha=0;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }
    public void btn4(View view)
    {
        imgView.setImageResource(a[Math.abs(++i)%5]);
    }
}
