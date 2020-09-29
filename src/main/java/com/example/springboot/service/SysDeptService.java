package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysDept;

public interface SysDeptService extends BaseService<SysDept>{
    /**
     * 查询部门列表
     * @return 部门列表集合
     */
    JsonDomainArray<SysDept> getDeptList();

}
