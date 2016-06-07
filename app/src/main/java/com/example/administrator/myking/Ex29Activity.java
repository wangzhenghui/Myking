package com.example.administrator.myking;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

import static com.example.administrator.myking.R.drawable.icon_30;

/**
 * Created by Administrator on 2016/6/3.
 */
public class Ex29Activity extends Activity {
   /* ImageView iv;
    int[] data = {R.drawable.icon_41,R.drawable.icon_40,R.drawable.icon_37,R.drawable.icon_28,R.drawable.icon_33};
    int anInt = 0;*/
    private GestureDetector detector;// 手势检测
    private ImageView imageView;// ImageView
    private float scale = 1;// 缩放比
    private Matrix matrix;
    private Bitmap bitmap;
    private int width,height;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex29_layout);
        // 初始化矩阵
        matrix = new Matrix();
        // 加载ImageView控件
        imageView = (ImageView) findViewById(R.id.imgageview);
        // 手势监听
        detector = new GestureDetector(this, new GestureListener());
        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.icon_30);
        width=bitmap.getWidth();
        height=bitmap.getHeight();
    }

   /* @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex29_layout);
        // 初始化矩阵
        matrix = new Matrix();
        // 加载ImageView控件
        imageView = (ImageView) findViewById(R.id.img);
        // 手势监听
        detector = new GestureDetector(this, new GestureListener());
        bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.icon_30);
        width=bitmap.getWidth();
        height=bitmap.getHeight();
    }
*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            Bitmap bitmap1 = ((BitmapDrawable) imageView.getBackground()).getBitmap();
            scale=(float)bitmap1.getWidth()/width;//计算当前图片的尺寸相对于原来图片的缩放比
            return super.onDown(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            //计算缩放比
            scale+=distanceX/320;
            if(scale<0.1)//如果缩放比小于0.1 就不继续缩放了
                return false;
            matrix.reset();
            matrix.setScale(scale, scale, 160, 200);
            // 获得ImageView当前显示的图片
            Bitmap bitmap1 = ((BitmapDrawable) imageView.getBackground()).getBitmap();
            Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width,
                    height, matrix, true);
            // 如果图片还没有回收，强制回收
            if (!bitmap1.isRecycled()) {
                bitmap1.recycle();
            }
            imageView.setBackgroundDrawable(new BitmapDrawable(bitmap2));
            return true;
        }
    }
}
