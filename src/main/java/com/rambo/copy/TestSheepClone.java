package com.rambo.copy;

/**
 * 深拷贝相较于上面所示的浅拷贝，除了值类型字段会复制一份，引用类型字段所指向的对象，会在内存中也创建一个副本
 * 
 * @author ：baizhanshi
 * @date ：Created in 2020/9/23 15:01
 */
public class TestSheepClone {
    public static void main(String[] args) throws CloneNotSupportedException {

        MajorSheep m = new MajorSheep("计算机科学与技术", 666666);
        StudentSheep student1 = new StudentSheep("CodeSheep", 18, m);

        // 由 student1 拷贝得到 student2
        StudentSheep student2 = (StudentSheep) student1.clone();

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
