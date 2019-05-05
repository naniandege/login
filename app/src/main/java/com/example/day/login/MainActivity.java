package com.example.day.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.day.login.fragment.LoginFragment;
import com.example.day.login.fragment.BangFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        addFragment();

    }

    private void addFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl,list.get(0));
        transaction.commit();
    }

    private void initFragment() {
        list = new ArrayList<>();
        list.add(new LoginFragment());
        list.add(new BangFragment());

    }

    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
    }
}
