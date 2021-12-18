package com.rambo.api;

import lombok.Data;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/18 18:31
 */
@BankAPI(url = "/bank/createUser", desc = "创建用户接口")
@Data
public class CreateUserAPI extends AbstractAPI {

    @BankAPIField(order = 1, type = "S", length = 10)
    private String name;
    @BankAPIField(order = 2, type = "S", length = 18)
    private String identity;
    @BankAPIField(order = 4, type = "S", length = 11)
    private String mobile;
    @BankAPIField(order = 3, type = "N", length = 5)
    private int age;

    public CreateUserAPI(String name, String identity, String mobile, int age) {
        this.name = name;
        this.identity = identity;
        this.mobile = mobile;
        this.age = age;
    }
}
