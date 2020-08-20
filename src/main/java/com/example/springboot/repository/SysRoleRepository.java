package com.example.springboot.repository;

import com.example.springboot.entities.SysMenu;
import com.example.springboot.entities.SysPermission;
import com.example.springboot.entities.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleRepository {

    /**
     * 查询角色列表
     * @param sysRole 角色封装类
     * @return 角色集合
     */
    List<SysRole> queryRoleList(SysRole sysRole);

    /**
     * 查询角色总条数
     * @param sysRole 角色封装类
     * @return 角色总条数
     */
    Integer getRoleCount(SysRole sysRole);

    /**
     * 新增角色
     * @param sysRole 角色封装类
     * @return >0 success <0 fail
     */
    Integer insertRole(SysRole sysRole);

    /**
     * 禁用角色
     * @param roleIdArr 角色id数组
     * @return >0 success <0 fail
     */
    Integer disable(Integer... roleIdArr);

    /**
     * 启用角色
     * @param roleId 角色id
     * @return >0 success <0 fail
     */
    Integer enable(Integer roleId);

    /**
     *新增角色对应菜单
     * @param roleId 角色id
     * @param menuList 菜单id集合
     * @return >0 <0
     */
    Integer addRoleMenuRelationship(@Param("roleId") Integer roleId, @Param("menuList")List<SysMenu> menuList);

    /**
     * 删除角色对应菜单
     * @param roleId 角色id
     * @return >0 <0
     */
    Integer deleteRoleMenuRelationship(@Param("roleId") Integer roleId);

    /**
     * 查询roleId对应的菜单是否存在
     * @param roleId 角色 id
     * @return 返回存在的条数
     */
    void delRelationshipByRoleId(@Param("roleId") Integer roleId);

    /**
     * 查询角色对应的菜单
     * @param roleId 角色id
     * @return 菜单集合
     */
    List<SysMenu> findMenuListByRoleId(@Param("roleId")Integer roleId);

    /**
     * 查询角色对应权限集合
     * @return 角色对应权限集合
     */
    List<SysPermission> permissionList(@Param("roleId")Integer roleId);

    /**
     * 可用权限集合
     * @return 可用权限集合
     */
    List<SysPermission> roleList();

    /**
     * 新增角色对应权限
     * @param roleId 角色id
     * @param arr 权限id数组
     * @return >0 <0
     */
    Integer insertPermission(@Param("roleId")Integer roleId,@Param("arr") Integer[] arr);

    /**
     * 删除角色对应的权限
     * @param roleId 角色id
     */
    boolean deletePermission(@Param("roleId")Integer roleId);
}
