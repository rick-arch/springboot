package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysMenu;
import com.example.springboot.entity.system.SysPermission;
import com.example.springboot.entity.system.SysRole;

import java.util.List;

public interface SysRoleService {
    /**
     * 查询角色列表
     *
     * @param sysRole 角色封装类
     * @return 角色列表集合
     */
    JsonDomainArray<SysRole> getRoleList(SysRole sysRole);

    /**
     * 新增角色
     *
     * @param sysRole 角色封装类
     * @return true 成功 false 失败
     */
    Boolean addRole(SysRole sysRole);

    /**
     * 禁用角色
     * @param roleIdArr 角色id数组
     * @return true success false fail
     */
    Boolean disableRole(Integer... roleIdArr);

    /**
     * 启用角色
     * @param roleId 角色id
     * @return true success false fail
     */
    Boolean activateRole(Integer roleId);

    /**
     * 配置角色对应菜单
     * @param menuList 菜单id集合
     * @param roleId 角色id
     * @return  true success false fail
     */
    Boolean deployMenu(List<SysMenu> menuList, Integer roleId);

    /**
     * 查询角色对应的菜单
     * @param roleId 角色id
     * @return 菜单集合
     */
    List<SysMenu> getMenuListByRoleId(Integer roleId);

    /**
     * 查询角色对应权限集合
     * @return 色对应权限集合
     */
    List<SysPermission> list(Integer roleId);

    /**
     * 可用权限集合
     * @return 可用权限集合
     */
    List<SysPermission> permissionList();

    /**
     * 新增角色对应的权限
     * @param arr 权限
     * @return
     */
   boolean addPermission(Integer roleId,Integer[] arr);
}
