package com.zyuc.log.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.zyuc.log.entity.User;
import com.zyuc.log.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hongwj
 * @date 2021/01/07
 **/
@RestController
@RequestMapping("/base")
public class ErrorController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String error( User user) throws Exception {
        System.out.println(DateUtil.formatDateTime(user.getTime()));
        return "ok";
    }
}
