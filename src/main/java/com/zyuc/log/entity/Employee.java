package com.zyuc.log.entity;

import lombok.Data;

/**
 * @author hongwj
 * @date 2021/01/26
 **/
@Data
public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
