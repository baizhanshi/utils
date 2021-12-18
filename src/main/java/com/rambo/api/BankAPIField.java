package com.rambo.api;

import java.lang.annotation.*;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/18 18:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {
    int order() default -1;

    int length() default -1;

    String type() default "";
}
