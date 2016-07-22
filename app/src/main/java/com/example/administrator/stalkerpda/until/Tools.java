package com.example.administrator.stalkerpda.until;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/18.
 */
public class Tools {
    /**
     * 从Map中取出 所需KEY的值
     * @param params
     * @param key
     * @return
     */
    public static String getValueFromMap(Map<String,String> params, String key){
        String rt = Global.getUnkownProps();
        if (params.containsKey(key)){
            rt = params.get(key).toString();
        }
        return rt;
    }

    public static boolean isUsefulString(String str){
        if ( str == null ){
            return false;
        }else if ( str.equals("") ) {
            return false;
        }else {
            return true;
        }
    }
}
