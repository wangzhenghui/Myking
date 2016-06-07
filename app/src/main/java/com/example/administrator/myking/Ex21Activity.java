package com.example.administrator.myking;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Ex21Activity extends BaseActivity {
    ImageView iv;
    AnimationDrawable ad;
    MediaPlayer music;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex21_layout);
        iv = (ImageView) findViewById(R.id.quanhuang);

        ad = (AnimationDrawable) iv.getBackground();
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ad.start();
                if(music == null)
                {
                    music = MediaPlayer.create(Ex21Activity.this,R.raw.bomb);
                }
                music.start();
                return false;
            }
        });
        ad.stop();
    }
}
