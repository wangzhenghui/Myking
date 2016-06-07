package com.example.administrator.myking;

/**
 * Created by Administrator on 2016/5/12.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyLove extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    private SurfaceHolder sfh = null;
    private Paint paint = null;
    private Canvas canvas = null;
    private int SH = 0, SW = 0;
    private int miCount = 0;
    private boolean loop = false;
    public MyLove(Context context) {
        super(context);
        this.setKeepScreenOn(true);
        this.setFocusable(true);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(32);
        paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
        loop = true;
    }

    public void surfaceCreated(SurfaceHolder holder) {
        SW = getWidth();
        SH = getHeight();
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        loop = false;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }

            synchronized (sfh) {
                draw();
            }
        }
    }

    private void draw() {
        canvas = sfh.lockCanvas();
        try {
            if (canvas == null)
                return;
            paint.setColor(Color.BLACK);
            canvas.drawRect(0, 0, SW, SH, paint);
            if (miCount < 100) {
                miCount++;
            } else {
                miCount = 0;
            }
            switch (miCount % 6) {
                case 0:
                    paint.setColor(Color.BLUE);
                    break;
                case 1:
                    paint.setColor(Color.GREEN);
                    break;
                case 2:
                    paint.setColor(Color.RED);
                    break;
                case 3:
                    paint.setColor(Color.YELLOW);
                    break;
                case 4:
                    paint.setColor(Color.argb(255, 255, 181, 216));
                    break;
                case 5:
                    paint.setColor(Color.argb(255, 0, 255, 255));
                    break;
                default:
                    paint.setColor(Color.WHITE);
                    break;
            }

            int i, j;
            double x, y, r;
            for (i = 0; i <= 90; i++) {
                for (j = 0; j <= 90; j++) {
                    r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 20;
                    x = r * Math.cos(Math.PI / 45 * j)* Math.sin(Math.PI / 45 * i) + 320 / 2;
                    y = -r * Math.sin(Math.PI / 45 * j) + 400 / 4;
                    canvas.drawPoint((float) x, (float) y, paint);
                }
            }
            canvas.drawText("Loving You", 75, 400, paint);
            RectF rect = new RectF(60, 403, 260, 408);
            canvas.drawRoundRect(rect, (float) 1.0, (float) 1.0, paint);

            sfh.unlockCanvasAndPost(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
