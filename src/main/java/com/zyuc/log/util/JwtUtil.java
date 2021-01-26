package com.zyuc.log.util;

import cn.hutool.core.date.DateUtil;
import com.zyuc.log.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hongwj
 * @date 2021/01/26
 **/
@Component
public class JwtUtil {

    @Autowired
    JwtConfig jwtConfig;

    /**
     * 生成token
     *
     * @param userId
     * @param username
     * @return
     */
    public String generateToken(String userId, String username) {

        Map<String, Object> claims = new HashMap<>(16);
        claims.put("company", "waner");

        String token = Jwts.builder()
                .setClaims(claims)
                .setId(userId)
                .setSubject(username)
                .setExpiration(DateUtil.date(DateUtil.date().getTime() + Long.valueOf(jwtConfig.getExpire())))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
                .compact();
        return token;
    }

    /**
     * 检验token
     *
     * @param token
     * @return
     */
    public String verifyToken(String token) {
        String result = "";
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
            result = "TOKEN_VALID";
        } catch (Exception e) {
            result = "TOKEN_INVALID";
        }
        return result;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public Claims getInfoToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }
}
