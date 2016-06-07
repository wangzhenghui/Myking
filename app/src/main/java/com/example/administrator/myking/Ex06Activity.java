package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Ex06Activity extends BaseActivity {
    int[] image = new int[]{R.drawable.icon_11,R.drawable.bullet_04,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33};
    int crnimg =0;


    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex06_layout);
        LinearLayout main = (LinearLayout) findViewById(R.id.root);
        final ImageView img = new ImageView(this);
        main.addView(img);
        img.setImageResource(image[0]);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(image[++crnimg % image.length]);
            }
        });
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       */
}
