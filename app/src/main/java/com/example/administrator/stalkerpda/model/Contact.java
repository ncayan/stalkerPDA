package com.example.administrator.stalkerpda.model;

import com.example.administrator.stalkerpda.until.Global;
import com.example.administrator.stalkerpda.until.Tools;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Contact {
    private String name;
    private String phoneNum;
    private String statu;
    private String level;
    private String orgnization;
    private String shengWang;

    public Contact(){
        this.name = Global.getUnkownProps();
        this.phoneNum = Global.getUnkownProps();
        this.statu = Global.getUnkownProps();
        this.shengWang = Global.getUnkownProps();
        this.level = Global.getUnkownProps();
        this.orgnization = Global.getUnkownProps();
    }

    public Contact(String name){
        this.name = name;
        this.phoneNum = Global.getUnkownProps();
        this.statu = Global.getUnkownProps();
        this.shengWang = Global.getUnkownProps();
        this.level = Global.getUnkownProps();
        this.orgnization = Global.getUnkownProps();
    }

    public Contact(String name, String phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
        this.statu = Global.getUnkownProps();
        this.shengWang = Global.getUnkownProps();
        this.level = Global.getUnkownProps();
        this.orgnization = Global.getUnkownProps();
    }

    public Contact(Map<String,String> params){
        this.name = Tools.getValueFromMap(params, "name");
        this.phoneNum = Tools.getValueFromMap(params, "phoneNum");
        this.statu = Tools.getValueFromMap(params, "statu");
        this.shengWang = Tools.getValueFromMap(params, "shengWang");
        this.level = Tools.getValueFromMap(params, "level");
        this.orgnization = Tools.getValueFromMap(params, "orgnization");
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOrgnization() {
        return orgnization;
    }

    public void setOrgnization(String orgnization) {
        this.orgnization = orgnization;
    }

    public String getShengWang() {
        return shengWang;
    }

    public void setShengWang(String shengWang) {
        this.shengWang = shengWang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
