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
import com.example.administrator.stalkerpda.until.Global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2016/2/29.
 */
public class ContactAdapter extends BaseAdapter{
    private Zujian zujian;
    private List<Map<String,Object>> data;
    private Context context;
    private LayoutInflater layoutInflater;
    /* public ContactAdapter(Context context,List<Map<String,Object>> data) {
        this.data=data;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
    }*/

    public ContactAdapter(Context context,List<Contact> data) {
        this.data = getDataFromContacts(data);
        this.context=context;
        this.layoutInflater=LayoutInflater.from(this.context);
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

    /**
     * 获取条目总数
     * @return
     */
    @Override
    public int getCount() {
        return data.size();
    }



    /**
     * 绑定模板对象
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Zujian zujian=null;
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
        setValue(position);
        return convertView;
    }

    /**
     * 模板对象赋值
     * @param position
     */
    private void setValue(int position){
        zujian.head.setImageResource((Integer) data.get(position).get("head"));
        //zujian.head.setBackgroundResource((Integer) data.get(position).get("head"));
        zujian.lev.setText((String) data.get(position).get("lev"));
        zujian.og.setText((String) data.get(position).get("og"));
        zujian.sw.setText((String) data.get(position).get("sw"));
        zujian.stat.setText((String) data.get(position).get("stat"));
        zujian.title.setText((String) data.get(position).get("title"));
    }

    /**
     * 获取对象 index 值
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取指定位置对象
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    private List<Map<String, Object>> getDataFromContacts(List<Contact> list){
        List<Map<String, Object>> data = new ArrayList<>();
        for (Contact contact: list){
            Map<String, Object> map=new HashMap<String, Object>();

            String headIcon = contact.getHeadIcon();
            if ( headIcon.equalsIgnoreCase(Global.getUnkownProps()) ){
                map.put("head",R.mipmap.ic_launcher);
            }else {
                //map.put("head",getImage(headIcon));
                map.put("head",R.mipmap.ic_launcher);
            }

            String name = contact.getName();
            if ( name.equalsIgnoreCase(Global.getUnkownProps()) ){
                map.put("title","未知");
            }else {
                map.put("title",name);
            }

            String orgnization = contact.getOrgnization();
            if ( orgnization.equalsIgnoreCase(Global.getUnkownProps()) ){
                map.put("og","组织       未知");
            }else {
                map.put("og","组织       " + orgnization);
            }

            String shengWang = contact.getShengWang();
            if ( shengWang.equalsIgnoreCase(Global.getUnkownProps()) ){
                map.put("sw","声望       未知");
            }else {
                map.put("sw","声望       " + shengWang);
            }

            String statu = contact.getStatu();
            if ( statu.equalsIgnoreCase(Global.getUnkownProps()) ){
                map.put("stat","态度       中立");
            }else {
                map.put("stat","态度       " + statu);
            }

            String level = contact.getLevel();
            if ( level.equalsIgnoreCase(Global.getUnkownProps()) ){
                map.put("lev","阶级       士兵");
            }else {
                map.put("lev","阶级       " + level);
            }

            data.add(map);
        }
        return data;
    }
}
