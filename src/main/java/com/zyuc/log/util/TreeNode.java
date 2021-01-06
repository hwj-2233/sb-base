package com.zyuc.log.util;

import cn.hutool.core.lang.tree.Tree;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hongwj
 * @date 2021/01/06
 **/
@Data
public class TreeNode<T> implements Serializable {

    /**
     * 节点 Id
     */
    private String id;

    /**
     * 显示节点文本
     */
    private String text;

    /**
     * 节点状态，open closed
     */
    private Map<String, Object> state;

    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;

    /**
     * 节点属性
     */
    private Map<String, Object> attributes;

    /**
     * 节点的子节点
     */
    private List<TreeNode<T>> children = new ArrayList<>();

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 是否有父节点
     */
    private boolean hasParent = false;

    /**
     * 是否有子节点
     */
    private boolean hasChildren = false;


}
