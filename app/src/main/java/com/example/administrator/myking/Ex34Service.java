package com.example.administrator.myking;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Ex34Service extends Service {
    MediaPlayer player;

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this,R.raw.wish);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
