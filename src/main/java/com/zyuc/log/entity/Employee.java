package com.zyuc.log.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hongwj
 * @date 2021/01/26
 **/
@Data
public class Employee {

    private String name;
    private String age;
}
