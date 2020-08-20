package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysLog;
import com.example.springboot.repository.SysLogRepository;
import com.example.springboot.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.springboot.constant.Constant.NUM_ONE;
import static com.example.springboot.constant.Constant.NUM_TEN;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogRepository sysLogRepository;

    @Override
    public void addSysLog(SysLog sysLog) {
        sysLogRepository.saveSysLog(sysLog);
    }

    @Override
    public JsonDomainArray<SysLog> selectSysLog(SysLog sysLog) {
        sysLog.setPage((sysLog.getPage() - NUM_ONE) * NUM_TEN);
        Integer count = sysLogRepository.logCount(sysLog);
        List<SysLog> sysLogList = sysLogRepository.querySysLog(sysLog);
        return new JsonDomainArray<SysLog>().setCount(count).setData(sysLogList);
    }
}
