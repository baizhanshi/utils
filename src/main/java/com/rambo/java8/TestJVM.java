package com.rambo.java8;

import java.util.*;

/**
 * 发生内存泄漏
 * Created by baizhanshi on 2019/5/24.
 */
public class TestJVM {
    public static void main(String[] args) {

        List<MyObject> objects = new ArrayList<>();

        while (true) {
            objects.add(new MyObject());
        }
    }
}

class MyObject {
    //设置默认数组长度为99999更快的发生OutOfMemoryError
    List<String> list = new ArrayList<>(99999);
}
