package com.example.administrator.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.ListAdapter;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MobileFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View mView;
    private LinearLayoutManager mLinearLayoutManager;
    private ListAdapter mListAdapter;
    private List<String> mDataList;


    public MobileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_mobile, container, false);
        init();
        initView();
        return mView;
    }

    private void initView() {
        mRecyclerView = (RecyclerView)mView.findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mListAdapter = new ListAdapter(R.layout.list_item,mDataList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mListAdapter);
    }

    private void init() {
        mDataList = new ArrayList<>();
        mDataList.add("手机");
        mDataList.add("平板");
        mDataList.add("电脑");
    }

}
