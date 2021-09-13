package com.rambo.excel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author baizhanshi
 * @version 1.0.0
 * @description 解析Annotation
 */
public class ExcelAnnotationParser {

    private static final String SERIALVERSIONUID_FIELD = "serialVersionUID";

    /**
     * 解析带有@ExcelColumn注解的类
     *
     * @param clazz 类的字节码
     * @param <T>   泛型类型
     * @return 排序好的AnnotationFieldPojo List集合
     */
    public static <T> List<AnnotationDTO> parseExcelColumnAnnotation(Class<T> clazz) {
        return parseAnnotation(clazz, ExcelColumn.class);
    }

    /**
     * 解析类上的注解信息
     *
     * @param clazz 类的字节码
     * @param <T>   泛型类型
     * @return 排序好的AnnotationFieldPojo List集合
     */
    public static <T> List<AnnotationDTO> parseAnnotation(Class<T> clazz, Class<ExcelColumn> annotationClass) {
        List<AnnotationDTO> list = parseSingleClassAnnotation(clazz, annotationClass);
        clazz = (Class<T>) clazz.getSuperclass();
        while (clazz != null) {
            list.addAll(parseSingleClassAnnotation(clazz, annotationClass));
            clazz = (Class<T>) clazz.getSuperclass();
        }
        //将List按照Sort升序排列
        return list.stream().sorted(Comparator.comparing(AnnotationDTO::getSort)).collect(Collectors.toList());
    }

    /**
     * 解析一个类中的所有字段
     *
     * @param clazz           类的字节码
     * @param annotationClass 注解
     * @param <T>             泛型类
     */
    private static <T> List<AnnotationDTO> parseSingleClassAnnotation(Class<T> clazz, Class<ExcelColumn> annotationClass) {
        List<AnnotationDTO> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        if (!ObjectUtils.isEmpty(fields)) {
            if (annotationClass != null) {
                for (Field field : fields) {
                    String fieldName = field.getName();
                    if (SERIALVERSIONUID_FIELD.equals(fieldName)) {
                        continue;
                    }
                    //注解class不为空
                    if (field.isAnnotationPresent(annotationClass)) {
                        ExcelColumn column = field.getAnnotation(annotationClass);
                        //设置为导出
                        if (column.isExport()) {
                            AnnotationDTO dto = new AnnotationDTO();
                            dto.setField(field);
                            dto.setTitle(column.title());
                            dto.setSort(column.sort());
                            list.add(dto);
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     * @param clazz 解析存在指定注解的字段
     * @param <T>   泛型
     * @return Field的List集合
     */
    public static <T> List<Field> parseField(Class<T> clazz, Class<? extends Annotation> annotationClass) {
        List<Field> list = parseSingleClassField(clazz, annotationClass);
        clazz = (Class<T>) clazz.getSuperclass();
        while (clazz != null) {
            list.addAll(parseSingleClassField(clazz, annotationClass));
            clazz = (Class<T>) clazz.getSuperclass();
        }
        return list;
    }

    /**
     * 解析一个类中的所有字段
     *
     * @param clazz           类的字节码
     * @param annotationClass 注解
     * @param <T>             泛型类
     */
    private static <T> List<Field> parseSingleClassField(Class<T> clazz, Class<? extends Annotation> annotationClass) {
        List<Field> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        if (!ObjectUtils.isEmpty(fields)) {
            //注解class不为空
            if (annotationClass != null) {
                for (Field field : fields) {
                    String fieldName = field.getName();
                    if (SERIALVERSIONUID_FIELD.equals(fieldName)) {
                        continue;
                    }
                    if (field.isAnnotationPresent(annotationClass)) {
                        list.add(field);
                    }
                }
            } else {
                for (Field field : fields) {
                    String fieldName = field.getName();
                    if (SERIALVERSIONUID_FIELD.equals(fieldName)) {
                        continue;
                    }
                    //注解class不为空
                    list.add(field);
                }
            }
        }
        return list;
    }


    /**
     * 解析类中的所有字段
     *
     * @param clazz 类的字节码
     * @param <T>   泛型类型
     * @return Field的List集合
     */
    public static <T> List<Field> parseAllField(Class<T> clazz) {
        return parseField(clazz, null);
    }

    public static void main(String[] args) {
        List<AnnotationDTO> list = parseExcelColumnAnnotation(AnnotationDTO.class);
        for (AnnotationDTO dto : list) {
            System.out.println(dto);
        }
    }
}
