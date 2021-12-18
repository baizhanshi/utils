package com.rambo.api;

import java.lang.annotation.*;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/18 18:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface BankAPI {
    String desc() default "";

    String url() default "";
}
