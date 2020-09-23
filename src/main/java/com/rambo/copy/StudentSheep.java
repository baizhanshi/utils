package com.rambo.copy;

import lombok.Data;

/**
 * 深拷贝
 * @author ：baizhanshi
 * @date ：Created in 2020/9/23 15:01
 */
@Data
public class StudentSheep implements Cloneable {

    private String name;  // 姓名
    private int    age;   // 年龄
    private MajorSheep  majorSheep; // 所学专业

    @Override
    public Object clone() throws CloneNotSupportedException {
        StudentSheep student = (StudentSheep) super.clone();
        student.majorSheep = (MajorSheep) majorSheep.clone(); // 重要！！！
        return student;
    }

    public StudentSheep(String name, int age, MajorSheep majorSheep) {
        this.name = name;
        this.age = age;
        this.majorSheep = majorSheep;
    }
}
