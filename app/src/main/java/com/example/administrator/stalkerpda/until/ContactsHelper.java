package com.example.administrator.stalkerpda.until;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;

import com.example.administrator.stalkerpda.model.Contact;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class ContactsHelper {

    public static List<Contact> readAllContacts(View view){
        ContentResolver CR = view.getContext().getContentResolver();
        List<Contact> contactList = new ArrayList<>();
        /*String ognization="组织       独行者";
        String status="态度       中立";
        String shengw="声望       中立";
        String level="阶级        士兵";*/
        Cursor cursor=null;
        try{
            cursor=CR.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()){
                Contact contact = new Contact();
                String displayName=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                contact.setName(displayName);
                String phoneNum=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contact.setPhoneNum(phoneNum);
                String orgnization=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CUSTOM_RINGTONE));
                contact.setOrgnization(orgnization);
                String shengWang = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Relation.CONTACT_STATUS));
                contact.setShengWang(shengWang);
                //String level = ????
                //contact.setLevel("");
                //String status = ????
                //contact.setStatu("");
                contactList.add(contact);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return contactList;
    }

    public void readeSMS(View view){
        final String SMS_URI_ALL = "content://sms/";
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_SEND = "content://sms/sent";
        final String SMS_URI_DRAFT = "content://sms/draft";
        final String SMS_URI_OUTBOX = "content://sms/outbox";
        final String SMS_URI_FAILED = "content://sms/failed";
        final String SMS_URI_QUEUED = "content://sms/queued";
        StringBuilder smsBuilder = new StringBuilder();
        Uri uri=Uri.parse(SMS_URI_ALL);
        Cursor cursor=null;
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
