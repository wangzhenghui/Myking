package com.example.administrator.myking;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/5/12.
 */
public class GameMainActivity extends BaseActivity {
    private MyLove love;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        this.love = new MyLove(this);

        setContentView(love);

    }

    /*@Override

 public void onCreate(Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);

      this.love = new MyLove(this);

        setContentView(love);

        }*/

}


