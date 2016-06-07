package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.os.Handler;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/5/18.
 */
public class Ex08xiaohua extends Activity{
    ArrayList<Ex08xiaohua> list = new ArrayList<Ex08xiaohua>();

    List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();

    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String str = (String) b.get("str");
            Gson gson = new Gson();
//            Xiaohua05 xh = gson.fromJson(str,Xiaohua05.class);
//            if ("".equals(xh.getShowapi_res_error()))
//            {
//
//            }
        }
    };

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex05_layout);
        ListView view = (ListView) findViewById(R.id.jirulist);
        textView = (TextView) findViewById(R.id.ct);

      /* SimpleAdapter sa = new SimpleAdapter(this,res,R.layout.ex05_activity,new String[]{"ct","img","title","type"},new int[]{R.id.ct,R.id.img,R.id.title,R.id.type});
       view.setAdapter(sa);*/
        (new Thread(){
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_pic";
                BufferedReader reader = null;
                //String result = null;
                StringBuffer sbf = new StringBuffer();
                //httpUrl = httpUrl + "?phone="+phone.getText().toString();

                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "592a75b030c0bbf916f71162d825880e");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    //result = sbf.toString();

                    Message m = new Message();
                    Bundle b = new Bundle();
                    //b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
