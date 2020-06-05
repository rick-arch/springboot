package com.example.springboot.repository;

import com.example.springboot.entity.system.SysRole;
import com.example.springboot.entity.user.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserRepository {
    /**
     * 查询用户是否存在
     * @param username 用户姓名
     * @return 存在返回用户 否则返回 null
     */
    SysUser selectByName(String username);

    /**
     * 根据用户名查询角色和权限
     * @param username 用户名
     * @return 角色和权限集合
     */
    List<SysUser> findRoleAndPermission(String username);

    /**
     * 查询所有用户
     * @param sysUser 用户封装类
     * @return 满足条件的用户集合
     */
    List<SysUser> findUserList(SysUser sysUser);

    /**
     * 修改用户状态
     * @param id 用户id 数组
     * @return >0 成功 否则失败
     */
    Integer updateUser(Integer[] id);

    /**
     * 查询满足条件的用户条数
     * @param sysUser 用户封装类
     * @return 返回用户条数
     */
    Integer getUserCount(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser 用户封装类
     * @return  0 fail >0 success
     */
    Integer modifyUser(SysUser sysUser);

    /**
     * 删除用户和角色的关系
     * @param id 用户id
     */
    void removeRelation(@Param("userId") Integer id);

    /**
     * 新增用户和角色的关系
     * @param id 用户id
     * @param sysRoleList 角色id集合
     */
    void insertRelation(@Param("userId") Integer id, @Param("sysRoleList") List<SysRole> sysRoleList);

    /**
     * 查询可用角色
     * @return 角色集合
     */
    List<SysRole> findRoleList();

    /**
     * 新增用户
     * @param sysUser 用户封装类
     * @return 0 fail >0 success
     */
    Integer insertUser(SysUser sysUser);

    /**
     * 启用用户
     * @param id 用户id
     * @return
     */
    Integer enable(@Param("userId")Integer id);

    /**
     * 判断账户是否有效
     * @param id 用户id
     * @return >0 有效 负责无效
     */
    Integer isEffective(Integer id);

    /**
     * 重置密码
     * @param sysUser 用户封装类
     * @return 0 fail >0 success
     */
    Integer resetPassword(SysUser sysUser);
}
