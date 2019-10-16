package com.gym.model.user;

import lombok.Data;

/**
 * @author jarek
 */
@Data
public class UserInfo {
    private Integer userId;
    private String nickName;
    private String nickId;
    private String avatarPath;
    private String phone;
    private String gender;
    private String birthday;
    private String signature;
    private String salt;

}
