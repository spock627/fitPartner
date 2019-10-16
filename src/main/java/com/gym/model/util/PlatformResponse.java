package com.gym.model.util;


import com.gym.constans.CommonConstants;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlatformResponse<T> implements Serializable {
    private String errCode;
    private String errMsg;
    private T data;

    public PlatformResponse() {
    }

    private PlatformResponse(String errCode, String errMsg, T data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public void fail(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * internal server error
     */
    public void fail() {
        this.errCode = "10004";
        this.errMsg = "服务器错误";
    }

    /**
     * fail to authentication
     */
    public void failAuth() {
        this.errCode = CommonConstants.RT_LOGIN;
        this.errMsg = CommonConstants.RM_LOGIN;
    }

    /**
     * request param is illegal
     */
    public void failParam() {
        this.errCode = CommonConstants.RT_PARAM;
        this.errMsg = CommonConstants.RM_PARAM;

    }

    /**
     * response success
     */
    public void success() {
        this.errCode = CommonConstants.RT_SUCC;
        this.errMsg = CommonConstants.RM_SUCC;
    }

    public static <R> PlatformResponse<R> success(R data) {
        return new PlatformResponse<>(CommonConstants.RT_SUCC, CommonConstants.RM_SUCC, data);
    }

    public static <R> PlatformResponse<R> success(String errCode, String errMsg, R data) {
        return new PlatformResponse<>(errCode, errMsg, data);
    }

    public static PlatformResponse authError() {
        return new PlatformResponse<>(CommonConstants.RT_LOGIN, CommonConstants.RM_LOGIN, null);
    }

    public static PlatformResponse error() {
        return new PlatformResponse<>(CommonConstants.RT_FAIL, CommonConstants.RM_FAIL, null);
    }

    public static PlatformResponse error(String errCode, String errMsg) {
        return new PlatformResponse<>(errCode, errMsg, null);
    }

//    public static PlatformResponse error(ErrCode errCode) {
//        return new PlatformResponse<>(errCode.getCode(), errCode.getMsg(), null);
//    }

}
