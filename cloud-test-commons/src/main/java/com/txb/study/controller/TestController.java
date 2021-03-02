package com.txb.study.controller;

import com.txb.springcloud.entities.CommonResult;
import com.txb.study.constants.HttpCode;
import com.txb.study.exception.downException.GlobalExecption;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @ Author txb
 * @ Date 2021/3/1 17:33
 * @ Description TODO
 */
public class TestController {

    @PostMapping("/queryAll")
//    @LogByMethod(remark = "查询所有人", editType = EditTypeEnum.QUERY)
    public CommonResult queryAll(@RequestBody Map<String, String> map) {
        if (true) {
            throw GlobalExecption.serverErrException("测试异常处理");
        }
//        threadService.queryAll();
        return ResultTemplate.success(HttpCode.CODE_200_MSG);
    }
}
