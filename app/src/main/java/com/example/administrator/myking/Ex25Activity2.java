package com.example.administrator.myking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Ex25Activity2 extends BaseActivity {
   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex25_layout2);
        LayoutInflater li = LayoutInflater.from(this);
        LinearLayout layout = (LinearLayout) li.inflate(R.layout.ex25_layout2, null);
        final DatePicker dp = (DatePicker) layout.findViewById(R.id.birth);

    }*/
   CalendarView cv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex25_layout2);
        cv = (CalendarView) findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //Toast.makeText(Ex25Activity.this, "你的生日是"+year+"年"+(month+1)+"月"+dayOfMonth+"日", Toast.LENGTH_SHORT).show();
                Intent i = getIntent();
                i.putExtra("shengri","你的生日是"+year+"年"+(month+1)+"月"+dayOfMonth+"日");
                setResult(123,i);
                finish();
            }
        });
    }
}
