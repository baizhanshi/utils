package com.rambo.enumTest;

import com.rambo.tools.EnumUtils;

/**
 * Created by baizhanshi on 2019/6/25.
 */
public class TestEnum {
    public static void main(String[] args) {
        //获取枚举值的code/value
        System.out.println(EnumUtils.mapByCode(BusinessTypeEnum.class));
        //根据特定值获取枚举
        System.out.println(EnumUtils.enumValueByCode(BusinessTypeEnum.class,"1"));
        //根据特定值获取枚举值对象
        System.out.println(EnumUtils.enumByCode(BusinessTypeEnum.class,"1"));
        //根据特定值获取枚举值对象
        System.out.println(EnumUtils.enumByValue(BusinessTypeEnum.class,"个险续保"));
        //根据特定值获取枚举值对象
        System.out.println(EnumUtils.enumByDesc(BusinessTypeEnum.class,"renewal"));
        //获取所有的code值集合
        System.out.println(EnumUtils.getCodeList(BusinessTypeEnum.class));
        //获取所有的value值集合
        System.out.println(EnumUtils.getValueList(BusinessTypeEnum.class));
    }
}
