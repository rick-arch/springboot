package com.example.springboot.repository;

import com.example.springboot.entities.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionRepository extends BaseRepository<SysPermission> {

	/**
	 * 查询父级权限
	 *
	 * @return >0 success <0 fail
	 */
	List<SysPermission> getParent();
}
