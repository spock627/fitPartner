package com.gym.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.Page;
import com.gym.service.GymInfoService;
import com.gym.util.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private  GymInfoService gymInfoService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value="测试接口", notes="登陆接口")
    public  String login(){
        List<Map<String,Object>> ret = gymInfoService.findAllGymInfo();
        return ret.toString();
    }

    @RequestMapping(value = "/login2Page",method = RequestMethod.GET)
    @ApiOperation(value="测试接口", notes="登陆接口")
    public  PageUtils login2page(@RequestParam("start") int start,@RequestParam("limit") int limit){
        Page ret = gymInfoService.findAllGymInfo2Page(start,limit);
        return new PageUtils(ret);
    }
}
