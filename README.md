# DropDownMenu
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
* mMenu.setMenuItems(ArrayList<String[]>);
* mMenu.setMenuSelectedListener(new OnMenuSelectedListener(){
     @Override
    public void onSelected(View listview,int RowIndex, int ColumnIndex) {

   }});


        
Contact
----------
>* Blog：[http://fangjie.info/](http://fangjie.info/)
>* Email:JayFang1993@gmail.com




        

        
