package com.example.springboot.repository;

import com.example.springboot.entities.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuRepository {
    /**
     * 查询用户对应的菜单
     * @param userId 用户id
     * @return 菜单集合
     */
    List<SysMenu> getMenuList(Integer userId);

    /**
     * 查询所有菜单
     * @return 菜单集合
     */
    List<SysMenu> findMenuList();

    /**
     * 查询满足条件的菜单条数
     * @param sysMenu 菜单封装类
     * @return 条数
     */
    Integer getMenuCount(SysMenu sysMenu);

    /**
     * 查询满足条件的菜单集合
     * @param sysMenu 菜单封装类
     * @return 菜单集合
     */
    List<SysMenu> queryMenuList(SysMenu sysMenu);

    /**
     * 修改菜单
     * @param sysMenu 菜单封装类
     * @return >0 success <0 fail
     */
    Integer updateMenu(SysMenu sysMenu);

    /**
     * 禁用菜单
     * @param arr menuId 集合
     * @return  >0 success <0 fail
     */
    Integer disable(Integer... arr);

    /**
     * 启用菜单
     * @param menuId 菜单id
     * @return >0 success <0 fail
     */
    Integer enable(Integer menuId);

    /**
     * 新增菜单
     * @param sysMenu 菜单封装类
     * @return >0 success <0 fail
     */
    Integer insertMenu(SysMenu sysMenu);
}
