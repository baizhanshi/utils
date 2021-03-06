package com.rambo.enumTest;

import com.google.common.collect.Lists;
import com.rambo.enumTest.BaseEnum;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baizhanshi
 */
public final class EnumUtils {

    private EnumUtils() {
    }

    /**
     * 返回指定编码的'枚举'
     */
    @SuppressWarnings("rawtypes")
    public static <C, T extends BaseEnum> T enumByCode(@NonNull Class<T> clazz, C code) {
        if (code == null) {
            return null;
        }
        for (T _enum : clazz.getEnumConstants())
            if (code.equals(_enum.getCode())) {
                return _enum;
            }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public static <C, T extends BaseEnum> Object enumValueByCode(@NonNull Class<T> clazz, C code) {
        if (code == null) {
            return null;
        }
        for (T _enum : clazz.getEnumConstants())
            if (code.equals(_enum.getCode())) {
                return _enum.getValue();
            }
        return null;
    }

    /**
     * 返回指定名称的'枚举'
     */
    @SuppressWarnings("rawtypes")
    public static <V, T extends BaseEnum> T enumByValue(@NonNull Class<T> clazz, V value) {
        if (value == null) {
            return null;
        }
        for (T _enum : clazz.getEnumConstants())
            if (value.equals(_enum.getValue())) {
                return _enum;
            }
        return null;
    }

    /**
     * 返回指定描述的'枚举'
     */
    @SuppressWarnings("rawtypes")
    public static <D, T extends BaseEnum> T enumByDesc(@NonNull Class<T> clazz, D desc) {
        if (desc == null) {
            return null;
        }
        for (T _enum : clazz.getEnumConstants())
            if (desc.equals(_enum.getDesc())) {
                return _enum;
            }
        return null;
    }

    /**
     * 返回指定枚举的code/value键值对
     *
     * @param clazz
     * @return
     */
    public static <C, V, T extends BaseEnum<C, V, ?>> Map<C, V> mapByCode(@NonNull Class<T> clazz) {
        Map<C, V> enumMap = new HashMap<>(clazz.getEnumConstants().length);
        for (T _enum : clazz.getEnumConstants()) {
            if (_enum.getCode() != null) {
                enumMap.put(_enum.getCode(), _enum.getValue());
            }
        }
        return enumMap;
    }

    /**
     * 返回所有枚举的key值集合
     *
     * @param clazz
     * @return
     */
    public static <C, T extends BaseEnum<C, ?, ?>> List<C> getCodeList(@NonNull Class<T> clazz) {
        List<C> codeList = Lists.newArrayList();
        for (T _enum : clazz.getEnumConstants()) {
            if (_enum.getCode() != null) {
                codeList.add(_enum.getCode());
            }
        }
        return codeList;
    }

    /**
     * 返回所有枚举的value值集合
     *
     * @param clazz
     * @return
     */
    public static <V, T extends BaseEnum<?, V, ?>> List<V> getValueList(@NonNull Class<T> clazz) {
        List<V> valueList = Lists.newArrayList();
        for (T _enum : clazz.getEnumConstants()) {
            if (_enum.getValue() != null) {
                valueList.add(_enum.getValue());
            }
        }
        return valueList;
    }
}
