package com.example.administrator.myking;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class Ex05Activity extends BaseActivity{
    List<String> list = new ArrayList<String>();
    EditText onyuyan;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex05_layout);
        onyuyan= (EditText) findViewById(R.id.onyuyan);
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex05_layout);
        onyuyan= (EditText) findViewById(R.id.onyuyan);


    }*/
    public void yuyan(View view)
    {
       final String[] arr = {"java","C","C++",".NET","javascrpt","Ruby"};
        AlertDialog.Builder b = new AlertDialog.Builder(this)
                .setTitle("选择你会的语言")
                .setIcon(R.drawable.icon_11)
                .setMultiChoiceItems(arr, new boolean[arr.length], new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked)
                            {
                                list.add(arr[which]);
                            }else {
                                list.remove(arr[which]);
                            }
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onyuyan.setText(list.toString());
                        list.clear();

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        b.create().show();
    }
}
