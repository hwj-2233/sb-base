package com.zyuc.log.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hongwj
 * @date 2020/12/30
 **/
@RestController
@RequestMapping("/oauth")
@Slf4j
public class JustAuthController {

    /**
     * 获取授权链接并跳转到第三方授权页面
     *
     * @param response response
     * @throws IOException response可能存在的异常
     */
    @ApiOperation(value = "获取认证", notes = "获取认证")
    @RequestMapping("/render/{source}")
    public void renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
        AuthRequest authRequest = new AuthGithubRequest(AuthConfig.builder()
                .clientId("ceeca6d74a0650569319")
                .clientSecret("cc74c669ebb1b53c027861e0c7ad3bcc9e70bff2")
                .redirectUri("http://localhost:8088/oauth/callback/" + source)
                .build());
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        response.sendRedirect(authorizeUrl);
    }

    /**
     * 用户在确认第三方平台授权（登录）后， 第三方平台会重定向到该地址，并携带code、state等参数
     *
     * @param callback 第三方回调时的入参
     * @return 第三方平台的用户信息
     */
    @ApiOperation(value = "回调地址", notes = "回调地址")
    @RequestMapping("/callback/{source}")
    public Object login(@PathVariable("source") String source, AuthCallback callback) {
        AuthRequest authRequest = new AuthGithubRequest(AuthConfig.builder()
                .clientId("ceeca6d74a0650569319")
                .clientSecret("cc74c669ebb1b53c027861e0c7ad3bcc9e70bff2")
                .redirectUri("http://localhost:8088/oauth/callback/" + source)
                .build());
        AuthResponse response = authRequest.login(callback);
        log.info(JSON.toJSONString(response));
        return "OK";
    }

    /**
     * 获取授权Request
     *
     * @return AuthRequest
     */
}
