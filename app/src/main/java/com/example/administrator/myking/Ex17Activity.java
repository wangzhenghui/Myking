package com.example.administrator.myking;

import android.app.ActionBar;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Ex17Activity extends BaseActivity {
    int[] imageids = new int[]
            {
                    R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37
            };
    ImageSwitcher is;
    int i = 0;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex17_layout);

        is = (ImageSwitcher) findViewById(R.id.imgswtc);
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView view = new ImageView(Ex17Activity.this);

                view.setImageResource(imageids[i++]);
                view.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return view;
            }
        });
    }

    public void next(View view)
    {
        is.setImageResource(imageids[(i++) % 5]);

        Toast t = new Toast(Ex17Activity.this);
        LinearLayout layout = new LinearLayout(Ex17Activity.this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        ImageView image = new ImageView(Ex17Activity.this);
        image.setImageResource(R.drawable.airplane);
        TextView tv = new TextView(Ex17Activity.this);
        tv.setTextSize(50);
        //tv.setText("飞机");

        layout.addView(image);
        layout.addView(tv);

        t.setView(layout);
        t.show();
    }
}
