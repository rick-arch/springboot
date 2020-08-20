package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysPermission;
import com.example.springboot.repository.SysPermissionRepository;
import com.example.springboot.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.springboot.constant.Constant.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Override
    public JsonDomainArray<SysPermission> querySysPermission(SysPermission sysPermission) {
        sysPermission.setPage((sysPermission.getPage() - NUM_ONE) * NUM_TEN);
        Integer count = sysPermissionRepository.getSysPermissionCount(sysPermission);
        List<SysPermission> sysPermissionList = sysPermissionRepository.getPermissionList(sysPermission);
        return new JsonDomainArray<SysPermission>().setCount(count).setData(sysPermissionList);
    }

    @Override
    public boolean activatePermission(Integer permissionId) {
        return sysPermissionRepository.enable(permissionId) > NUM_ZERO;
    }

    @Override
    public boolean disablePermission(Integer[] arr) {
        return sysPermissionRepository.disable(arr) > NUM_ZERO;
    }

    @Override
    public boolean addOrUpdatePermission(SysPermission sysPermission) {
        if (sysPermission.getPermissionId() == null) {
            return sysPermissionRepository.insertPermission(sysPermission) > NUM_ZERO;
        }
        return sysPermissionRepository.updatePermission(sysPermission) > NUM_ZERO;
    }

    @Override
    public JsonDomainArray<SysPermission> parent() {
        return new JsonDomainArray<SysPermission>().setData(sysPermissionRepository.getParent());
    }

}
