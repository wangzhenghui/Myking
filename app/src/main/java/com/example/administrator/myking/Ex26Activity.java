package com.example.administrator.myking;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Ex26Activity extends BaseActivity {
    Handler h = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            ps += 10;
            p.setProgress(ps);
            if (ps >= 100)
            {
                p.dismiss();
            }
        }
    };
    int ps = 0;
    ProgressDialog p;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex26_layout);
    }
    public void but1(View view)
    {
        (new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    h.sendMessage(new Message());
                    try
                    {
                        sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        p = new ProgressDialog(this);
        p.setTitle("下载中");
        p.setIcon(R.drawable.icon_28);
        p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p.setIndeterminate(false);
        p.show();

    }
}
