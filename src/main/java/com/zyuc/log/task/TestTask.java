//package com.zyuc.log.task;
//
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.core.date.DateUtil;
//import cn.hutool.core.io.FileUtil;
//import cn.hutool.extra.mail.MailAccount;
//import cn.hutool.extra.mail.MailUtil;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//
///**
// * @author hongwj
// * @date 2020/10/27
// **/
//@Component
//public class TestTask {
//    /**
//     * 每天将服务器的日志发送到我的qq邮箱
//     * 发送一个日志文件，redis存一个文件名避免重复发送
//     */
//
//    private static final String localLogDir = "D:/logs/logback/";
//
//    private static final String remoteLogDir = "/logs/logback/";
//
//    @Scheduled(cron = "${data.consumer.cron}")
//    public void report() {
//
//        MailAccount account = new MailAccount();
//        account.setHost("smtp.qq.com");
//        account.setPort(587);
//        account.setAuth(true);
//        account.setFrom("2233128678@qq.com");
//        account.setUser("2233128678@qq.com");
//        account.setPass("nnqvmbfddddiecgi");
//
//        MailUtil.send(account, CollUtil.newArrayList("2233128678@qq.com"), "服务器每日日志", "日志", false,FileUtil.file(remoteLogDir+ DateUtil.yesterday().toString("yyyy-MM-dd")+".log"));
//
//    }
//}