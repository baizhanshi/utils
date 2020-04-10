package com.rambo.threadUtil;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 *
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/4/8 9:56
 */
public class ListParttition {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
        ListUtils.partition(list,4).forEach(aa-> {
            System.out.println(aa);
        });
    }
}
