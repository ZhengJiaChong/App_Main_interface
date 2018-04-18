package com.example.administrator.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.myapplication.fragments.CircleFragment;
import com.example.administrator.myapplication.fragments.FindFragment;
import com.example.administrator.myapplication.fragments.MeFragment;
import com.example.administrator.myapplication.fragments.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private List<Fragment> mFragments;
    private BottomNavigationBar mBottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        init();
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new CircleFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MeFragment());

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultItem();
    }

    private void setDefaultItem() {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_container,mFragments.get(0));
        ft.commit();

    }

    private void initview() {
        mBottomNavigationBar = (BottomNavigationBar)findViewById(R.id.btm_nav_bar);
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_container,mFragments.get(position));
        ft.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
