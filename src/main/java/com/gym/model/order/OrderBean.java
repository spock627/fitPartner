package com.gym.model.order;

import lombok.Builder;
import lombok.Data;

/**
 * business:
 * Author:easy
 * Date:19/10/14 下午6:19
 */
@Data
@Builder
public class OrderBean {

    private String userId;
    private String gymId;
    private double price;
    private String createTime;
    private String startTime;
    private String endTime;
    private String content;
    private String receiveId;
    private String receiveTime;
    private int type;
} 