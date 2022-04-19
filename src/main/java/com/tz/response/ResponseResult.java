package com.tz.response;

import java.lang.annotation.*;

/**
 * Created by slc on 2022/4/19 23:52
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD})
public @interface ResponseResult {

}
