package com.example.administrator.myking;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/6/2.
 */
public class pinBall extends Activity {
    private int tablewidth;
    private int tableheight;
    private int rackety;
    private final int RACKET_HEIGHT = 20;
    private final int RACKET_WIDTH = 120;
    private final int BALL_SIZE = 18;
    private int ySpeed = 15;
    Random rand = new Random();
    private double xyRate = rand.nextDouble() - 0.5;
    private int xSpeed = (int) (ySpeed * xyRate * 2);
    private int ballx = rand.nextInt(200) + 20;
    private int bally = rand.nextInt(10) + 20;
    private int racketx = rand.nextInt(200);
    private boolean isLose = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final GameView gameView = new GameView(this);
        setContentView(gameView);
        WindowManager windowmanager = getWindowManager();
        Display display = windowmanager.getDefaultDisplay();
        tablewidth = display.getWidth();
        tableheight = display.getHeight();
        rackety = tableheight - 80;
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what ==  0x123)
                {
                    gameView.invalidate();
                }
            }
        };
        gameView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float xx;
                switch (event.getAction() & MotionEvent.ACTION_MASK)
                {
                    case MotionEvent.ACTION_MOVE:
                       if (racketx > 0) {
                           racketx += 10;
                           break;
                       }
                    //case KeyEvent.KEYCODE_DPAD_RIGHT:
                       if (racketx < tablewidth - RACKET_WIDTH) {
                           racketx -= 10;
                           break;
                       }

                }
                gameView.invalidate();
                return true;
            }
        });
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (ballx <= 0 || ballx >= tablewidth - BALL_SIZE)
                {
                    xSpeed = -xSpeed;
                }
                if (bally >= rackety - BALL_SIZE && (ballx < racketx || ballx > racketx + RACKET_WIDTH))
                {
                    timer.cancel();
                    isLose = true;
                }
                else if (bally <= 0 || (bally >= rackety - BALL_SIZE && ballx > racketx && ballx <= racketx +RACKET_WIDTH))
                {
                    ySpeed = -ySpeed;
                }
                bally += ySpeed;
                ballx += xSpeed;
                handler.sendEmptyMessage(0x123);
            }
        },0,100);
    }
    class GameView extends View
    {
        public GameView(Context context) {
            super(context);
            setFocusable(true);
        }
        public void onDraw(Canvas canvas)
        {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            if (isLose)
            {
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("游戏结束",50,200,paint);
            }
            else
            {
                paint.setColor(Color.rgb(200,200,100));
                canvas.drawCircle(ballx,bally,BALL_SIZE,paint);
                paint.setColor(Color.rgb(80,80,200));
                canvas.drawRect(racketx,rackety,racketx + RACKET_WIDTH,rackety + RACKET_HEIGHT,paint);
            }
        }
    }
}
