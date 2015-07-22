package com.jayfang.dropdownmenu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  <a href="http://fangjie.info">JayFang</a>
 *  Email:JayFang1993@gmail.com
 *  GitHub:github.com/JayFang1993
 *
 */
public class DropDownMenu extends LinearLayout{

    // Menu 展开的ListView 的 adapter
    private List<MenuListAdapter> MenuAdapters=new ArrayList<MenuListAdapter>();

    // Menu 展开的 list item
    private List<String[]> MenuItems=new ArrayList<>();

    //菜单 上的文字
    private List<TextView> mTvMenuTitles=new ArrayList<>();
    //菜单 的背景布局
    private List<RelativeLayout> mRlMenuBacks=new ArrayList<>();
    //菜单 的箭头
    private List<ImageView> mIvMenuArrow=new ArrayList<>();

    private Context context;

    private PopupWindow mPopupWindow;
    // Menu 展开的ListView
    private ListView mMenuList;
    // Menu 展开的ListView 下部的阴影
    private RelativeLayout mRlShadow;

    // 监听器
    private OnMenuSelectedListener MenuSelectedListener;

    // 主Menu的个数
    private int MenuCount;
    // Menu 展开的list 显示数量
    private int ShowCount;

    //选中行数
    private int RowSelected=0;
    //选中列数
    private int ColumnSelected=0;

    //Menu的字体颜色
    private int MenuTitleTextColor;
    //Menu的字体大小
    private int MenuTitleTextSize;
    //Menu的按下的字体颜色
    private int MenuPressedTitleTextColor;
    //Menu的按下背景
    private int MenuPressedBackColor;
    //Menu的背景
    private int MenuBackColor;
    //Menu list 的字体大小
    private int MenuListTextSize;
    //Menu list 的字体颜色
    private int MenuListTextColor;
    //是否显示选中的对勾
    private boolean showCheck;
    //是否现实列表的分割线
    private boolean showDivider;
    //列表的背景
    private int MenuListBackColor;
    //列表的按下效果
    private int MenuListSelectorRes;
    //箭头距离
    private int ArrowMarginTitle;

    //对勾的图片资源
    private int CheckIcon;
    //向上的箭头图片资源
    private int UpArrow;
    //向下的箭头图片资源
    private int DownArrow;

    private boolean drawable=false;

    private String[] defaultMenuTitle;

    private boolean isDebug=true;

    public DropDownMenu(Context context) {
        super(context);
        init(context);

    }

