package com.rambo.rateLimiter;

import com.rambo.reflect.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/8/3 18:09
 */
@RestController
@RequestMapping("/user")
public class SentinelController {

    @Resource
    private UserService userService;

    @RequestMapping("/queryByUserName/{userName}")
    public User queryByUserName(@PathVariable(name = "userName") String userName) {
        return userService.queryByUserName(userName);
    }
}
