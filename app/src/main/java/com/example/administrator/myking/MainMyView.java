package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/5/12.
 */
public class MainMyView extends Activity {
    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MyView my = new MyView(this);
        my.setOnTouchListener(my);

        setContentView(my);

    }
}
