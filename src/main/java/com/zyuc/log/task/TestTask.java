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

    @Autowired
    private MailService mailService;

    @Scheduled(cron = "${data.consumer.cron}")
    public void report() {
        mailService.sendEmail("晚安打工人！");

    }
}