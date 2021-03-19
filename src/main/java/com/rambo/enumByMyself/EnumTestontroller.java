package com.rambo.enumByMyself;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/2 16:22
 */
@Slf4j
@RestController
@RequestMapping(value = "/enum")
public class EnumTestontroller {

    @LogApi
    @RequestMapping(value = "/get/{id}/{sex}", method = RequestMethod.GET)
    public String testEnum(@PathVariable(name = "id") String id,@PathVariable(name = "sex") String sex) {
        HashMap<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("sex", sex);
        user.put("name", "关之琳");
        user.put("经典角色", "十三姨");
        return JSON.toJSONString(user);
    }

}
