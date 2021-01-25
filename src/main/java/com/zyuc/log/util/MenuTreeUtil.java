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
     * pid为父节点，没有则为null,默认是-1
     * @param menuList
     * @param pid
     * @return
     */
    private static List<Menu> buildMenuTree(List<Menu> menuList, String pid) {
        List<Menu> treeList = new ArrayList<>();
        menuList.forEach(menu -> {
            if (StringUtils.equals(pid, menu.getParentId())) {
                menu.setChildMenus(buildMenuTree(menuList, menu.getId()));
                treeList.add(menu);
            }
        });
        return treeList;
    }

}
