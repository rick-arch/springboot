package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysPermission;

public interface SysPermissionService {

    /**
     * 查询权限集合
     * @param sysPermission 权限封装类
     * @return 权限集合
     */
    JsonDomainArray<SysPermission> querySysPermission(SysPermission sysPermission);

    /**
     * 启用权限
     * @param permissionId 权限id
     * @return true success false fail
     */
    boolean activatePermission(Integer permissionId);

    /**
     * 禁用权限
     * @param arr 权限id数组
     * @return true success false fail
     */
    boolean disablePermission(Integer[] arr);

    /**
     * 新增权限
     * @param sysPermission 权限封装类
     * @return true 成功 false 失败
     */
    boolean addOrUpdatePermission(SysPermission sysPermission);

    /**
     * 查询父级权限
     * @return true 成功 false 失败
     */
    JsonDomainArray<SysPermission> parent();
}
