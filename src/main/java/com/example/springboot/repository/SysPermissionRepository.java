package com.example.springboot.repository;

import com.example.springboot.entities.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionRepository {

    /**
     * 根据条件查询权限集合
     * @param sysPermission 权限封装类
     * @return 权限集合
     */
    List<SysPermission> getPermissionList(SysPermission sysPermission);

    /**
     * 根据条件查询权限条数
     * @param sysPermission 权限封装类
     * @return 满足条件的权限条数
     */
    Integer getSysPermissionCount(SysPermission sysPermission);

    /**
     * 启用权限
     * @param permissionId 权限id
     * @return   >0 <0
     */
    Integer enable(Integer permissionId);

    /**
     * 禁用权限
     * @param arr 权限
     * @return  >0 <0
     */
    Integer disable(Integer[] arr);

    /**
     * 新增权限
     * @param sysPermission 权限封装类
     * @return >0 success <0 fail
     */
    Integer insertPermission(SysPermission sysPermission);

    /**
     * 修改权限
     * @param sysPermission 权限封装类
     * @return >0 success <0 fail
     */
    Integer updatePermission(SysPermission sysPermission);

    /**
     * 查询父级权限
     * @return >0 success <0 fail
     */
    List<SysPermission> getParent();
}
