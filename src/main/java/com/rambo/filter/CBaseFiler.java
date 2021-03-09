package com.rambo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/2 16:18
 */
@Component
@Order(1)
public class CBaseFiler implements BaseFilter {
    @Override
    public Boolean test() {
        System.out.println("请求C过滤器成功！");
        return true;
    }
}
