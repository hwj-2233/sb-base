package com.zyuc.log;

import cn.hutool.core.date.DateUtil;
import org.mapstruct.Mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
@SpringBootApplication
@EnableScheduling
@EnableAsync
@MapperScan("com.zyuc.log.mapper")
@SuppressWarnings("all")
public class LogApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);
		System.out.println(DateUtil.thisYear());
	}

}
