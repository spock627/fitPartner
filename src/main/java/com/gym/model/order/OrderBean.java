package com.gym.model.order;

import lombok.Data;

/**
 * business:
 * Author:easy
 * Date:19/10/14 下午6:19
 */
@Data
public class OrderBean {

    private Integer id;
    private String userId;
    private String gymId;
    private Double price;
    private String createTime;
    private String startTime;
    private String endTime;
    private String content;
    private String receiveId;
    private String receiveTime;
    private Integer type;
    private Integer status;
} 