package com.example.day.login.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day.login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private ImageView wechat;
    private EditText ed;
    private Button but;
    private String edit;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_login, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        wechat = (ImageView) inflate.findViewById(R.id.wechat);
        but = (Button) inflate.findViewById(R.id.but);
        ed = (EditText) inflate.findViewById(R.id.ed);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit = ed.getText().toString();
                if (edit.isEmpty()){
                    return;
                }
                    initFragment();
            }
        });

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)) {
                    but.setBackgroundResource(R.drawable.shape);
                } else {
                    but.setBackgroundResource(R.drawable.shape1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.add(R.id.fl, new BangFragment());
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
    }
}
