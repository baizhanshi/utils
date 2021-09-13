package com.rambo.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author baizhanshi
 * @version 1.0.0
 * @description  导入导出时标注到字段上的注解
 */

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {

    /**
     * 当前字段是否导出Excel
     * true:导出; false:不导出
     * 默认为false
     */
    boolean isExport() default false;

    /**
     * 导出的标题
     */
    String title() default "";

    /**
     * 字段排序，升序
     */
    int sort() default 0;

}
