package com.jayfang.dropdownmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * Created by Jay on 15/4/23.
 */
public class DropDownMenu extends LinearLayout{

    private int MenuCount;

    private ListView MenuList;

    private Context context;

    private PopupWindow mPopupWindow;
    private ListView mMenuList;

    private String[] arr1=new String[]{"item1","item2","item3","item4"};
    private String[] arr2=new String[]{"item1","item2","item3","item4"};

    public DropDownMenu(Context context) {
        super(context);
        MenuCount=3;
        this.context=context;
    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        MenuCount=3;
        this.context=context;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        View popupView =LayoutInflater.from(context).inflate(R.layout.popupwindow_filter, null);
        mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(),(Bitmap) null));
        mMenuList=(ListView)popupView.findViewById(R.id.lv_filter);

        int width=getWidth();
        for (int i=0;i<MenuCount;i++){
            RelativeLayout v =(RelativeLayout)LayoutInflater.from(context).inflate(R.layout.menu_item,null,false);
            RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(width/MenuCount, LayoutParams.WRAP_CONTENT);
            v.setLayoutParams(parms);
            this.addView(v,i);
            mMenuList.setAdapter(new MenuListAdapter(context, arr1));

            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupWindow.showAsDropDown(v);
                }
            });
//
//            mRlFilterBottom.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mPopupWindow.dismiss();
//                }
//            });
        }
    }
}
