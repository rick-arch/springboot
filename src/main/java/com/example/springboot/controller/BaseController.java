package com.example.springboot.controller;

import com.example.springboot.entities.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

public class BaseController {

    /**
     * 用户登录
     */
    public static void login(UsernamePasswordToken token) {
        SecurityUtils.getSubject().login(token);
    }

    /**
     * 获取用户主体信息
     */
    public static SysUser getPrincipal() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 用户退出
     */
    public static void userLogout() {
        SecurityUtils.getSubject().logout();
    }


}
