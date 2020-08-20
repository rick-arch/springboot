package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysMenu;
import com.example.springboot.entities.SysPermission;
import com.example.springboot.entities.SysRole;
import com.example.springboot.repository.SysRoleRepository;
import com.example.springboot.service.SysRoleService;
import com.example.springboot.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.springboot.constant.Constant.*;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public JsonDomainArray<SysRole> getRoleList(SysRole sysRole) {
        sysRole.setPage((sysRole.getPage() - NUM_ONE) * NUM_TEN);
        Integer count = sysRoleRepository.getRoleCount(sysRole);
        List<SysRole> sysRoleList = sysRoleRepository.queryRoleList(sysRole);
        return new JsonDomainArray<SysRole>().setCount(count).setData(sysRoleList);
    }

    @Override
    public Boolean addRole(SysRole sysRole) {
        sysRole.setCreateTime(DateUtil.format());
        return sysRoleRepository.insertRole(sysRole) > NUM_ZERO;
    }

    @Override
    public Boolean disableRole(Integer... roleIdArr) {
        return sysRoleRepository.disable(roleIdArr) > NUM_ZERO;
    }

    @Override
    public Boolean activateRole(Integer roleId) {
        return sysRoleRepository.enable(roleId) > NUM_ZERO;
    }

    @Override
    public Boolean deployMenu(List<SysMenu> menuList, Integer roleId) {
        boolean success;

        //根据角色id删除菜单
        success = sysRoleRepository.deleteRoleMenuRelationship(roleId) > NUM_ZERO;

        if (!menuList.isEmpty()) {
            //新增角色对应菜单关系
            success = sysRoleRepository.addRoleMenuRelationship(roleId, menuList) > NUM_ZERO;
        }
        return success;
    }

    @Override
    public List<SysMenu> getMenuListByRoleId(Integer roleId) {
        return sysRoleRepository.findMenuListByRoleId(roleId);
    }

    @Override
    public List<SysPermission> list(Integer roleId) {
        return sysRoleRepository.permissionList(roleId);
    }

    @Override
    public List<SysPermission> permissionList() {
        return sysRoleRepository.roleList();
    }

    @Override
    public boolean addPermission(Integer roleId, Integer[] arr) {

        //根据角色id删除权限
        boolean success = sysRoleRepository.deletePermission(roleId);

        if (arr.length != NUM_ZERO) {
            //新增角色对应权限按钮关系
            success = sysRoleRepository.insertPermission(roleId, arr) > NUM_ZERO;
        }
        return success;
    }
}
