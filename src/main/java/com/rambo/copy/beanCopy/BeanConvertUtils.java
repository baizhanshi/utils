package com.rambo.copy.beanCopy;

/**
 * @author ：iyb-baizhanshi
 * @date ：Created in 2022/7/1 9:48
 */

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 转换对象工具
 *
 * @author bugpool
 */
public class BeanConvertUtils extends BeanUtils {

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier) {
        return convertTo(source, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param source         源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == source || null == targetSupplier) {
            return null;
        }

        T target = targetSupplier.get();
        copyProperties(source, target);
        if (callBack != null) {
            callBack.callBack(source, target);
        }
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) {
        return convertListTo(sources, targetSupplier, null);
    }

    /**
     * 转换对象
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, ConvertCallBack<S, T> callBack) {
        if (null == sources || null == targetSupplier) {
            return null;
        }

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T target = targetSupplier.get();
            copyProperties(source, target);
            if (callBack != null) {
                callBack.callBack(source, target);
            }
            list.add(target);
        }
        return list;
    }

    /**
     * 回调接口 公众号：Java精选
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface ConvertCallBack<S, T> {
        void callBack(S t, T s);
    }

    //vo转化
    // 使用后
//    public Vo findById(Integer id) {
//        return BeanConvertUtils.converTo(dao.findById(id), Vo::new);
//    }
//
//    // 使用后，通过lambda表达式特殊处理个别字段
//    public Vo findById(Integer id) {
//        return BeanConvertUtils.converTo(dao.findById(id), Vo::new,
//                (s, t) -> t.setName(s.getName))
//        );
//    }

    //调用方式
    // 使用后
//    public List<Vo> findAll() {
//        return BeanConvertUtils.converToList(dao.findAll(), Vo::new);
//    }
//
//    // 同样支持自定义lambda
//    public List<Vo> findAll() {
//        return BeanConvertUtils.converToList(dao.findAll(), Vo::new,
//                (s, t) -> t.setName(s.getName));
//        )
//    }
}