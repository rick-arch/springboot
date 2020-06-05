package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.ResponseBo;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.user.UserOnline;
import com.example.springboot.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.springboot.common.ResponseBo.error;
import static com.example.springboot.common.ResponseBo.ok;
import static com.example.springboot.constant.Constant.KICK_OUT_USER_FAILED;
import static com.example.springboot.constant.Constant.PERMISSION_USER_KICK_OUT;
import static com.example.springboot.constant.WebURIConstant.ONLINE_FORCE_LOGOUT;
import static com.example.springboot.constant.WebURIConstant.ONLINE_LIST;

@Controller
@Slf4j
public class SessionController {
    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @GetMapping(ONLINE_LIST)
    @Log("在线用户")
    public JsonDomainArray<UserOnline> onlineUserList() {
        return sysUserService.list();
    }

    @ResponseBody
    @PostMapping(ONLINE_FORCE_LOGOUT)
    @Log("踢出在线用户")
    @RequiresPermissions(value = PERMISSION_USER_KICK_OUT)
    public ResponseBo forceLogout(@PathVariable String id) {
        try {
            sysUserService.forceLogout(id);
            return ok();
        } catch (Exception e) {
            log.info(KICK_OUT_USER_FAILED);
            return error(KICK_OUT_USER_FAILED);
        }
    }

}
