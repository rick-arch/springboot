package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysPermission;
import com.example.springboot.service.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebURIConstant.*;

@Controller
@Slf4j
public class PermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping(GET_PERMISSION_LIST)
    @Log("查询所有权限")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_VIEW)
    public JsonDomainArray<SysPermission> getPermissionList(SysPermission sysPermission) {
        return sysPermissionService.getAll(sysPermission);
    }

    @PostMapping(ENABLE_PERMISSION)
    @Log("启用权限")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ENABLE)
    public JsonResponseVO enable(@PathVariable Integer permissionId) {
        return new JsonResponseVO(sysPermissionService.unlock(permissionId));
    }


    @PostMapping(DISABLE_PERMISSION)
    @Log("禁用权限")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_DISABLE})
    public JsonResponseVO disable(@RequestBody Integer... arr) {
        return new JsonResponseVO(sysPermissionService.lock(arr));
    }

    @PostMapping(PERMISSION_ADD_OR_UPDATE)
    @Log("新增或修改权限")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_MODIFY, PERMISSION_ADD}, logical = Logical.OR)
    public JsonResponseVO addRole(@RequestBody SysPermission sysPermission) {
        return new JsonResponseVO(sysPermissionService.add(sysPermission));
    }

    @GetMapping(PERMISSION_PARENT)
    @Log("查询父级权限")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_VIEW)
    public JsonDomainArray<SysPermission> parent() {
        return sysPermissionService.parent();
    }
}
