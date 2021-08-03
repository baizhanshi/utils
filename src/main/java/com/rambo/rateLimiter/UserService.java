package com.rambo.rateLimiter;

import com.rambo.reflect.User;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/8/3 18:10
 */
public interface UserService {

    User queryByUserName(String userName);
}
