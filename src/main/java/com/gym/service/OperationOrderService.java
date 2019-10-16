package com.gym.service;

import com.gym.dao.GymDao;
import com.gym.dao.OrderDao;
import com.gym.model.gym.GymBean;
import com.gym.model.order.AddOrderBean;
import com.gym.model.order.GymOrderListResponseBean;
import com.gym.model.order.OrderBean;
import com.gym.model.order.ReceiveOrderBean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * business:处理订单逻辑层
 * Author:easy
 * Date:19/10/14 下午6:31
 */

@Service
@Log4j2
public class OperationOrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GymDao gymDao;

    /**
     * 添加订单
     * @param orderBean
     * @return
     */
    public boolean addOrder(AddOrderBean orderBean) {
        log.info(orderBean.toString());
        orderDao.saveOrder(orderBean);
        return true;
    }

    /**
     * 接受订单
     * @param receiveOrderBean
     * @return
     */
    public boolean receiveOrder(ReceiveOrderBean receiveOrderBean) {
        orderDao.updateOrder(receiveOrderBean);
        return true;
    }

    /**
     * 健身房任务列表
     * @param gymId
     * @return
     */
    public GymOrderListResponseBean getGymOrderList(String gymId) {
        GymBean gymBean = gymDao.getGymInfo(gymId);
        java.util.List<OrderBean> orderList = orderDao.getGymOrderList(gymId);

        GymOrderListResponseBean gymOrderListResponseBean = new GymOrderListResponseBean();
        gymOrderListResponseBean.setGymBean(gymBean);
        gymOrderListResponseBean.setOrderList(orderList);
        return gymOrderListResponseBean;
    }
} 