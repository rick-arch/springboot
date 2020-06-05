package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.common.Tree;
import com.example.springboot.entity.system.SysMenu;
import com.example.springboot.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebURIConstant.*;

@Controller
@Slf4j
public class MenuController {

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 在需要加缓存的方法上添加注解 @Cacheable(cacheNames = "product", key = "123"),
     * cacheNames 和 key 都必须填，如果不填 key ，默认的 key 是当前的方法名，更新缓存时会因为方法名不同而更新失败。
     * 在需要更新缓存的方法上加注解： @CachePut(cacheNames = "prodcut", key = "123")
     * cacheNames 和 key 要跟 @Cacheable() 里的一致，才会正确更新。
     * Key 也可以动态设置为方法的参数；如果参数是个对象，也可以设置对象的某个属性为 key。比如其中一个参数是 user 对象，key 可以写成 key="#user.id"
     * 还可以指定unless 即条件不成立时缓存。#result 代表返回值，意思是当返回码不等于 0 时不缓存，也就是等于 0 时才缓存
     *
     * @Cacheable(cacheNames = "prodcut", key = "#openid", condition = "#openid.length > 3", unless = "#result.code != 0")
     */
    @Cacheable(cacheNames = "menuList", key = "#userId")
    @PostMapping(MENU_LIST)
    @Log("用户对应菜单")
    @ResponseBody
    public List<SysMenu> getMenuList(@PathVariable Integer userId) {
        return sysMenuService.queryMenuList(userId);
    }

    @PostMapping(MENU_GET_LIST)
    @Log("菜单，角色配置 （菜单tree）用")
    @ResponseBody
    public List<Tree> getMenuList() {
        return Tree.menuList2Tree(sysMenuService.getMenuList());
    }

    @GetMapping(MENU_GET_LIST)
    @Log("查询菜单")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_MENU_VIEW)
    public JsonDomainArray<SysMenu> getMenuList(SysMenu sysMenu) {
        return sysMenuService.getMenuList(sysMenu);
    }

    @PostMapping(MENU_EDIT)
    @Log("修改菜单")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_MENU_MODIFY)
    public JsonResponseVO menuEdit(@RequestBody SysMenu sysMenu) {
        return new JsonResponseVO(sysMenuService.modifyMenu(sysMenu));
    }

    @PostMapping(MENU_DISABLE)
    @Log("禁用菜单")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_MENU_DISABLE})
    public JsonResponseVO disable(@RequestBody Integer... arr) {
        return new JsonResponseVO(sysMenuService.disableMenu(arr));
    }

    @PostMapping(MENU_ENABLE)
    @Log("启用菜单")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_MENU_ENABLE)
    public JsonResponseVO enable(@PathVariable Integer menuId) {
        return new JsonResponseVO(sysMenuService.activateMenu(menuId));
    }

    @PostMapping(MENU_ADD)
    @Log("新增菜单")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_MENU_ADD)
    public JsonResponseVO addMenu(@RequestBody SysMenu sysMenu) {
        return new JsonResponseVO(sysMenuService.addMenu(sysMenu));
    }
}
