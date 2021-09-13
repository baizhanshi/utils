package com.rambo.excel;

import lombok.Data;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/9/13 19:39
 */
@Data
public class Animal {
    private int id;
    private String name;
    private String sex;

    public Animal() {

    }

    public Animal(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
