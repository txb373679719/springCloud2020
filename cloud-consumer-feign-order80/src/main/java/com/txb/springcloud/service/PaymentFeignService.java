package com.txb.springcloud.service;

import com.txb.springcloud.entities.CommonResult;
import com.txb.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ Author txb
 * @ Date 2020/8/26 16:33
 * @ Description
 * 根据 http调用方式原则，对外暴露的接口地址是: http://localhost:80/consumerFeign/payment/get/31
 * 找到了下面的方法，然后在找到对应服务 CLOUD-PAYMENT-SERVICE
 * 去轮询找到 payment8001或者payment8002项目中的/payment/get/{id}方法
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
