package com.rambo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/22 11:26
 */
public class TestReflect {
    public static void main(String[] args) throws Exception {
        Class<User> clazz = User.class;
        Class<?> aClass = Class.forName("com.rambo.reflect.User");
        //获取有参构造
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        //获取该类对象并设置属性的值
        Object obj = constructor.newInstance("黎杜", 18);

        //获得类全类名，既包含包路径
        String fullClassName = clazz.getName();

        System.out.println("全类名:" + fullClassName);

        //获得类名
        String className = clazz.getSimpleName();

        System.out.println("类名:" + className);

        //获得类中公共类型（public）属性
        Field[] fields = clazz.getFields();
        String fieldName = "";
        for (Field field : fields) {
            // 获取属性名
            fieldName = field.getName();
            System.out.println("共有属性名：" + fieldName);
        }

        //获得类中全部类型属性(包括private)
        Field[] fieldsAll = clazz.getDeclaredFields();
        fieldName = "";
        for (Field field : fieldsAll) {
            // 获取属性名
            fieldName = field.getName();
            System.out.println("属性名：" + fieldName);
        }

        //获得指定公共属性值
//        Field age = clazz.getField("age");
//        Object value = age.get(obj);
//        System.err.println("公共指定属性：" + value);

        //获得指定的私有属性值
        Field name = clazz.getDeclaredField("name");
        //设置为true才能获取私有属性
        name.setAccessible(true);
        Object value2 = name.get(obj);
        System.err.println("私有指定属性值：" + value2);

        //获取所有公共类型方法   这里包括 Object 类的一些方法
        Method[] methods = clazz.getMethods();
        String methodsName = "";
        for (Method method : methods) {
            methodsName = method.getName();
            System.out.println("共有类型方法：" + methodsName);
        }

        //获取该类中的所有方法（包括private）
        Method[] methodsAll = clazz.getDeclaredMethods();
        methodsName = "";
        for (Method method : methodsAll) {
            methodsName = method.getName();
            System.out.println("类型方法：" + methodsName);
        }

        //获取并使用指定方法
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");//获取无参私有方法
        privateMethod.setAccessible(true);
        privateMethod.invoke(obj);//调用方法

        Method publicMethod = clazz.getMethod("publicMethod", String.class);//获取有参数方法
        publicMethod.invoke(obj, "黎杜");//调用有参方法
    }
}
