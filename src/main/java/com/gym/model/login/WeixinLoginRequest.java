package com.gym.model.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeixinLoginRequest {
    private String code;
    private String encryted;
    private String iv;
}
