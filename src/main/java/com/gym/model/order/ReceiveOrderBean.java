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
public class ReceiveOrderBean {
    private int id;
    private String receiveId;
    private String receiveTime;
    private int status;
} 