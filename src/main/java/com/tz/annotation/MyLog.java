package com.tz.annotation;

import java.lang.annotation.*;

/**
 * Created by slc on 2022/4/20 0:06
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

}
