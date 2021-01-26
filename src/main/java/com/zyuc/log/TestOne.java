package com.zyuc.log;

import cn.hutool.core.date.DateUtil;
import com.zyuc.log.entity.Employee;
import org.elasticsearch.search.aggregations.metrics.ParsedScriptedMetric;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongwj
 * @date 2021/01/21
 **/
public class TestOne {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<Employee>();

        empList.add(new Employee("张三", 30));
        empList.add(new Employee("张三1", 96));
        empList.add(new Employee("张三2", 23));
        empList.add(new Employee("张三3", 69));
        empList.add(new Employee("张三4", 85));
        empList.add(new Employee("张三5", 62));
        empList.add(new Employee("张三6", 12));
        empList.add(new Employee("张三7", 99));
        empList.add(new Employee("张三8", 11));

        //获取员工年龄的最大、最小、总和、平均值
        int sum = empList.stream().mapToInt(Employee -> Employee.getAge()).sum();
        int max = empList.stream().mapToInt(Employee -> Employee.getAge()).max().getAsInt();
        int min = empList.stream().mapToInt(Employee -> Employee.getAge()).min().getAsInt();
        double avg = empList.stream().mapToInt(Employee -> Employee.getAge()).average().getAsDouble();
        System.out.println("最大值：" + max + "\n最小值：" + min + "\n总和：" + sum + "\n平均值：" + avg);
        System.out.println(DateUtil.date().before(DateUtil.tomorrow()));

    }
}
