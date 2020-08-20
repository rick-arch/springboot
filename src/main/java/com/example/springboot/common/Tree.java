package com.example.springboot.common;

import com.example.springboot.entities.SysMenu;
import com.example.springboot.entities.SysPermission;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.springboot.constant.Constant.NUM_ZERO;

@Setter
@Getter
public final class Tree {
    private String title;//节点标题
    private Integer id;//	节点唯一索引值，用于对指定节点进行各类操作
    private Integer parentId;
    private List<Tree> children;//子节点。支持设定选项同父节点
    private boolean spread;//	节点是否初始展开，默认 false

    /**
     * 菜单树
     */
    public static List<Tree> menuList2Tree(List<SysMenu> sysMenuList) {

        //过滤出父级菜单
        List<SysMenu> parentList = sysMenuList.stream().filter(sysMenu -> sysMenu.getParentId().equals(NUM_ZERO)).collect(Collectors.toList());

        List<Tree> menuList = Lists.newArrayList();//最后返回的树形菜单

        parentList.forEach(prt -> {
            Tree parent = new Tree();
            parent.setId(prt.getMenuId());//设置父菜单id
            parent.setTitle(prt.getMenuName());//设置父菜单名称
            List<Tree> sonMenuList = Lists.newArrayList();//父菜单对应的子菜单集合

            //过滤出当前父级id与子级parentId相同的集合
            List<SysMenu> equalsList = sysMenuList.stream().filter(sm -> sm.getParentId().equals(prt.getMenuId())).collect(Collectors.toList());

            //当前父id下 子菜单
            equalsList.forEach(equal -> {
                Tree son = new Tree();
                if (equal.getParentId().equals(prt.getMenuId())) {
                    son.setTitle(equal.getMenuName());//设置子菜单名称
                    son.setId(equal.getMenuId());//设置子菜单id
                    son.setParentId(prt.getMenuId());//设置子菜单对应的父级menuId
                }
                sonMenuList.add(son);
            });
            parent.setChildren(sonMenuList);//设置父菜单对应的子菜单
            menuList.add(parent);
        });
        return menuList;
    }

    /**
     * 权限树
     */
    public static List<Tree> permissionList2Tree(List<SysPermission> list) {

        //过滤出父级权限
        List<SysPermission> parentList = list.stream().filter(sysPermission -> sysPermission.getParentId() == NUM_ZERO).collect(Collectors.toList());

        List<Tree> permissionList = Lists.newArrayList();//最后返回的树形权限

        parentList.forEach(par -> {
            Tree parent = new Tree();
            parent.setId(par.getPermissionId());
            parent.setTitle(par.getPermissionNameCn());
            par.setParentId(par.getParentId());
            List<Tree> sonMenuList = Lists.newArrayList();//父权限对应的子角色集合

            //过滤出当前父级id与子级parentId相同的集合
            List<SysPermission> equalsList = list.stream().filter(sm -> sm.getParentId().equals(par.getPermissionId())).collect(Collectors.toList());

            //当前父id下 子权限
            equalsList.forEach(equal -> {
                Tree son = new Tree();
                if (equal.getParentId().equals(par.getPermissionId())) {
                    son.setTitle(equal.getPermissionNameCn());//子权限名称
                    son.setId(equal.getPermissionId());//子权限id
                    son.setParentId(par.getPermissionId());//子权限父级id
                }
                sonMenuList.add(son);
            });
            parent.setChildren(sonMenuList);//设置父菜单对应的子菜单
            permissionList.add(parent);
        });
        return permissionList;
    }
}
