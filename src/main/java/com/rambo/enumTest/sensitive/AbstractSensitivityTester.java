package com.rambo.enumTest.sensitive;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/4 12:01
 */
public abstract class AbstractSensitivityTester implements SensitivityTester {


    protected boolean test(String data) {
        //可以添加各个实现类共同的数据库查询逻辑，判断是否正确
        return true;
    }

}