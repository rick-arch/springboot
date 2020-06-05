package com.example.springboot.repository;

import com.example.springboot.entity.system.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogRepository {
    /**
     * 保存日志
     * @param sysLog 日志实体
     */
    void saveSysLog(SysLog sysLog);

    /**
     * 查询所有日志
     * @param sysLog 日志实体
     * @return 日志集合
     */
    List<SysLog> querySysLog(SysLog sysLog);

    /**
     * 查询满足条件的日志
     * @param sysLog 日志实体
     * @return 日志条数
     */
    Integer logCount(SysLog sysLog);

    /**
     * 删除日志
     */
    void deleteLog();
}
