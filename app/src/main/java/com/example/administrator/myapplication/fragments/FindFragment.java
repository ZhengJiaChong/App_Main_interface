package com.example.administrator.myapplication.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments;
    private View mView;
    private String[] titles ={"科技","新闻"};

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_find, container, false);
        initView();
        init();
        // Inflate the layout for this fragment
        return mView;
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new MobileFragment());
        mFragments.add(new NewsFragment());

        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText("科技");
        mTabLayout.getTabAt(1).setText("新闻");

    }
        public class PagerAdapter extends FragmentPagerAdapter {
            public PagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
    }

    private void initView() {
        mTabLayout = (TabLayout)mView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)mView.findViewById(R.id.view_pager);
    }

}
