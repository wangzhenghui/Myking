package com.example.administrator.myking;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
public class MyView extends View implements View.OnTouchListener{
        List<MyPoint> list=new ArrayList<MyPoint>();
        public float cx=300;
        public float cy=300;

    public MyView(Context context) {
        super(context);
    }


public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        }
@Override
protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        p.setAntiAlias(true);
                p.setStrokeWidth(8);
             for(MyPoint point:list) {
             p.setColor(point.getColor());
                    for (float x = -2; x <= 2; x += 0.01) {

                     float y = -(float) Math.sqrt(2 * Math.sqrt(x * x) - x * x);
                        float b = -(float) ((-2.14) * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x))));
                        canvas.drawPoint(x * 50 + point.getX(), y * 50 + point.getY(), p);
                        canvas.drawPoint(x * 50 + point.getX(), b * 50 + point.getY(), p);
            }
      }
}
@Override
public boolean onTouch(View v, MotionEvent event) {
        cx = event.getX();
        cy = event.getY();
        MyPoint p1=new MyPoint();
               p1.setX(cx);
               p1.setY(cy);
        int color=0xFF000000+(int)( Math.random()*0xFFFFFF);
              p1.setColor(color);
        list.add(p1);
        invalidate();
        return true;
        }
}