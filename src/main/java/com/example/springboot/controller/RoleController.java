package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.Tree;
import com.example.springboot.entities.SysMenu;
import com.example.springboot.entities.SysPermission;
import com.example.springboot.entities.SysRole;
import com.example.springboot.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebURIConstant.*;

@Controller
@Slf4j
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping(ROLE_LIST)
    @Log("查询角色")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_VIEW)
    public JsonDomainArray<SysRole> getRoleList(SysRole sysRole) {
        return sysRoleService.getRoleList(sysRole);
    }

    @PostMapping(ADD_ROLE)
    @Log("新增角色")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_ADD)
    public JsonResponseVO addRole(@RequestBody SysRole sysRole) {
        return new JsonResponseVO(sysRoleService.addRole(sysRole));
    }

    @PostMapping(DISABLE_ROLE)
    @Log("禁用角色")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_ROLE_DISABLE})
    public JsonResponseVO disable(@RequestBody Integer... arr) {
        return new JsonResponseVO(sysRoleService.disableRole(arr));
    }

    @PostMapping(ENABLE_ROLE)
    @Log("启用角色")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_ENABLE)
    public JsonResponseVO enable(@PathVariable Integer roleId) {
        return new JsonResponseVO(sysRoleService.activateRole(roleId));
    }

    @PostMapping(DEPLOY_MENU)
    @Log("配置角色对应的菜单")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_MENU)
    public JsonResponseVO deployMenu(@RequestBody List<SysMenu> menuList, @PathVariable Integer roleId) {
        return new JsonResponseVO(sysRoleService.deployMenu(menuList, roleId));
    }

    @PostMapping(GET_MENU_BY_ROLE_ID)
    @Log("查询角色对应菜单")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_VIEW)
    public List<SysMenu> getMenuListByRoleId(@PathVariable Integer roleId) {
        return sysRoleService.getMenuListByRoleId(roleId);
    }

    @PostMapping(GET_PERMISSION_BY_ROLE_ID)
    @Log("查询角色对应权限")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_VIEW)
    public List<SysPermission> permissionList(@PathVariable Integer roleId) {
        return sysRoleService.list(roleId);
    }

    @PostMapping(PERMISSION_LIST)
    @Log("查询可用权限")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_VIEW)
    public List<Tree> list() {
        return Tree.permissionList2Tree(sysRoleService.permissionList());
    }

    @PostMapping(ROLE_PERMISSION_ADD)
    @Log("新增角色对应权限")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ROLE_PERMISSION)
    public JsonResponseVO add(@PathVariable Integer roleId, @RequestBody Integer... arr) {
        return new JsonResponseVO(sysRoleService.addPermission(roleId, arr));
    }

}
