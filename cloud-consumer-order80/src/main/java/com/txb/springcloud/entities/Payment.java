package com.txb.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author txb
 * @ Date 2020/7/9 11:03
 * @ Description TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    private  Long id;
    private  String serial;
}
