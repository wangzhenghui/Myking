package com.example.administrator.myking;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/6/3.
 */
public class StudentHelper extends SQLiteOpenHelper {
    public static final String CREATE_STUDENT_TABLE = "create table student(_id integer primary key,name varchar(50),pic integer,age integer)";

    public StudentHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
        ContentValues c = new ContentValues();
        c.put("_id",1);
        c.put("name","king");
        c.put("pic",R.drawable.icon_30);
        c.put("age",100);
        db.insert("student",null,c);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");

        onCreate(db);
    }
}
