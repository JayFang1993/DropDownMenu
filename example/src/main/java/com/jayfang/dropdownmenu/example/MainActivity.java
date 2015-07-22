package com.jayfang.dropdownmenu.example;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jayfang.dropdownmenu.DropDownMenu;
import com.jayfang.dropdownmenu.OnMenuSelectedListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private DropDownMenu mMenu;
    private ListView mList;

    private int city_index;
    private int sex_index;
    private int age_index;
    private List<String> data;
    final String[] arr1=new String[]{"全部城市","北京","上海","广州","深圳"};
    final String[] arr2=new String[]{"性别","男","女"};
    final String[] arr3=new String[]{"全部年龄","10","20","30","40","50","60","70"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu=(DropDownMenu)findViewById(R.id.menu);

        mMenu.setMenuCount(3);
        mMenu.setShowCount(6);
        mMenu.setShowCheck(true);
        mMenu.setMenuTitleTextSize(16);
        mMenu.setMenuTitleTextColor(Color.WHITE);
        mMenu.setMenuListTextSize(16);
        mMenu.setMenuListTextColor(Color.BLACK);
        mMenu.setMenuBackColor(Color.GRAY);
        mMenu.setMenuPressedBackColor(Color.WHITE);

        mMenu.setCheckIcon(R.drawable.ico_make);

        mMenu.setUpArrow(R.drawable.arrow_up);
        mMenu.setDownArrow(R.drawable.arrow_down);


        mMenu.setShowDivider(false);
        mMenu.setMenuListBackColor(getResources().getColor(R.color.white));
        mMenu.setMenuListSelectorRes(R.color.white);
        mMenu.setArrowMarginTitle(20);
        mMenu.setMenuPressedTitleTextColor(Color.BLACK);

        mMenu.setMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onSelected(View listview, int RowIndex, int ColumnIndex) {
                Log.i("MainActivity", "select " + ColumnIndex + " column and " + RowIndex + " row");
                if (ColumnIndex == 0) {
                    city_index = RowIndex;
                } else if (ColumnIndex == 1) {
                    sex_index = RowIndex;
                } else {
                    age_index = RowIndex;
                }
                //过滤筛选
                setFilter();
            }
        });
//        List<String[]> items = new ArrayList<>();
//        items.add(arr1);
//        items.add(arr2);
//        items.add(arr3);
//        mMenu.setMenuItems(items);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String[]> items = new ArrayList<>();
                items.add(arr1);
                items.add(arr2);
                items.add(arr3);
                mMenu.setMenuItems(items);

            }
        }, 1000);

        mList=(ListView)findViewById(R.id.lv_list);
        data=getData();
        mList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data));


    }

    private void setFilter(){
        List<String> temp=new ArrayList<String>();
        for (int i=0;i<getData().size();i++){
            boolean city=((city_index==0)?true:data.get(i).contains(arr1[city_index]));
            boolean sex=((sex_index==0)?true:data.get(i).contains(arr2[sex_index]));
            boolean age=((age_index==0)?true:data.get(i).contains(arr3[age_index]));
            if(city && sex && age){
                temp.add(data.get(i));
            }
        }
        mList.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,temp));
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("上海－男－10");
        data.add("上海－男－20");
        data.add("上海－男－30");
        data.add("上海－男－40");
        data.add("上海－男－50");
        data.add("上海－男－60");
        data.add("上海－男－70");
        data.add("广州－男－10");
        data.add("广州－女－10");
        data.add("北京－男－20");
        data.add("北京－女－10");
        data.add("广州－男－10");
        data.add("北京－男－10");
        data.add("广州－男－10");
        data.add("上海－女－60");
        data.add("上海－女－20");
        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
