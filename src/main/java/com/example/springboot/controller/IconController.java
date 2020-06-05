package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysIcon;
import com.example.springboot.service.SysIconService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.springboot.constant.Constant.PERMISSION_ICON_ADD;
import static com.example.springboot.constant.Constant.PERMISSION_ICON_VIEW;
import static com.example.springboot.constant.WebURIConstant.ADD_ICON;
import static com.example.springboot.constant.WebURIConstant.ICON_LIST;

@Controller
@Slf4j
public class IconController {

    @Autowired
    private SysIconService sysIconService;

    @GetMapping(ICON_LIST)
    @Log("查询所有图标")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ICON_VIEW)
    public JsonDomainArray<SysIcon> iconList(SysIcon sysIcon) {
        return sysIconService.queryAll(sysIcon);
    }

    @PostMapping(ADD_ICON)
    @Log("新增图标")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_ICON_ADD)
    public JsonResponseVO addIcon(@RequestBody SysIcon sysIcon) {
        return new JsonResponseVO(sysIconService.addIcon(sysIcon));
    }

}
