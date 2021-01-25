package com.zyuc.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hongwj
 * @date 2021/01/06
 **/
@Data
public class Menu extends Model<Menu> implements Serializable {

    private String id;

    private String name;

    private String parentId;

    private String url;

    private String icon;

    private int order;

    private List<Menu> childMenus;

}
