package com.example.springboot.controller;

import com.example.springboot.annotation.Limit;
import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysLog;
import com.example.springboot.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.springboot.constant.Constant.PERMISSION_LOG_VIEW;
import static com.example.springboot.constant.WebURIConstant.LOG_LIST;

@Controller
@Slf4j
public class LogController {
    @Autowired
    private SysLogService sysLogService;

    @GetMapping(LOG_LIST)
    @Log("系统日志")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_LOG_VIEW)
    /**
     * //TODO 意味着 10S 内最多最多允许访问10次
     */
    @Limit(key = "test", period = 10, count = 10)
    public JsonDomainArray<SysLog> sysLogList(SysLog sysLog) {
        return sysLogService.selectSysLog(sysLog);
    }
}
