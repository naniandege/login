package com.example.day.day_01;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.day.day_01.adapter.VpAdapter;
import com.example.day.day_01.fragment.TongFragment;
import com.example.day.day_01.fragment.XiaoFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);

        ArrayList<String> title = new ArrayList<>();
        title.add("通知");
        title.add("消息");
        tab.setupWithViewPager(vp);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new TongFragment());
        list.add(new XiaoFragment());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), list, title);
        vp.setAdapter(vpAdapter);
    }
}
