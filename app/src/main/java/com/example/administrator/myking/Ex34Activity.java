package com.example.administrator.myking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Ex34Activity extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex34_layout);
    }

    public void startPlay(View view)
    {
        Intent i = new Intent(this,Ex34Service.class);
        startService(i);
    }

    public void stopPlay(View view)
    {
        Intent i = new Intent(this,Ex34Service.class);
        stopService(i);
    }
}
