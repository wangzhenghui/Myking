package com.example.administrator.myking;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Ex23Activity extends BaseActivity {
    int data = 0;
    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0x99){
                pb2.setVisibility(View.GONE);
            }else {
                pb.setProgress(data);
            }
        }
    };

    ProgressBar pb;

    ProgressBar pb2;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex23_layout);

        pb = (ProgressBar) findViewById(R.id.pb);
        pb2 = (ProgressBar) findViewById(R.id.mone1);

        (new Thread(){
            @Override
            public void run() {
                while(data<100){
                    h.sendMessage(new Message());
                    data += 5;
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message m = new Message();
                m.what = 0x99;
                h.sendMessage(m);
            }
        }).start();
    }
}
