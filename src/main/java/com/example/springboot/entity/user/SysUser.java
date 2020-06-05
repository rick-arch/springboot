package com.example.springboot.entity.user;

import com.example.springboot.common.Page;
import com.example.springboot.entity.system.SysDept;
import com.example.springboot.entity.system.SysRole;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
public class SysUser extends Page implements Serializable {

    /**用户id*/
    @NotNull(message = "id不能为空！")
    private Integer id;

    /**用户登录名*/
    @NotBlank(message = "username不能为空！")
    private String username;

    /**用户密码*/
    @NotBlank(message = "password不能为空！")
    private String password;

    /**创建时间*/
    private String createTime;

    /**1有效 0无效*/
    private String status;

    private SysDept sysDept;

    /**关联的部门id*/
    private String deptId;

    /**用户名（中文）*/
    private String chinaName;

    /**用户email*/
    private String email;

    /**用户描述*/
    private String description;

    /**性别*/
    private String gender;

    /**
     * 用户对应的角色集合（ 一个用户具有多个角色）
     */
    private Collection<SysRole> roleLists;


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("username", username)
                .add("password", password)
                .add("createTime", createTime)
                .add("status", status)
                .add("sysDept", sysDept)
                .add("deptId", deptId)
                .add("chinaName", chinaName)
                .add("email", email)
                .add("description", description)
                .add("gender", gender)
                .add("roleLists", roleLists)
                .toString();
    }
}
