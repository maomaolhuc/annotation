package com.tz.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by slc on 2022/4/19 23:53
 */
//响应增强类
@RestControllerAdvice
public class ResponseParse implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //返回值决定他是否需要进入beforeBodyWrite
        return returnType.getMethod().isAnnotationPresent(ResponseResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //更改返回值
        if (body == null) {
            return Result.success();
        }
        if (body instanceof Integer) {
            return Result.failure(ResultCode.queryCode((Integer) body));
        }
        if (body instanceof ResultCode) {
            return Result.failure((ResultCode) body);
        }
        if (body instanceof Result) {
            return body;
        }
        return null;

    }
}
