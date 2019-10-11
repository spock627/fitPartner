package com.gym.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ApiOperation(value="测试接口", notes="登陆接口")
    public  String login(){
        return "<h1>GYM</h1>";
    }

}
