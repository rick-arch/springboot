package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysIcon;
import com.example.springboot.repository.SysIconRepository;
import com.example.springboot.service.SysIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.springboot.constant.Constant.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysIconServiceImpl implements SysIconService {
    @Autowired
    private SysIconRepository sysIconRepository;

    @Override
    public JsonDomainArray<SysIcon> queryAll(SysIcon sysIcon) {
        sysIcon.setPage((sysIcon.getPage() - NUM_ONE) * NUM_TEN);
        Integer count = sysIconRepository.countIcon(sysIcon);
        List<SysIcon> iconList = sysIconRepository.selectIconList(sysIcon);
        return new JsonDomainArray<SysIcon>().setCount(count).setData(iconList);
    }

    @Override
    public boolean addIcon(SysIcon sysIcon) {
        sysIcon.setIconClass(LAYUI_ICON + sysIcon.getIconClass());
        String[] ar = sysIcon.getIconCode().split(AND_SYMBOL);
        sysIcon.setIconCode(AMP + ar[NUM_ONE]);
        return sysIconRepository.insertIcon(sysIcon) > NUM_ZERO;
    }
}
