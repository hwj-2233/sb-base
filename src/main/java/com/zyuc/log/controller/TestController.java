package com.zyuc.log.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.extra.servlet.ServletUtil;

import cn.hutool.http.HttpStatus;
import com.zyuc.log.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author hongwj
 * @date 2020/09/08
 **/
@RestController
@Api("controller")
public class TestController {

    @Value("${server.port}")
    private String port;

    @Value("${Directory}")
    private String Directory;

    @Value("${captcha}")
    private String captcha;

    @Autowired
    private MessageService messageService;


    @ApiOperation(value = "下载application", notes = "application下载")
    @GetMapping("/download/{fileName}")
    public String test(@PathVariable("fileName") String fileName, HttpServletResponse response, HttpServletRequest request) throws Exception {
        ServletUtil.write(response, FileUtil.file(Directory + fileName));
        return fileName + "下载完成" + DateUtil.now();
    }

    @ApiOperation(value = "获取手机验证码", notes = "获取手机验证码")
    @GetMapping("/getPhoneCaptcha")
    public String getPhone(String phone) throws Exception {
        messageService.sendMessage(phone, captcha);
        return "success";
    }

    @ApiOperation(value = "登录", notes = "登录")
    @GetMapping("/doLogin")
    public String doLogin(String captchaForm) throws Exception {
        if (captcha.equals(captchaForm)) {
            return "success";
        } else {
            return "false";
        }
    }

}
