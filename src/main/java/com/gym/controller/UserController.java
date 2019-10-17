package com.gym.controller;

import com.gym.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * business:用户相关业务
 * Author:easy
 * Date:19/10/11 下午8:15
 */

@RestController
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/setUserGym",method = RequestMethod.GET)
    @ApiOperation(value="设置常驻健身房", notes="设置常驻健身房")
    public void setUserGym(@RequestParam("userId") String userId, @RequestParam("gymId") String gymId) {
        userService.setUserGym(userId, gymId);
    }

} 