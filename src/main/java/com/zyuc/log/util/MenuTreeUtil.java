package com.zyuc.log.util;

import com.zyuc.log.entity.Menu;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongwj
 * @date 2021/01/25
 **/
public class MenuTreeUtil {
    /**
     * 根节点 默认为-1，没有则为null
     * @param menuList
     * @param rootId
     * @return
     */
    private static List<Menu> buildMenuTree(List<Menu> menuList, String rootId) {
        List<Menu> treeList = new ArrayList<>();
        menuList.forEach(menu -> {
            if (StringUtils.equals(rootId, menu.getParentId())) {
                menu.setChildMenus(buildMenuTree(menuList, menu.getId()));
                treeList.add(menu);
            }
        });
        return treeList;
    }

}
