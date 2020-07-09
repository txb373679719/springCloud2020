package com.txb.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author txb
 * @ Date 2020/7/9 13:50
 * @ Description 封装公共返回参数
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public  CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
