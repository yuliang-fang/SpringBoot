package com.fang.springboot_demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 对象和String互转
 */
public class jsonUtils {

    private static ObjectMapper objectMapper=new ObjectMapper();

    public static <T> String obj2String(T obj){
        if(obj==null){
            return null;
        }
        try{
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
