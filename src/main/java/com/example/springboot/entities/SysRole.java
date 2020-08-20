package com.example.springboot.entities;

import com.example.springboot.common.Page;
import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysRole extends Page implements Serializable {

    /**角色id*/
    @NotNull(message = "roleId不能为空！")
    private Integer roleId;

    /**角色id字符串*/
    private String roleIdStr;

    /**角色名称（英文）*/
    @NotBlank(message = "roleName不能为空！")
    private String roleName;

    /**角色描述*/
    private String description;

    /**1有效 0无效*/
    private Integer deleteFlag;

    /**创建时间*/
    private String createTime;

    /**角色名称（中文）*/
    @NotBlank(message = "roleNameCn不能为空！")
    private String roleNameCn;

    /**
     * 角色对应的权限集合( 权限关系：多对多关系;)
     */
    private List<SysPermission> permissionsLists;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("roleId", roleId)
                .add("roleIdStr", roleIdStr)
                .add("roleName", roleName)
                .add("description", description)
                .add("deleteFlag", deleteFlag)
                .add("createTime", createTime)
                .add("roleNameCn", roleNameCn)
                .add("permissionsLists", permissionsLists)
                .toString();
    }
}
