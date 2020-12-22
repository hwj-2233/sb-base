package com.zyuc.log.util;

import com.zyuc.log.config.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hongwj
 * @date 2020/12/22
 **/
@Component
public class JwtTokenUtil {

    @Autowired
    private KeyConfiguration keyConfiguration;

    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserSecret(),keyConfiguration.getExpire());
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserSecret());
    }


}
