package com.rambo.copy;

import lombok.Data;

/**
 * 浅拷贝
 * @author ：baizhanshi
 * @date ：Created in 2020/9/23 15:01
 */
@Data
public class Student implements Cloneable {

    private String name;  // 姓名
    private int    age;   // 年龄
    private Major  major; // 所学专业

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Student(String name, int age, Major major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }
}
