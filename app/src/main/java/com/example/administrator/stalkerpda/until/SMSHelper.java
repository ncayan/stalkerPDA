package com.example.administrator.stalkerpda.until;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.administrator.stalkerpda.model.SMS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SMSHelper {

    /**
     * 参考方法
     * @param context
     */
    public static void readeSMS(Context context){
        //多种URL
        final String SMS_URI_ALL = "content://sms/";
        final String SMS_URI_INBOX = "content://sms/inbox";
        final String SMS_URI_SEND = "content://sms/sent";
        final String SMS_URI_DRAFT = "content://sms/draft";
        final String SMS_URI_OUTBOX = "content://sms/outbox";
        final String SMS_URI_FAILED = "content://sms/failed";
        final String SMS_URI_QUEUED = "content://sms/queued";
        //创建一个查询
        StringBuilder smsBuilder = new StringBuilder();
        Uri uri = Uri.parse(SMS_URI_ALL);
        Cursor cursor = null;
        String[] projection = new String[] { "_id", "address", "person", "body", "date", "type" };
        cursor=context.getContentResolver().query(uri,projection,null,null,"date desc");
        //获取不同列的ID方便获取
        int index_Address = cursor.getColumnIndex("address");
        int index_Person = cursor.getColumnIndex("person");
        int index_Body = cursor.getColumnIndex("body");
        int index_Date = cursor.getColumnIndex("date");
        int index_Type = cursor.getColumnIndex("type");
        //获取
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

    public static List<SMS> findSMSByContactName(String name, Context context){
        List<SMS> data = new ArrayList<>();
        SMS msg1 = new SMS();
        SMS msg2 = new SMS();
        SMS msg3 = new SMS();
        data.add(msg1);
        data.add(msg2);
        data.add(msg3);

        final String SMS_URI_ALL = "content://sms/";

        StringBuilder smsBuilder = new StringBuilder();
        Uri uri = Uri.parse(SMS_URI_ALL);
        Cursor cursor = null;
        String[] projection = new String[] { "_id", "address", "person", "body", "date", "type" };
        cursor=context.getContentResolver().query(uri,projection,null,null,"date desc");

        int index_Address = cursor.getColumnIndex("address");
        int index_Person = cursor.getColumnIndex("person");
        int index_Body = cursor.getColumnIndex("body");
        int index_Date = cursor.getColumnIndex("date");
        int index_Type = cursor.getColumnIndex("type");

        //获取
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
                SMS sms = new SMS();
                sms.setTitle( strType + strDate);
                sms.setContent(strbody);
                data.add(sms);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null)
                cursor.close();
            return data;
        }
    }
}
