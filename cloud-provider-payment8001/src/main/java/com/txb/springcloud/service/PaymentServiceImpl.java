package com.txb.springcloud.service;

import com.txb.springcloud.dao.PaymentDao;
import com.txb.springcloud.entities.Payment;
import com.txb.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ Author txb
 * @ Date 2020/7/9 11:05
 * @ Description TODO
 */
@Service
public class PaymentServiceImpl  implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
