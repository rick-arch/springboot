package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysRole;
import com.example.springboot.entities.SysUser;
import com.example.springboot.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebURIConstant.*;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(USER_LIST)
    @Log("查询用户")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_USER_VIEW)
    public JsonDomainArray<SysUser> userList(SysUser sysUser) {
        return sysUserService.getUseList(sysUser);
    }

    @PostMapping(DELETE_USER)
    @Log("禁用用户")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_USER_DISABLE})
    public JsonResponseVO deleteUser(@RequestBody Integer[] id) {
        return new JsonResponseVO(sysUserService.removeUser(id));
    }

    @PostMapping(ENABLE_USER)
    @Log("启用用户")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_USER_ENABLE)
    public JsonResponseVO enableUser(@PathVariable Integer id) {
        return new JsonResponseVO(sysUserService.enableUser(id));
    }

    @PostMapping(UPDATE_OR_ADD_USER)
    @Log("修改或新增用户")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_USER_ADD, PERMISSION_USER_MODIFY}, logical = Logical.OR)
    public JsonResponseVO updateOrUpdateUser(@RequestBody SysUser sysUser) {
        return new JsonResponseVO(sysUserService.updateOrUpdateUser(sysUser));
    }

    @PostMapping(GET_ROLE_LIST)
    @Log("查询角色")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_USER_VIEW)
    public List<SysRole> getRoleList() {
        return sysUserService.getRoleList();
    }

    @PostMapping(REGISTER)
    @Log("注册用户")
    @ResponseBody
    public JsonResponseVO add(@RequestBody SysUser sysUser) {
        return new JsonResponseVO(sysUserService.updateOrUpdateUser(sysUser));
    }

    @PostMapping(RESET_PASS_WORD)
    @Log("重置密码")
    @ResponseBody
    public JsonResponseVO reset(@RequestBody SysUser sysUser) {
        return new JsonResponseVO(sysUserService.reset(sysUser));
    }
}
