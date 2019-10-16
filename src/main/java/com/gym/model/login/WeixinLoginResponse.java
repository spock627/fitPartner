package com.gym.model.login;

import com.gym.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeixinLoginResponse {
    private int registered; // 是否已经注册
    // 未注册情况下 将下面三个数据返回给客户端 用于帮助用户填写数据
    private String avatarUrl;
    private String nickname;
    private int sex;
    private String code;
    // 注册情况下  返回下面的数据
    private UserInfo userInfo;
    private String userId;
    private String flowId;
}
