package com.txb.springcloud.service;

import com.txb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author txb
 * @ Date 2020/7/9 11:04
 * @ Description 接口
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById2(@Param("id") Long id);
}
