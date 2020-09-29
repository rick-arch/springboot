package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysIcon;

public interface SysIconService {

	/**
	 * 根据条件查询icon
	 *
	 * @param sysIcon icon封装类
	 * @return icon集合
	 */
	JsonDomainArray<SysIcon> queryAll(SysIcon sysIcon);

	/**
	 * 新增icon
	 *
	 * @param sysIcon icon封装类
	 * @return true success false fail
	 */
	boolean addIcon(SysIcon sysIcon);
}
