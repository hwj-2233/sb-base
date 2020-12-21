package com.zyuc.log.controller;

import cn.hutool.core.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hongwj
 * @date 2020/11/06
 **/
@RestController
public class UploadController {

    private static final String localDir = "D:/Google/";

    private static final String remoteDir = "/application/";

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            file.transferTo(FileUtil.file(remoteDir+file.getOriginalFilename()));
        }
        catch (Exception e){
            logger.info("上传失败");
            return "fail";
        }
        logger.info("上传成功"+file.getOriginalFilename());

        return "sucess";
    }
}
