package com.zyuc.log.controller;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.servlet.ServletUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hongwj
 * @date 2020/11/03
 **/
@Controller
@Slf4j
public class PageController {


    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    private static final String localDir = "D:/Google/";

    private static final String remoteDir = "/application/";

    @ApiOperation(value = "首页", notes = "index")
    @GetMapping("/index")
    public String show(HttpServletRequest request, Model model) {
        return "404";
    }

    @ApiOperation(value = "首页", notes = "index")
    @GetMapping("/inner")
    public String inner(HttpServletRequest request, Model model) {

        Jedis jedis = new Jedis("47.92.123.27", 6379);
        Integer account = Integer.valueOf(jedis.get("account"));
        account++;
        jedis.set("account", String.valueOf(account));
        List<String> fileNameList = new ArrayList<>();
        File[] files = FileUtil.ls(remoteDir);
        for (File file : files) {
            fileNameList.add(file.getName());
        }
        model.addAttribute("size", files.length);
        logger.info("当前访问时间："+DateUtil.now());
        logger.info("当前的请求IP:" + ServletUtil.getClientIP(request));
        logger.info("当前访问总次数："+jedis.get("account"));
        return "index";
    }


    @ApiOperation(value = "404", notes = "404")
    @GetMapping("/notFound")
    public String fail() {
        return "404";
    }
}
