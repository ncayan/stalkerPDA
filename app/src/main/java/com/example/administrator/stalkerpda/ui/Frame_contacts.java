package com.example.administrator.stalkerpda.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.stalkerpda.adapter.ContactAdapter;
import com.example.administrator.stalkerpda.R;
import com.example.administrator.stalkerpda.adapter.SMSAdapter;
import com.example.administrator.stalkerpda.model.Contact;
import com.example.administrator.stalkerpda.until.ContactsHelper;
import com.example.administrator.stalkerpda.until.SMSHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/29.
 */
public class Frame_contacts extends Fragment {
    View view;
    Context context;
    private ViewGroup container;
    private ListView contactList;
    private ListView SMSList;
    ArrayAdapter<String> adapter;
    List<String> contactsList=new ArrayList<String>();
    List<Contact> contacts = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.contact_list,container,false);
        context = view.getContext();
        contactList = (ListView)view.findViewById(R.id.contact_listview);
        SMSList = (ListView)view.findViewById(R.id.message_listview);
        contacts = ContactsHelper.readAllContacts(view);
        adapter = new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,contactsList);
        //adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList);
        //List<Map<String, Object>> list=getData();
        contactList.setAdapter(new ContactAdapter(container.getContext(),contacts));
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contacts.get(position);
                String Name = contact.getName();
                refreshSMS(Name);
            }
        });
        this.container = container;
        return view;
    }

    public void refreshSMS( String Name ){
        SMSList.setAdapter(new SMSAdapter(container.getContext(), SMSHelper.findSMSByContactName("",context)));
    }

    public void refreshSMS( int postision ){
        SMSList.setAdapter(new SMSAdapter(container.getContext(),null));
    }

    /*private void readContacts(){
        String ognization="组织       独行者";
        String status="态度       中立";
        String shengw="声望       中立";
        String level="阶级       士兵";
        Cursor cursor=null;
        try{
            cursor=view.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
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
    }*/


    /*public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        Cursor cursor=null;
        try{
            cursor=view.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
            while (cursor.moveToNext()){
                String displayName=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNum=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                Map<String, Object> map=new HashMap<String, Object>();
                map.put("head",R.mipmap.ic_launcher);
                map.put("og","组织       独行者");
                map.put("sw","声望       中立");
                map.put("stat","态度       中立");
                map.put("title",displayName);
                map.put("lev","阶级       士兵");

                list.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }

        return list;
    }*/

    public void readeSMS(){
        final String SMS_URI_ALL = "content://sms/";
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_SEND = "content://sms/sent";
        final String SMS_URI_DRAFT = "content://sms/draft";
        final String SMS_URI_OUTBOX = "content://sms/outbox";
        final String SMS_URI_FAILED = "content://sms/failed";
        final String SMS_URI_QUEUED = "content://sms/queued";
        StringBuilder smsBuilder = new StringBuilder();
        Uri uri = Uri.parse(SMS_URI_ALL);
        Cursor cursor = null;
        String[] projection = new String[] { "_id", "address", "person", "body", "date", "type" };
        cursor=view.getContext().getContentResolver().query(uri,projection,null,null,"date desc");
        int index_Address = cursor.getColumnIndex("address");
        int index_Person = cursor.getColumnIndex("person");
        int index_Body = cursor.getColumnIndex("body");
        int index_Date = cursor.getColumnIndex("date");
        int index_Type = cursor.getColumnIndex("type");
        try{
            if(cursor.moveToFirst()){
                String strAddress = cursor.getString(index_Address);
                int intPerson = cursor.getInt(index_Person);
                String strbody = cursor.getString(index_Body);
                long longDate = cursor.getLong(index_Date);
                int intType = cursor.getInt(index_Type);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date d = new Date(longDate);
                String strDate = dateFormat.format(d);

                String strType = "";
                if (intType == 1) {
                    strType = "接收";
                } else if (intType == 2) {
                    strType = "发送";
                } else {
                    strType = "null";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null)
                cursor.close();
        }
    }
}
