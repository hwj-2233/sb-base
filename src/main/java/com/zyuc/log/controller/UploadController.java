package com.zyuc.log.controller;

import cn.hutool.core.io.FileUtil;
import com.zyuc.log.constant.SystemConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hongwj
 * @date 2020/11/06
 **/
@RestController
public class UploadController {

    @Value("${Directory}")
    private String Directory;

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            file.transferTo(FileUtil.file(Directory + file.getOriginalFilename()));
        } catch (Exception e) {
            logger.info("上传失败");
            return "fail";
        }
        logger.info("上传成功" + file.getOriginalFilename());

        return "sucess";
    }


}
