package com.rambo.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/2 16:18
 */
@Component
@Order(0)
public class ABaseFiler implements BaseFilter {
    @Override
    public Boolean test() {
        System.out.println("请求A过滤器成功！");
        return true;
    }
}
