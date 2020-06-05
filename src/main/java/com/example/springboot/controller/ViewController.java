package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.springboot.constant.WebForwardConstant.*;
import static com.example.springboot.constant.WebURIConstant.*;

@Controller
public class ViewController {

    @GetMapping(DEPT_INDEX)
    @Log("部门管理主页")
    public String deptManager() {
        return FWD_DEPT_INDEX;
    }

    @GetMapping(LOG_INDEX)
    @Log("系统日志主页")
    public String logManager() {
        return FWD_LOG_INDEX;
    }

    @GetMapping(MENU_INDEX)
    @Log("菜单管理主页")
    public String menuManager() {
        return FWD_MENU_INDEX;
    }

    @GetMapping(PERMISSION_INDEX)
    @Log("权限管理主页")
    public String permissionManager() {
        return FWD_PERMISSION_INDEX;
    }

    @GetMapping(ROLE_INDEX)
    @Log("角色管理主页")
    public String roleManager() {
        return FWD_ROLE_INDEX;
    }

    @GetMapping(ICON_INDEX)
    @Log("图标管理主页")
    public String iconManager() {
        return FWD_ICON_INDEX;
    }

    @GetMapping(ONLINE_INDEX)
    @Log("在线用户主页")
    public String index() {
        return FWD_ONLINE_INDEX;
    }

    @GetMapping(TIMELINE_INDEX)
    @Log("时间线管理主页")
    public String timeLineManager() {
        return FWD_TIME_LINE_INDEX;
    }

    @GetMapping(USER_INDEX)
    @Log("用户管理主页")
    public String userManager() {
        return FWD_USER_INDEX;
    }

    @GetMapping(LOGIN)
    @Log("登录主页")
    public String login() {
        return FWD_LOGIN;
    }

    @GetMapping(MAP_INDEX)
    @Log("地图主页")
    public String mapIndex() {
        return FWD_MAP;
    }

    @GetMapping(IMAGE_INDEX)
    @Log("图片主页")
    public String imageIndex() {
        return FWD_IMAGE_INDEX;
    }

    @GetMapping(MAIN)
    @Log("系统主页")
    public String mainIndex() {
        return FWD_MAIN;
    }
}
