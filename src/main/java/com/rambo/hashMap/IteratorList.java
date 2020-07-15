package com.rambo.hashMap;

import java.util.List;

/**
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/10 17:54
 */
public class IteratorList {
    public static void main(String[] args) {

        List<String> list = new WhyArrayList();
        list.add("11");
        list.add("22");
//        list.removeIf(a->a.equals("11"));//推荐使用这种方式
        for (String s : list) {
            if(s.equals("22")){
                list.remove(s);
            }
        }
        System.out.println("remove list after=" + list);
    }
}
