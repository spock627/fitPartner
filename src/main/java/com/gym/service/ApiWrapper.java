package com.gym.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.fencelabs.bizlogic.BaseLogic;
import com.fencelabs.bizlogic.RedisLogic;
import com.fencelabs.constants.Constants;
import com.fencelabs.constants.FeedTypeEnum;
import com.fencelabs.event.AsyncTaskExecutor;
import com.fencelabs.exception.ErrCode;
import com.fencelabs.flowx.model.*;
import com.fencelabs.flowx.mongo.model.PhoneLoginRecord;
import com.fencelabs.flowx.mongo.model.WeiXinRegisterRecord;
import com.fencelabs.model.Feed;
import com.fencelabs.model.FlowCDNFileStyle;
import com.fencelabs.model.FlowCDNFileType;
import com.fencelabs.model.PlatformResponse;
import com.fencelabs.model.feed.FeedPhotoS2C;
import com.fencelabs.mongo.entity.FeedModel;
import com.fencelabs.reco.feed.rpc.service.seenfeed.HaveSeenFeedsRpc;
import com.fencelabs.recommendationRpc.bean.apiRequest.FeedRecRequestBean;
import com.fencelabs.recommendationRpc.bean.apiResponse.FeedRecResponseBean;
import com.fencelabs.recommendationRpc.controller.FeedRecService;
import com.fencelabs.redis.RedisLockTool;
import com.fencelabs.redis.StringRedisUtil;
import com.fencelabs.security.SecureIDLogic;
import com.fencelabs.util.*;
import com.gym.model.login.WeiXinToken;
import com.gym.model.login.WeixinLoginRequest;
import com.gym.model.util.PlatformResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author jarek
 */
@Log4j2
@Component
public class ApiWrapper {

    private static final String WX_APPID = "wx3640a32bcf1cfc4a";
    private static final String WX_APP_SECRET = "4d25a4e38a3d1c839b89b3e199fc31c5";
    private static final String OK = "200";

    @Value("${recoService.url}")
    private String recoServiceURL;
    @Value("${userService.url}")
    private String userServiceURL;
    @Autowired
    private RestTemplate restTemplate;




    public Object weixinLogin(WeixinLoginRequest loginReq) {
        JSONObject postData = new JSONObject();
        postData.put("code", loginReq.getCode());
        JSONObject request = new JSONObject();
        request.put("request", postData);
        PlatformResponse body = restTemplate.postForEntity(userServiceURL + "user/wechat/login?under=water", request, PlatformResponse.class).getBody();
        if (!OK.equalsIgnoreCase(body.getErrCode())) {
            log.error("[ED]weixinLogin failed {}", body);
        } else {
            log.info("[ED]weixinLogin OK Req:{}", loginReq);
            Object data = body.getData();
            log.info("[ED]weixinLogin Response:{}", data);
            return data;
        }
        return null;
    }


    public JSONObject getWeiXinSession(String jsCode) {
        // GET https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        String weixinApi = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
        String reqURL = String.format(weixinApi, WX_APPID, WX_APP_SECRET, jsCode);
        Map<String, Object> uriParams = new HashMap<>();
        String forObject = restTemplate.getForObject(reqURL, String.class, uriParams);
        log.info("WeixinSession:{} {}", forObject, forObject.getClass());
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        return jsonObject;
    }
}