    public DropDownMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        this.context=context;
        MenuCount=2;
        ShowCount=5;
        MenuTitleTextColor=getResources().getColor(R.color.default_menu_text);
        MenuPressedBackColor=getResources().getColor(R.color.default_menu_press_back);
        MenuPressedTitleTextColor=getResources().getColor(R.color.default_menu_press_text);
        MenuBackColor=getResources().getColor(R.color.default_menu_back);
        MenuListBackColor=getResources().getColor(R.color.white);
        MenuListSelectorRes=R.color.white;
        MenuTitleTextSize=18;
        ArrowMarginTitle=10;
        showCheck=true;
        showDivider=true;
        CheckIcon=R.drawable.ico_make;
        UpArrow=R.drawable.arrow_up;
        DownArrow=R.drawable.arrow_down;

    }

    // 设置 Menu的item
    public void setMenuItems(List<String[]> menuItems) {
        MenuItems = menuItems;
        drawable=true;
        invalidate();
    }

    // 设置 Menu的数量
    public void setMenuCount(int menuCount) {
        MenuCount = menuCount;
    }


    public void setShowDivider(boolean showDivider) {
        this.showDivider = showDivider;
    }

    public void setMenuListBackColor(int menuListBackColor) {
        MenuListBackColor = menuListBackColor;
    }

    public void setMenuListSelectorRes(int menuListSelectorRes) {
        MenuListSelectorRes = menuListSelectorRes;
    }

    public void setArrowMarginTitle(int arrowMarginTitle) {
        ArrowMarginTitle = arrowMarginTitle;
    }

    public void setMenuPressedTitleTextColor(int menuPressedTitleTextColor) {
        MenuPressedTitleTextColor = menuPressedTitleTextColor;
    }

    public void setDefaultMenuTitle(String[] defaultMenuTitle) {
        this.defaultMenuTitle = defaultMenuTitle;
    }

    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
    }

    // 设置 show 数量
    public void setShowCount(int showCount) {
        ShowCount = showCount;
    }

    // 设置 Menu的字体颜色
    public void setMenuTitleTextColor(int menuTitleTextColor) {
        MenuTitleTextColor = menuTitleTextColor;
    }

    // 设置 Menu的字体大小
    public void setMenuTitleTextSize(int menuTitleTextSize) {
        MenuTitleTextSize = menuTitleTextSize;
    }

    //设置Menu的背景色
    public void setMenuBackColor(int menuBackColor) {
        MenuBackColor = menuBackColor;
    }

    //设置Menu的按下背景色
    public void setMenuPressedBackColor(int menuPressedBackColor) {
        MenuPressedBackColor = menuPressedBackColor;
    }

    //设置Menu list的字体颜色
    public void setMenuListTextColor(int menuListTextColor) {
        MenuListTextColor = menuListTextColor;
        for (int i=0;i<MenuAdapters.size();i++){
            MenuAdapters.get(i).setTextColor(MenuListTextColor);
        }
    }
    //设置Menu list的字体大小
    public void setMenuListTextSize(int menuListTextSize) {
        MenuListTextSize = menuListTextSize;
        for (int i=0;i<MenuAdapters.size();i++){
            MenuAdapters.get(i).setTextSize(menuListTextSize);
        }
    }
    //设置是否显示对勾
    public void setShowCheck(boolean showCheck) {
        this.showCheck = showCheck;
    }

    //设置对勾的icon
    public void setCheckIcon(int checkIcon) {
        CheckIcon = checkIcon;
    }

    public void setUpArrow(int upArrow) {
        UpArrow = upArrow;
    }

    public void setDownArrow(int downArrow) {
        DownArrow = downArrow;
    }

    public void setMenuSelectedListener(OnMenuSelectedListener menuSelectedListener) {
        MenuSelectedListener = menuSelectedListener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            if (mPopupWindow==null||drawable) {
                View popupView = LayoutInflater.from(context).inflate(R.layout.popupwindow_menu, null);
                mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                mPopupWindow.setTouchable(true);
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
                mMenuList = (ListView) popupView.findViewById(R.id.lv_menu);
                mRlShadow = (RelativeLayout) popupView.findViewById(R.id.rl_menu_shadow);

                mRlShadow.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopupWindow.dismiss();
                    }
                });

                mMenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mPopupWindow.dismiss();
                        RowSelected = position;

                        mTvMenuTitles.get(ColumnSelected).setText(MenuItems.get(ColumnSelected)[RowSelected]);
                        mIvMenuArrow.get(ColumnSelected).setImageResource(DownArrow);
                        MenuAdapters.get(ColumnSelected).setSelectIndex(RowSelected);
                        if (MenuSelectedListener == null && isDebug)
                            Toast.makeText(context, "MenuSelectedListener is  null", Toast.LENGTH_LONG).show();
                        else
                            MenuSelectedListener.onSelected(view, RowSelected, ColumnSelected);
                    }
                });

                mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        for (int i = 0; i < MenuCount; i++) {
                            mIvMenuArrow.get(i).setImageResource(DownArrow);
                            mRlMenuBacks.get(i).setBackgroundColor(MenuBackColor);
                            mTvMenuTitles.get(i).setTextColor(MenuTitleTextColor);
                        }
                    }
                });

                if (MenuItems.size() != MenuCount&&isDebug) {
                    Toast.makeText(context, "Menu item is not setted or incorrect", Toast.LENGTH_LONG).show();
                    return;
                }

                if (MenuAdapters.size() == 0) {
                    for (int i = 0; i < MenuCount; i++) {
                        MenuListAdapter adapter = new MenuListAdapter(context, MenuItems.get(i));
                        adapter.setShowCheck(showCheck);
                        adapter.setCheckIcon(CheckIcon);
                        MenuAdapters.add(adapter);

                    }
                } else if (MenuAdapters.size() != MenuCount &&isDebug) {
                    Toast.makeText(context, "If you want set Adapter by yourself,please ensure the number of adpaters equal MenuCount", Toast.LENGTH_LONG).show();
                    return;
                }
                int width = getWidth();

                for (int i = 0; i < MenuCount; i++) {
                    final RelativeLayout v = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.menu_item, null, false);
                    RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(width / MenuCount, LayoutParams.WRAP_CONTENT);
                    v.setLayoutParams(parms);
                    TextView tv = (TextView) v.findViewById(R.id.tv_menu_title);
                    tv.setTextColor(MenuTitleTextColor);
                    tv.setTextSize(MenuTitleTextSize);
                    if (defaultMenuTitle.length==0){
                        tv.setText(MenuItems.get(i)[0]);
                    }else{
                        tv.setText(defaultMenuTitle[i]);
                    }
                    this.addView(v, i);
                    mTvMenuTitles.add(tv);

                    RelativeLayout rl = (RelativeLayout) v.findViewById(R.id.rl_menu_head);
                    rl.setBackgroundColor(MenuBackColor);
                    mRlMenuBacks.add(rl);

                    ImageView iv = (ImageView) v.findViewById(R.id.iv_menu_arrow);
                    mIvMenuArrow.add(iv);
                    mIvMenuArrow.get(i).setImageResource(DownArrow);

                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv.getLayoutParams();
                    params.leftMargin = ArrowMarginTitle;
                    iv.setLayoutParams(params);

                    final int index = i;
                    v.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mMenuList.setAdapter(MenuAdapters.get(index));
                            if (MenuAdapters.get(index).getCount() > ShowCount) {
                                View childView = MenuAdapters.get(index).getView(0, null, mMenuList);
                                childView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                                RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, childView.getMeasuredHeight() * ShowCount);
                                mMenuList.setLayoutParams(parms);
                            } else {
                                View childView = MenuAdapters.get(index).getView(0, null, mMenuList);
                                childView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                                RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                                mMenuList.setLayoutParams(parms);
                            }
                            if (!showDivider)
                                mMenuList.setDivider(null);
                            mMenuList.setBackgroundColor(MenuListBackColor);
                            mMenuList.setSelector(MenuListSelectorRes);
                            ColumnSelected = index;
                            mTvMenuTitles.get(index).setTextColor(MenuPressedTitleTextColor);
                            mRlMenuBacks.get(index).setBackgroundColor(MenuPressedBackColor);
                            mIvMenuArrow.get(index).setImageResource(UpArrow);
                            mPopupWindow.showAsDropDown(v);
                        }
                    });
                }
                drawable=false;
            }
    }


}
