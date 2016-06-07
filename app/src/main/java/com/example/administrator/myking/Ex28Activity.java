package com.example.administrator.myking;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Administrator on 2016/6/3.
 */
public class Ex28Activity extends BaseActivity {
    StudentHelper helper;
    ListView lv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex28_layout);
        helper = new StudentHelper(this,"student.db",null,Contants.DB_VERSION);
        lv = (ListView) findViewById(R.id.stulist);

        Cursor c = helper.getReadableDatabase().query("student",null,null,null,null,null,null);
        SimpleCursorAdapter aca = new SimpleCursorAdapter(this,R.layout.ex28_layout2 ,c,new String[]{"name","pic","age"},new int[]{R.id.studName,R.id.studPic,R.id.studAge},0);

        lv.setAdapter(aca);
    }
}
