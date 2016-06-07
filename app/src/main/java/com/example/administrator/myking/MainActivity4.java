package com.example.administrator.myking;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.baidu.android.common.logging.Log;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2016/6/6.
 */
public class MainActivity4 extends Activity {
    //继承SQLiteOpenHelper类
    private MySQLiteOpenHelper sqlHelper;
    private ListView listview;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex32_layout);
        sqlHelper = new MySQLiteOpenHelper(this, "StuDatabase.db", null,2);
        //建立新表
        Button createBn = (Button) findViewById(R.id.button1);
        createBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHelper.getWritableDatabase();
            }
        });
        //插入数据
        Button insertBn = (Button) findViewById(R.id.button2);
        edit1 = (EditText) findViewById(R.id.edit_id);
        edit2 = (EditText) findViewById(R.id.edit_name);
        edit3 = (EditText) findViewById(R.id.edit_tel);
        edit4 = (EditText) findViewById(R.id.edit_height);
        insertBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                /*
                //插入第一组数据
                values.put("id", "10001");
                values.put("name", "Eastmount");
                values.put("tel", "15201610000");
                values.put("height", "172.5");
                db.insert("Student", null, values);
                */
                values.put("id", edit1.getText().toString());
                values.put("name", edit2.getText().toString());
                values.put("tel", edit3.getText().toString());
                values.put("height", edit4.getText().toString());
                db.insert("Student", null, values);
                Toast.makeText(MainActivity4.this, "数据插入成功", Toast.LENGTH_SHORT).show();
                edit1.setText("");
                edit2.setText("");
                edit3.setText("");
                edit4.setText("");
            }
        });
        //删除数据
        Button deleteBn = (Button) findViewById(R.id.button3);
        deleteBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                db.delete("Student", "height = ?", new String[]{"1.22"});
                Toast.makeText(MainActivity4.this, "删除数据", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });
        //更新数据
        Button updateBn = (Button) findViewById(R.id.button4);
        updateBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("height", "180");
                db.update("Student", values, "name = ?", new String[]{"zhangsan"});
                Toast.makeText(MainActivity4.this, "更新数据", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });
        //查询数据
        listview = (ListView) findViewById(R.id.listview1);
        Button selectBn = (Button) findViewById(R.id.button5);
        selectBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SQLiteDatabase db = sqlHelper.getWritableDatabase();
                    //游标查询每条数据
                    Cursor cursor = db.query("Student", null, null, null, null, null, null);
                    //定义list存储数据
                    List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
                    //适配器SimpleAdapter数据绑定
                    //错误:构造函数SimpleAdapter未定义 需把this修改为MainActivity.this
                    SimpleAdapter adapter = new SimpleAdapter(MainActivity4.this, list, R.layout.stu_item,
                            new String[]{"id", "name", "tel", "height"},
                            new int[]{R.id.stu_id, R.id.stu_name, R.id.stu_tel, R.id.stu_height});
                    //读取数据 游标移动到下一行
                    while (cursor.moveToNext()) {
                        HashMap<String, Object> map = new HashMap<String, Object>();
                        map.put("id", cursor.getString(cursor.getColumnIndex("id")));
                        map.put("name", cursor.getString(cursor.getColumnIndex("name")));
                        map.put("tel", cursor.getString(cursor.getColumnIndex("tel")));
                        map.put("height", cursor.getString(cursor.getColumnIndex("height")));
                        list.add(map);
                    }
                    listview.setAdapter(adapter);
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            ListView listView = (ListView) parent;
                            HashMap<String, Object> data = (HashMap<String, Object>) listView.getItemAtPosition(position);
                            String personid = data.get("id").toString();

                        }
                    });
                }
                catch (Exception e) {
                    Log.i("exception", e.toString());
                }
            }
        });
    }
}//</string,></string,></map<string,></map<string,>
