package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.WorkSource;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/5/27.
 */
public class Ex14Activity extends BaseActivity {


    Handler h = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
                btn.setText("获取验证码");
                btn.setEnabled(true);
                t.cancel();
            }else {
                btn.setText("获取中..."+msg.what+"秒");
            }
        }
    };
    Timer t;
    Button btn;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex14_layout);
        btn = (Button) findViewById(R.id.button14);
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex14_layout);
        btn = (Button) findViewById(R.id.button14);

    }*/
    public void butt14(View view)
    {
        btn.setEnabled(false);
        btn.setText("获取中......");
        t = new Timer();
        t.schedule(new TimerTask() {
            int time = 60;
            @Override
            public void run() {
                Message m = new Message();
                m.what = time--;
                h.sendMessage(m);
            }
        },100,1000);
    }
}
