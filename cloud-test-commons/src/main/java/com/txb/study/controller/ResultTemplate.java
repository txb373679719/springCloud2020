package com.txb.study.controller;


import com.txb.springcloud.entities.CommonResult;
import com.txb.study.constants.HttpCode;

import java.io.Serializable;

/**
 * @ Author txb
 * @ Date 2021/3/1 17:32
 * @ Description 自定义返回页面结果
 */
public class ResultTemplate<T> implements Serializable {

    private static final long serialVersionUID = -669633312320552296L;

    /**
     * 返回成功，用于新增、编辑、删除操作
     * @param msg
     * @return
     */
    public static <T> CommonResult<T> success(String msg) {
        CommonResult <T>  result = new CommonResult<T>();
        result.setCode(HttpCode.CODE_200);
        result.setMessage(msg);
        return result;
    }

    /**
     * 返回成功，用于查询
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> successData(T data, String msg) {
        CommonResult result = new CommonResult<>();
        result.setCode(HttpCode.CODE_200);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }


    /**
     * 返回成功，用于新增、编辑、删除操作
     * @param msg
     * @return
     */
    public static <T> CommonResult<T> fail(String msg) {
        CommonResult <T>  result = new CommonResult<T>();
        result.setCode(HttpCode.CODE_500);
        result.setMessage(msg);
        return result;
    }

    public static <T> CommonResult<T> error(Integer code, String msg) {
        CommonResult <T>  result = new CommonResult<T>();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
