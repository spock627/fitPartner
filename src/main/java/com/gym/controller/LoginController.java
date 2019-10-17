package com.gym.controller;

import com.github.pagehelper.Page;
import com.gym.service.GymService;
import com.gym.util.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private GymService gymInfoService;

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


//    @ApiOperation(value = "微信登录")
//    @RequestMapping(path = "/loginByWX", method = RequestMethod.POST)
//    public @ResponseBody
//    PlatformResponse<Object> loginByWX(@RequestBody PlatformRequest<WeixinLoginRequest> platformRequest) {
//        WeixinLoginRequest request = platformRequest.getRequest();
//        WeixinLoginResponse login = weChatMiniLogic.login(request.getCode(), request.getEncryted(), request.getIv());
//        return new PlatformResponse<Object>() {{
//            setData(login);
//            success();
//        }};
//    }
}
