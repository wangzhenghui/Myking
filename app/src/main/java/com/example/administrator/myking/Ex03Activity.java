package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/24.
 */
public class Ex03Activity extends Activity {
    String[] str = new String[]{"宝马750汽车","奔驰800汽车","路虎揽胜","捷豹汽车","兰博基尼","法拉利超跑"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex03_layout);
        //setContentView(R.layout.ex03_chalayout);
        ListView list = (ListView) findViewById(R.id.lis);
        ArrayAdapter<String> aad = new ArrayAdapter<String>(
                this,R.layout.support_simple_spinner_dropdown_item,str
        );
        //list.setTextFilterEnabled(true);
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.auto);
        actv.setAdapter(aad);

        //list.setAdapter(aad);
    }
}
