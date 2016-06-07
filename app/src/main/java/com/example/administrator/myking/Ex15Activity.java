package com.example.administrator.myking;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/31.
 */
public class Ex15Activity extends BaseActivity {
    private String[] opername = {"车世界","西游记","粉丝","吃货","联盟"};
    private  String[][] peroname = {{"宝马","奔驰","宾利","兰博基尼"},{"唐僧","孙悟空","猪八戒","沙和尚","白龙马"},{"灰狼","美羊羊","刀郎"},{"波波","馒头","花卷","面包"},{"上单","打野","中单"}};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex15_layout);
        ExpandableListAdapter ela = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return opername.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return peroname[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return opername[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return peroname[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LayoutInflater li = LayoutInflater.from(Ex15Activity.this);
                View v = li.inflate(android.R.layout.simple_list_item_1,null);
                TextView tv = (TextView) v.findViewById(android.R.id.text1);
                tv.setPadding(80,0,0,0);
                tv.setText(opername[groupPosition]);
                return v;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = new TextView(Ex15Activity.this);
                textView.setPadding(130,0,0,0);
                textView.setText(peroname[groupPosition][childPosition]);

                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return childId;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return groupId;
            }
        };
        ExpandableListView view = (ExpandableListView) findViewById(R.id.grouplist);
        view.setAdapter(ela);
    }
}
