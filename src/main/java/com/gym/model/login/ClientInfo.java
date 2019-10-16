package com.gym.model.login;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientInfo implements Serializable {
    private String sig;
    private String version;
}
