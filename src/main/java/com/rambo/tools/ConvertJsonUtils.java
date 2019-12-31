package com.rambo.tools;

/**
 * Created by baizhanshi on 2019/5/17.
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换json工具类
 * 
 * @author Andy
 */
public class ConvertJsonUtils {

    /**
     * 将java对象转换为json格式的字符串
     * 
     * @param object 带转换的对象
     * @return json格式的字符串
     */
    public static String toJsonString(Object object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * 默认日期
     * 
     * @param object
     * @return
     */
    public static String toJsonWithDefaultDateFormatString(Object object) {
        return toJsonWithDateString(object, "yyyy-MM-DD hh:mm:ss");
    }

    /**
     * 带有日期格式的json格式字符串转换
     * 
     * @param object
     * @param format
     * @return
     */
    public static String toJsonWithDateString(Object object, String format) {
        return JSONObject.toJSONStringWithDateFormat(object, format, SerializerFeature.PrettyFormat);
    }

    /**
     * 将对象转换为json格式字符串(包括子类的,与toJsonString具体区别可以参考自定义菜单)
     * 
     * @param object
     * @return
     */
    public static String toJSONAndChildStr(Object object) {
        return JSONObject.toJSON(object).toString();
    }

    /**
     * 将json格式的数据转换为java对象(不包括数组,集合类型)
     * 
     * @param <T>
     * @param jsonData json格式的字符串
     * @param t 待转换成的java对象
     * @return
     */
    public static <T> T jsonToJavaObject(String jsonData, Class<T> t) {
        return JSONObject.parseObject(jsonData, t);
    }

    /**
     * 将json格式的数据转换为java集合对象 ,List集合,map集合
     * 
     * @param jsonData 待转换的json格式的字符串
     * @param t 泛型集合对象
     * @return
     */
    public static <T> List<T> jsonToJavaList(String jsonData, Class<T> t) {
        return JSONObject.parseArray(jsonData, t);
    }

    /**
     * 获取json格式数据中的键,将其中的值作为转换为List中的数据
     * 
     * @param jsonData json格式的数据
     * @param t 待转换的类型
     * @param key json格式中的指定的键
     * @return list集合 示列：
     */
    public static <T> List<T> jsonToJavaListByKey(String jsonData, Class<T> t, String key) {
        List<T> result = new ArrayList<T>();
        JSONObject obj = JSONObject.parseObject(jsonData);
        if (null != obj) {
            if (obj.containsKey(key)) {
                jsonData = obj.getString(key);
                result = new ArrayList<T>();
                result = JSONObject.parseArray(jsonData, t);
            }
        }
        return result;
    }
}
