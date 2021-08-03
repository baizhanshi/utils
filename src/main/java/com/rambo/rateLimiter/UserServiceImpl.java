package com.rambo.rateLimiter;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.rambo.reflect.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/8/3 18:11
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    //资源名称
    public static final String RESOURCE_NAME_QUERY_USER_BY_NAME = "queryByUserName";


    @Override
    @SentinelResource(value = RESOURCE_NAME_QUERY_USER_BY_NAME, blockHandler = "queryUserByUserNameBlock")
    public User queryByUserName(String userName) {
        User user = new User(userName, 12);
        log.info("资源被正常去请求：{}", user.toString());
        return user;
    }

    //注意细节，一定要跟原函数的返回值和形参一致，并且形参最后要加个BlockException参数
    //否则会报错，FlowException: null
    public User queryUserByUserNameBlock(String userName, BlockException ex) {
        //打印异常
        log.info("用户名：" + userName + "资源访问被限流");
        return new User("用户名：" + userName + "资源访问被限流", 0);
    }

}
