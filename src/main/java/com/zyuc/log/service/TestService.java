package com.zyuc.log.service;

import org.springframework.stereotype.Service;

/**
 * @author hongwj
 * @date 2021/01/07
 **/
@Service
public class TestService {
    public String hello(Integer a) throws Exception {
        if (a > 1) {
            throw new Exception("密码不对");
        }
        return "ok";
    }
}
