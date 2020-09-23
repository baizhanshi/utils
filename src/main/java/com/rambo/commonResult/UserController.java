package com.rambo.commonResult;

import com.google.common.collect.Lists;
import com.rambo.reflect.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/9/21 15:26
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/getResult")
    public List<User> getUserList() {
        List<User> userVoList = Lists.newArrayListWithCapacity(2);
        userVoList.add(User.builder().name("baizhanshi").age(18).build());
        userVoList.add(User.builder().name("tan").age(19).build());
        return userVoList;
    }
}
