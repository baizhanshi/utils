package com.rambo.enumTest.sensitive;

import com.rambo.copy.Student;
import com.rambo.exceptions.BizException;
import org.apache.commons.lang.StringUtils;

/**
 * 具体实现类，可以有多个
 * @author ：baizhanshi
 * @date ：Created in 2021/12/4 12:03
 */
public class PhoneSensitivityTester extends AbstractSensitivityTester {

    @Override
    public String test(Object... params) {
        if (this.test(((Student) params[0]).getName())) {
            throw new BizException("异常!");
        }
        return StringUtils.EMPTY;
    }
}