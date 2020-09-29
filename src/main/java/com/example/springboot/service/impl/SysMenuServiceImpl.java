package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entities.SysMenu;
import com.example.springboot.repository.SysMenuRepository;
import com.example.springboot.service.SysMenuService;
import com.example.springboot.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.springboot.constant.Constant.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Override
    public List<SysMenu> queryMenuList(Integer userId) {
        return sysMenuRepository.getMenuList(userId);
    }

    @Override
    public List<SysMenu> getMenuList() {
        return sysMenuRepository.findMenuList();
    }

    @Override
    public boolean modifyMenu(SysMenu sysMenu) {
        return sysMenuRepository.update(sysMenu)> NUM_ZERO;
    }


    @Override
    public boolean add(SysMenu sysMenu) {
        sysMenu.setCreateTime(DateUtil.format());
        return sysMenuRepository.insert(sysMenu) > NUM_ZERO;
    }

    @Override
    public JsonDomainArray<SysMenu> getAll(SysMenu sysMenu) {
        sysMenu.setPage((sysMenu.getPage() - NUM_ONE) * NUM_TEN);//1,10  2,10
        Integer count = sysMenuRepository.count(sysMenu);
        List<SysMenu> userList = sysMenuRepository.selectAll(sysMenu);
        return new JsonDomainArray<SysMenu>().setCount(count).setData(userList);
    }

    @Override
    public Boolean lock(Integer... arr) {
        return sysMenuRepository.disable(arr) > NUM_ZERO;
    }

    @Override
    public Boolean unlock(Integer id) {
        return sysMenuRepository.enable(id) > NUM_ZERO;
    }
}
