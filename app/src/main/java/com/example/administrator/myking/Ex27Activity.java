package com.example.administrator.myking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Ex27Activity extends BaseActivity {
    Intent i;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex27_layout);
        /*Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);*/
    }
    public void mybutton1(View view)
    {
        i = new Intent();
        i.setAction(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
    public void mybutton2(View view)
    {
        i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.baidu.com"));
        //Uri uri = Uri.parse(data);
        //i.setData(uri);
        startActivity(i);
    }
}
