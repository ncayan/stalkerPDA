package com.example.administrator.stalkerpda.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.stalkerpda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/26.
 */
public class SubFrame_contact extends Activity {
    private ListView contactList;
    ArrayAdapter<String> adapter;
    List<String> contactsList=new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.contact_list);
        contactList=(ListView)findViewById(R.id.contact_listview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        contactList.setAdapter(adapter);

    }

    private void readContacts(){
        String ognization="组织       独行者";
        String status="态度       中立";
        String shengw="声望       中立";
        String level="阶级        士兵";
        Cursor cursor=null;
        try{
            cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            while (cursor.moveToNext()){
                String displayName=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNum=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
               // String phoneNum=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsList.add(displayName+'\n'+phoneNum+'\n'+ognization+'\n'+status+'\n'+shengw+'\n'+level);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }
    }
}
