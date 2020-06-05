package com.example.springboot.service.impl;

import com.example.springboot.common.JsonDomainArray;
import com.example.springboot.entity.system.SysDept;
import com.example.springboot.repository.SysDeptRepository;
import com.example.springboot.service.SysDeptService;
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
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptRepository sysDeptRepository;

    @Override
    public JsonDomainArray<SysDept> getDeptList() {
        List<SysDept> sysDeptList = sysDeptRepository.findDeptList();
        JsonDomainArray<SysDept> result = new JsonDomainArray<>();
        result.setData(sysDeptList);
        result.setCount(sysDeptList.size());
        return result;
    }

    @Override
    public JsonDomainArray<SysDept> getDeptByCondition(SysDept dept) {
        dept.setPage((dept.getPage() - NUM_ONE) * NUM_TEN);
        Integer count = sysDeptRepository.getDeptCount(dept);
        List<SysDept> sysDeptList = sysDeptRepository.queryDeptList(dept);
        return new JsonDomainArray<SysDept>().setCount(count).setData(sysDeptList);
    }

    @Override
    public Boolean addDept(SysDept dept) {
        dept.setCreateTime(DateUtil.format());

        if (dept.getDeptId() == null) {
            //新增部门
            return sysDeptRepository.insertDept(dept) > NUM_ZERO;
        }
        //修改部门
        return sysDeptRepository.updateDept(dept) > NUM_ZERO;
    }

    @Override
    public boolean disableDept(Integer... arr) {
        return sysDeptRepository.disable(arr) > NUM_ZERO;
    }

    @Override
    public boolean activateDept(Integer deptId) {
        return sysDeptRepository.enable(deptId) > NUM_ZERO;
    }
}
