package com.example.administrator.stalkerpda;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView menuItem1;
    private TextView menuItem2;

    private List<TextView> menuItemList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();

        menuItemList=new ArrayList<TextView>();
        menuItem1=(TextView)findViewById(R.id.menu_item1);
        menuItem2=(TextView)findViewById(R.id.menu_item2);
        menuItemList.add(menuItem1);
        menuItemList.add(menuItem2);
        menuItem1.setOnClickListener(this);
        menuItem2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_item1:
                menuRedraw();
                menuItem1.setTextColor(getResources().getColor(R.color.menuSelected));
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                TestFrame2 frame2=new TestFrame2();
                transaction.replace(R.id.main_frame, frame2);
                transaction.commit();
                break;
            case R.id.menu_item2:
                menuRedraw();
                menuItem2.setTextColor(getResources().getColor(R.color.menuSelected));
                FragmentManager fragmentManager2=getFragmentManager();
                FragmentTransaction transaction2=fragmentManager2.beginTransaction();
                TestFrame1 frame1=new TestFrame1();
                transaction2.replace(R.id.main_frame, frame1);
                transaction2.commit();
                break;
            default:
        }
    }

    private void initFragment(){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        TestFrame2 frame2=new TestFrame2();
        transaction.replace(R.id.main_frame, frame2);
        transaction.commit();
    }

    private void menuRedraw(){
        for(TextView t:menuItemList){
            t.setTextColor(getResources().getColor(R.color.menuUnSelected));
        }
    }
}
