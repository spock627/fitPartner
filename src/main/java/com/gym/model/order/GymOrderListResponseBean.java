package com.gym.model.order;

import com.gym.model.gym.GymBean;
import lombok.Data;

import java.util.List;

/**
 * business:
 * Author:easy
 * Date:19/10/14 下午6:19
 */
@Data
public class GymOrderListResponseBean {

    private GymBean gymBean;
    private List<OrderBean> orderList;
} 