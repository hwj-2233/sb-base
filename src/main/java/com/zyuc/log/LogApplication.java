package com.zyuc.log;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan("com.zyuc.log.mapper")
@SuppressWarnings("all")
@Slf4j
@EnableDiscoveryClient
public class LogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogApplication.class, args);
        System.out.println("     _             _                                                   _ \n" +
                "    | |           | |                                                 | |\n" +
                " ___| |_ __ _ _ __| |_           ___ _   _  ___ ___ ___  ___ ___      | |\n" +
                "/ __| __/ _` | '__| __|         / __| | | |/ __/ __/ _ \\/ __/ __|     | |\n" +
                "\\__ \\ || (_| | |  | |_          \\__ \\ |_| | (_| (_|  __/\\__ \\__ \\     |_|\n" +
                "|___/\\__\\__,_|_|   \\__|         |___/\\__,_|\\___\\___\\___||___/___/     (_)\n" +
                "                                                                         \n" +
                "                                                                         ");
    }
}
