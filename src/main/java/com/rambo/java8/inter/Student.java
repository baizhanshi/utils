package com.rambo.java8.inter;

import lombok.Data;

/**
 * Created by baizhanshi on 2019/6/13.
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;

    public Student(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
