package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by Administrator on 2016/5/19.
 */
public class Ex07Activity extends BaseActivity {
    String[] s = {"aaa","aab","aac","abb","bbc","bbd","bca","caa","cdd","ccc"};
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex06_layout);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.auto1);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        textView.setAdapter(ad);
    }*/

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex07_layout);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.auto1);
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        textView.setAdapter(ad);
    }
}
