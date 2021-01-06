package com.zyuc.log.util;

/**
 * @author hongwj
 * @date 2021/01/06
 **/

import cn.hutool.core.lang.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 递归树形结构类
 */
public class TreeUtil {

    /**
     * 自定义顶级结点的parentId，返回递归树形结构
     */
    public static <T> List<TreeNode<T>> buildTree(List<TreeNode<T>> nodes, String idParam) {
        // 1.非空判断
        if (nodes == null) {
            return null;
        }

        // 2.定义返回数据类型
        List<TreeNode<T>> topNodes = new ArrayList<>();

        // 3.取出每一个元素，判断它有没有父类
        for (TreeNode<T> children : nodes) {
            String pid = children.getParentId();

            // 3.1 pid（parentId）为空，或者等于父节点，则没有父类，直接返回
            if (pid == null || idParam.equals(pid)) {
                topNodes.add(children);
                continue;
            }

            // 3.2 否则，遍历一遍集合，找它的父类，原则：子类的parentId = 父类的id
            for (TreeNode<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {

                    // 3.2.1 将子类添加到父类的children属性下
                    parent.getChildren().add(children);

                    // 3.2.2 设置子节点闭合状态：true - 关闭
                    children.setHasParent(true);
                }
            }
        }

        // 4. 返回结果集
        return topNodes;
    }

}
