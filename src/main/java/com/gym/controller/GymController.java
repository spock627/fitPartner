package com.gym.controller;

import com.gym.model.gym.GymBean;
import com.gym.model.gym.NearbyGymListRequest;
import com.gym.model.gym.NearbyGymListResponse;
import com.gym.model.order.AddOrderBean;
import com.gym.model.order.GymOrderListResponseBean;
import com.gym.model.util.PlatformResponse;
import com.gym.service.GymService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * business:健身房相关业务
 * Author:easy
 * Date:19/10/11 下午8:15
 */

@RestController
@Log4j2
public class GymController {

    @Autowired
    private GymService gymService;

    @RequestMapping(value = "/nearbyGymList",method = RequestMethod.POST)
    @ApiOperation(value="健身房列表", notes="附近健身房")
    public PlatformResponse<NearbyGymListResponse> receiveOrder(@RequestBody NearbyGymListRequest nearbyGymListRequest) {
        List<GymBean> gymList = gymService.getNearbyGymList();
        NearbyGymListResponse nearbyGymListResponse = new NearbyGymListResponse();
        nearbyGymListResponse.setNearbyGymList(gymList);
        return new PlatformResponse<NearbyGymListResponse>() {{
            setData(nearbyGymListResponse);
            setErrCode("200");
        }};
    }

} 