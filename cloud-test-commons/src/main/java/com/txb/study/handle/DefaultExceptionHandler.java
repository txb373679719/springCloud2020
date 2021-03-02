package com.txb.study.handle;

/**
 * @ Author txb
 * @ Date 2021/3/1 17:31
 * @ Description  异常统一处理
 */

import com.txb.springcloud.entities.CommonResult;
import com.txb.study.constants.HttpCode;
import com.txb.study.controller.ResultTemplate;
import com.txb.study.exception.downException.GlobalExecption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理
 */
@RestControllerAdvice
public class DefaultExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public CommonResult serverError(Exception e) {
        String errMsg = "";
        if (e instanceof NullPointerException) {
            errMsg = "发生空指针异常";
        } else if (e instanceof RuntimeException) {
            errMsg = "发生运行时异常";
        } else {
            errMsg = "发生未知异常";
        }
        logger.error("############" + errMsg + "############", e);
        return ResultTemplate.error(HttpCode.CODE_500, errMsg);
    }

    @ExceptionHandler(value = GlobalExecption.class)
    public CommonResult<Object> paramError(GlobalExecption e) {
        logger.info("############" + e.getMsg() + "############");
        return ResultTemplate.error(e.getCode(), e.getMsg());
    }

}