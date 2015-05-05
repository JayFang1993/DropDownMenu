# DropDownMenu

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-DropDownMenu-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1753)

DropDownMenu for Android,Filter the list based on multiple condition.

<img src="screenshot.gif" width="270" height="450"/>


Usage
----
    <com.jayfang.dropdownmenu.DropDownMenu
        android:orientation="horizontal"
        android:layout_width="fill_parent"
        android:id="@+id/menu"
        android:background="@color/ripple_material_dark"
        android:layout_height="60dp"/>


* mMenu=(DropDownMenu)findViewById(R.id.menu);
* mMenu.setMenuItems(ArrayList<String[]>);
* mMenu.setMenuCount(3);
* mMenu.setShowCount(6);
* mMenu.setShowCheck(true);
* mMenu.setMenuTitleTextSize(16);
* mMenu.setMenuTitleTextColor(Color.BLACK);
* mMenu.setMenuListTextSize(16);
* mMenu.setMenuListTextColor(Color.BLACK);
* mMenu.setMenuBackColor(Color.GRAY);
* mMenu.setMenuPressedBackColor(Color.CYAN);
* mMenu.setCheckIcon(R.drawable.ico_make);
* mMenu.setUpArrow(R.drawable.arrow_up);
* mMenu.setDownArrow(R.drawable.arrow_down);
* mMenu.setMenuSelectedListener(new OnMenuSelectedListener(){
     @Override
    public void onSelected(View listview,int RowIndex, int ColumnIndex) {

   }});


        
Contact
----------
* Blog：[http://fangjie.info/](http://fangjie.info/)
* Email:JayFang1993@gmail.com


License
----------

    Copyright 2015 JayFang, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


        

        