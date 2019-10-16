package com.gym.model.util;

import com.gym.model.login.ClientInfo;
import lombok.Data;

import java.io.Serializable;

@Data
public class PlatformRequest<T> implements Serializable {
    private ClientInfo client;
    private T request;
}
