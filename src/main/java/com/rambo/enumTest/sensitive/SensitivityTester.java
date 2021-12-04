package com.rambo.enumTest.sensitive;

/**
 * @author ：baizhanshi
 * @SensitivityTest(tester = PhoneSensitivityTester.class)
 * 以上是具体的使用逻辑，加在方法上
 * @date ：Created in 2021/12/4 12:01
 */
public interface SensitivityTester {

    String test(Object... params);
}
