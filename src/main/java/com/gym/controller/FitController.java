package com.gym.controller;

import com.gym.model.gym.GymBean;
import com.gym.model.order.AddOrderBean;
import com.gym.model.order.GymOrderListResponseBean;
import com.gym.model.order.PlatformResponse;
import com.gym.model.order.ReceiveOrderBean;
import com.gym.service.OperationOrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * business:健身任务相关业务
 * Author:easy
 * Date:19/10/11 下午8:15
 */

@RestController
@Log4j2
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

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    @ApiOperation(value="生成订单", notes="添加新的订单")
    public void addOrder(@RequestBody AddOrderBean addOrderBean) {
        operationOrderService.addOrder(addOrderBean);
    }

    @RequestMapping(value = "/receiveOrder",method = RequestMethod.POST)
    @ApiOperation(value="接受订单", notes="接受订单")
    public void receiveOrder(@RequestBody ReceiveOrderBean receiveOrderBean) {
        operationOrderService.receiveOrder(receiveOrderBean);
    }


    @RequestMapping(value = "/gymOrderList",method = RequestMethod.GET)
    @ApiOperation(value="健身房订单", notes="某个健身房的订单列表")
    public PlatformResponse<GymOrderListResponseBean> receiveOrder(@RequestParam("gymId") String gymId) {
        GymOrderListResponseBean gymOrderListResponseBean = operationOrderService.getGymOrderList(gymId);

        return new PlatformResponse<GymOrderListResponseBean>() {{
            setData(gymOrderListResponseBean);
            setErrCode("200");
        }};
    }
} 