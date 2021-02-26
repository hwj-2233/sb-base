package com.zyuc.log.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.*;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

/**
 * @author hongwj
 * @date 2021/01/21
 **/
@HeadRowHeight(10)
@Data
@HeadFontStyle(fontHeightInPoints = 10)
@HeadStyle(fillForegroundColor = 57)
public class User extends BaseRowModel {

    @ExcelProperty(value = "姓名", index = 0)
    @ColumnWidth(10)
    private String name;

    @ExcelProperty(value = "昵称", index = 1)
    @ColumnWidth(10)
    private String nickName;

    @ExcelProperty(value = "密码", index = 2)
    @ColumnWidth(10)
    private String password;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "生日", index = 3)
    @ColumnWidth(20)
    private Date birthday;

    @ExcelIgnore
    private String hello;
}
