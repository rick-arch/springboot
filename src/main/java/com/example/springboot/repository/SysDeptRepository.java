package com.example.springboot.repository;

import com.example.springboot.entity.system.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysDeptRepository {
    /**
     * 部门列表
     * @return 返回部门集合
     */
    List<SysDept> findDeptList();

    /**
     * 查询满足条件的部门信息条数
     * @param dept 部门封装类
     * @return 部门信息条数
     */
    Integer getDeptCount(SysDept dept);

    /**
     * 查询满足条件的部门信息
     * @param dept 部门封装类
     * @return 部门信息集合
     */
    List<SysDept> queryDeptList(SysDept dept);

    /**
     * 新增部门
     * @param dept 部门封装类
     * @return >0 success <0 fail
     */
    Integer insertDept(SysDept dept);

    /**
     * 禁用部门
     * @param arr 部门id
     * @return >0 success <0 fail
     */
    Integer disable(Integer... arr);

    /**
     * 启用部门
     * @param deptId 部门id
     * @return >0 success <0 fail
     */
    Integer enable(@Param("deptId") Integer deptId);

    /**
     * 修改部门信息
     * @param dept 部门封装类
     * @return >0 success <0 fail
     */
    Integer updateDept(SysDept dept);
}
