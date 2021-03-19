package com.rambo.enumByMyself;

import java.lang.annotation.*;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/3/19 14:24
 */
@Target(value = ElementType.METHOD)
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
public @interface LogApi {

}
