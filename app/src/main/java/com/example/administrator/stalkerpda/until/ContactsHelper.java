package com.example.administrator.stalkerpda.until;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.example.administrator.stalkerpda.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class ContactsHelper {

    private List<Contact> readAllContacts(ContentResolver CR){
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
                String orgnization=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                contact.setOrgnization(orgnization);
                String shengWang = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
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
}
