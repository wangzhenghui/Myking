package com.example.administrator.myking;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Ex22Activity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex22_layout);

        TabHost host = getTabHost();

        TabHost.TabSpec tab1 = host.newTabSpec("tab1").setIndicator("我的主页").setContent(R.id.tab1);
        host.addTab(tab1);

        TabHost.TabSpec tab2 = host.newTabSpec("tab2").setIndicator("我的图片").setContent(R.id.tab2);
        host.addTab(tab2);

        TabHost.TabSpec tab3 = host.newTabSpec("tab3").setIndicator("个人设置").setContent(R.id.tab3);
        host.addTab(tab3);
    }
}
