package com.zyuc.log.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author hongwj
 * @date 2021/01/26
 **/
@Component
public class JwtConfig {

    @Value("${com.waner.jwt.expire}")
    private String expire;

    @Value("${com.waner.jwt.secret}")
    private String secret;

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
