package com.example.administrator.myking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Ex24Activity extends BaseActivity {
    EditText et;
    Intent i;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex24_layout);
        et = (EditText) findViewById(R.id.city);
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(Ex24Activity.this,Ex24Activity2.class);
                startActivityForResult(i,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 123)
        {
            String city = data.getStringExtra("city");
            et.setText(city);
        }
    }
}
