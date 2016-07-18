package com.example.administrator.stalkerpda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.stalkerpda.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/29.
 */
public class ContactAdapter extends BaseAdapter {

    private List<Map<String,Object>> data;
    private Context context;
    private LayoutInflater layoutInflater;
    public ContactAdapter(Context context,List<Map<String,Object>> data) {
        this.data=data;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     * @author Administrator
     */
    public final class Zujian{
        public TextView title;
        public TextView og;
        public TextView stat;
        public TextView sw;
        public TextView lev;
        public ImageView head;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            convertView=layoutInflater.inflate(R.layout.contact_list_item,null);
            zujian.head=(ImageView)convertView.findViewById(R.id.contact_item_head);
            zujian.title=(TextView)convertView.findViewById(R.id.contact_item_title);
            zujian.sw=(TextView)convertView.findViewById(R.id.contact_item_shengw);
            zujian.stat=(TextView)convertView.findViewById(R.id.contact_item_status);
            zujian.og=(TextView)convertView.findViewById(R.id.contact_item_ognization);
            zujian.lev=(TextView)convertView.findViewById(R.id.contact_item_level);
            convertView.setTag(zujian);
        }else {
            zujian=(Zujian)convertView.getTag();
        }
        zujian.head.setImageResource((Integer) data.get(position).get("head"));
        //zujian.head.setBackgroundResource((Integer) data.get(position).get("head"));
        zujian.lev.setText((String) data.get(position).get("lev"));
        zujian.og.setText((String) data.get(position).get("og"));
        zujian.sw.setText((String) data.get(position).get("sw"));
        zujian.stat.setText((String) data.get(position).get("stat"));
        zujian.title.setText((String)data.get(position).get("title"));
        return convertView;
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
