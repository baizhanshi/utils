package com.rambo.reflect;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/22 11:25
 */
@Builder
@JsonIgnoreProperties(value = "handler")
public class User{
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private void privateMethod() {
        System.err.println("privateMethod");
    }

    public void publicMethod(String param) {
        System.err.println("publicMethod" + param);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
