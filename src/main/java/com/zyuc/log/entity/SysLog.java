package com.zyuc.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hongwj
 * @date 2020/12/25
 **/
@Data
@TableName("sys_log")
public class SysLog extends Model<SysLog> implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String operation;

    private String method;

    private String params;

    private String ip;
    @TableField("create_date")
    private Date createDate;

}
