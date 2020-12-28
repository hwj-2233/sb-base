package com.zyuc.log.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hongwj
 * @date 2020/12/28
 **/
@ConfigurationProperties(prefix = "hwj")
@Configuration
@Data
public class User {
    private String name;
    private String age;
    private String gender;
}
