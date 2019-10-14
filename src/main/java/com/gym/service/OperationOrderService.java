package com.gym.service;

import com.gym.model.order.AddOrderBean;
import org.springframework.stereotype.Component;

/**
 * business:处理订单逻辑层
 * Author:easy
 * Date:19/10/14 下午6:31
 */

@Component
public class OperationOrderService {

    public boolean addOrder(AddOrderBean orderBean) {

        return true;
    }
} 