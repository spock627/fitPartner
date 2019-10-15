package com.gym.service;

import com.gym.dao.OrderDao;
import com.gym.model.order.AddOrderBean;
import com.gym.model.order.ReceiveOrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * business:处理订单逻辑层
 * Author:easy
 * Date:19/10/14 下午6:31
 */

@Service
public class OperationOrderService {

    @Autowired
    private OrderDao orderDao;

    public boolean addOrder(AddOrderBean orderBean) {

        orderDao.saveOrder(orderBean);
        return true;
    }

    public boolean receiveOrder(ReceiveOrderBean receiveOrderBean) {
        orderDao.updateOrder(receiveOrderBean);
        return true;
    }
} 