package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysDept;

public interface SysDeptService {
    /**
     * 查询部门列表
     * @return 部门列表集合
     */
    JsonDomainArray<SysDept> getDeptList();

    /**
     * 查询部门信息
     * @param dept 部门封装类
     * @return 部门信息集合
     */
    JsonDomainArray<SysDept> getDeptByCondition(SysDept dept);

    /**
     * 新增部门
     * @param dept 部门封装类
     * @return true success false fail
     */
    Boolean addDept(SysDept dept);

    /**
     * 禁用部门
     * @param arr 部门id
     * @return true success false fail
     */
    boolean disableDept(Integer... arr);

    /**
     * 启用部门
     * @param deptId 部门id
     * @return true success false fail
     */
    boolean activateDept(Integer deptId);
}
