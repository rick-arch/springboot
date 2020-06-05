package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysRole;
import com.example.springboot.entity.user.SysUser;
import com.example.springboot.entity.user.UserOnline;

import java.util.List;

public interface SysUserService {
    /**
     * 查询用户是否存在
     * @param username 用户名
     * @return 存在返回用户 否则返回 null
     */
    SysUser queryByName(String username);

    /**
     * 查询角色和权限
     * @param username 用户名
     * @return 返回角色和权限集合
     */
    List<SysUser> getRoleAndPermission(String username);

    /**
     * 查询用户列表
     * @param sysUser 用户封装类
     * @return 返回用户集合
     */
    JsonDomainArray<SysUser> getUseList(SysUser sysUser);

    /**
     * 禁用用户
     * @param id 用户id 集合
     * @return 返回true 或则false
     */
    boolean removeUser(Integer[] id);

    /**
     * 修改用户信息
     * @param sysUser 用户封装类
     * @return
     */
    boolean updateOrUpdateUser(SysUser sysUser);


    /**
     * 查询可用角色
     * @return 角色集合
     */
    List<SysRole> getRoleList();

    /**
     * 启用用户
     * @param id 用户id
     * @return 返回true 或则false
     */
    boolean enableUser(Integer id);

    /**
     * 判断账户是否有效
     * @param id 用户id
     * @return >0 有效 负责无效
     */
    boolean accountIsEffective(Integer id);

    /**
     * 在线用户管理
     */
    JsonDomainArray<UserOnline> list();

    /**
     * 踢出用户
     */
    boolean forceLogout(String sessionId);

    /**
     * 重置密码
     * @param sysUser 用户封装类
     * @return 返回true 或则false
     */
    boolean reset(SysUser sysUser);
}
