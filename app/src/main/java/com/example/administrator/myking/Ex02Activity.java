package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2016/5/23.
 */
public class Ex02Activity extends BaseActivity{
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex02layout);
        final ImageView image = (ImageView) findViewById(R.id.img);
        SeekBar skb = (SeekBar) findViewById(R.id.seekbar);
        RatingBar rtb = (RatingBar) findViewById(R.id.rating);
        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                image.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rtb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                image.setAlpha((int)(rating*255/5));
            }
        });
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex02layout);
        final ImageView image = (ImageView) findViewById(R.id.img);
        SeekBar skb = (SeekBar) findViewById(R.id.seekbar);
        RatingBar rtb = (RatingBar) findViewById(R.id.rating);
        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                image.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        rtb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                image.setAlpha((int)(rating*255/5));
            }
        });
    }*/
}