package com.rambo.java8;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author baizhanshi on 2018/11/1.
 */
@Data
public class Apple {
    private Integer    id;
    private String     name;
    private BigDecimal money;
    private Integer    num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Apple(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
