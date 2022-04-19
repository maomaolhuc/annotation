package com.tz.controller;

import com.tz.annotation.MyLog;
import com.tz.response.ResponseResult;
import com.tz.response.Result;
import com.tz.response.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by slc on 2022/4/19 23:55
 */

@RestController
public class TestController {

    @MyLog
    @ResponseResult
    @RequestMapping("/add")
    public Result add(){
        return Result.success("yes");
    }


    @RequestMapping("/del")
    @ResponseResult
    public Object del(){
        return 201;
    }

    @RequestMapping("/upd")
    @ResponseResult
    public Object upd(){
        return ResultCode.USER_ACCOUNT_NOT_FIND;
    }


    @RequestMapping("/list")
    @ResponseResult
    public Object list(){
        return Result.success("yes");
    }



}
