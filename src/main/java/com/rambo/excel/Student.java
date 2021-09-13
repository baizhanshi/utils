package com.rambo.excel;

import com.rambo.excel.ExcelColumn;
import lombok.Data;

/**
 * @author BAIZHANSHI
 * @version 1.0.0
 * @description 注解学生类
 */
@Data
public class Student extends Person{
    private static final long serialVersionUID = -6180523202831503132L;

    @ExcelColumn(isExport = true, title = "班级编号", sort = 1)
    private String classNo;

    private Integer score;

    @ExcelColumn(isExport = true, title = "爱好", sort = 4)
    private String hobby;

    public Student(String id, String name, String classNo, Integer score, String hobby){
        super(id, name);
        this.classNo = classNo;
        this.score = score;
        this.hobby = hobby;
    }

    public Student(){

    }
}