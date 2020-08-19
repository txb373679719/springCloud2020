package com.txb.springcloud.dao;

import com.txb.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author txb
 * @ Date 2020/7/9 11:07
 * @ Description TODO
 */
@Mapper
public interface  PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById2(@Param("id") Long id);
}
