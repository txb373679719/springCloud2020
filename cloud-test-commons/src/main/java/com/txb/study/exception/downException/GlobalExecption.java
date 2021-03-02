package com.txb.study.exception.downException;

import com.txb.study.constants.HttpCode;

/**
 * @ Author txb
 * @ Date 2021/3/1 17:24
 * @ Description TODO
 */
public class GlobalExecption extends RuntimeException{
    private static final long serialVersionUID = 4453214753962022203L;
    private Integer code;
    private String msg;

    public GlobalExecption() {}

    public GlobalExecption(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public GlobalExecption(String msg) {
        super(msg);
        this.msg = msg;
    }

    public GlobalExecption(String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
    }

    public GlobalExecption(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
        this.msg = msg;
    }

    public static GlobalExecption paramException(String message) {
        GlobalExecption baseExecption = new GlobalExecption(HttpCode.CODE_400, message);
        return baseExecption;
    }

    public static GlobalExecption serverErrException(String message) {
        return new GlobalExecption(HttpCode.CODE_500, message);
    }

    public static GlobalExecption serverErrException(String message, Exception e) {
        return new GlobalExecption(HttpCode.CODE_500, message, e);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

