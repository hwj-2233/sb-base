package com.zyuc.log.controller;

import com.alibaba.fastjson.JSON;
import com.zyuc.log.annotation.MyLog;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Value;
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
@SuppressWarnings("all")
public class JustAuthController {

    @Value("${github.clientId}")
    private String gitHubClientId;

    @Value("${github.clientSecret}")
    private String gitHubClientSecret;

    private static final String QQ = "qq";

    private static final String GITHUB = "github";

    /**
     * 获取授权链接并跳转到第三方授权页面
     *
     * @param response response
     * @throws IOException response可能存在的异常
     */
    @ApiOperation(value = "获取认证", notes = "获取认证")
    @RequestMapping("/render/{source}")
    @MyLog("三方登录授权")
    public void renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
        if (GITHUB.equals(source)) {
            AuthRequest authRequest = getGitHubAuthRequest(source);
            String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
            response.sendRedirect(authorizeUrl);
        }
    }

    /**
     * 用户在确认第三方平台授权（登录）后， 第三方平台会重定向到该地址，并携带code、state等参数
     *
     * @param callback 第三方回调时的入参
     * @return 第三方平台的用户信息
     */
    @ApiOperation(value = "回调地址", notes = "回调地址")
    @RequestMapping("/callback/{source}")
    @MyLog("获取三方用户信息")
    public Object login(@PathVariable("source") String source, AuthCallback callback) {
        if (GITHUB.equals(source)) {
            AuthRequest authRequest = getGitHubAuthRequest(source);
            AuthResponse response = authRequest.login(callback);
            log.info(JSON.toJSONString(response));
            return "OK";
        }

        return "登录类型错误(错误码：2233128678)";
    }

    /**
     * 获取授权Request
     *
     * @return AuthRequest
     */
    private AuthRequest getGitHubAuthRequest(String source) {
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId(gitHubClientId)
                .clientSecret(gitHubClientSecret)
                .redirectUri("http://localhost:8088/oauth/callback/" + source)
                .build());
    }
}
