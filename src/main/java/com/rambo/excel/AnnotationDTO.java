package com.rambo.excel;

import lombok.Data;
import java.lang.reflect.Field;

/**
 * @author baizhanshi
 * @version 1.0.0
 * @description 通过解析Annotation得出的信息
 */
@Data
public class AnnotationDTO {
    /**
     * 标题
     */
    private String title = "";

    /**
     * 排序值，升序
     */
    private int sort = 0;

    /**
     * 当前字段
     */
    private Field field;

}
