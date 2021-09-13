package com.rambo.excel;

import com.rambo.excel.ExcelColumn;
import lombok.Data;

import java.io.Serializable;

/**
 * @author BAIZHANSHI
 * @version 1.0.0
 * @description 测试注解导出Excel
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 3251965335162340137L;

    @ExcelColumn(isExport = true, title = "编号", sort = 2)
    private String id ;

    @ExcelColumn(isExport = true, title = "姓名", sort = 3)
    private String name;

    public Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Person(){

    }
}
