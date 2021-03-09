package com.rambo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/2 16:18
 */
@Component
@Order(2)
public class DBaseFiler implements BaseFilter {
    @Override
    public Boolean test() {
        System.out.println("请求D过滤器成功！");
        return false;
    }
}
