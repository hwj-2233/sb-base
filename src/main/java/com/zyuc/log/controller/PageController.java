package com.zyuc.log.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.zyuc.log.annotation.MyLog;
import com.zyuc.log.service.MailService;
import com.zyuc.log.service.MessageService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongwj
 * @date 2020/11/04
 **/
@Controller
@Slf4j
public class PageController {

    @Autowired
    private MessageService messageService;

    @Value("${Directory}")
    private String Directory;


    @ApiOperation(value = "首页", notes = "index")
    @GetMapping("/index")
    @MyLog(value = "访问首页")
    public String getShow(HttpServletRequest request) {
        return "404";
    }

    @ApiOperation(value = "首页", notes = "index")
    @GetMapping("/inner")
    @MyLog(value = "访问内部系统")
    public String getInner(HttpServletRequest request, Model model) {
        List<String> fileNameList = new ArrayList<>();
        File[] files = FileUtil.ls(Directory);
        for (File file : files) {
            fileNameList.add(file.getName());
        }
        model.addAttribute("size", files.length);
        model.addAttribute("fileNameList", fileNameList);
        log.info("当前访问时间：" + DateUtil.now());
        log.info("当前的请求IP:" + ServletUtil.getClientIP(request));
        return "index";
    }
}
