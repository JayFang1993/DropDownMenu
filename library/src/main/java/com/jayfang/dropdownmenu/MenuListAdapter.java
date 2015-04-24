package com.jayfang.dropdownmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Jay on 15/4/24.
 */

public class MenuListAdapter extends BaseAdapter {
    private Context context;
    private String[] strs;

    public MenuListAdapter(Context context, String[] strs) {
        this.context = context;
        this.strs=strs;
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
        View v= LayoutInflater.from(context).inflate(R.layout.item_menu_popupwindow,parent,false);
        TextView textView=(TextView)v.findViewById(R.id.tv_filter_item);
        textView.setText(strs[position]);
        return v;
    }
}