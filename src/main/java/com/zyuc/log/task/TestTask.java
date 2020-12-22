package com.zyuc.log.task;

import com.zyuc.log.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author hongwj
 * @date 2020/10/27
 **/
@Component
public class TestTask {
    /**
     * 每天将服务器的日志发送到我的qq邮箱
     * 发送一个日志文件，redis存一个文件名避免重复发送
     */
    @Autowired
    private MailService mailService;

    private static final String localLogDir = "D:/logs/logback/";

    private static final String remoteLogDir = "/logs/logback/";

    @Scheduled(cron = "${data.consumer.cron}")
    public void report() {
        mailService.sendEmail("晚安打工人！");

    }
}