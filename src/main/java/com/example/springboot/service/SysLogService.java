package com.example.springboot.service;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysLog;

public interface SysLogService {
    /**
     * 保存日志
     * @param sysLog 日志实体
     */
    void addSysLog(SysLog sysLog);

    /**
     * 查询所有日志
     * @param sysLog 日志实体
     * @return 日志集合
     */
    JsonDomainArray<SysLog> selectSysLog(SysLog sysLog);
}
