package com.zyuc.log.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * xx
 */
@TableName("cm_plat_tenant")
public class Tenant extends Model<Tenant> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户id", notes = "租户id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "租户名称", notes = "租户名称")
    private String name;

    @ApiModelProperty(value = "租户编码", notes = "租户编码")
    private String code;

    @ApiModelProperty(value = "租户有效期开始", notes = "租户有效期开始")
    @TableField("valid_time_start")
    private String validTimeStart;

    @ApiModelProperty(value = "租户有效期结束", notes = "租户有效期结束")
    @TableField("valid_time_end")
    private String validTimeEnd;

    @ApiModelProperty(value = "租户描述", notes = "租户描述")
    private String description;

    @TableField("create_time")
    private Date createTime;

    @TableField("create_user")
    private String createUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValidTimeStart() {
        return validTimeStart;
    }

    public void setValidTimeStart(String validTimeStart) {
        this.validTimeStart = validTimeStart;
    }

    public String getValidTimeEnd() {
        return validTimeEnd;
    }

    public void setValidTimeEnd(String validTimeEnd) {
        this.validTimeEnd = validTimeEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date creatTime) {
        this.createTime = creatTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String creatUser) {
        this.createUser = creatUser;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", validTimeStart='" + validTimeStart + '\'' +
                ", validTimeEnd='" + validTimeEnd + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}
