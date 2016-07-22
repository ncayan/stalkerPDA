package com.example.administrator.stalkerpda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.stalkerpda.R;
import com.example.administrator.stalkerpda.model.Contact;
import com.example.administrator.stalkerpda.model.SMS;
import com.example.administrator.stalkerpda.until.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/19.
 */
public class SMSAdapter extends BaseAdapter {
    private Zujian zujian;
    private List<Map<String,Object>> data;
    private Context context;
    private LayoutInflater layoutInflater;

    private final class Zujian{
        private TextView smsTitle;
        private TextView smsContent;
        private ImageView headIcon;
    }

    public SMSAdapter(Context context, List<SMS> list){
        this.context=context;
        this.layoutInflater=LayoutInflater.from(this.context);
        setSMSValue(list);
    }

    private void setSMSValue(List<SMS> list){
        if (data == null){
            data = new ArrayList<>();
        } else {
            data.clear();
        }
        Map<String,Object> map = new HashMap<>();
        for (SMS sms: list) {
            if ( Tools.isUsefulString( sms.getTitle()) ){
                map = new HashMap<>();
                map.put("head",sms.getHeadIcon());
                map.put("title", sms.getTitle());
                map.put("cont", sms.getContent());
                this.data.add(map);
            }
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if ( null == convertView ) {
            zujian = new Zujian();
            convertView=layoutInflater.inflate(R.layout.sms_list_item,null);
            zujian.smsTitle = (TextView) convertView.findViewById(R.id.text_sms_title);
            zujian.smsContent = (TextView) convertView.findViewById(R.id.text_sms_content);
            zujian.headIcon = (ImageView) convertView.findViewById(R.id.image_icon_head);
        } else {
            zujian = (Zujian) convertView.getTag();
        }
        setValue(position);
        return convertView;
    }

    private void setValue(int position){
        //zujian.headIcon.setImageResource((Integer) data.get(position).get("head"));
        zujian.smsContent.setText((String) data.get(position).get("cont"));
        zujian.smsTitle.setText((String) data.get(position).get("title"));
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
}
