package com.jayfang.dropdownmenu.example;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenu=(DropDownMenu)findViewById(R.id.menu);
        mMenu.setMenuCount(3);

        final String[] arr1=new String[]{"全部城市","北京","上海","广州","深圳"};
        final String[] arr2=new String[]{"性别","男","女"};
        final String[] arr3=new String[]{"全部年龄","10","20","30","40","50","60","70"};


        List<String[]> items=new ArrayList<>();
        items.add(arr1);
        items.add(arr2);
        items.add(arr3);

        mMenu.setMenuItems(items);
        mMenu.setMenuSelectedListener(new OnMenuSelectedListener(){
            @Override
            public void onSelected(View listview,int RowIndex, int ColumnIndex) {
                Log.i("MainActivity","select "+ColumnIndex +"column and " +RowIndex+" row");
                if (ColumnIndex==0){
                    city_index=RowIndex;
                }else if (ColumnIndex==1){
                    sex_index=RowIndex;
                }else {
                    age_index=RowIndex;
                }

                List<String> temp=new ArrayList<String>();
                for (int i=0;i<getData().size();i++){
                    if(data.get(i).contains(arr1[city_index])&& data.get(i).contains(arr2[sex_index]) && data.get(i).contains(arr3[age_index])){
                        temp.add(data.get(i));
                    }
                }

                mList.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,temp));

            }
        });

        mList=(ListView)findViewById(R.id.lv_list);
        data=getData();
        mList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,data));
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("上海_男_10");
        data.add("上海_男_20");
        data.add("上海_男_30");
        data.add("上海_男_40");
        data.add("上海_男_50");
        data.add("上海_男_60");
        data.add("上海_男_70");
        data.add("广州_男_10");
        data.add("广州_女_10");
        data.add("北京_男_20");
        data.add("北京_女_10");
        data.add("广州_男_10");
        data.add("北京_男_10");
        data.add("广州_男_10");
        data.add("上海_女_60");
        data.add("上海_女_20");
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
