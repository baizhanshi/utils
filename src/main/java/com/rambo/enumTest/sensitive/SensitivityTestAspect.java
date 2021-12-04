package com.rambo.enumTest.sensitive;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/4 12:00
 */
@Slf4j
@Aspect
@Component
public class SensitivityTestAspect {

    @Autowired
    private BeanFactory beanFactory;

    @Pointcut("@annotation(com.rambo.enumTest.sensitive.SensitivityTest)")
    public void sensitivityTestMethod() {

    }

    @Before("sensitivityTestMethod()")
    public void doBefore(JoinPoint joinPoint) {
        this.testSensitivity(joinPoint);
    }

    private void testSensitivity(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SensitivityTest test = methodSignature.getMethod().getAnnotation(SensitivityTest.class);
        SensitivityTester tester = beanFactory.getBean(test.tester());
        // invoke tester method
        if (tester != null) {
            tester.test(joinPoint.getArgs());
        } else {
            log.warn("tester missing... class={}", test.tester());
        }
    }
}
