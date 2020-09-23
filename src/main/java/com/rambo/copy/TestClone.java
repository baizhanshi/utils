package com.rambo.copy;

/**
 * 浅拷贝测试用例
 * 值类型的字段会复制一份（比如年龄），而引用类型的字段拷贝的仅仅是引用地址，而该引用地址指向的实际对象空间其实只有一份。
 * @author ：baizhanshi
 * @date ：Created in 2020/9/23 15:01
 */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {

        Major m = new Major("计算机科学与技术", 666666);
        Student student1 = new Student("CodeSheep", 18, m);

        // 由 student1 拷贝得到 student2
        Student student2 = (Student) student1.clone();

        System.out.println(student1 == student2);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println("\n");

        // 修改student1的值类型字段
        student1.setAge(35);

        // 修改student1的引用类型字段
        m.setMajorName("电子信息工程");
        m.setMajorId(888888);

        System.out.println(student1);
        System.out.println(student2);

    }
}
