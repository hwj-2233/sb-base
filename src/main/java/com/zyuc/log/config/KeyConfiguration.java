package com.zyuc.log.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongwj
 * @date 2020/12/22
 **/
@Configuration
public class KeyConfiguration {

    @Value("${com.waner.jwt.rsa-secret}")
    private String userSecret;
    @Value("${com.waner.jwt.expire}")
    private int expire;
    @Value("${com.waner.jwt.token-header}")
    private String tokenHeader = "zy_token";
    private String dialectType = "mysql";
    @Value("${com.waner.token.expire:300}")
    private int tokenexpire;

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }
    public String getUserSecret() {
        return userSecret;
    }
    public int getExpire() {
        return expire;
    }
    public void setExpire(int expire) {
        this.expire = expire;
    }
    public String getTokenHeader() {
        return tokenHeader;
    }
    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getDialectType() {
        return dialectType;
    }

    public void setDialectType(String dialectType) {
        this.dialectType = dialectType;
    }

    public int getTokenexpire() {
        return tokenexpire;
    }

    public void setTokenexpire(int tokenexpire) {
        this.tokenexpire = tokenexpire;
    }
}
