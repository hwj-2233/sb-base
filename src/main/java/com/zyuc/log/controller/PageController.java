package com.zyuc.log.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.zyuc.log.service.MailService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    private static final String localDir = "D:/Google/";

    private static final String remoteDir = "/application/";

    @ApiOperation(value = "首页", notes = "index")
    @GetMapping("/index")
    public String getShow() {
        return "404";
    }

    @ApiOperation(value = "首页", notes = "index")
    @GetMapping("/inner")
    public String getInner(HttpServletRequest request, Model model) {
        List<String> fileNameList = new ArrayList<>();
        File[] files = FileUtil.ls(remoteDir);
        for (File file : files) {
            fileNameList.add(file.getName());
        }
        model.addAttribute("size", files.length);
        model.addAttribute("fileNameList",fileNameList);
        logger.info("当前访问时间："+DateUtil.now());
        logger.info("当前的请求IP:" + ServletUtil.getClientIP(request));
        return "index";
    }

    @GetMapping(value="/getUpload")
    public String upload(){

        return "upload";
    }
}
