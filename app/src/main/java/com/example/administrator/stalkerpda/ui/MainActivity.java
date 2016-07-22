package com.example.administrator.stalkerpda.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.SupportMapFragment;
import com.example.administrator.stalkerpda.R;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

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

        // 初始化 Bmob SDK
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, "e89d75ae02ac1c2489d1f0e8ad8cad38");
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
                Frame_home frame2=new Frame_home();
                transaction.replace(R.id.main_frame, frame2);
                transaction.commit();
                break;
            case R.id.menu_item2:
                menuRedraw();
                menuItem2.setTextColor(getResources().getColor(R.color.menuSelected));
                Frame_map frame1=new Frame_map();
                transaction.replace(R.id.main_frame, frame1);
                transaction.commit();
                break;
            case R.id.menu_item3:
                menuRedraw();
                menuItem3.setTextColor(getResources().getColor(R.color.menuSelected));
                Frame_contacts contactFrame=new Frame_contacts();
                transaction.replace(R.id.main_frame, contactFrame);
                transaction.commit();
                break;
            default:
        }
    }

    private void initFragment(){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        Frame_map frame1=new Frame_map();
        transaction.replace(R.id.main_frame, frame1);
        transaction.commit();
    }

    private void menuRedraw(){
        for(TextView t:menuItemList){
            t.setTextColor(getResources().getColor(R.color.menuUnSelected));
        }
    }

}
