package com.zyuc.log;

import cn.hutool.core.date.DateUtil;
import org.elasticsearch.search.aggregations.metrics.ParsedScriptedMetric;

/**
 * @author hongwj
 * @date 2021/01/21
 **/
public class Test {
    public static void main(String[] args) {
        String dateStr = "2017-03-01 22:33:23";
        String s = DateUtil.format(DateUtil.parseDateTime(dateStr), "yyyy-MM-dd HH");
        System.out.println(s);
    }
}
