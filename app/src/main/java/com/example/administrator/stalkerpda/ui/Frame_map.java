package com.example.administrator.stalkerpda.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.stalkerpda.R;

/**
 * Created by Administrator on 2016/2/24.
 */
public class Frame_map extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.test_frame1,container,false);
        return view;
    }
}
