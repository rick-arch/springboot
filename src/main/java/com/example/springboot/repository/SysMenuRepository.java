package com.example.springboot.repository;

import com.example.springboot.entities.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuRepository extends BaseRepository<SysMenu>{
    /**
     * 查询用户对应的菜单
     * @param userId 用户id
     * @return 菜单集合
     */
    List<SysMenu> getMenuList(Integer userId);

    /**
     * 查询所有菜单
     * @return 菜单集合
     */
    List<SysMenu> findMenuList();

}
