package com.tz.response;

import java.io.Serializable;

/**
 * 响应结果码枚举
 */
public enum ResultCode implements Serializable {


    /* 正常状态 */
    SUCCESS(100, "成功"),
    FAILURE(101, "失败"),
    UNKNOWN(102, "未知响应"),
    /**
     * 用户code范围: 200~300;
     */
    USER_ACCOUNT_NOT_FIND(201, "用户名不存在"),
    USER_ACCOUNT_DISABLED(202, "该用户已被禁用"),
    USER_PASSWORD_NOT_MATCH(203, "该用户密码不一致"),
    USER_PERMISSION_ERROR(204, "该用户不具备访问权限"),
    USER_STATE_OFF_LINE(205, "该用户未登录");

    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultCode queryCode(Integer code) {
        for (ResultCode value : values()) {
            if (code.equals(value.code)) {
                return value;
            }
        }
        return UNKNOWN;
    }


}
