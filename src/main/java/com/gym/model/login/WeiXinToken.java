package com.gym.model.login;

import lombok.Data;

/**
 * @author jarek
 */
@Data
public class WeiXinToken {
    private static long MSPerSec = 1000;
    private String token;
    private long lastMS;
    private int offsetSec;

    public static WeiXinToken parseFromString(String tokenString) {
        try {
            String[] split = tokenString.split("|");
            WeiXinToken token = new WeiXinToken();
            token.token = split[0];
            token.lastMS = Long.parseLong(split[1]);
            token.offsetSec = Integer.parseInt((split[2]));
            return token;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean needNew() {
        if ((lastMS + offsetSec * MSPerSec - 10 * MSPerSec) < System.currentTimeMillis()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return token + "|" + lastMS + "|" + offsetSec;
    }
}
