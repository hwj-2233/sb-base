package com.zyuc.log.controller;

import com.zyuc.log.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String error() throws Exception {
        testService.hello(2);
        return "ok";
    }
}
