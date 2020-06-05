package com.example.springboot.repository;

import com.example.springboot.entity.system.SysIcon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysIconRepository {
    /**
     * 根据条件查询icon
     * @param sysIcon icon封装类
     * @return icon集合
     */
    List<SysIcon> selectIconList(SysIcon sysIcon);

    /**
     * 查询满足条件的icon
     * @param sysIcon icon封装类
     * @return 条数
     */
    Integer countIcon(SysIcon sysIcon);

    /**
     * 新增icon
     * @param sysIcon icon封装列
     * @return >0 success <0 fail
     */
    Integer insertIcon(SysIcon sysIcon);
}
