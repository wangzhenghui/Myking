package com.example.administrator.myking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Ex20Activity extends BaseActivity {
    List<Student> list = new ArrayList<Student>();

    List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex20_layout);

        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();

        s1.setName("张三");
        s2.setName("张三2");
        s3.setName("张三3");
        s4.setName("张三4");
        s5.setName("张三5");
        s1.setAge(20);
        s2.setAge(40);
        s3.setAge(60);
        s4.setAge(80);
        s5.setAge(100);
        s1.setPic(R.drawable.icon_11);
        s2.setPic(R.drawable.icon_28);
        s3.setPic(R.drawable.icon_30);
        s4.setPic(R.drawable.icon_33);
        s5.setPic(R.drawable.icon_37);
        Collections.addAll(list,s1,s2,s3,s4,s5);


        for(Student ss:list)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("studName",ss.getName());
            map.put("studAge",ss.getAge()+"");
            map.put("studPic",ss.getPic());

            res.add(map);
        }

        ListView view = (ListView) findViewById(R.id.list);
//        SimpleAdapter sa = new SimpleAdapter(this,res,R.layout.ex09_row_layout,new String[]{"studName","studAge","studPic"},new int[]{R.id.studName,R.id.studAge,R.id.studPic});
//        view.setAdapter(sa);
        MyAdpater ad = new MyAdpater();
        view.setAdapter(ad);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Ex20Activity.this,Ex20Activity2.class);
                Bundle b = new Bundle();
                b.putSerializable("student", (Serializable) res.get(position));
                intent.putExtra("data", b );

                startActivity(intent);
            }
        });
    }

    class MyAdpater extends BaseAdapter
    {
        @Override
        public int getCount() {
            return res.size();
        }

        @Override
        public Object getItem(int position) {
            return res.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = LayoutInflater.from(Ex20Activity.this);
            View view = li.inflate(R.layout.ex20row_layout,null);

            ImageView iv = (ImageView) view.findViewById(R.id.studPic);
            TextView nameTv = (TextView) view.findViewById(R.id.studName);
            TextView ageTv = (TextView) view.findViewById(R.id.studAge);

            Map<String,Object> obj = res.get(position);
            iv.setImageResource((int) obj.get("studPic"));
            nameTv.setText((String) obj.get("studName"));
            ageTv.setText((String)obj.get("studAge"));

            return view;
        }
    }
}