package com.example.administrator.myking;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class Ex37Activity extends BaseActivity {
    MediaRecorder recorder;
    MediaPlayer mediaPlayer;
    File file;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex37_layout);

    }
    public void record(View view)
    {
        file = new File("/mnt/sdcard/sound.amr");
        try{
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.prepare();
            recorder.start();
        }catch(Exception e){
            Log.e("error",e.getMessage());
        }
    }

    public void stop(View view)
    {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
    }
    public void play(View view)
    {
        mediaPlayer = new MediaPlayer();
        file = new File("/mnt/sdcard/sound.amr");
        try {
            mediaPlayer.setDataSource(file.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        super.onDestroy();
    }
}
