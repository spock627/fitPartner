package com.gym.controller;

import com.gym.model.gym.GymBean;
import com.gym.model.order.AddOrderBean;
import com.gym.model.order.ReceiveOrderBean;
import com.gym.service.OperationOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * business:健身任务相关业务
 * Author:easy
 * Date:19/10/11 下午8:15
 */

@RestController
public class FitController {

    @Autowired
    private OperationOrderService operationOrderService;

    //获取当前健身房的任务订单
    public void getFitOrderList() {

    }

    //选择某个订单
    public void chooseFitOrder() {

    }

    //获取某个订单信息
    public void getOrderInfo() {

    }

    @RequestMapping(value = "/addOrder",method = RequestMethod.GET)
    @ApiOperation(value="生成订单", notes="添加新的订单")
    public void addOrder(@RequestParam("addOrderBean") AddOrderBean addOrderBean) {

        operationOrderService.addOrder(addOrderBean);
    }

    @RequestMapping(value = "/receiveOrder",method = RequestMethod.GET)
    @ApiOperation(value="接受订单", notes="接受订单")
    public void receiveOrder(@RequestParam("receiveOrderBean") ReceiveOrderBean receiveOrderBean) {

        operationOrderService.receiveOrder(receiveOrderBean);
    }
} 