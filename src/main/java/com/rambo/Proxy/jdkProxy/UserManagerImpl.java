package com.rambo.Proxy.jdkProxy;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/8 17:23
 */
public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userId, String userName) {
        System.out.println(userId + "-----proxy add user test123-----" + userName);
    }
}
