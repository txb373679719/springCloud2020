package com.txb.study.exception;

import com.cntaiping.tplife.ft.common.core.model.ResponseObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 自定义异常处理器
 * @create 2020-03-09 8:48
 **/
@RestControllerAdvice
public class DefaultExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseObj notFount(RuntimeException e)
    {
        log.error("运行时异常:", e);
        return ResponseObj.ERROR(e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseObj handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return ResponseObj.ERROR("系统异常请稍后再试!");
    }



    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseObj processValidationError(WebExchangeBindException ex) {
        log.info("url:{},method:{}",ex.getNestedPath(),ex.getMethodParameter());
        log.error(ex.getMessage(), ex);
        /*String result = ex
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));*/

        return ResponseObj.ERROR(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseObj processArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseObj.ERROR(ex.getMessage());
    }


}
