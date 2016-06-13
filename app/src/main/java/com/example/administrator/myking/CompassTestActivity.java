package com.example.administrator.myking;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class CompassTestActivity extends Activity implements SensorEventListener {
    // 定义显示指南针图片的组件
    ImageView image;
    // 记录指南针图片转过的角度
    float currentDegree = 0f;
    // 定义真机的Sensor管理器
    SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("MainActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex41_layout);
        image = (ImageView) findViewById(R.id.main_iv);
// 获取真机的传感器管理服务
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        System.out.println("MainActivity.onResume");
        super.onResume();
// 为系统的方向传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        System.out.println("MainActivity.onStop");
        mSensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        System.out.println("MainActivity.onPause");
        // 取消注册
        mSensorManager.unregisterListener(this);
        super.onPause();

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        System.out.println("MainActivity.onSensorChanged()");
// 如果真机上触发event的传感器类型为水平传感器类型
        int sensorType = event.sensor.getType();
        switch (sensorType)
        {
            case Sensor.TYPE_ORIENTATION:
                // 获取绕Z轴转过的角度
                float degree = event.values[0];
// 创建旋转动画（反向转过degree度）
                RotateAnimation ra = new RotateAnimation(currentDegree, -degree,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
// 设置动画的持续时间
                ra.setDuration(200);
// 设置动画结束后的保留状态
                //ra.setFillAfter(true);
// 启动动画
                image.startAnimation(ra);
                currentDegree = -degree;
                break;
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        System.out.println("MainActivity.onAccuracyChanged()");
    }
}