package com.rambo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/2 16:22
 */
@Slf4j
@RestController
@RequestMapping(value = "/filter")
public class BaseFilterController {

    @Resource
    private List<BaseFilter> baseFilterList;

    @RequestMapping(value = "/testFilter", method = RequestMethod.GET)
    public void testFilter() {
        Stream<Boolean> test = baseFilterList.stream().map(filter -> {
            return filter.test();
        });
        test.forEach(a -> {
            System.out.println("有成功的过滤器" + a);
        });
    }

}
