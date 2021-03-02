package com.txb.study.test;

import com.txb.study.exception.BusinessException;

/**
 * @ Author txb
 * @ Date 2021/3/1 17:17
 * @ Description TODO
 */
public class DemoTestOne {
    public static void main(String[] args) {
        Long a = 1L;
        if(a==0L){
            System.out.println("equal");
        }else{
            throw new BusinessException("爱你爱你");
        }
    }
}
