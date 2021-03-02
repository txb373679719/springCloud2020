package com.txb.study.handle;

import com.txb.springcloud.entities.CommonResult;
import com.txb.study.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @ Author txb
 * @ Date 2021/3/1 16:56
 * @ Description TODO
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static int DUPLICATE_KEY_CODE = 1001;
    private static int PARAM_FAIL_CODE = 1002;
    private static int VALIDATION_CODE = 1003;
    private static int CUSTOMER_DECIDE_CODE = 1000;

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public CommonResult handleRRException(BusinessException e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(CUSTOMER_DECIDE_CODE,e.getMessage());
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(PARAM_FAIL_CODE, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public CommonResult handleValidationException(ValidationException e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(VALIDATION_CODE, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public CommonResult handleConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(PARAM_FAIL_CODE, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(404, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public CommonResult handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(DUPLICATE_KEY_CODE, "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return new CommonResult(500, "系统繁忙,请稍后再试");
    }
}
