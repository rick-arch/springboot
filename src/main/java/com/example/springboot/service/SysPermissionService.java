package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysPermission;

public interface SysPermissionService extends BaseService<SysPermission> {

    /**
     * 查询父级权限
     * @return true 成功 false 失败
     */
    JsonDomainArray<SysPermission> parent();
}
