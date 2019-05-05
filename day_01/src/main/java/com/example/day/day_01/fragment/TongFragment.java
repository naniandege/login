package com.example.day.day_01.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.day.day_01.R;
import com.example.day.day_01.adapter.TongAdapter;
import com.example.day.day_01.bean.Bean;
import com.example.day.day_01.callback.SimCallBack;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongFragment extends Fragment {


    private RecyclerView lv;
    private ArrayList<Bean> list;
    private TongAdapter adapter;

    public TongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_tong, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        list.add(new Bean("系统通知","2017/10/21","通过分享获得2米粒"));
        list.add(new Bean("系统通知","2017/10/21","通过分享获得2米粒"));
        list.add(new Bean("系统通知","2017/10/21","通过分享获得2米粒"));

        adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        lv = (RecyclerView) inflate.findViewById(R.id.lv);

        list = new ArrayList<>();

        adapter = new TongAdapter(list, getActivity());
        lv.setAdapter(adapter);

        lv.setLayoutManager(new LinearLayoutManager(getActivity()));
        lv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        SimCallBack simCallBack = new SimCallBack(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simCallBack);
        itemTouchHelper.attachToRecyclerView(lv);
    }
}
