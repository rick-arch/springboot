package com.example.springboot.service;

import com.example.springboot.entities.SysMenu;
import com.example.springboot.entities.SysPermission;
import com.example.springboot.entities.SysRole;

import java.util.List;

public interface SysRoleService extends BaseService<SysRole> {


	/**
	 * 配置角色对应菜单
	 *
	 * @param menuList 菜单id集合
	 * @param roleId   角色id
	 * @return true success false fail
	 */
	Boolean deployMenu(List<SysMenu> menuList, Integer roleId);

	/**
	 * 查询角色对应的菜单
	 *
	 * @param roleId 角色id
	 * @return 菜单集合
	 */
	List<SysMenu> getMenuListByRoleId(Integer roleId);

	/**
	 * 查询角色对应权限集合
	 *
	 * @return 色对应权限集合
	 */
	List<SysPermission> list(Integer roleId);

	/**
	 * 可用权限集合
	 *
	 * @return 可用权限集合
	 */
	List<SysPermission> permissionList();

	/**
	 * 新增角色对应的权限
	 *
	 * @param arr 权限
	 * @return
	 */
	boolean addPermission(Integer roleId, Integer[] arr);
}
