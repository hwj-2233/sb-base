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
 * @date 2021/01/06
 **/
@Data
@TableName("sys_log")
public class Menu extends Model<Menu> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO, value = "menu_id")
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 排序
     */
    @TableField("order_num")
    private Integer orderNum;
    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @TableField("gmt_modified")
    private Date gmtModified;

}
