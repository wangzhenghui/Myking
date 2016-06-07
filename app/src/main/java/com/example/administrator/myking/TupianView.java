package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by Administrator on 2016/5/15.
 */
public class TupianView extends Activity {
    int img[] = new int[]{
            R.drawable.bullet_04,
            R.drawable.airplane,
            R.drawable.plane,
            R.drawable.qq,
            R.drawable.xin,
    };
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuoianview);
        LinearLayout main = (LinearLayout) findViewById(R.id.tu);
        final ImageView imageView = new ImageView(this);
        main.addView(imageView);
        imageView.setImageResource(img[0]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i >= 4){
                    i = -1;
                }
                imageView.setImageResource(img[++i]);
            }
        });
    }
}
