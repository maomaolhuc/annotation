package com.tz.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by slc on 2022/4/19 23:51
 */
@Data
public class Result<T> implements Serializable {

    private final int code;
    private final String message;
    private final T data;

    /**
     * 私有构造, 只允许通过static调用构造
     *
     * @param resultCode 结果枚举
     * @param data       响应数据
     */
    private Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 成功调用返回的结果(无数据携带)
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 成功调用返回的结果(数据携带)
     *
     * @return Result
     */
    public static <T> Result success(T data) {
        return new Result(ResultCode.SUCCESS, data);
    }

    /**
     * 失败调用返回的结果(数据携带)
     *
     * @param resultCode 状态枚举
     * @param data       携带的数据
     * @return Result
     */
    public static <T> Result failure(ResultCode resultCode, T data) {
        return new Result(resultCode, data);
    }

    /**
     * 失败调用返回的结果(无数据携带)
     *
     * @param resultCode 状态枚举
     * @return Result
     */
    public static Result failure(ResultCode resultCode) {
        return failure(resultCode, null);
    }


}
