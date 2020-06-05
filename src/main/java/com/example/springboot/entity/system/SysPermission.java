package com.example.springboot.entity.system;

import com.example.springboot.common.Page;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SysPermission extends Page implements Serializable {

    /**
     * 权限id
     */
    @NotNull(message = "permissionId不能为空！")
    private Integer permissionId;

    /**
     * 权限名称
     */
    @NotBlank(message = "permissionName不能为空！")
    private String permissionName;

    /**
     * 权限名称
     */
    @NotBlank(message = "permissionNameCn不能为空！")
    private String permissionNameCn;

    /**
     * 是否有效：1 有效 0 无效
     */
    private String deleteFlag;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 上级id
     */
    private Integer parentId;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("permissionId", permissionId)
                .add("permissionName", permissionName)
                .add("permissionNameCn", permissionNameCn)
                .add("deleteFlag", deleteFlag)
                .add("description", description)
                .add("createTime", createTime)
                .add("parentId", parentId)
                .toString();
    }
}
