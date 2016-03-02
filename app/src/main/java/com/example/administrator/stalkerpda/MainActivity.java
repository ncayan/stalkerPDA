package com.example.administrator.stalkerpda;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private SupportMapFragment map;
    private TextView menuItem1;
    private TextView menuItem2;
    private TextView menuItem3;

    private List<TextView> menuItemList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

        menuItemList=new ArrayList<TextView>();
        menuItem1=(TextView)findViewById(R.id.menu_item1);
        menuItem2=(TextView)findViewById(R.id.menu_item2);
        menuItem3=(TextView)findViewById(R.id.menu_item3);
        menuItemList.add(menuItem1);
        menuItemList.add(menuItem2);
        menuItemList.add(menuItem3);
        menuItem1.setOnClickListener(this);
        menuItem2.setOnClickListener(this);
        menuItem3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.menu_item1:
                menuRedraw();
                menuItem1.setTextColor(getResources().getColor(R.color.menuSelected));
                TestFrame2 frame2=new TestFrame2();
                transaction.replace(R.id.main_frame, frame2);
                transaction.commit();
                break;
            case R.id.menu_item2:
                menuRedraw();
                menuItem2.setTextColor(getResources().getColor(R.color.menuSelected));
                TestFrame1 frame1=new TestFrame1();
                transaction.replace(R.id.main_frame, frame1);
                transaction.commit();
                break;
            case R.id.menu_item3:
                menuRedraw();
                menuItem3.setTextColor(getResources().getColor(R.color.menuSelected));
                ContactFrame contactFrame=new ContactFrame();
                transaction.replace(R.id.main_frame, contactFrame);
                transaction.commit();
                break;
            default:
        }
    }

    private void initFragment(){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        TestFrame1 frame1=new TestFrame1();
        transaction.replace(R.id.main_frame, frame1);
        transaction.commit();
    }

    private void menuRedraw(){
        for(TextView t:menuItemList){
            t.setTextColor(getResources().getColor(R.color.menuUnSelected));
        }
    }

}
