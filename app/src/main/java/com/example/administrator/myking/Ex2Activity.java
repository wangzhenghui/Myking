package com.example.administrator.myking;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Ex2Activity extends BaseActivity {
    private TextView txt = null;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex2_layout);
        txt = (TextView) findViewById(R.id.textview);
        DisplayMetrics dm=new DisplayMetrics();
        super.getWindowManager().getDefaultDisplay().getMetrics(dm);
        String strOpt="手机屏幕分辨率为："+dm.widthPixels+"*"+dm.heightPixels;
        txt.setText(strOpt);
    }
}
