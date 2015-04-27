package com.jayfang.dropdownmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 *  <a href="http://fangjie.info">JayFang</a>
 *  Email:JayFang1993@gmail.com
 *  GitHub:github.com/JayFang1993
 *
 */

public class MenuListAdapter extends BaseAdapter {

    private Context context;
    private String[] strs;

    private int SelectIndex;

    public MenuListAdapter(Context context, String[] strs) {
        this.context = context;
        this.strs=strs;
    }

    public void setSelectIndex(int selectIndex) {
        SelectIndex = selectIndex;
    }

    @Override
    public int getCount() {
        return strs.length;
    }

    @Override
    public Object getItem(int position) {
        return strs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= LayoutInflater.from(context).inflate(R.layout.menu_list_item,parent,false);
        TextView textView=(TextView)v.findViewById(R.id.tv_menu_item);
        textView.setText(strs[position]);

        if (SelectIndex==position) {
            ImageView imageView = (ImageView) v.findViewById(R.id.iv_menu_select);
            imageView.setVisibility(View.VISIBLE);
        }
        return v;
    }
}