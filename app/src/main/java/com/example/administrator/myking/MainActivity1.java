package com.example.administrator.myking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void mybutton(View view)
    {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //SimpleFormatter sdf = new SimpleFormatter("yyyy-MM-dd hh:mm:ss");
        String str = sdf.format(d);
        TextView tv = (TextView) findViewById(R.id.tu);
        tv.setText(str);
    }
}
