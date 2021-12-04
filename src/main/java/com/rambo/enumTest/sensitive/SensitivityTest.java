package com.rambo.enumTest.sensitive;


import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/4 12:00
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
@Inherited
public @interface SensitivityTest {

    Class<? extends SensitivityTester> tester();

}