package com.example.administrator.myking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Ex25Activity extends BaseActivity {
    EditText birth;
    Intent i;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex25_layout);
        birth = (EditText) findViewById(R.id.birth);
        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Ex25Activity.this,Ex25Activity2.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0)
        {
            String sr = data.getStringExtra("shengri");
            birth.setText(sr);
        }
    }
}
