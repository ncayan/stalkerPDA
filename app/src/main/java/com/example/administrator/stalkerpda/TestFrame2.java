package com.example.administrator.stalkerpda;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

/**
 * Created by Administrator on 2016/2/24.
 */
public class TestFrame2 extends Fragment {
    private MapView mMapView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SDKInitializer.initialize(getActivity().getApplicationContext());

        View view=inflater.inflate(R.layout.test_frame2,container,false);

        mMapView = (MapView)view.findViewById(R.id.simple_map1);
        BaiduMap mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
        mBaiduMap.setTrafficEnabled(false);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
