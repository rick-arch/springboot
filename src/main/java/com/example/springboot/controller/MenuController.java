package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.common.Tree;
import com.example.springboot.entities.SysMenu;
import com.example.springboot.service.SysMenuService;
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
public class MenuController {

	@Autowired
	private SysMenuService sysMenuService;


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
		return sysMenuService.getAll(sysMenu);
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
		return new JsonResponseVO(sysMenuService.lock(arr));
	}

	@PostMapping(MENU_ENABLE)
	@Log("启用菜单")
	@ResponseBody
	@RequiresPermissions(value = PERMISSION_MENU_ENABLE)
	public JsonResponseVO enable(@PathVariable Integer menuId) {
		return new JsonResponseVO(sysMenuService.unlock(menuId));
	}

	@PostMapping(MENU_ADD)
	@Log("新增菜单")
	@ResponseBody
	@RequiresPermissions(value = PERMISSION_MENU_ADD)
	public JsonResponseVO addMenu(@RequestBody SysMenu sysMenu) {
		return new JsonResponseVO(sysMenuService.add(sysMenu));
	}
}
