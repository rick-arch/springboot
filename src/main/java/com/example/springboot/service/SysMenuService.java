package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 查询用户对应的菜单
     * @param userId 用户id
     * @return 菜单集合
     */
    List<SysMenu> queryMenuList(Integer userId);

    /**
     * 查询所有菜单
     * @return 菜单集合
     */
    List<SysMenu> getMenuList();

    /**
     * 根据条件查询菜单
     * @param sysMenu 菜单封装类
     * @return 菜单集合
     */
    JsonDomainArray<SysMenu> getMenuList(SysMenu sysMenu);

    /**
     * 修改菜单
     * @param sysMenu 菜单封装类
     * @return true success false  fail
     */
    boolean modifyMenu(SysMenu sysMenu);

    /**
     * 禁用菜单
     * @param arr menuId 集合
     * @return true success false fail
     */
    boolean disableMenu(Integer... arr);

    /**
     * 启用菜单
     * @param menuId 菜单id
     * @return
     */
    boolean activateMenu(Integer menuId);

    /**
     * 新增菜单
     * @param sysMenu  菜单封装类
     * @return  true success false fail
     */
    boolean addMenu(SysMenu sysMenu);
}
