package com.gym.constans;

import com.google.common.collect.Sets;

import java.util.Set;

public class CommonConstants {
    public static String RT_SUCC = "200";
    public static String RM_SUCC = "请求成功";


    public static String RT_LOGIN = "10002";
    public static String RM_LOGIN = "登录异常，请重新登录";

    public static String RT_PARAM = "10003";
    public static String RM_PARAM = "请求参数错误";

    public static String RT_FAIL = "10004";
    public static String RM_FAIL = "服务器异常";


	//TODO 官号设置
	public static int OFFICIAL_USERID = 1;


    /**
     * 官号列表
     */
    public static final Set<Long> OFFICIAL_USER_IDS = Sets.newHashSet(1L,188153L);
}
