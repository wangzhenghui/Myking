package com.example.administrator.myking;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/27.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
           initContentView(savedInstanceState);
      //  setContentView(R.layout.tools_bar);
        Toolbar t = (Toolbar) findViewById(R.id.toolbar);

         t.setTitle("课堂练习");
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        t.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.normal_btn:
                    AlertDialog.Builder ad = new AlertDialog.Builder(BaseActivity.this);
                        ad.setTitle("『作者』");
                        ad.setMessage("《王正辉》");
                        ad.create().show();
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.baesmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(BaseActivity.this,BaesActvity2.class);
                startActivity(intent);
                /*Toast.makeText(this, "点击了Home图标", Toast.LENGTH_SHORT).show();*/
                break;
        }
        return true;
    }

   protected abstract void initContentView(Bundle savedInstanceState);
}
