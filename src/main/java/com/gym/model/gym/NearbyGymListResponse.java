package com.gym.model.gym;

import lombok.Data;

import java.util.List;

/**
 * business:
 * Author:easy
 * Date:19/10/17 下午5:16
 */
@Data
public class NearbyGymListResponse {
    private List<GymBean> nearbyGymList;

} 