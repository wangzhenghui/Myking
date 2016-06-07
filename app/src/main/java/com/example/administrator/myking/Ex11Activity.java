package com.example.administrator.myking;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/5/26.
 */
public class Ex11Activity extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex11_layout);
        t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                currentcolor++;
                Message m = new Message();
                m.what = currentcolor;
                handler.sendMessage(m);
            }
        },100,100);

    }

    int currentcolor = 0;
    Timer t;
    final int[] colors = new int[]
            {
                    Color.RED,
                    Color.BLACK,
                    Color.YELLOW,
                    Color.DKGRAY,
                    Color.GREEN,
                    Color.MAGENTA
            };
   final int[] aa = new int[]
            {
                    R.id.corlo1,
                    R.id.corlo2,
                    R.id.corlo3,
                    R.id.corlo4,
                    R.id.corlo5,
                    R.id.corlo6
            };

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                for (int i = 0; i < 6; i++) {
                   TextView textView = (TextView) findViewById(aa[i]);
                    textView.setBackgroundColor(colors[(msg.what+i)% 6]);
                }
        };
    };
  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex11_layout);
      t = new Timer();
        t.schedule(new TimerTask() {
           @Override
           public void run() {
               currentcolor++;
               Message m = new Message();
               m.what = currentcolor;
               handler.sendMessage(m);
           }
       },100,100);

    }*/
}
