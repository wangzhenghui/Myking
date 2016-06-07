package com.example.administrator.myking;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Ex16Activity extends BaseActivity {
    int[] i={R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    AdapterViewFlipper adapterViewFlipper;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex16_layout);
        adapterViewFlipper= (AdapterViewFlipper) findViewById(R.id.myadp);
        BaseAdapter b=new BaseAdapter() {
            @Override
            public int getCount() {
                return i.length;
            }

            @Override
            public Object getItem(int position) {
                return i[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(Ex16Activity.this);
                iv.setImageResource(i[position]);
                return iv;
            }
        };
        adapterViewFlipper.setAdapter(b);
        adapterViewFlipper.setFlipInterval(3000);
        adapterViewFlipper.startFlipping();
    }

    public void last(View s){

        adapterViewFlipper.showPrevious();
        adapterViewFlipper.stopFlipping();
    }
    public void next(View s){

        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }
    public void auto(View s){

        adapterViewFlipper.startFlipping();
    }

}
