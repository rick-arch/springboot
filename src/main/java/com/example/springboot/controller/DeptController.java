package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysDept;
import com.example.springboot.service.SysDeptService;
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
public class DeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping(DEPT_LIST)
    @Log("部门信息")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_DEPT_VIEW)
    public JsonDomainArray<SysDept> deptList() {
        return sysDeptService.getDeptList();
    }

    @GetMapping(DEPT_LIST)
    @Log("部门信息")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_DEPT_VIEW)
    public JsonDomainArray<SysDept> deptList(SysDept dept) {
        return sysDeptService.getDeptByCondition(dept);
    }

    @PostMapping(ADD_OR_UPDATE)
    @Log("修改或新增部门")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_DEPT_ADD, PERMISSION_DEPT_MODIFY}, logical = Logical.OR)
    public JsonResponseVO addOrUpdateDept(@RequestBody SysDept dept) {
        return new JsonResponseVO(sysDeptService.addDept(dept));
    }

    @PostMapping(DISABLE_DEPT)
    @Log("禁用部门")
    @ResponseBody
    @RequiresPermissions(value = {PERMISSION_DEPT_DISABLE})
    public JsonResponseVO disable(@RequestBody Integer... arr) {
        return new JsonResponseVO(sysDeptService.disableDept(arr));
    }

    @PostMapping(ENABLE_DEPT)
    @Log("启用部门")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_DEPT_ENABLE)
    public JsonResponseVO enable(@PathVariable Integer deptId) {
        return new JsonResponseVO(sysDeptService.activateDept(deptId));
    }
}
