package com.rambo.hashCodeAndEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/5/20 10:50
 */
public class TestHashCodeAndEquals {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAddr("1111");
        s1.setAge("20");
        s1.setName("allan");
        s1.setSex("male");
        s1.setWeight(60f);
        Student s2 = new Student();
        s2.setAddr("222");
        s2.setAge("20");
        s2.setName("allan");
        s2.setSex("male");
        s2.setWeight(70f);
        if (s1.equals(s2)) {
            System.out.println("s1==s2");
        } else {
            System.out.println("s1 != s2");
        }
//没重写hashCode 输出连个对象
// [Student(name=allan, sex=male, age=20, weight=60.0, addr=1111), Student(name=allan, sex=male, age=20, weight=70.0, addr=222)]
//重写了hashCode 只会输出一个对象[Student(name=allan, sex=male, age=20, weight=60.0, addr=1111)]
        Set set = new HashSet();
        set.add(s1);
        set.add(s2);
        System.out.println(set);

        Map m = new HashMap();
        m.put(s1, s1);
        m.put(s2, s2);
        System.out.println(m);
        System.out.println(((Student)m.get(s1)).getAddr());
    }
}
