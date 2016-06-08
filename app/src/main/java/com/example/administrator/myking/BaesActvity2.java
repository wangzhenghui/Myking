package com.example.administrator.myking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/5/27.
 */
public class BaesActvity2 extends BaseActivity {
    String[] str = {"Hello World","分辨率","循环图片","画心","布局1","布局2","布局3","QQ登录页面","霓虹灯闪烁","计算器","单选多选","获取验证码","QQ分组","选择你会的语言","自动播放图片","幻灯片","图片透明度",
    "GridView2列显示图片","下拉选择","ListView列显示","Fals动画","搜索框","选项卡","星评分RatingBar","进度条显示进度","ExpandListView城市选择","选择生日","下载文件","回主页面和百度","小球游戏",
    "SQLite查询信息","图片缩放","手势保存","手势识别","百度语音朗读TTS","学生信息增删改","飞机大战"};
    ListView lv;
    Class[] clazz = {MainActivity.class,Ex2Activity.class,Ex06Activity.class,MainMyView.class,Ex09Activity.class,Ex10Activity.class,Ex12Activity.class,QQindex.class,Ex11Activity.class,Jisuanqi.class,
    Ex04Activity.class,Ex14Activity.class,Ex15Activity.class,Ex05Activity.class,Ex16Activity.class,Ex17Activity.class,Ex13Activity.class,Ex19Activity.class,Ex18Activity.class,Ex20Activity.class,
    Ex21Activity.class,Ex07Activity.class,Ex22Activity.class,Ex02Activity.class,Ex23Activity.class,Ex24Activity.class,Ex25Activity.class,Ex26Activity.class,Ex27Activity.class,pinBall.class,
    Ex28Activity.class,Ex29Activity.class,Ex30Activity.class,Ex30Activity3.class,Ex31Activity.class,MainActivity4.class,GPanlewarActivity1.class};
   @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.base_layout);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,str);
        lv = (ListView) findViewById(R.id.listid);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BaesActvity2.this,clazz[position]);
                startActivity(intent);
               /* if (position == 0){
                    Intent intent = new Intent(BaesActvity2.this,MainActivity.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(BaesActvity2.this,MainActivity.class);
                    startActivity(intent);
                }if (position == 2){
                    Intent intent = new Intent(BaesActvity2.this,MainActivity.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(BaesActvity2.this,Ex06Activity.class);
                    startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(BaesActvity2.this,MainMyView.class);
                    startActivity(intent);
                }
                if (position == 5){
                    Intent intent = new Intent(BaesActvity2.this,Ex09Activity.class);
                    startActivity(intent);
                }
                if (position == 6){
                    Intent intent = new Intent(BaesActvity2.this,Ex10Activity.class);
                    startActivity(intent);
                }
                if (position == 7){
                    Intent intent = new Intent(BaesActvity2.this,Ex12Activity.class);
                    startActivity(intent);
                }
                if (position == 8){
                    Intent intent = new Intent(BaesActvity2.this,QQindex.class);
                    startActivity(intent);
                }
                if (position == 9){
                    Intent intent = new Intent(BaesActvity2.this,Ex11Activity.class);
                    startActivity(intent);
                } if (position == 10){
                    Intent intent = new Intent(BaesActvity2.this,Jisuanqi.class);
                    startActivity(intent);
                }
                if (position == 11){
                    Intent intent = new Intent(BaesActvity2.this,MainActivity.class);
                    startActivity(intent);
                }
                if (position == 12){
                    Intent intent = new Intent(BaesActvity2.this,MainActivity.class);
                    startActivity(intent);
                }
                if (position == 13){
                    Intent intent = new Intent(BaesActvity2.this,MainActivity.class);
                    startActivity(intent);
                }*/


            }
        });
    }
}
