package com.example.springboot.service;

import com.example.springboot.entities.SysMenu;

import java.util.List;

public interface SysMenuService  extends BaseService<SysMenu>{
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
     * 修改菜单
     * @param sysMenu 菜单封装类
     * @return true success false  fail
     */
    boolean modifyMenu(SysMenu sysMenu);
}
