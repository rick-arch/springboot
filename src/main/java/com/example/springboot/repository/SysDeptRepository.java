package com.example.springboot.repository;

import com.example.springboot.entities.SysDept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysDeptRepository extends BaseRepository<SysDept>{
    /**
     * 部门列表
     * @return 返回部门集合
     */
    List<SysDept> findDeptList();
}
