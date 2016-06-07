package com.example.administrator.myking;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Ex30Activity3 extends BaseActivity {
    GestureOverlayView gestureOverlayView;
    GestureLibrary gestLib;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex30_layout3);
        gestLib = GestureLibraries.fromPrivateFile(this,"mygestures");
        if(!gestLib.load())
        {
            Toast.makeText(Ex30Activity3.this, "手势库加载失败！", Toast.LENGTH_SHORT).show();
        }

        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestureView);
        gestureOverlayView.setGestureColor(Color.GREEN);
        gestureOverlayView.setGestureStrokeWidth(5);

        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                List<Prediction> list = gestLib.recognize(gesture);
                for(Prediction p:list)
                {
                    if(p.score>2.0)
                    {
                        Toast.makeText(Ex30Activity3.this, "找到匹配手势！"+p.name+"<<<"+p.score, Toast.LENGTH_LONG).show();
                        break;
                    }else {
                        Toast.makeText(Ex30Activity3.this,"未找到匹配手势",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
